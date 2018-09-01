package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.CorporationMedal;

import java.time.ZonedDateTime;

public class CorporationMedalImpl implements CorporationMedal {
    private final int creatorID;
    private final ZonedDateTime createdAt;
    private final int medalID;
    private final String title;
    private final String description;

    CorporationMedalImpl(
        @JsonProperty(value = "creator_id", required = true)
        final int creatorID,
        @JsonProperty(value = "created_at", required = true)
        final ZonedDateTime createdAt,
        @JsonProperty(value = "medal_id", required = true)
        final int medalID,
        @JsonProperty(value = "title", required = true)
        final String title,
        @JsonProperty(value = "description", required = true)
        final String description
    ) {
        this.creatorID = creatorID;
        this.createdAt = createdAt;
        this.medalID = medalID;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getCreatorID() {
        return creatorID;
    }

    @Override
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public int getMedalID() {
        return medalID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
