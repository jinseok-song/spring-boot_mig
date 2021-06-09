package net.appspeed.studio.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.appspeed.studio.controller.HelloController;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Service
@PropertySource("classpath:/application.yml")
public class DbConnectService {
//DBConfig 파일

    //public static final Logger logger = LogManager.getLogger(DbConnectService.class);

    @Autowired
    DataSource dataSource;

    @ConfigurationProperties(prefix = "spring.datasource.hikari")
     class DataSourceOrd extends HikariConfig {


        @Primary
        @Bean(name = "dataSourceOrd")
        public DataSource DataSourceOrd() {
            System.out.println("데이터소스  실행");

            return new HikariDataSource(this);

        }
    }

    public Object getMariadbData(){

        DataSourceOrd dataSource = new DataSourceOrd();


        dataSource.getDataSourceClassName();
        System.out.println(dataSource.getDataSourceClassName());
        dataSource.getJdbcUrl();
        dataSource.getUsername();
        dataSource.getPassword();


        NamedParameterJdbcTemplate resultJdbcTemplate = new NamedParameterJdbcTemplate(dataSource.getDataSource());
        Map<String, Object> jbatisMap = new HashMap<String, Object>();
        Map<String, Object> map = resultJdbcTemplate.queryForMap("select version()", jbatisMap);

        System.out.println(map);
        return null;
    }
//    public Object getMariadbData(){
//        BasicDataSource driver = new BasicDataSource();
//        driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        driver.setUrl("jdbc:mysql://169.56.72.66:3306/studio?zeroDateTimeBehavior=convertToNull");
//
//        driver.setUsername("sa");
//        driver.setPassword("sm1418!1662");
//        driver.setDefaultAutoCommit(true);
//        NamedParameterJdbcTemplate resultJdbcTemplate = new NamedParameterJdbcTemplate(driver);
//        Map<String, Object> jbatisMap = new HashMap<String, Object>();
//        Map<String, Object> map = resultJdbcTemplate.queryForMap("select version()", jbatisMap);
//        logger.info("db실행성공");
//        logger.info(map);
//
//        return null;
//    }

//    public Object getMssqlData(){
//        BasicDataSource driver = new BasicDataSource();
//        driver.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        driver.setUrl("jdbc:sqlserver://169.56.72.70:1433;databaseName=sample");
//
//
//        driver.setUsername("sa");
//        driver.setPassword("sm1418!1662");
//        driver.setDefaultAutoCommit(true);
//
//        NamedParameterJdbcTemplate resultJdbcTemplate = new NamedParameterJdbcTemplate(driver);
//        Map<String, Object> jbatisMap = new HashMap<String, Object>();
//
//
//        Map<String, Object> map = resultJdbcTemplate.queryForMap("select @@version as version", jbatisMap);
//
//
//        logger.info("db실행성공");
//        logger.info(map);
//
//        return null;
//    }
//
//    public Object getOracleData(){
//        BasicDataSource source = new BasicDataSource();
//        source.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        source.setUrl("jdbc:oracle:thin:@169.56.72.70:1521:xe");
//
//        source.setUsername("sa");
//        source.setPassword("sm1418!1662");
//        source.setDefaultAutoCommit(true);
//
//        NamedParameterJdbcTemplate resultJdbcTemplate = new NamedParameterJdbcTemplate(source);
//        Map<String, Object> jbatisMap = new HashMap<String, Object>();
//
//
//        Map<String, Object> map = resultJdbcTemplate.queryForMap("SELECT BANNER_FULL as version FROM v$version WHERE banner LIKE 'Oracle%'", jbatisMap);
//
//
//        logger.info("db실행성공");
//        logger.info(map);
//
//        return null;
//    }
//    public Object getPostgreData(){
//        BasicDataSource source = new BasicDataSource();
//        source.setDriverClassName("org.postgresql.Driver");
//        source.setUrl("jdbc:postgresql://169.56.72.66:5438/postgres");
//        source.setUsername("sa");
//        source.setPassword("sm1418!1662");
//        source.setDefaultAutoCommit(true);
//
//        NamedParameterJdbcTemplate resultJdbcTemplate = new NamedParameterJdbcTemplate(source);
//        Map<String, Object> jbatisMap = new HashMap<String, Object>();
//
//
//        Map<String, Object> map = resultJdbcTemplate.queryForMap("select version() as version", jbatisMap);
//
//
//        logger.info("db실행성공");
//        logger.info(map);
//
//        return null;
//    }


}
