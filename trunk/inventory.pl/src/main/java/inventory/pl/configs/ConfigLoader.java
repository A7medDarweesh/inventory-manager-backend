package inventory.pl.configs;

import inventory.pl.services.ServiceManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class ConfigLoader {
 private static ApplicationContext ctx;
    public static ServiceManager getServiceManager() {
        ctx= new AnnotationConfigApplicationContext(JPAConfig.class);
        ServiceManager manager = ctx.getBean(ServiceManager.class);
        return manager;
    }
    public static void closeContext(){
        ((ConfigurableApplicationContext)ctx).close();
    }
}
