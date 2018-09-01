package gbsio.esiclient.internal.scheduling.impl;

import gbsio.esiclient.internal.Constants;
import gbsio.esiclient.internal.scheduling.ErrorCapacity;
import io.netty.handler.codec.http.HttpHeaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ErrorCapacityImplTest {
    private static final String DATE = "Sun, 10 Jun 2018 01:08:36 GMT";
    private static final ZonedDateTime DATE_AFTER = ZonedDateTime.parse("Sun, 10 Jun 2018 01:09:36 GMT", DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz"));
    private static final ZonedDateTime DATE_VALID = ZonedDateTime.parse(DATE, DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz"));
    private static final String ERROR_LIMIT_RESET = "60";
    private static final String REMAINING = "100";

    private HttpHeaders headers;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<ErrorCapacity> errorCapacity;

    @BeforeEach
    void setUp() {
        headers = mock(HttpHeaders.class);
    }

    @Test
    void fromNullDate() {
        mockHeaders(ERROR_LIMIT_RESET, REMAINING, null);
        errorCapacity = ErrorCapacity.from(headers);
        assertEquals(Optional.empty(), errorCapacity);
    }

    @Test
    void fromMalformedDate() {
        mockHeaders(ERROR_LIMIT_RESET, REMAINING, "lol");
        errorCapacity = ErrorCapacity.from(headers);
        assertEquals(Optional.empty(), errorCapacity);
    }

    @Test
    void fromMissingErrorLimit() {
        mockHeaders(null, REMAINING, DATE);
        errorCapacity = ErrorCapacity.from(headers);
        assertEquals(Optional.empty(), errorCapacity);
    }

    @Test
    void fromMissingRemaining() {
        mockHeaders(ERROR_LIMIT_RESET, null, DATE);
        errorCapacity = ErrorCapacity.from(headers);
        assertEquals(Optional.empty(), errorCapacity);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void fromValid() {
        mockHeaders(ERROR_LIMIT_RESET, REMAINING, DATE);
        errorCapacity = ErrorCapacity.from(headers);
        assertTrue(errorCapacity.isPresent());
        assertEquals(Integer.parseInt(ERROR_LIMIT_RESET), errorCapacity.get().getSecondsUntilCapacityReset());
        assertEquals(Integer.parseInt(REMAINING), errorCapacity.get().getRemainingCapacity());
    }

    private void mockHeaders(String errorLimitReset, String remainingHeaders, String dateHeader) {
        if (null != errorLimitReset) {
            when(headers.get(Constants.ERROR_LIMIT_RESET_HEADER)).thenReturn(errorLimitReset);
            when(headers.contains(Constants.ERROR_LIMIT_RESET_HEADER)).thenReturn(true);
        }
        if (null != remainingHeaders) {
            when(headers.get(Constants.REMAINING_ERROR_LIMIT_HEADER)).thenReturn(remainingHeaders);
            when(headers.contains(Constants.REMAINING_ERROR_LIMIT_HEADER)).thenReturn(true);
        }
        if (null != dateHeader) {
            when(headers.get(Constants.DATE_HEADER)).thenReturn(dateHeader);
            when(headers.contains(Constants.DATE_HEADER)).thenReturn(true);
        }
    }
}