package net.appspeed.studio.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Component

@Configuration
@PropertySource("classpath:application.yml")
public class hello {

    @Value("${site-url.naver}")
    private String naver;

    @Value("${site-url.google}")
    private String google;

    @Value("${site-url.test}")
    private String test;


    @Autowired
    DbConnectService dbc;



    public Map<String, Object> index() throws Exception {


        Map<String, Object> tokenData = new HashMap();//<String, Object>();
        tokenData.put("naver", naver);
        tokenData.put("google", google);
        tokenData.put("test", test);
        dbc.getMariadbData();
//        dbc.getMssqlData();
//        dbc.getOracleData();
//        dbc.getPostgreData();
        //dbc.getOracleData();
        //tokenData.put("dbinfo",dbc.getMariadbData());

        return tokenData;

    }
}
