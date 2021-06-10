package net.appspeed.studio.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

@Configuration
@Service
@Log4j2

//@ConfigurationProperties(prefix = "spring.datasource.hikari")
//class DataSourceOrd extends HikariConfig {
//
//
//    @Primary
//    @Bean(name = "dataSource")
//    public DataSource DataSource() {
//        System.out.println("데이터소스 생성");
//
//        return new HikariDataSource(this);
//
//    }
//}



//DBConfig 파일
@PropertySource("classpath:/application.yml")
public class DbConnectService {
    //@Qualifier("dataSource")


    @Bean
    @ConfigurationProperties(prefix = "spring.maria.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Autowired
    @Bean(name = "dataSource")
    public DataSource dataSource() throws Exception {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println(dataSource.getConnection().getMetaData().getDriverVersion());
        return dataSource;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getMariadbData() throws Exception {

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from jj_user");

//        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
//        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
//
//        Connection connection = null;
//        PreparedStatement pstmt = null;
//        ResultSet resultSet = null;
//        connection = dataSource().getConnection();
//        pstmt = connection.prepareStatement("select * from jj_user");
//
//        resultSet = pstmt.executeQuery();
//        ResultSetMetaData md = resultSet.getMetaData();
//
//        int cols = md.getColumnCount();
//
//        while (resultSet.next()) {
//            //System.out.println(resultSet.getString(1));
//            Map<String, Object> row = new LinkedHashMap<>(cols);
//
//            for (int j = 1; j <= cols; ++j) {
//                if (resultSet.getObject(j) != null && "CLOB".equals(resultSet.getObject(j).getClass().getSimpleName())) {
//                    row.put(md.getColumnName(j), resultSet.getString(j));
//                } else {
//                    row.put(md.getColumnName(j), resultSet.getObject(j));
//                }
//                System.out.println(row);
//            }
//
//            rows.add(row);
//
//        }

//        System.out.println(rows);


//        dataSource.getDataSourceClassName();
//        dataSource.getJdbcUrl();
//        dataSource.getUsername();
//        dataSource.getPassword();


//        NamedParameterJdbcTemplate resultJdbcTemplate = new NamedParameterJdbcTemplate(dataSource.getDataSource());
//        Map<String, Object> jbatisMap = new HashMap<String, Object>();
//        Map<String, Object> map = resultJdbcTemplate.queryForMap("select version()", jbatisMap);
//
//        System.out.println(map);
        log.info(String.valueOf(rows));
        return rows;
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
