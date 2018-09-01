package gbsio.esiclient.internal.domain.response.corporations;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.corporation.CorporationIconURLs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class CorporationIconURLsImpl implements CorporationIconURLs {
    private final URL icon128;
    private final URL icon256;
    private final URL icon64;

    CorporationIconURLsImpl(
        @JsonProperty("px128x128")
        final String icon128,
        @JsonProperty("px256x256")
        final String icon256,
        @JsonProperty("px64x64")
        final String icon64
    ) throws MalformedURLException {
        this.icon128 = icon128 == null ? null : new URL(icon128);
        this.icon256 = icon256 == null ? null : new URL(icon256);
        this.icon64 = icon64 == null ? null : new URL(icon64);
    }

    @Override
    public Optional<URL> getIcon128() {
        return Optional.ofNullable(icon128);
    }

    @Override
    public Optional<URL> getIcon256() {
        return Optional.ofNullable(icon256);
    }

    @Override
    public Optional<URL> getIcon64() {
        return Optional.ofNullable(icon64);
    }
}
