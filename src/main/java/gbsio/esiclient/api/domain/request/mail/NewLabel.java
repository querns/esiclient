package gbsio.esiclient.api.domain.request.mail;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import gbsio.esiclient.api.domain.common.mail.LabelColor;

import java.util.Optional;

public interface NewLabel {
    /**
     * Gets the color to be assigned to this label.
     *
     * @return a label color
     */
    @JsonGetter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<LabelColor> getColor();

    /**
     * Gets the name for this label.
     *
     * @return the name
     */
    @JsonGetter
    String getName();
}
