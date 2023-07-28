package com.onesoft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class ConfigurationClass extends WebSecurityConfigurerAdapter {

	
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	auth.inMemoryAuthentication().withUser("siva")
	.password("$2a$10$LHqKpZvUiYvNq7qhI39FIueH1vvFN.iaQLwONxp5MYdRFXWB0B2C.")
	.roles("student").and()
	.withUser("guru").password("$2a$10$rwutMibwdFjY0RJzQD1a7uQ0LctdoH4fq9I//z9wt5b8/3qffulfS")
	.roles("trainer").and()
	.withUser("ram").password("$2a$10$rGtufZ2lgaY2yIXFufMPjO/04HBvq67PjHVp25WRC4YoAYMg3W/PW")
	.roles("manager");
	  
}
  
//  @Bean
//  public PasswordEncoder setPassword() {
//	  return NoOpPasswordEncoder.getInstance();
//  }
	
  @Bean 
   public PasswordEncoder getThisPassword() {
	  return new BCryptPasswordEncoder(10);
  }
  
   @Override
  protected void configure(HttpSecurity http) throws Exception {
	    
		http.authorizeRequests().antMatchers("/manager").hasRole("manager");
	    http.authorizeRequests().antMatchers("/trainer").hasAnyRole("trainer","manager");
	    http.authorizeRequests().antMatchers("/student").hasAnyRole("manager","trainer","student");
	    
	    super.configure(http);
}
  
  
}
