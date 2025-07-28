package com.foro.foro_hub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.foro.foro_hub.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String claveSecreta;

    @Value("${jwt.expiration}")
    private Long tiempoExpiracionEnSegundos;

    public String generarToken(Usuario usuario) {
        Algorithm algoritmo = Algorithm.HMAC256(claveSecreta);
        return JWT.create()
                .withSubject(usuario.getEmail())
                .withIssuer("foro_hub") // ← ¡Este es necesario!
                .withIssuedAt(Date.from(Instant.now()))
                .withExpiresAt(Date.from(Instant.now().plus(tiempoExpiracionEnSegundos, ChronoUnit.SECONDS)))
                .sign(algoritmo);
    }

    public String getSubject(String tokenJWT) {
        return JWT.require(Algorithm.HMAC256(claveSecreta))
                .withIssuer("foro_hub")
                .build()
                .verify(tokenJWT)
                .getSubject();
    }


}
