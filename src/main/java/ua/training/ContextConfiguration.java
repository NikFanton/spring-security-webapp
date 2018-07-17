package ua.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.Property;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ContextConfiguration {

    @Bean
    public InternalResourceViewResolver setInternalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Value("classpath:sql/init.sql")
    private Resource schemaScript;

    @Value("classpath:sql/test-data.sql")
    private Resource dataScript;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:sql/init.sql")
                .addScript("classpath:sql/test-data.sql")
                .build();
    }

//    @Bean(name = "dataSource")
//    public DataSource getDataSource(){
//        DataSource dataSource = createDataSource();
//        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
//        return dataSource;
//    }
//
//    private DatabasePopulator createDatabasePopulator() {
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.setContinueOnError(true);
//        databasePopulator.addScript(schemaScript);
//        databasePopulator.addScript(dataScript);
//        return databasePopulator;
//    }
//
//    private SimpleDriverDataSource createDataSource() {
//        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
//        simpleDriverDataSource.setDriverClass(org.h2.Driver.class);
//        simpleDriverDataSource.setUrl("jdbc:h2:target/database/example;AUTO_RECONNECT=TRUE");
//        simpleDriverDataSource.setUsername("");
//        simpleDriverDataSource.setPassword("");
//        return simpleDriverDataSource;
//    }

//    @Bean
//    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
//            DataSource dataSource,
//            HibernateJpaVendorAdapter hibernateJpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean lcemFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        lcemFactoryBean.setDataSource(dataSource);
//        lcemFactoryBean.setPackagesToScan("ua.training.model");
//        lcemFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        map.put("hibernate.show_sql", "true");
//
//        lcemFactoryBean.setJpaPropertyMap(map);
//        return lcemFactoryBean;
//    }
//
//    @Bean
//    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
//        return jpaTransactionManager;
//    }
}
