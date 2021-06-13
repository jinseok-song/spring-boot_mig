package net.appspeed.studio.service;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.*;

@Service
@Log4j2
@Configuration
public class DbConnectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private final AppSppedConfig appSppedConfig;

    public DbConnectService(AppSppedConfig appSppedConfig) {
        this.appSppedConfig = appSppedConfig;

        System.out.println(appSppedConfig.getPlatform());
    }


    @Bean(name = "Config")
    @Qualifier("Config")

    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource Config() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    public List<Map<String, Object>> getdbData() throws Exception {
        String sql;

        String dbType = appSppedConfig.getPlatform();

        if (dbType == "maria") {
            sql = "select * from jj_user";

        } else {
            sql = "select @@version as version";
        }

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        log.info("======================================");

        log.info("사용된 db이름: " + String.valueOf(rows));

        log.info("======================================");
        return rows;
    }

}
