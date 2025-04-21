package ma.enset.exam1.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder){
        return new InMemoryUserDetailsManager(
            User.withUsername("u1").password(passwordEncoder.encode("0000")).roles("USER").build(),
            User.withUsername("admin").password(passwordEncoder.encode("0000")).roles("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/",true).permitAll();
        //httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll();

        httpSecurity.authorizeHttpRequests().anyRequest().permitAll();
        //httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");

        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}