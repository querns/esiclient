package gbsio.esiclient.api.config;

/**
 * Describes which server to pull data from.
 */
public enum DataSource {
    TRANQUILITY("tranquility"), SINGULARITY("singularity");

    private final String identifier;

    DataSource(final String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
