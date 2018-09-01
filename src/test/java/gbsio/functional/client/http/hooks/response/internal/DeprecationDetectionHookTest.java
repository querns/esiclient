package gbsio.functional.client.http.hooks.response.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.search.SearchResults;
import gbsio.esiclient.api.request.specific.GetRequest;
import gbsio.esiclient.api.response.Response;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeprecationDetectionHookTest extends FunctionalTestHarness {
    @Test
    void checkDeprecated() throws IOException {
        final Integer characterID = Integer.valueOf(getProperty("querns_id"));
        final String authenticationToken = getProperty("querns_token");
        final Response<SearchResults> response = getClient().sendRequest(new DeprecatedRequest(characterID, authenticationToken)).join();

        assertTrue(response.isDeprecated());
    }

    private class DeprecatedRequest implements GetRequest<SearchResults> {
        private final int characterID;
        private final String authenticationToken;

        private DeprecatedRequest(final int characterID, final String authenticationToken) {
            this.characterID = characterID;
            this.authenticationToken = authenticationToken;
        }

        @Override
        public Map<String, Object> getQueryParameters() {
            //noinspection SpellCheckingInspection
            return ImmutableMap.of(
                "categories", "character",
                "search", "Querns"
            );
        }

        @Override
        public String getURL() {
            return String.format("/v2/characters/%d/search/", characterID);
        }

        @Override
        public TypeReference<SearchResults> getExpectedType() {
            return new TypeReference<SearchResults>() {
            };
        }

        @Override
        public Optional<String> getAccessToken() {
            return Optional.of(authenticationToken);
        }
    }
}
