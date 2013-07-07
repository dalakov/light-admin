package org.lightadmin.core.context;

import javax.servlet.ServletContext;

import static org.apache.commons.lang.BooleanUtils.toBoolean;
import static org.apache.commons.lang.StringUtils.defaultIfBlank;
import static org.lightadmin.core.util.LightAdminConfigurationUtils.*;

public class StandardWebContext implements WebContext {

    private final String applicationBaseUrl;
    private final String applicationBaseNoEndSeparator;
    private final boolean securityEnabled;
    private final String securityLogoutUrl;

    public StandardWebContext(ServletContext servletContext) {
        this.applicationBaseUrl = servletContext.getInitParameter(LIGHT_ADMINISTRATION_BASE_URL);
        this.applicationBaseNoEndSeparator = urlWithoutEndSeparator(this.applicationBaseUrl);
        this.securityEnabled = toBoolean(servletContext.getInitParameter(LIGHT_ADMINISTRATION_SECURITY));
        if (securityEnabled) {
            this.securityLogoutUrl = servletContext.getContextPath() + this.applicationBaseNoEndSeparator + LIGHT_ADMIN_SECURITY_LOGOUT_URL_DEFAULT;
        } else {
            this.securityLogoutUrl = servletContext.getContextPath() + defaultIfBlank(servletContext.getInitParameter(LIGHT_ADMINISTRATION_SECURITY_LOGOUT_URL), "#");
        }
    }

    @Override
    public String getApplicationBaseUrl() {
        return applicationBaseUrl;
    }

    @Override
    public String getApplicationUrl(String path) {
        return applicationBaseNoEndSeparator + path;
    }

    @Override
    public boolean isSecurityEnabled() {
        return securityEnabled;
    }

    @Override
    public String getSecurityLogoutUrl() {
        return securityLogoutUrl;
    }

    private String urlWithoutEndSeparator(String url) {
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }
}