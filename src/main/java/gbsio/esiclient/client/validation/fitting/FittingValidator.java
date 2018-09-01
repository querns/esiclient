package gbsio.esiclient.client.validation.fitting;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import gbsio.esiclient.api.domain.common.fittings.Fitting;
import gbsio.esiclient.api.domain.common.fittings.Item;

/**
 * Validates instances of {@link Fitting}.
 */
public class FittingValidator {
    private static final Range<Integer> NAME_LENGTH = Range.closed(1, 50);
    private static final Range<Integer> DESCRIPTION_LENGTH = Range.closed(0, 500);
    private static final Range<Integer> ITEMS_LENGTH = Range.closed(1, 255);

    public static void validate(Fitting fitting) {
        Preconditions.checkArgument(
            ITEMS_LENGTH.contains(fitting.getItems().size()),
            "A fitting must contain between 1 and 255 items"
        );

        Preconditions.checkArgument(
            NAME_LENGTH.contains(fitting.getName().length()),
            "Name must be a string of length between 1 and 50 characters"
        );

        Preconditions.checkArgument(
            DESCRIPTION_LENGTH.contains(fitting.getDescription().length()),
            "Description must be a string of length between 0 and 500 characters"
        );

        Preconditions.checkArgument(
            fitting.getShipItemTypeID() > 0,
            "Ship item type ID cannot be zero or negative"
        );

        for (int i = 0; i < fitting.getItems().size(); i++) {
            validateItem(fitting.getItems().get(i), i);
        }
    }

    private static void validateItem(Item item, int index) throws IllegalArgumentException {
        Preconditions.checkArgument(
            item.getFlag() >= 0,
            index == 0
                ? "Item's flag must be greater than or equal to 0"
                : "Item #%d's flag must be greater than or equal to 0",
            index
        );
        Preconditions.checkArgument(
            item.getQuantity() >= 0,
            index == 0
                ? "Item's quantity must be greater than or equal to 0"
                : "Item #%d's quantity must be greater than or equal to 0",
            index
        );
        Preconditions.checkArgument(
            item.getItemTypeID() > 0,
            index == 0
                ? "Item's typeID must be greater than 0"
                : "Item #%d's typeID must be greater than 0",
            index
        );
    }

}
