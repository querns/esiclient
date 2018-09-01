package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterMedal;
import gbsio.esiclient.api.domain.response.common.Medal;

import java.time.ZonedDateTime;

public class CharacterMedalImpl implements CharacterMedal {
    private final int corporationID;
    private final ZonedDateTime date;
    private final String description;
    private final ImmutableList<Medal.MedalGraphicLayer> graphics;
    private final int issuerID;
    private final int medalID;
    private final String reason;
    private final Medal.PrivacyStatus status;
    private final String title;

    CharacterMedalImpl(
        @JsonProperty(value = "corporation_id", required = true)
        final int corporationID,
        @JsonProperty(value = "date", required = true)
        final ZonedDateTime date,
        @JsonProperty(value = "description", required = true)
        final String description,
        @JsonProperty(value = "graphics", required = true)
        final ImmutableList<Medal.MedalGraphicLayer> graphics,
        @JsonProperty(value = "issuer_id", required = true)
        final int issuerID,
        @JsonProperty(value = "medal_id", required = true)
        final int medalID,
        @JsonProperty(value = "reason", required = true)
        final String reason,
        @JsonProperty(value = "status", required = true)
        final Medal.PrivacyStatus status,
        @JsonProperty(value = "title", required = true)
        final String title
    ) {
        this.corporationID = corporationID;
        this.date = date;
        this.description = description;
        this.graphics = graphics;
        this.issuerID = issuerID;
        this.medalID = medalID;
        this.reason = reason;
        this.status = status;
        this.title = title;
    }

    public int getCorporationID() {
        return corporationID;
    }

    public ZonedDateTime getIssueDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public ImmutableList<Medal.MedalGraphicLayer> getGraphics() {
        return graphics;
    }

    public int getIssuerID() {
        return issuerID;
    }

    public int getMedalID() {
        return medalID;
    }

    public String getReason() {
        return reason;
    }

    public Medal.PrivacyStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
