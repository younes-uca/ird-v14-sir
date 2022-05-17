package com.ird.faa.security.config;

import com.ird.faa.security.common.AuthoritiesConstants;
import com.ird.faa.security.jwt.JWTAuthenticationFilter;
import com.ird.faa.security.jwt.JWTAuthorizationFiler;
import com.ird.faa.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private FrontEndUrlBuilder frontEndUrlBuilder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
        final String loginURL = "/api/login";

        filter.setFilterProcessesUrl(loginURL);

        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers(loginURL).permitAll()
                .antMatchers("/actuator/health").permitAll()
                .antMatchers("/actuator/info").permitAll()
                .antMatchers("/api/admin/login").permitAll()
                .antMatchers("/api/chercheur/login").permitAll()
                .antMatchers("/api/admin/").hasAnyAuthority(AuthoritiesConstants.admin)
                .antMatchers("/api/chercheur/").hasAnyAuthority(AuthoritiesConstants.chercheur)
                .and()
                .formLogin().loginProcessingUrl(loginURL).permitAll()
                .and().addFilterBefore(new JWTAuthorizationFiler(frontEndUrlBuilder.buildURL()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
