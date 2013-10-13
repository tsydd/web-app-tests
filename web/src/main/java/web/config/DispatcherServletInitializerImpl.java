package web.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author Dmitry Tsydzik
 * @since Date: 04.10.13
 */
public class DispatcherServletInitializerImpl
        extends AbstractDispatcherServletInitializer {

    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocation("classpath:dispatcher-servlet.xml");
        return ctx;
    }

//    @Override
    protected String[] getServletMappings() {
        return new String[]{"/disp/*"};
    }
}
