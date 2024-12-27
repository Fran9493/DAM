package com.franciscojosegarciacutillas.appinstituto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author Fran
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/hello").permitAll();//Permite el acceso sin login a esta ruta
                    auth.anyRequest().authenticated();//Todo lo que no sea lo anterior, se necesita autenticación
                })
                //Dónde ir si se accede con éxito en el login
                .formLogin(form -> {
                    form.successHandler(successHandler());
                    form.permitAll();
                })
                //Política de creación de la sesión
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
                })
                .build();

    }

    //Método para indicar a qué endPoint debe ir cuando se loguee un usuario
    public AuthenticationSuccessHandler successHandler() {
        return ((request, response, authentication) -> {
            response.sendRedirect("/api/v1/inicio");
        });
    }

}
