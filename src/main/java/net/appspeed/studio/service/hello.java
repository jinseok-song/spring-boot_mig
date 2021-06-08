package net.appspeed.studio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class hello {

    @Value("${site-url.naver}")
    private String naver;

    @Value("${site-url.google}")
    private String google;
    @Autowired
    DbConnectService dbc;


    public Map<String, Object> index() {

        @SuppressWarnings("rawtypes")
        Map<String, Object> tokenData = new HashMap();//<String, Object>();
        tokenData.put("naver", naver);
        tokenData.put("google", google);

        dbc.getData();

        System.out.print("dbc.getData()");
        return tokenData;

    }
}
