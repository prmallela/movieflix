package com.prmallela.app;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.config.SystemProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class JPAConfig {

	@Value("${Database.Driver}")
	private String databaseDriver;
	@Value("${Database.Url}")
	private String databaseUrl;
	@Value("${Database.Username}")
	private String databaseUsername;
	@Value("${Database.Password}")
	private String databasePassword;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.prmallela.app.entity");
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(databaseDriver);
		ds.setUrl(databaseUrl);
		ds.setUsername(databaseUsername);
		ds.setPassword(databasePassword);

		/*ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/movieflix?useSSL=false");
		ds.setUsername("param");
		ds.setPassword("param");*/
		return ds;
	}

	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
		JpaTransactionManager txnManager = new JpaTransactionManager(emf);
		return txnManager;
	}

	private Properties jpaProperties() {
		Properties props = new Properties();
		props.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
		props.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		props.setProperty(PersistenceUnitProperties.WEAVING, "false");
		return props;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}