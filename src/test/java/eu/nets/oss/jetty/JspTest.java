package eu.nets.oss.jetty;

import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Ignore;
import org.junit.Test;

import static eu.nets.oss.jetty.EmbeddedJettyBuilder.ServletContextHandlerBuilder;

public class JspTest {

    private final String contextPath = "/";
    private final int port = 8098;

    @Test
    @Ignore
    public void testCreateRootContextHandler() throws Exception {
        EmbeddedJettyBuilder builder = getBuilder();

        ServletContextHandlerBuilder<WebAppContext> ctx = builder.createRootWebAppContext("", Resource.newClassPathResource("/jsp-test"));

        builder.startJetty();
        Thread.sleep(100 * 1000);
        builder.stopJetty();
    }

    public static void main(String[] args) throws Exception {
        new JspTest().testCreateRootContextHandler();
    }

    private EmbeddedJettyBuilder getBuilder() {
        ContextPathConfig config = new StaticConfig(contextPath, port);
        return new EmbeddedJettyBuilder(config, true);
    }
}
