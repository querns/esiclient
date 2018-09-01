package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Medal;

import java.util.Optional;

public class MedalGraphicLayerImpl implements Medal.MedalGraphicLayer {
    private final String graphic;
    private final int layer;
    private final int part;
    private final Integer color;

    MedalGraphicLayerImpl(
        @JsonProperty(value = "graphic", required = true)
        final String graphic,
        @JsonProperty(value = "layer", required = true)
        final int layer,
        @JsonProperty(value = "part", required = true)
        final int part,
        @JsonProperty("color")
        final Integer color
    ) {
        this.graphic = graphic;
        this.layer = layer;
        this.part = part;
        this.color = color;
    }

    @Override
    public String getGraphic() {
        return graphic;
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public int getPart() {
        return part;
    }

    @Override
    public Optional<Integer> getColor() {
        return Optional.ofNullable(color);
    }
}
