package gbsio.functional.request.authenticated.contracts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.contracts.OwnedContract;
import gbsio.esiclient.api.domain.response.contracts.ContractBid;
import gbsio.esiclient.api.domain.response.contracts.ContractItem;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.contracts.*;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContractsTest extends FunctionalTestHarness {
    @Test
    void characterContracts() throws IOException {
        final Client client = getClient();
        final int characterID = getPropertyAsInt("promfem_id");
        final String accessToken = getAccessToken("my_5s_token");

        performTest(
            "character",
            () -> {
                final Response<ImmutableList<OwnedContract>> contractsResponse = client.sendRequest(new CharacterContractsRequest(
                    characterID,
                    accessToken
                )).join();

                return assertResponseExistsAndGet(contractsResponse);
            },
            (contractID) -> {
                final Response<ImmutableList<ContractBid>> bidsResponse = client.sendRequest(new CharacterContractBidsRequest(
                        characterID, accessToken, contractID
                    )).join();

                return assertResponseExistsAndGet(bidsResponse);
            },
            (contractID) -> {
                final Response<ImmutableList<ContractItem>> itemsResponse = client.sendRequest(new CharacterContractItemsRequest(
                    characterID, accessToken, contractID
                )).join();

                return assertResponseExistsAndGet(itemsResponse);
            }
        );
    }

    @Test
    void corporationContracts() throws IOException {
        final Client client = getClient();
        final int corporationID = getPropertyAsInt("my_5s_id");
        final String accessToken = getAccessToken("my_5s_token");

        performTest(
            "corporation",
            () -> {
                final Response<ImmutableList<OwnedContract>> contractsResponse = client.sendRequest(new CorporationContractsRequest(
                    corporationID,
                    accessToken
                )).join();

                return assertResponseExistsAndGet(contractsResponse);
            },
            (contractID) -> {
                final Response<ImmutableList<ContractBid>> bidsResponse = client.sendRequest(new CorporationContractBidsRequest(
                    corporationID, accessToken, contractID
                    )).join();

                return assertResponseExistsAndGet(bidsResponse);
            },
            (contractID) -> {
                final Response<ImmutableList<ContractItem>> itemsResponse = client.sendRequest(new CorporationContractItemsRequest(
                    corporationID, accessToken, contractID
                )).join();

                return assertResponseExistsAndGet(itemsResponse);
            }
        );
    }

    private void performTest(
        String contractOwnerType,
        Supplier<ImmutableList<OwnedContract>> contractsSupplier,
        Function<Integer, ImmutableList<ContractBid>> bidsSupplier,
        Function<Integer, ImmutableList<ContractItem>> itemsSupplier
    ) {
        final ImmutableList<OwnedContract> contracts = contractsSupplier.get();

        if (contracts.size() > 0) {
            final AtomicBoolean foundAuction = new AtomicBoolean(false);
            final AtomicReference<OwnedContract> filteredContract = new AtomicReference<>();

            contracts.stream()
                .filter(contract -> contract.getType() == OwnedContract.Type.AUCTION)
                .findFirst()
                .ifPresent(contract -> {
                    foundAuction.set(true);
                    filteredContract.set(contract);
                });

            if (null == filteredContract.get()) {
                log(Level.WARNING, String.format("Could not find a %s contract to test bid functionality.", contractOwnerType));
                contracts.stream()
                    .filter(contract -> contract.getType() == OwnedContract.Type.ITEM_EXCHANGE || contract.getType() == OwnedContract.Type.COURIER)
                    .findFirst()
                    .ifPresent(filteredContract::set);
            }

            if (null == filteredContract.get()) {
                log(Level.WARNING, String.format("Could not find a %s contract to test either bid functionality or items functionality.", contractOwnerType));
            } else {
                final int contractID = filteredContract.get().getContractID();

                if (foundAuction.get()) {
                    final ImmutableList<ContractBid> bids = bidsSupplier.apply(contractID);
                    assertNotNull(bids);
                }

                final ImmutableList<ContractItem> items = itemsSupplier.apply(contractID);
                assertNotNull(items);
                assertTrue(items.size() > 0);
            }
        } else {
            log(Level.WARNING, String.format("No %s contracts exist; test was not able to verify bid and item functionality.", contractOwnerType));
        }
    }
}