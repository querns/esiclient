package gbsio.functional.request.authenticated.planetaryinteraction;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Colony;
import gbsio.esiclient.api.domain.response.planetaryinteraction.ColonySummary;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Pin;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Schematic;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.planetaryinteraction.ColonyRequest;
import gbsio.esiclient.client.request.planetaryinteraction.ColonySummariesRequest;
import gbsio.esiclient.client.request.planetaryinteraction.SchematicRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColonyTest extends FunctionalTestHarness {
    @Test
    void colonies() throws IOException {
        final int characterID = getPropertyAsInt("researcher_id");
        final String accessToken = getAccessToken("researcher_token");

        final Response<ImmutableList<ColonySummary>> summaryResponse = getClient().sendRequest(new ColonySummariesRequest(
            characterID, accessToken
        )).join();

        final ImmutableList<ColonySummary> colonyList = assertResponseExistsAndGet(summaryResponse);
        assertTrue(colonyList.size() > 0);
        final ColonySummary summary = colonyList.get(0);

        final Response<Colony> colonyResponse = getClient().sendRequest(new ColonyRequest(
            characterID, accessToken, summary.getPlanetID()
        )).join();

        final Colony colony = assertResponseExistsAndGet(colonyResponse);
        final Optional<Pin> schematicPin = colony.getPins()
            .stream()
            .filter(pin -> pin.getSchematicID().isPresent())
            .findFirst()
            ;
        assertTrue(schematicPin.isPresent(), "Could not find pin in colony that contained a schematic");

        // We've guaranteed that the schematic is present in the stream earlier
        //noinspection OptionalGetWithoutIsPresent
        final Response<Schematic> schematicResponse = getClient().sendRequest(
            new SchematicRequest(schematicPin.get().getSchematicID().get())
        ).join();

        final Schematic schematic = assertResponseExistsAndGet(schematicResponse);
        assertNotNull(schematic);
    }
}