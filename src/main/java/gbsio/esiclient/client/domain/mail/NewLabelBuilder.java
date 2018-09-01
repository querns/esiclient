package gbsio.esiclient.client.domain.mail;

import gbsio.esiclient.api.domain.common.mail.LabelColor;
import gbsio.esiclient.api.domain.request.mail.NewLabel;
import gbsio.esiclient.client.validation.mail.NewLabelValidator;

import java.util.Optional;

final public class NewLabelBuilder {
    private LabelColor color;
    private String name;

    @SuppressWarnings("unused")
    public NewLabelBuilder(final LabelColor color, final String name) {
        this.color = color;
        this.name = name;
    }

    @SuppressWarnings("unused")
    public NewLabelBuilder(final String name) {
        this.name = name;
        this.color = null;
    }

    @SuppressWarnings("unused")
    public NewLabelBuilder() {
    }

    @SuppressWarnings("unused")
    public NewLabelBuilder setColor(final LabelColor color) {
        this.color = color;
        return this;
    }

    public NewLabelBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public NewLabel build() {
        final NewLabel newLabel = new NewLabelImpl(color, name);
        NewLabelValidator.validate(newLabel);

        return newLabel;
    }

    public static class NewLabelImpl implements NewLabel {
        private final LabelColor color;
        private final String name;

        public NewLabelImpl(final LabelColor color, final String name) {
            this.color = color;
            this.name = name;
        }

        @Override
        public Optional<LabelColor> getColor() {
            return Optional.ofNullable(color);
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
