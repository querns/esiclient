package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.response.common.CorporationPermissions;
import gbsio.esiclient.internal.domain.response.character.CharacterRolesImpl;

/**
 * Permissions for characters.
 *
 * This class exists to provide a deserialization point for {@link gbsio.esiclient.internal.domain.response.character.CharacterRolesImpl}
 * so as not to accidentally deserialize to the wrong type for the base interface.
 */
@JsonDeserialize(as = CharacterRolesImpl.class)
public interface CharacterRoles extends CorporationPermissions {
}
