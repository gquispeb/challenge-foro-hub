package com.foro.foro_hub.controller;

import com.foro.foro_hub.domain.usuarios.DatosAutenticacionUsuario;
import com.foro.foro_hub.domain.usuarios.DatosJWTToken;
import com.foro.foro_hub.domain.usuarios.Usuario;
import com.foro.foro_hub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DatosAutenticacionUsuario datos) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.contrasena());
        Authentication autenticacion = authenticationManager.authenticate(authToken);

        String jwtToken = tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }

}
