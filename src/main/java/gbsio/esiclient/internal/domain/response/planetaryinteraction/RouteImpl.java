package gbsio.esiclient.internal.domain.response.planetaryinteraction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.planetaryinteraction.Route;

public class RouteImpl implements Route {
    private final int contentItemTypeID;
    private final long destinationPinID;
    private final float quantity;
    private final long ID;
    private final long sourcePinID;
    private final ImmutableList<Long> waypoints;

    RouteImpl(
        @JsonProperty(value = "content_type_id", required = true)
        final int contentItemTypeID,
        @JsonProperty(value = "destination_pin_id", required = true)
        final long destinationPinID,
        @JsonProperty(value = "quantity", required = true)
        final float quantity,
        @JsonProperty(value = "route_id", required = true)
        final long id,
        @JsonProperty(value = "source_pin_id", required = true)
        final long sourcePinID,
        @JsonProperty("waypoints")
        final ImmutableList<Long> waypoints
    ) {
        this.contentItemTypeID = contentItemTypeID;
        this.destinationPinID = destinationPinID;
        this.quantity = quantity;
        ID = id;
        this.sourcePinID = sourcePinID;
        this.waypoints = MoreObjects.firstNonNull(waypoints, ImmutableList.of());
    }

    @Override
    public int getContentItemTypeID() {
        return contentItemTypeID;
    }

    @Override
    public long getDestinationPinID() {
        return destinationPinID;
    }

    @Override
    public float getQuantity() {
        return quantity;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public long getSourcePinID() {
        return sourcePinID;
    }

    @Override
    public ImmutableList<Long> getWaypoints() {
        return waypoints;
    }
}
