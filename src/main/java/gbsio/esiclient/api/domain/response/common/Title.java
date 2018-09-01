package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.common.TitleImpl;

import java.util.Optional;

/**
 * Represents a title granted by a corporation towards one of its members.
 */
@JsonDeserialize(as = TitleImpl.class)
public interface Title {
    /**
     * Get the title's name.
     *
     * @return the
     */
    Optional<String> getName();

    /**
     * Get the title's ID
     *
     * @return the ID
     */
    Optional<Integer> getID();
}
