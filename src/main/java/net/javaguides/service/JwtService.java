package net.javaguides.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.entity.Member;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtService {
    // Token有效期限 (設定15分鐘過期)
    private Long EXPIRATION_TIME = (long) (60*60*1000); //單位ms

    //BASE64編碼的密鑰
    private String SECRET_KEY = "546A55A71347A254462D4......";

    /**
     * 從JWT令牌中提取用戶名
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * 提取JWT令牌中的任何聲明（Claims），並通過提供的Function來解析它們。
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(Member member) {
        return generateToken(new HashMap<>(), member);
    }

    /**
     * 簽發Token
     */
    public String generateToken(
            Map<String, Object> extractClaims,
            Member member
    ) {
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setHeaderParam("typ","JWT")
                .setSubject("測試測試123") //以Username做為Subject
                .claim("name",member.getMemberName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 驗證Token有效性，比對JWT和member的memberName(Email)是否相同
     * @return 有效為True，反之False
     */
    public boolean isTokenValid(String token, Member member) {
        final String memberName = extractUsername(token);
        return (memberName.equals(member.getMemberName())) && !isTokenExpired(token);
    }

    /**
     * 驗證token是否過期
     */
    private boolean isTokenExpired(String token) {
        final Date expirationDate = extractExpiration(token);
        return expirationDate != null && expirationDate.before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * 獲取令牌中所有的聲明將其解析
     * @return 令牌中所有的聲明
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 獲取JWT簽名的密鑰
     */
    private Key getSignInKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
}
