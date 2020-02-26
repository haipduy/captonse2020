package com.example.demo.config;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AuthServerWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/user/login");
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        try {
            List<UserDTO> userDTOList = userDAO.getUserList();
            UserDetails user = null;
            for (UserDTO userDTO: userDTOList) {
                user = User.builder().username(userDTO.getUsername()).password(passwordEncoder.encode(userDTO.getPassword())).
                        roles(userDTO.getRole()).build();
                userDetailsList.add(user);
            }
        } catch (Exception e){
        }
        return new InMemoryUserDetailsManager(userDetailsList);
    }


}
