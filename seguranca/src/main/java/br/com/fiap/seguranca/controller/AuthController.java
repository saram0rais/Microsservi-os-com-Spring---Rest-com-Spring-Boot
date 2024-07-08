package br.com.fiap.seguranca.controller;

import br.com.fiap.seguranca.config.security.TokenService;
import br.com.fiap.seguranca.dto.LoginDto;
import br.com.fiap.seguranca.dto.HabitanteCadastroDto;
import br.com.fiap.seguranca.dto.HabitanteExibicaoDto;
import br.com.fiap.seguranca.dto.TokenDto;
import br.com.fiap.seguranca.model.Habitante;
import br.com.fiap.seguranca.service.HabitanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private HabitanteService habitanteService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            LoginDto usuarioDto
    ){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDto.email(),
                        usuarioDto.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Habitante) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDto(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public HabitanteExibicaoDto registrar(
            @RequestBody @Valid HabitanteCadastroDto usuarioCadastroDTO){

        HabitanteExibicaoDto usuarioSalvo = null;
        usuarioSalvo = habitanteService.salvarHabitante(usuarioCadastroDTO);

        return usuarioSalvo;

    }

}