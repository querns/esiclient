package gbsio.esiclient.client.validation.assets;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class AssetIDListValidator {
    public static void validate(ImmutableList<Long> assetIDs) {
        Preconditions.checkNotNull(assetIDs);
        Preconditions.checkArgument(
            assetIDs.size() > 0,
            "There must be at least one asset item ID passed to this function"
        );

        Preconditions.checkArgument(
            assetIDs.size() <= 1000,
            "There can be no more than 1000 asset item IDs passed to this function"
        );
    }
}
