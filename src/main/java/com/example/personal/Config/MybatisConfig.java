package com.example.personal.Config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@MapperScan(value = "com.example.personal.MybatisRepository", sqlSessionFactoryRef = "SqlSessionFactory", sqlSessionTemplateRef = "SessionTemplate")
public class MybatisConfig {

	@Autowired
	private Environment env;

	@Value("${spring.datasource.mapper-locations}")
	public String mPath;

	@Value("${mybatis.config-location}")
	public String configPath;

	public String configEnvPath;

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "SqlSessionFactory")
	public SqlSessionFactory SqlSessionFactory(@Qualifier("dataSource") DataSource DataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(DataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mPath));

		// Mybatis-config에서 부여한 별칭을 세팅
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(configPath));

		/* Environment를 활용한 환경변수 가져오기 */
//		configEnvPath = env.getProperty("mybatis.config-location", "classpath:mybatis-config.xml");
//		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(configEnvPath));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "SessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory firstSqlSessionFactory) {
		return new SqlSessionTemplate(firstSqlSessionFactory);
	}
}
