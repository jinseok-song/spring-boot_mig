package net.appspeed.studio.service;

import net.appspeed.studio.controller.HelloController;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class DbConnectService {


    public static final Logger logger = LogManager.getLogger(DbConnectService.class);
    public Object getData(){
        BasicDataSource driver = new BasicDataSource();
        driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driver.setUrl("jdbc:mysql://169.56.72.66:3306/studio?zeroDateTimeBehavior=convertToNull");


        driver.setUsername("sa");
        driver.setPassword("sm1418!1662");
        driver.setDefaultAutoCommit(true);

        NamedParameterJdbcTemplate resultJdbcTemplate = new NamedParameterJdbcTemplate(driver);
        Map<String, Object> jbatisMap = new HashMap<String, Object>();


        Map<String, Object> map = resultJdbcTemplate.queryForMap("select version()", jbatisMap);


        logger.debug("db실행성공");
        logger.debug(map);

        return null;
    }




}
