package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
	private static String[] AUTH_WHITELIST = {
			"/",
			"/login",
			"/category",
			"/details2/**",
			"/playmovie/**",
			"/playmovie2/"
		//	"/admin/dashboard"
	};
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize
												.requestMatchers(AUTH_WHITELIST)
												.permitAll()
												.anyRequest().authenticated()
									);
		
		http.headers(headers -> headers.frameOptions().disable());		
		http.authenticationProvider(authenticationProvider());		
		
		// Login process
		http
			.formLogin()
			.loginProcessingUrl("/login" ) // Login process path
			.loginPage("/login" ) // Specify login page
			.failureUrl("/login?error" ) // Transition destination when login fails
			.usernameParameter("userId" ) // Login page user ID
			.passwordParameter("password" ) // Login page password
			.defaultSuccessUrl("/admin/dashboard" , true ); // Transition destination after success
		// Logout process
		http
	        .logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout" ))
	        .logoutUrl("/logout" )
	        .logoutSuccessUrl("/login?logout" );
		
		http.csrf().disable();
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web
				.ignoring()
				.requestMatchers("/admin/assets/**")
				.requestMatchers("/users/css/**")
				.requestMatchers("/users/js/**")
				.requestMatchers(new AntPathRequestMatcher("/h2-console/**")); 
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}	
	
	@Bean
    public UserDetailsService userDetailsService() {
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("user")
        		.password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();
		return new InMemoryUserDetailsManager(admin, user);

    }
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();	     
	    authProvider.setUserDetailsService(userDetailsService());	
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}
	

}
