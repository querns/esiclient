package gbsio.esiclient.api.request;

import gbsio.esiclient.api.domain.request.Language;

import java.util.Optional;

/**
 * Indicates that a request can optionally support a language as a query
 * parameter.
 */
@SuppressWarnings("SpellCheckingInspection")
public interface I18Nable {
    /**
     * Gets the preferred language type to return.
     *
     * @return a language
     */
    Optional<Language> getLanguage();
}
