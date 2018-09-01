package gbsio.esiclient.client.domain.ui;

final public class Waypoint {
    private final long destinationID;
    private final boolean addToBeginning;
    private final boolean clearOtherWaypoints;

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Waypoint(final long destinationID, final boolean addToBeginning, final boolean clearOtherWaypoints) {
        this.destinationID = destinationID;
        this.addToBeginning = addToBeginning;
        this.clearOtherWaypoints = clearOtherWaypoints;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Waypoint(final long destinationID) {
        this(destinationID, false, false);
    }

    public long getDestinationID() {
        return destinationID;
    }

    public boolean addToBeginning() {
        return addToBeginning;
    }

    public boolean clearOtherWaypoints() {
        return clearOtherWaypoints;
    }
}
