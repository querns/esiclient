package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.industry.IndustryJob;
import gbsio.esiclient.internal.json.JsonTestHarness;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class IndustryJobImplTest {
    @Test
    void parse() throws IOException {
        ImmutableList<IndustryJob> list = JsonTestHarness.deserialize(
            getClass().getClassLoader().getResourceAsStream("json/domain/industry/job.json"),
            new TypeReference<ImmutableList<IndustryJob>>() { }
        );

        assertEquals(1, list.size());
        IndustryJob job = list.get(0);

        assertEquals(1, job.getActivityID());
        assertEquals(1015116533326L, job.getBlueprintID());
        assertEquals(60006382L, job.getBlueprintLocationID());
        assertEquals(2047, job.getBlueprintTypeID());
        assertTrue(job.getCost().isPresent());
        assertEquals((Double)118.01D, job.getCost().get());
        assertEquals(548, job.getDuration());
        assertEquals(ZonedDateTime.parse("2014-07-19T15:56:14Z"), job.getEndDate());
        assertEquals(60006382L, job.getFacilityID());
        assertEquals(498338451, job.getInstallerCharacterID());
        assertEquals(229136101, job.getID());
        assertTrue(job.getLicensedRuns().isPresent());
        assertEquals((Integer)200, job.getLicensedRuns().get());
        assertEquals(60006382, job.getOutputLocationID());
        assertEquals(1, job.getRuns());
        assertEquals(ZonedDateTime.parse("2014-07-19T15:47:06Z"), job.getStartDate());
        assertEquals(60006382, job.getStationID());
        assertEquals(IndustryJob.Status.ACTIVE, job.getStatus());

        assertFalse(job.getCompletedCharacterID().isPresent());
        assertFalse(job.getCompletionDate().isPresent());
        assertFalse(job.getProbability().isPresent());
        assertFalse(job.getProductItemTypeID().isPresent());
        assertFalse(job.getSuccessfulRuns().isPresent());
    }
}