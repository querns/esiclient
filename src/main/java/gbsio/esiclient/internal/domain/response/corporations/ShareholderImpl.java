package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.Shareholder;

public class ShareholderImpl implements Shareholder {
    private final long shareCount;
    private final int shareholderID;
    private final ShareholderType shareholderType;

    ShareholderImpl(
        @JsonProperty(value = "share_count", required = true)
        final long shareCount,
        @JsonProperty(value = "shareholder_id", required = true)
        final int shareholderID,
        @JsonProperty(value = "shareholder_type", required = true)
        final ShareholderType shareholderType
    ) {
        this.shareCount = shareCount;
        this.shareholderID = shareholderID;
        this.shareholderType = shareholderType;
    }

    @Override
    public long getShareCount() {
        return shareCount;
    }

    @Override
    public int getShareholderID() {
        return shareholderID;
    }

    @Override
    public ShareholderType getShareholderType() {
        return shareholderType;
    }
}
