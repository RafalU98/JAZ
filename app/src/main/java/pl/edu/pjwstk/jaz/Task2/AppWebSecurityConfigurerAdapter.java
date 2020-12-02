package pl.edu.pjwstk.jaz.Zadanie2;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class AppWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/auth0/**").permitAll()
                        // co kolwiek jest przez auth0 to przepuszcamy bo osobny filtr (ExampleFilter)
                .anyRequest().authenticated()
                .and().csrf().disable();
        }
}


