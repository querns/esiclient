package gbsio.esiclient.client.domain.fitting;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.common.fittings.Fitting;
import gbsio.esiclient.api.domain.common.fittings.Item;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FittingBuilderTest {
    private final static String VALID_DESCRIPTION = "description";
    private final static String VALID_NAME = "name";
    private final static int VALID_SHIP_ITEM_TYPE_ID = 1;
    private final static int VALID_FLAG = 1;
    private final static int VALID_QUANTITY = 2;
    private final static int VALID_ITEM_TYPE_ID = 3;
    private final static Item VALID_ITEM = new MyItem(VALID_FLAG, VALID_QUANTITY, VALID_ITEM_TYPE_ID);

    @Test
    void invariants() {
        final List<Pair<FittingComponents, String>> list = ImmutableList.of(
            new Pair<>(new FittingComponents(new String(new char[501]).replace('\0', 'x'), VALID_NAME, VALID_SHIP_ITEM_TYPE_ID, VALID_ITEM), "Expected description over 500 characters to not validate."),
            new Pair<>(new FittingComponents(VALID_DESCRIPTION, "", VALID_SHIP_ITEM_TYPE_ID, VALID_ITEM), "Expected missing name to not validate."),
            new Pair<>(new FittingComponents(VALID_DESCRIPTION, new String(new char[51]).replace('\0', 'x'), VALID_SHIP_ITEM_TYPE_ID, VALID_ITEM), "Expected a name more than 50 characters to not validate."),
            new Pair<>(new FittingComponents(VALID_DESCRIPTION, VALID_NAME, 0, VALID_ITEM), "Expected shipItemTypeID of 0 to not validate."),
            new Pair<>(new FittingComponents(VALID_DESCRIPTION, VALID_NAME, VALID_SHIP_ITEM_TYPE_ID), "Expected a fit with no items to not validate."),
            new Pair<>(new FittingComponents(VALID_DESCRIPTION, VALID_NAME, VALID_SHIP_ITEM_TYPE_ID, new MyItem(-1, VALID_QUANTITY, VALID_ITEM_TYPE_ID)), "Expected an item in a fit with a flag of -1 to not validate."),
            new Pair<>(new FittingComponents(VALID_DESCRIPTION, VALID_NAME, VALID_SHIP_ITEM_TYPE_ID, new MyItem(VALID_FLAG, -1, VALID_ITEM_TYPE_ID)), "Expected an item in a fit with a quantity of -1 to not validate."),
            new Pair<>(new FittingComponents(VALID_DESCRIPTION, VALID_NAME, VALID_SHIP_ITEM_TYPE_ID, new MyItem(VALID_FLAG, VALID_QUANTITY, -1)), "Expected an item in a fit with an item type ID of -1 to not validate.")
        );

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> new FittingBuilder(
                pair.getValue0().description,
                pair.getValue0().name,
                pair.getValue0().shipItemTypeID,
                pair.getValue0().items
            ).build(),
            invariantsFailureMessage(pair.getValue1(), pair.getValue0())
        ));

        list.forEach(pair -> assertThrows(
            IllegalArgumentException.class,
            () -> {
                final FittingBuilder initiallyValid = new FittingBuilder(
                    VALID_DESCRIPTION,
                    VALID_NAME,
                    VALID_SHIP_ITEM_TYPE_ID
                );

                initiallyValid.setDescription(pair.getValue0().description)
                    .setName(pair.getValue0().name)
                    .setShipItemTypeID(pair.getValue0().shipItemTypeID);

                if (pair.getValue0().items.length > 0) {
                    initiallyValid.addItem(pair.getValue0().items);
                }

                initiallyValid.build();
            },
            invariantsFailureMessage(pair.getValue1(), pair.getValue0())
        ));
    }

    @Test
    void serialize() throws IOException {
        FittingBuilder builder = new FittingBuilder(VALID_DESCRIPTION, VALID_NAME, VALID_SHIP_ITEM_TYPE_ID, VALID_ITEM);
        Fitting fitting = builder.build();

        final JsonNode node = JsonTestHarness.serializeToNode(fitting);
        assertTrue(node.has("description"));
        assertTrue(node.has("items"));
        assertTrue(node.has("name"));
        assertTrue(node.has("ship_type_id"));

        final JsonNode descriptionNode = node.get("description");
        final JsonNode itemsNode = node.get("items");
        final JsonNode nameNode = node.get("name");
        final JsonNode shipTypeIDNode = node.get("ship_type_id");

        assertTrue(descriptionNode.isTextual());
        assertTrue(nameNode.isTextual());
        assertTrue(shipTypeIDNode.isInt());
        assertTrue(itemsNode.isArray());

        assertEquals(VALID_DESCRIPTION, descriptionNode.textValue());
        assertEquals(VALID_NAME, nameNode.textValue());
        assertEquals(VALID_SHIP_ITEM_TYPE_ID, shipTypeIDNode.numberValue());

        assertTrue(itemsNode.has(0));
        final JsonNode singleItemNode = itemsNode.get(0);

        assertTrue(singleItemNode.has("flag"));
        assertTrue(singleItemNode.has("quantity"));
        assertTrue(singleItemNode.has("type_id"));

        final JsonNode flagNode = singleItemNode.get("flag");
        final JsonNode quantityNode = singleItemNode.get("quantity");
        final JsonNode itemTypeIDNode = singleItemNode.get("type_id");

        assertTrue(flagNode.isNumber());
        assertTrue(quantityNode.isNumber());
        assertTrue(itemTypeIDNode.isNumber());

        assertEquals(VALID_FLAG, flagNode.numberValue());
        assertEquals(VALID_QUANTITY, quantityNode.numberValue());
        assertEquals(VALID_ITEM_TYPE_ID, itemTypeIDNode.numberValue());
    }

    private String invariantsFailureMessage(String message, FittingComponents components) {
        return String.format(
            "%s\nWith arguments:\n(string with length %d)\n\"%s\"\n%d\nItem: %s %s %s",
            message,
            components.description.length(),
            components.name,
            components.shipItemTypeID,
            components.items.length != 0 ? components.items[0].getFlag() : "n/a",
            components.items.length != 0 ? components.items[0].getQuantity() : "n/a",
            components.items.length != 0 ? components.items[0].getItemTypeID() : "n/a"
        );
    }

    private class FittingComponents {
        private final String description;
        private final String name;
        private final int shipItemTypeID;
        private final Item[] items;

        private FittingComponents(final String description, final String name, final int shipItemTypeID) {
            this.description = description;
            this.name = name;
            this.shipItemTypeID = shipItemTypeID;
            this.items = new Item[0];
        }

        FittingComponents(final String description, final String name, final int shipItemTypeID, final Item ...items) {
            this.description = description;
            this.name = name;
            this.shipItemTypeID = shipItemTypeID;
            this.items = items;
        }
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
}