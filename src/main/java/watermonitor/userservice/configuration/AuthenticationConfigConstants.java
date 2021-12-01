package watermonitor.userservice.configuration;

public class AuthenticationConfigConstants {
    public static final String SECRET = "Java_to_Dev_Secret";
    public static final long EXPIRATION_TIME = 3600000; // 1 hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user/create";
    public static final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
    };
    public static final String ROLE_HIERARCHY = "ROLE_ADMIN > ROLE_STAFF \n ROLE_STAFF > ROLE_USER";
}