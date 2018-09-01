package gbsio.functional.request.unauthenticated.contracts;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.contracts.Contract;
import gbsio.esiclient.api.domain.response.contracts.ContractBid;
import gbsio.esiclient.api.domain.response.contracts.DetailedContractItem;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.contracts.PublicContractBidsRequest;
import gbsio.esiclient.client.request.contracts.PublicContractItemsRequest;
import gbsio.esiclient.client.request.contracts.PublicContractsRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PublicContractsTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final Client client = getClient();
        final Response<ImmutableList<Contract>> response = client.sendRequest(new PublicContractsRequest(
            getPropertyAsInt("the_forge_region_id")
        )).join();

        final ImmutableList<Contract> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);

        final Optional<Contract> auctionContract = list.stream()
            .filter(contract -> contract.getType() == Contract.Type.AUCTION)
            .findFirst()
            ;

        Contract itemsContract;

        if (auctionContract.isPresent()) {
            itemsContract = auctionContract.get();
            final Response<ImmutableList<ContractBid>> bidsResponse = client.sendRequest(new PublicContractBidsRequest(
                itemsContract.getContractID())
            ).join();
            final ImmutableList<ContractBid> bidList = assertResponseExistsAndGet(bidsResponse);
            assertNotNull(bidList);
        } else {
            log("Could not perform auctions test due to no contract auctions being available");
            final Optional<Contract> potentialItemsContract = list.stream()
                .filter(contract -> contract.getType() == Contract.Type.ITEM_EXCHANGE)
                .findFirst();

            itemsContract = potentialItemsContract.orElse(null);
        }

        if (null != itemsContract) {
            final Response<ImmutableList<DetailedContractItem>> itemsResponse = client.sendRequest(new PublicContractItemsRequest(
                itemsContract.getContractID()
            )).join();

            final ImmutableList<DetailedContractItem> itemList = assertResponseExistsAndGet(itemsResponse);
            assertTrue(itemList.size() > 0);
        } else {
            log("Could not perform items test due to no contracts of type auction or item exchange being available");
        }
    }
}