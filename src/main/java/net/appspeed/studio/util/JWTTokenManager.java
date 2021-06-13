package net.appspeed.studio.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class JWTTokenManager {

    //@Value("${jwt.encode.key}")
    private String jwtEncodeKey = "appspeed";


    public String makeTokenCookie() throws Exception {

        Date tokenExpireDate;
        tokenExpireDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        String token;


        Map<String, Object> tokenData = new HashMap<String, Object>();
        // 토튼해드를 만든다
        Map<String, Object> header = new HashMap<String, Object>();

        header.put("alg", "HS256");
        header.put("typ", "JWT");

        // 현재 IP를 추가한다
        // 향후 오인방지를 위해서 적용함
        tokenData.put("ip", "appspeed");
        tokenData.put("name","우리나라");
        JwtBuilder builder = Jwts.builder();

        builder.setHeader(header);
        builder.setClaims(tokenData);
        builder.setExpiration(tokenExpireDate);
        builder.signWith(SignatureAlgorithm.HS256, jwtEncodeKey.getBytes("UTF-8"));


        token = builder.compact();

        return token;


    }
}
