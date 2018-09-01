package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.internal.domain.response.corporations.DivisionLabelImpl;
import gbsio.esiclient.internal.domain.response.corporations.DivisionsImpl;

import java.util.Optional;

/**
 * Represents the wallet and hangar divisions of a corporation.
 */
@JsonDeserialize(as = DivisionsImpl.class)
public interface Divisions {
    /**
     * Gets the names of hangars of the corporation.
     *
     * @return a collection of 0 or more division/name tuples, if the hangar has
     * a name other than the default name
     */
    ImmutableList<DivisionLabel> getHangars();

    /**
     * Gets the names of the wallets of the corporation.
     *
     * @return a collection of 0 or more division/name tuples, if the wallet has
     * a name other than the default name
     */
    ImmutableList<DivisionLabel> getWallets();

    @JsonDeserialize(as = DivisionLabelImpl.class)
    interface DivisionLabel {
        /**
         * Gets the number for this division or wallet.
         *
         * @return an integer between 1 and 7
         */
        Optional<Integer> getDivision();

        /**
         * Gets the name for this division or wallet.
         *
         * @return the name
         */
        Optional<String> getName();
    }
}
