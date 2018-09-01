package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.OwnedStructure;

public class ServiceImpl implements OwnedStructureImpl.Service {
    private final String name;
    private final OwnedStructure.ServiceStatus status;

    ServiceImpl(
        @JsonProperty(value = "name", required = true)
        final String name,
        @JsonProperty(value = "state", required = true)
        final OwnedStructure.ServiceStatus status
    ) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public OwnedStructure.ServiceStatus getStatus() {
        return status;
    }
}
