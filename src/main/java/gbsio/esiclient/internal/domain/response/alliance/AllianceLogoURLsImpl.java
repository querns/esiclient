package gbsio.esiclient.internal.domain.response.alliance;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.alliance.AllianceLogoURLs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class AllianceLogoURLsImpl implements AllianceLogoURLs {
    private final URL logo128;
    private final URL logo64;

    AllianceLogoURLsImpl(
        @JsonProperty("px128x128") String logo128,
        @JsonProperty("px64x64") String logo64
    ) throws MalformedURLException {
        this.logo128 = null == logo128 ? null : new URL(logo128);
        this.logo64 = null == logo64 ? null : new URL(logo64);
    }

    @Override
    public Optional<URL> getLogo128() {
        return Optional.ofNullable(logo128);
    }

    @Override
    public Optional<URL> getLogo64() {
        return Optional.ofNullable(logo64);
    }
}
