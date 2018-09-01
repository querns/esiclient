package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.corporations.ShareholderImpl;

/**
 * Represents a shareholder in the corporation.
 *
 * To determine the total number of shares available, see the
 * {@link CorporationInfo#getShares()} method.
 */
@JsonDeserialize(as = ShareholderImpl.class)
public interface Shareholder {
    /**
     * Gets the number of shares this shareholder possesses.
     *
     * @return the share count
     */
    long getShareCount();

    /**
     * Gets the ID of the shareholder.
     *
     * This may refer to any of the types in {@link ShareholderType}.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the ID of the shareholder
     */
    int getShareholderID();

    /**
     * Get the type of shareholder.
     *
     * @return the shareholder type
     */
    ShareholderType getShareholderType();

    /**
     * Describes the type of shareholder.
     */
    enum ShareholderType implements EnumUtil.MappableEnum {
        CHARACTER("character"), CORPORATION("corporation"), UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, ShareholderType> map = EnumUtil.generateMap(values());

        ShareholderType(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static ShareholderType of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
