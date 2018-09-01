package gbsio.esiclient.api.domain.response.errors;

import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.util.EnumUtil;

/**
 * Describes the type of error encountered.
 */
public enum ErrorType implements EnumUtil.MappableEnum {
    BAD_REQUEST(400), ERROR_LIMITED(420), FORBIDDEN(403), GATEWAY_TIMEOUT(504),
    INTERNAL_SERVER_ERROR(500), SERVICE_UNAVAILABLE(503), UNAUTHORIZED(401),
    METHOD_NOT_ALLOWED(405), NOT_FOUND(404), UNPROCESSABLE_ENTITY(422),
    UNKNOWN(0), CLIENT_EXCEPTION(600);

    private final int errorCode;
    private static final ImmutableMap<String, ErrorType> map = EnumUtil.generateMap(values());

    ErrorType(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getIdentifier() {
        return String.valueOf(errorCode);
    }

    public static ErrorType of(int identifier) {
        return map.getOrDefault(String.valueOf(identifier), UNKNOWN);
    }
}
