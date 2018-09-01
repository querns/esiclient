package gbsio.esiclient.api.domain.request;

/**
 * Describes a language return type supported by ESI.
 */
public enum Language {
    DE("de"), EN_US("en-us"), FR("fr"), JA("ja"), RU("ru"), ZH("zh");

    private final String identifier;

    Language(final String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
