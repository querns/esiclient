package gbsio.esiclient.internal.domain.response.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.character.PortraitURLs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class PortraitURLsImpl implements PortraitURLs {
    private final URL url128;
    private final URL url256;
    private final URL url512;
    private final URL url64;

    PortraitURLsImpl(
        @JsonProperty("px128x128")
        final String url128,
        @JsonProperty("px256x256")
        final String url256,
        @JsonProperty("px512x512")
        final String url512,
        @JsonProperty("px64x64")
        final String url64
    ) throws MalformedURLException {
        this.url128 = null == url128 ? null : new URL(url128);
        this.url256 = null == url256 ? null : new URL(url256);
        this.url512 = null == url512 ? null : new URL(url512);
        this.url64 =  null == url64 ? null : new URL(url64);
    }

    @Override
    public Optional<URL> get128x128() {
        return Optional.ofNullable(url128);
    }

    @Override
    public Optional<URL> get256x256() {
        return Optional.ofNullable(url256);
    }

    @Override
    public Optional<URL> get512x512() {
        return Optional.ofNullable(url512);
    }

    @Override
    public Optional<URL> get64x64() {
        return Optional.ofNullable(url64);
    }
}
