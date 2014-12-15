package inventory.pl.configs;

import inventory.pl.services.ServiceManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class ConfigLoader {

    public static ServiceManager getServiceManager() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
        ServiceManager manager = ctx.getBean(ServiceManager.class);
        return manager;
    }
}
