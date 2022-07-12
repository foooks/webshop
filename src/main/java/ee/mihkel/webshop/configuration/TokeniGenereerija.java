package ee.mihkel.webshop.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component  //JWT  -- JSON WEb Token
public class TokeniGenereerija {
    public String createAuthToken(){
        Date expirationDate = DateUtils.addHours(new Date(), 5);//appache commons lang
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String token = Jwts.builder()
            //    .signWith(key)
             .signWith(SignatureAlgorithm.HS512, "minu-taiesti-unikaalne-v6ti")
                .setExpiration(expirationDate)
                .setIssuer("Webshop")
                .compact();
        return token;
    }
}
