package com.hcms.hostelcomplaintmanagementsystem.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String key;

    @Value("${jwt.expiration}")
    private long keyExp;

    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(HashMap<String,Object> extraClaims, UserDetails userDetails)
    {
        return build(extraClaims,userDetails,keyExp);
    }

    private String build(HashMap<String, Object> extraClaims, UserDetails userDetails, long keyExp)
    {
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+keyExp))
                .signWith(getSignInKey())
                .compact();
    }

    private Key getSignInKey() {

        byte[] secretKey= Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(secretKey);

    }


    public boolean isTokenValid(String token, UserDetails userDetails)
    {
        try
        {
            String userName=extractUsername(token);
            return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
        }
        catch (ExpiredJwtException e) {
            log.warn("Token is expired: {}",e.getMessage());
            return false;
        }

        catch (Exception e)
        {
            log.error("Token validation failed: {}",e.getMessage());
            return false;
        }
    }

    private String extractUsername(String token) {

        return extractClaim(token,Claims::getSubject);

    }

    private Date extractExpirationDate(String token) {

        return extractClaim(token,Claims::getExpiration);
    }

    private<T> T extractClaim(String token, Function<Claims,T> claimResolver) {

        final Claims claims= extractAllClaims(token);
        return claimResolver.apply(claims);

    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith((SecretKey) getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }


    private boolean isTokenExpired(String token) {

        return extractExpirationDate(token).before(new Date());

    }











}
