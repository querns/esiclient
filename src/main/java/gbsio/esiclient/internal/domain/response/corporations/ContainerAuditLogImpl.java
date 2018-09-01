package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.ContainerAuditLog;

import java.time.ZonedDateTime;
import java.util.Optional;

public class ContainerAuditLogImpl implements ContainerAuditLog {
    private final Action action;
    private final int characterID;
    private final long containerID;
    private final int containerTypeID;
    private final String locationFlag;
    private final long locationID;
    private final ZonedDateTime date;
    private final Integer newConfigBitmask;
    private final Integer oldConfigBitmask;
    private final PasswordType passwordType;
    private final Integer quantity;
    private final Integer itemTypeID;

    ContainerAuditLogImpl(
        @JsonProperty(value = "action", required = true)
        final Action action,
        @JsonProperty(value = "character_id", required = true)
        final int characterID,
        @JsonProperty(value = "container_id", required = true)
        final long containerID,
        @JsonProperty(value = "container_type_id", required = true)
        final int containerTypeID,
        @JsonProperty(value = "location_flag", required = true)
        final String locationFlag,
        @JsonProperty(value = "location_id", required = true)
        final long locationID,
        @JsonProperty(value = "logged_at", required = true)
        final ZonedDateTime date,
        @JsonProperty("new_config_bitmask")
        final Integer newConfigBitmask,
        @JsonProperty("old_config_bitmask")
        final Integer oldConfigBitmask,
        @JsonProperty("password_type")
        final PasswordType passwordType,
        @JsonProperty("quantity")
        final Integer quantity,
        @JsonProperty("type_id")
        final Integer itemTypeID
    ) {
        this.action = action;
        this.characterID = characterID;
        this.containerID = containerID;
        this.containerTypeID = containerTypeID;
        this.locationFlag = locationFlag;
        this.locationID = locationID;
        this.date = date;
        this.newConfigBitmask = newConfigBitmask;
        this.oldConfigBitmask = oldConfigBitmask;
        this.passwordType = passwordType;
        this.quantity = quantity;
        this.itemTypeID = itemTypeID;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public int getCharacterID() {
        return characterID;
    }

    @Override
    public long getContainerID() {
        return containerID;
    }

    @Override
    public int getContainerTypeID() {
        return containerTypeID;
    }

    @Override
    public String getLocationFlag() {
        return locationFlag;
    }

    @Override
    public long getLocationID() {
        return locationID;
    }

    @Override
    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public Optional<Integer> getNewConfigBitmask() {
        return Optional.ofNullable(newConfigBitmask);
    }

    @Override
    public Optional<Integer> getOldConfigBitmask() {
        return Optional.ofNullable(oldConfigBitmask);
    }

    @Override
    public Optional<PasswordType> getPasswordType() {
        return Optional.ofNullable(passwordType);
    }

    @Override
    public Optional<Integer> getQuantity() {
        return Optional.ofNullable(quantity);
    }

    @Override
    public Optional<Integer> getItemTypeID() {
        return Optional.ofNullable(itemTypeID);
    }
}
