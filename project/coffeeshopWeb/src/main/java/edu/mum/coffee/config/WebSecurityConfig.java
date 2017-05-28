package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select email as username,password,enabled from person where email=?")
                .authoritiesByUsernameQuery(
                        "select p.email as username, a.authority from person p," +
                                " authorities a where p.email=a.username and p.email=?");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .antMatchers("/css/**", "/images/**", "/webjars/**").permitAll()
                .antMatchers("/", "/product/", "/login", "/person/add", "/person/create").permitAll()
                .antMatchers( "/product/order/*","/orders/add/", "/orders/show/", "/person/edit/*", "/person/update/").hasRole("USER")
                .antMatchers("/product/**", "/person/", "/person/show/", "/orders/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}