package gbsio.esiclient.client.domain.routes;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.request.routes.RouteQuery;
import gbsio.esiclient.api.domain.request.routes.SecurityPreference;
import org.javatuples.Pair;

import java.util.Optional;

final public class RouteQueryBuilder {
    private final ImmutableList.Builder<Integer> avoidedSolarSystemsBuilder = ImmutableList.builder();
    private final ImmutableList.Builder<Pair<Integer, Integer>> connectedSolarSystemsBuilder = ImmutableList.builder();

    private int originSolarSystemID;
    private int destinationSolarSystemID;
    private SecurityPreference securityPreference;

    public RouteQueryBuilder(final int originSolarSystemID, final int destinationSolarSystemID) {
        this.originSolarSystemID = originSolarSystemID;
        this.destinationSolarSystemID = destinationSolarSystemID;
    }

    public RouteQueryBuilder(final int originSolarSystemID, final int destinationSolarSystemID, final SecurityPreference securityPreference) {
        this.originSolarSystemID = originSolarSystemID;
        this.destinationSolarSystemID = destinationSolarSystemID;
        this.securityPreference = securityPreference;
    }

    public RouteQueryBuilder setOriginSolarSystemID(final int originSolarSystemID) {
        this.originSolarSystemID = originSolarSystemID;
        return this;
    }

    public RouteQueryBuilder setDestinationSolarSystemID(final int destinationSolarSystemID) {
        this.destinationSolarSystemID = destinationSolarSystemID;
        return this;
    }

    public RouteQueryBuilder setSecurityPreference(final SecurityPreference securityPreference) {
        this.securityPreference = securityPreference;
        return this;
    }

    public RouteQueryBuilder addAvoidedSolarSystemID(Integer avoidedSolarSystemID) {
        avoidedSolarSystemsBuilder.add(avoidedSolarSystemID);
        return this;
    }

    public RouteQueryBuilder addAvoidedSolarSystemIDs(Integer ... avoidedSolarSystemIDs) {
        avoidedSolarSystemsBuilder.add(avoidedSolarSystemIDs);
        return this;
    }

    public RouteQueryBuilder addConnectedSolarSystemIDPair(int startSolarSystemID, int endSolarSystemID) {
        connectedSolarSystemsBuilder.add(new Pair<>(startSolarSystemID, endSolarSystemID));
        return this;
    }

    public RouteQuery build() {
        return new RouteQueryImpl(
            originSolarSystemID,
            destinationSolarSystemID,
            avoidedSolarSystemsBuilder.build(),
            connectedSolarSystemsBuilder.build(),
            securityPreference
        );
    }

    static class RouteQueryImpl implements RouteQuery {
        private final int originSolarSystemID;
        private final int destinationSolarSystemID;
        private final ImmutableList<Integer> avoidedSolarSystems;
        private final ImmutableList<Pair<Integer, Integer>> connectedSolarSystemIDPairs;
        private final SecurityPreference securityPreference;

        RouteQueryImpl(final int originSolarSystemID, final int destinationSolarSystemID, final ImmutableList<Integer> avoidedSolarSystems, final ImmutableList<Pair<Integer, Integer>> connectedSolarSystemIDPairs, final SecurityPreference securityPreference) {
            this.originSolarSystemID = originSolarSystemID;
            this.destinationSolarSystemID = destinationSolarSystemID;
            this.avoidedSolarSystems = MoreObjects.firstNonNull(avoidedSolarSystems, ImmutableList.of());
            this.connectedSolarSystemIDPairs = MoreObjects.firstNonNull(connectedSolarSystemIDPairs, ImmutableList.of());
            this.securityPreference = securityPreference;
        }

        @Override
        public int getOriginSolarSystemID() {
            return originSolarSystemID;
        }

        @Override
        public int getDestinationSolarSystemID() {
            return destinationSolarSystemID;
        }

        public ImmutableList<Integer> getAvoidedSolarSystemIDs() {
            return avoidedSolarSystems;
        }

        @Override
        public ImmutableList<Pair<Integer, Integer>> getConnectedSolarSystemIDPairs() {
            return connectedSolarSystemIDPairs;
        }

        @Override
        public Optional<SecurityPreference> getSecurityPreference() {
            return Optional.ofNullable(securityPreference);
        }
    }
}
