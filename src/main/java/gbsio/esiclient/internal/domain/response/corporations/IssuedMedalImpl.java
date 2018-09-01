package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.common.Medal;
import gbsio.esiclient.api.domain.response.corporation.IssuedMedal;

import java.time.ZonedDateTime;

public class IssuedMedalImpl implements IssuedMedal {
    private final int recipientCharacterID;
    private final ZonedDateTime issueDate;
    private final int issuerCharacterID;
    private final int medalID;
    private final String reason;
    private final Medal.PrivacyStatus privacyStatus;

    IssuedMedalImpl(
        @JsonProperty(value = "character_id", required = true)
        final int recipientCharacterID,
        @JsonProperty(value = "issued_at", required = true)
        final ZonedDateTime issueDate,
        @JsonProperty(value = "issuer_id", required = true)
        final int issuerCharacterID,
        @JsonProperty(value = "medal_id", required = true)
        final int medalID,
        @JsonProperty(value = "reason", required = true)
        final String reason,
        @JsonProperty(value = "status", required = true)
        final Medal.PrivacyStatus privacyStatus
    ) {
        this.recipientCharacterID = recipientCharacterID;
        this.issueDate = issueDate;
        this.issuerCharacterID = issuerCharacterID;
        this.medalID = medalID;
        this.reason = reason;
        this.privacyStatus = privacyStatus;
    }

    @Override
    public int getRecipientCharacterID() {
        return recipientCharacterID;
    }

    @Override
    public ZonedDateTime getIssueDate() {
        return issueDate;
    }

    @Override
    public int getIssuerCharacterID() {
        return issuerCharacterID;
    }

    @Override
    public int getMedalID() {
        return medalID;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public Medal.PrivacyStatus getPrivacyStatus() {
        return privacyStatus;
    }
}
