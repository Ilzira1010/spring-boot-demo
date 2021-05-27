package ru.itis.springbootdemo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/img/*").permitAll()
                .antMatchers("/track/*").permitAll()
                .antMatchers("/edit/*").authenticated()
                .antMatchers("/delete/*").authenticated()
                .antMatchers("/papers/search/**").permitAll()
                .antMatchers("main").permitAll()
                .antMatchers("/podcast").permitAll()
                .antMatchers("/podcast_specific").permitAll()
//               .antMatchers("/**").authenticated()
//                .antMatchers("/users").permitAll()
                .antMatchers("/profile").authenticated()
//                .antMatchers("/profile").permitAll()
                .antMatchers("/create").authenticated()
                .antMatchers("/users/**").hasAnyAuthority("USER")  //i
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .defaultSuccessUrl("/profile", true)

                .failureUrl("/signIn?error")
        .and().exceptionHandling().accessDeniedPage("/error403"); //i
//                   .and()
//                   .logout()
//                   .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//                   .invalidateHttpSession(true)

//                   .deleteCookies("JSESSIONID");

    }
}
