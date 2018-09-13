package gbsio.functional.client.http.hooks.response.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.universe.SystemKillData;
import gbsio.esiclient.api.request.specific.GetRequest;
import gbsio.esiclient.api.response.Response;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeprecationDetectionHookTest extends FunctionalTestHarness {
    @Test
    void checkDeprecated() {
        final Response<ImmutableList<SystemKillData>> response = getClient().sendRequest(new DeprecatedRequest()).join();

        assertTrue(response.isDeprecated());
    }

    private class DeprecatedRequest implements GetRequest<ImmutableList<SystemKillData>>{


        private DeprecatedRequest() {}

        @Override
        public String getURL() {
            return "/v1/universe/system_kills/";
        }


        @Override
        public TypeReference<ImmutableList<SystemKillData>> getExpectedType() {
            return new TypeReference<ImmutableList<SystemKillData>>() {
            };
        }
    }
}
