package filmgroup.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)
        throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().withUser("user")
                .password("User").roles("USER");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("admin")
                .password("admin").roles("ADMIN");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("superadmin")
                .password("superadmin").roles("SUPERADMIN");

    }

    @Override
    protected void configure(HttpSecurity httpSecurity)
        throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/films/**")
                .access("hasRole('ROLE_ADMIN')")
                .antMatchers("/add/**", "/delete/**", "/edit/**")
                .access("hasRole('ROLE_SUPERADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false);

    }



}
