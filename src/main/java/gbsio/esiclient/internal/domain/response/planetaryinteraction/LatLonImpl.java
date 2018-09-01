package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import gbsio.esiclient.api.domain.response.planetaryinteraction.LatLon;

class LatLonImpl implements LatLon {
    private final float latitude;
    private final float longitude;

    LatLonImpl(final float latitude, final float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public float getLatitude() {
        return latitude;
    }

    @Override
    public float getLongitude() {
        return longitude;
    }
}
