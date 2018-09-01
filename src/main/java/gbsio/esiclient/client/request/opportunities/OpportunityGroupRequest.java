package gbsio.esiclient.client.request.opportunities;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.request.Language;
import gbsio.esiclient.api.domain.response.opportunities.OpportunityGroup;
import gbsio.esiclient.api.request.I18Nable;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about an opportunity group.
 */
final public class OpportunityGroupRequest implements GetRequest<OpportunityGroup>, I18Nable {
    private final int groupID;
    private final Language language;

    /**
     * Creates a request with the default language of en-us.
     *
     * @param groupID the ID of the group to query
     */
    public OpportunityGroupRequest(final int groupID) {
        this(groupID, null);
    }

    /**
     * @param groupID the ID of the group to query
     * @param language the language to use for info returned
     */
    @SuppressWarnings("WeakerAccess")
    public OpportunityGroupRequest(final int groupID, final Language language) {
        this.groupID = groupID;
        this.language = language;
    }

    @Override
    public String getURL() {
        return String.format("/v1/opportunities/groups/%d/", groupID);
    }

    @Override
    public TypeReference<OpportunityGroup> getExpectedType() {
        return new TypeReference<OpportunityGroup>() {
        };
    }

    @Override
    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }
}
