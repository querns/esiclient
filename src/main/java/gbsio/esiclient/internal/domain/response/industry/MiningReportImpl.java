package gbsio.esiclient.internal.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.industry.MiningReport;

import java.time.LocalDate;

public class MiningReportImpl implements MiningReport {
    private final LocalDate date;
    private final long quantity;
    private final int solarSystemID;
    private final int materialItemTypeID;

    MiningReportImpl(
        @JsonProperty(value = "date", required = true)
        final LocalDate date,
        @JsonProperty(value = "quantity", required = true)
        final long quantity,
        @JsonProperty(value = "solar_system_id", required = true)
        final int solarSystemID,
        @JsonProperty(value = "type_id", required = true)
        final int materialItemTypeID
    ) {
        this.date = date;
        this.quantity = quantity;
        this.solarSystemID = solarSystemID;
        this.materialItemTypeID = materialItemTypeID;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public long getQuantity() {
        return quantity;
    }

    @Override
    public int getSolarSystemID() {
        return solarSystemID;
    }

    @Override
    public int getMaterialItemTypeID() {
        return materialItemTypeID;
    }

}
