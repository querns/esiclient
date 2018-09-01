package gbsio.esiclient.client.domain.fleets;

import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.request.fleets.FleetUpdate;

import java.util.Optional;

/**
 * Generates a FleetUpdate object.
 *
 * <P>This class is NOT thread-safe.</P>
 */
@SuppressWarnings("unused")
final public class FleetUpdateBuilder {
    private Boolean freeMove;
    private String motd;

    @SuppressWarnings("unused")
    public FleetUpdateBuilder() {
    }

    @SuppressWarnings("unused")
    public FleetUpdateBuilder(final Boolean freeMove, final String motd) {
        this.freeMove = freeMove;
        this.motd = motd;
    }

    @SuppressWarnings("unused")
    public FleetUpdateBuilder setFreeMove(final Boolean freeMove) {
        this.freeMove = freeMove;
        return this;
    }

    @SuppressWarnings("unused")
    public FleetUpdateBuilder setMotd(final String motd) {
        this.motd = motd;
        return this;
    }

    /**
     * Builds the {@link FleetUpdate} object.
     * @return the FleetUpdate object
     * @throws IllegalArgumentException if both free move and motd are null
     */
    @SuppressWarnings("unused")
    public FleetUpdate build() throws IllegalArgumentException {
        Preconditions.checkArgument(!(null == freeMove && null == motd), "Either or both of free move or motd need to be set");
        return new MyFleetUpdate(freeMove, motd);
    }

    private static class MyFleetUpdate implements FleetUpdate {
        private final Boolean freeMove;
        private final String motd;

        private MyFleetUpdate(final Boolean freeMove, final String motd) {
            this.freeMove = freeMove;
            this.motd = motd;
        }

        @Override
        public Optional<Boolean> isFreeMove() {
            return Optional.ofNullable(freeMove);
        }

        @Override
        public Optional<String> getMOTD() {
            return Optional.ofNullable(motd);
        }
    }
}
