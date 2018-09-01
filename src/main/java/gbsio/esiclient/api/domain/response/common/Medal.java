package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.common.MedalGraphicLayerImpl;

import java.util.Optional;

/**
 * Represents common information about medals, as described by a character
 * possessing them and a corporation's complete list of medals.
 */
public interface Medal {
    /**
     * Gets the unique ID for this medal.
     *
     * @return the unique medal ID
     */
    int getMedalID();

    /**
     * Gets the title of the medal.
     *
     * @return the medal's title
     */
    String getTitle();

    /**
     * Get the medal's description.
     *
     * @return the medal's description
     */
    String getDescription();


    enum PrivacyStatus implements EnumUtil.MappableEnum {
        PUBLIC("public"), PRIVATE("private"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, PrivacyStatus> map = EnumUtil.generateMap(PrivacyStatus.values());

        PrivacyStatus(String identifier) {
            this.identifier = identifier;
        }

        @Override
        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static PrivacyStatus of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }

    /**
     * Represents a layer of a medal's graphic.
     */
    @JsonDeserialize(as = MedalGraphicLayerImpl.class)
    interface MedalGraphicLayer {
        /**
         * Get the graphic for this layer.
         *
         * @return the graphic
         */
        String getGraphic();

        /**
         * Get an ordinal for this layer.
         *
         * @return the layer ordinal
         */
        int getLayer();

        /**
         * Get the part for this layer
         *
         * @return the part
         */
        int getPart();

        /**
         * Get the color of this layer.
         *
         * @return the color
         */
        Optional<Integer> getColor();

    }
}
