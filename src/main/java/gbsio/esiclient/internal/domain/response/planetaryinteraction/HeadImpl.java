package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Extractor;
import gbsio.esiclient.api.domain.response.planetaryinteraction.LatLon;

public class HeadImpl implements Extractor.Head {
    private final int ID;
    private final LatLon latLon;

    HeadImpl(
        @JsonProperty(value = "head_id", required = true)
        final int ID,
        @JsonProperty(value = "latitude", required = true)
        float latitude,
        @JsonProperty(value = "longitude", required = true)
        float longitude) {
        this.ID = ID;
        this.latLon = new LatLonImpl(latitude, longitude);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public LatLon getLatLon() {
        return latLon;
    }
}
