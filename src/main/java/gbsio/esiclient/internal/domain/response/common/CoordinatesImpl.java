package gbsio.esiclient.internal.domain.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Coordinates;

public class CoordinatesImpl implements Coordinates {
    private final double x;
    private final double y;
    private final double z;

    CoordinatesImpl(
        @JsonProperty(value = "x", required = true)
        double x,
        @JsonProperty(value = "y", required = true)
        double y,
        @JsonProperty(value = "z", required = true)
        double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }
}
