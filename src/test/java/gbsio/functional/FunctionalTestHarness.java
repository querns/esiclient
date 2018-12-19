package gbsio.functional;

import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;
import gbsio.esiclient.ClientModule;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.config.ClientConfig;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import org.junit.jupiter.api.Tag;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Provides common functions used by functional tests to instantiate clients and
 * pull test properties.
 */
@Tag("functional")
public class FunctionalTestHarness {
    public static final String USER_AGENT = "gbs.io ESI Client functional tests";

    private static final ClientConfig CONFIG = ClientConfig.builder()
        .setUserAgent(USER_AGENT)
        .build();

    private static Map<String, TokenResponse> accessTokenMap = new LinkedHashMap<>();

    public static Client getClient() {
        return getClient(CONFIG);
    }

    public static Client getClient(ClientConfig config) {
        Injector injector = Guice.createInjector(new ClientModule(config));

        return injector.getInstance(Client.class);
    }

    public static String getAccessToken(String tokenKey) throws IOException {
        if (accessTokenMap.containsKey(tokenKey)) {
            final TokenResponse tokenResponse = accessTokenMap.get(tokenKey);

            if (tokenResponse.getExpiresInSeconds() > 10) {
                return tokenResponse.getAccessToken();
            }
        }

        final String clientID = getProperty("client_id");
        final String secret = getProperty("secret");
        final String authToken = getProperty(tokenKey);

        final RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest(
            new NetHttpTransport(),
            new JacksonFactory(),
            new GenericUrl("https://login.eveonline.com/v2/oauth/token"),
            authToken
        );

        refreshTokenRequest.setGrantType("refresh_token");
        refreshTokenRequest.setClientAuthentication(new BasicAuthentication(clientID, secret));

        final TokenResponse response = refreshTokenRequest.execute();

        accessTokenMap.put(tokenKey, response);
        return response.getAccessToken();
    }

    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(FunctionalTestHarness.class.getClassLoader().getResourceAsStream("functionalTest.properties"));

        if (!properties.containsKey(key)) {
            throw new IOException(String.format("Can't find key %s in functionalTest.properties", key));
        }

        return properties.getProperty(key);
    }

    public static int getPropertyAsInt(String key) throws IOException {
        return Integer.valueOf(getProperty(key));
    }

    @SuppressWarnings("WeakerAccess")
    public static long getPropertyAsLong(String key) throws IOException {
        return Long.valueOf(getProperty(key));
    }

    protected static <T> T assertResponseExistsAndGet(Response<T> response) {
        assertFalse(response.isDeprecated(), "Request was marked as deprecated by the server");
        if (response.getResponseObject().isPresent()) {
            return response.getResponseObject().get();
        } else if (response.getError().isPresent() && response.getErrorType().isPresent()) {
            fail(String.format(
                "Server returned with an error.\nError Type: %s\nError Message: %s",
                response.getErrorType().get().name(),
                response.getError().get().getErrorMessage())
            );
        } else {
            fail("No response object was found and no error message was found");
        }

        throw new RuntimeException("Arrived at unreachable point in the assertion somehow");
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    protected void assertBooleanResponseCompletedNormally(BooleanResponse response) {
        if (response.getError().isPresent()) {
            fail(String.format(
                "Server returned with an error.\nError Type: %s\nError Message: %s",
                response.getErrorType().get().name(),
                response.getError().get().getErrorMessage())
            );
        }
    }

    @SuppressWarnings("unused")
    protected void log(String message) {
        log(Level.INFO, message);
    }

    @SuppressWarnings("WeakerAccess")
    protected void log(@SuppressWarnings("SameParameterValue") Level level, String message) {
        Logger.getLogger(getClass().getName()).log(level, message);
    }
}
