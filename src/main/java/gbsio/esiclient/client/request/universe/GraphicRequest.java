package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.universe.Graphic;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Retrieves information about a graphic used in Eve.
 */
final public class GraphicRequest implements GetRequest<Graphic> {
    private final int graphicID;

    /**
     * @param graphicID the ID of the graphic to query
     */
    public GraphicRequest(final int graphicID) {
        this.graphicID = graphicID;
    }

    @Override
    public String getURL() {
        return String.format("/v1/universe/graphics/%d/", graphicID);
    }

    @Override
    public TypeReference<Graphic> getExpectedType() {
        return new TypeReference<Graphic>() {
        };
    }
}
