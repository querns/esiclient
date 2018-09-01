package gbsio.esiclient.client.domain.fitting;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.common.fittings.Fitting;
import gbsio.esiclient.api.domain.common.fittings.Item;
import gbsio.esiclient.client.validation.fitting.FittingValidator;

import java.util.List;

/**
 * Builds a ship fitting to be stored to the Eve servers.
 * <P>
 *     Constraints are enforced when building a fit.
 *     <ul>
 *         <li>The fit's name must be between 1 and 50 characters.</li>
 *         <li>The description must be between 0 and 500 characters.</li>
 *         <li>The fit must contain at least one and no more than 255 items.</li>
 *         <li>The ship's item type ID must be a positive integer.</li>
 *     </ul>
 *     FittingBuilder is NOT thread-safe.
 * </P>
 */
final public class FittingBuilder {
    private final ImmutableList.Builder<Item> itemsBuilder = ImmutableList.builder();

    private String description;
    private String name;
    private int shipItemTypeID;

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder(final String description, final String name, final int shipItemTypeID) throws IllegalArgumentException {
        this.description = description;
        this.name = name;
        this.shipItemTypeID = shipItemTypeID;
    }


    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder(final String description, final String name, final int shipItemTypeID, List<Item> items) throws IllegalArgumentException {
        this(description, name, shipItemTypeID);
        itemsBuilder.addAll(items);
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder(final String description, final String name, final int shipItemTypeID, Item ...items) throws IllegalArgumentException {
        this(description, name, shipItemTypeID);
        itemsBuilder.add(items);
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder setDescription(final String description) {
        this.description = description;
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder setShipItemTypeID(final int shipItemTypeID) {
        this.shipItemTypeID = shipItemTypeID;
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder addItem(int flag, int quantity, int itemTypeID) throws IllegalArgumentException {
        final MyItem item = new MyItem(flag, quantity, itemTypeID);

        itemsBuilder.add(item);
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder addItem(Item item) throws IllegalArgumentException {
        itemsBuilder.add(item);
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public FittingBuilder addItem(Item ...items) throws IllegalArgumentException {
        itemsBuilder.add(items);
        return this;
    }

    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
    public Fitting build() throws NullPointerException, IllegalArgumentException {
        final Fitting fitting = new Impl(description, itemsBuilder.build(), name, shipItemTypeID);
        FittingValidator.validate(fitting);

        return fitting;
    }

    private static class MyItem implements Item {
        private final int flag;
        private final int quantity;
        private final int itemTypeID;

        private MyItem(final int flag, final int quantity, final int itemTypeID) {
            this.flag = flag;
            this.quantity = quantity;
            this.itemTypeID = itemTypeID;
        }

        @Override
        public int getFlag() {
            return flag;
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public int getItemTypeID() {
            return itemTypeID;
        }
    }

    private static class Impl implements Fitting {
        private final String description;
        private final ImmutableList<Item> items;
        private final String name;
        private final int shipItemTypeID;

        private Impl(final String description, final ImmutableList<Item> items, final String name, final int shipItemTypeID) {
            this.description = description;
            this.items = items;
            this.name = name;
            this.shipItemTypeID = shipItemTypeID;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public ImmutableList<Item> getItems() {
            return items;
        }

        @Override
        public String getName() {
            return name;
        }

        public int getShipItemTypeID() {
            return shipItemTypeID;
        }
    }
}
