package inventory.pl.configs;

import inventory.pl.services.ServiceManager;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"inventory.pl.dao"}, entityManagerFactoryRef = "enityMangerFactory")
@ComponentScan(basePackages = {"inventory.pl"})
@PropertySource("file:${user.home}/app.properties")
@EnableAsync
public class JPAConfig implements AsyncConfigurer{

    @Autowired
    Environment env;

   @Bean
    public LocalContainerEntityManagerFactoryBean enityMangerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        if( !env.getProperty("inventory.datasource.enabled").equals("true")){emf.setDataSource(dataSource());}
        emf.setPackagesToScan(new String[]{"inventory.pl"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaProperties(additionalProperties());
        return emf;
    }

    // @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("inventory.datasource.driver"));
        dataSource.setUrl(env.getProperty("inventory.datasource.url"));
        dataSource.setUsername(env.getProperty("inventory.datasource.user"));
        dataSource.setPassword(env.getProperty("inventory.datasource.password"));
        
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
       if( env.getProperty("inventory.datasource.enabled").equals("true")){ hibernateProperties.setProperty("hibernate.connection.datasource", env.getProperty("inventory.datasource.name"));}
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
        return hibernateProperties;
    }

 @Bean
    public ServiceManager getServiceManager() {
        return new ServiceManager();
    }
    @Bean
    public MessageSource messageSource(){
    	 ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
         messageSource.setBasename("inventory/pl/messages/messages");
         return messageSource;
    }
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setThreadNamePrefix("AsyncExecutor-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {

            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                System.out.println("exeption::"+ex.getMessage());
            }
        };
    }
}
