package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.industry.MiningObserverImpl;

import java.time.LocalDate;

/**
 * Represents an entity that can observe and record mining for a corporation.
 */
@JsonDeserialize(as = MiningObserverImpl.class)
public interface MiningObserver {
    /**
     * Get the date that the observer last updated.
     *
     * @return the last update date
     */
    LocalDate getLastUpdatedDate();

    /**
     * Get the unique ID for this observer.
     *
     * @return the ID
     */
    long getID();

    /**
     * Get the type of observer.
     *
     * @return the observer type
     */
    ObserverType getType();

    /**
     * Represents a type of observer.
     */
    enum ObserverType implements EnumUtil.MappableEnum {
        /** A player-built structure, such as a refinery. */
        STRUCTURE("structure"),
        /** A type of observer that the client does not currently support. */
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, ObserverType> map = EnumUtil.generateMap(values());

        ObserverType(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static ObserverType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
