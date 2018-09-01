package gbsio.esiclient.client.request.planetaryinteraction;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Schematic;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a PI factory schematic.
 */
final public class SchematicRequest implements GetRequest<Schematic> {
    private final int schematicID;

    /**
     * @param schematicID the ID of the schematic to query
     */
    public SchematicRequest(final int schematicID) {
        this.schematicID = schematicID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/schematics/%d/", schematicID);
    }

    @Override
    public TypeReference<Schematic> getExpectedType() {
        return new TypeReference<Schematic>() {
        };
    }
}
