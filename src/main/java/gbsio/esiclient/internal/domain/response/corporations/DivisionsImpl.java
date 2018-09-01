package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import gbsio.esiclient.api.domain.response.corporation.Divisions;

public class DivisionsImpl implements Divisions {
    private final ImmutableList<DivisionLabel> hangars;
    private final ImmutableList<DivisionLabel> wallets;

    DivisionsImpl(
        @JsonProperty("hangar")
        final ImmutableList<DivisionLabel> hangars,
        @JsonProperty("wallet")
        final ImmutableList<DivisionLabel> wallets
    ) {
        checkListInvariants(hangars, "#1");
        checkListInvariants(wallets, "#2");
        this.hangars = hangars;
        this.wallets = wallets;
    }

    @Override
    public ImmutableList<DivisionLabel> getHangars() {
        return MoreObjects.firstNonNull(hangars, ImmutableList.of());
    }

    @Override
    public ImmutableList<DivisionLabel> getWallets() {
        return MoreObjects.firstNonNull(wallets, ImmutableList.of());
    }

    private void checkListInvariants(ImmutableList<?> list, String listLabel) {
        if (null != list && !Range.closed(1, 7).contains(list.size())) {
            throw new IllegalArgumentException("Argument ".concat(listLabel).concat(" to DivisionsImpl must be a list with between 1 and 7 elements."));
        }
    }
}
