package lk.jiat.app.web.listner;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import lk.jiat.app.core.provider.MailServiceProvider;

@WebListener
public class ServletContextListener implements jakarta.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MailServiceProvider.getInstance().start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MailServiceProvider.getInstance().shutdown();
    }

}
