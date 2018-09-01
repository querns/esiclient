package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.Star;

public class StarImpl implements Star {
    private final long age;
    private final float luminosity;
    private final String name;
    private final long radius;
    private final int solarSystemID;
    private final String spectralClass;
    private final int temperature;
    private final int itemTypeID;

    StarImpl(
        @JsonProperty(value = "age", required = true)
        final long age,
        @JsonProperty(value = "luminosity", required = true)
        final float luminosity,
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "radius", required = true)
        final long radius,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "spectral_class", required = true)
        final String spectralClass,
        @JsonProperty(value = "temperature", required = true)
        final int temperature,
        @JsonProperty(value = "type_id", required = true)
        final int itemTypeID
    ) {
        this.age = age;
        this.luminosity = luminosity;
        this.name = name;
        this.radius = radius;
        this.solarSystemID = solarSystemID;
        this.spectralClass = spectralClass;
        this.temperature = temperature;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public long getAge() {
        return age;
    }

    @Override
    public float getLuminosity() {
        return luminosity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getRadius() {
        return radius;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public String getSpectralClass() {
        return spectralClass;
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public int getItemTypeID() {
        return itemTypeID;
    }
}
