package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.corporation.Shareholder;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ShareholderImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<Shareholder> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/corporations/shareholders.json"),
            new TypeReference<ImmutableList<Shareholder>>() { }
        );

        assertEquals(4, list.size());
        Shareholder one = list.get(0);
        Shareholder two = list.get(1);
        Shareholder three = list.get(2);
        Shareholder four = list.get(3);

        assertEquals(580, one.getShareCount());
        assertEquals(98000001, one.getShareholderID());
        assertEquals(Shareholder.ShareholderType.CORPORATION, one.getShareholderType());

        assertEquals(20, two.getShareCount());
        assertEquals(2112000003, two.getShareholderID());
        assertEquals(Shareholder.ShareholderType.CHARACTER, two.getShareholderType());

        assertEquals(300, three.getShareCount());
        assertEquals(2112000004, three.getShareholderID());
        assertEquals(Shareholder.ShareholderType.CHARACTER, three.getShareholderType());

        assertEquals(100, four.getShareCount());
        assertEquals(2112000001, four.getShareholderID());
        assertEquals(Shareholder.ShareholderType.CHARACTER, four.getShareholderType());

    }
}