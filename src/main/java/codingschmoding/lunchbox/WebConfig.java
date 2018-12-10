package codingschmoding.lunchbox;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
            	//.antMatchers("/responses", "/responses/{id}", "/responselist").permitAll()
                .antMatchers("/questions", "/questions/{id}", "/questions-no-options", "/questions-no-options/{id}", "/questionoptions").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home")
                .permitAll();
    }
        public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
            if(HttpMethod.OPTIONS.matches(request.getMethod())){
                response.setStatus(HttpServletResponse.SC_OK);
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, request.getHeader(HttpHeaders.ORIGIN));
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS));
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD));
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
            }else{
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
            }
        }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("netta")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}