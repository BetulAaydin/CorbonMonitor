package com.corbonmonitor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	  
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            //Each user can retrive co2 from the sensor which are authrized for them.
	        auth.inMemoryAuthentication()
	                .withUser("sensor1").password("{noop}password").roles("SensorSpain")
	                .and()
	                .withUser("sensor2").password("{noop}password").roles("SensorAustria")
	                .and()
	                .withUser("sensor3").password("{noop}password").roles("SensorGermany")
	                .and()
	                .withUser("admin").password("{noop}password").roles("SensorGermany", "SensorAustria","SensorSpain","ADMIN");

	    }


	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	                //HTTP Basic authentication
	                .httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/sensors/**").permitAll()
	                .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()	               
	                .antMatchers(HttpMethod.GET, "//sensor-co2/**").hasAnyRole("SensorSpain","SensorAustria","SensorAustria")
	                .and()
	                .csrf().disable()
	                .headers().frameOptions().disable();
	              
	    }

}
