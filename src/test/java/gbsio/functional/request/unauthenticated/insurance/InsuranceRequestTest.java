package gbsio.functional.request.unauthenticated.insurance;

import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.insurance.InsurancePriceData;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.insurance.InsuranceRequest;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceRequestTest extends FunctionalTestHarness {
    @Test
    void request() throws IOException {
        final int clawItemTypeID = getPropertyAsInt("claw_item_type_id");
        final Response<ImmutableList<InsurancePriceData>> response = getClient().sendRequest(new InsuranceRequest()).join();
        final ImmutableList<InsurancePriceData> list = assertResponseExistsAndGet(response);
        assertTrue(list.size() > 0);

        final Optional<InsurancePriceData> claw = list.stream()
            .filter(insurancePriceData -> insurancePriceData.getShipItemTypeID() == clawItemTypeID)
            .findFirst();

        assertTrue(claw.isPresent());
    }
}