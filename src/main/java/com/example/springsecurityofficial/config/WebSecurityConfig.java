package com.example.springsecurityofficial.config;

import com.example.springsecurityofficial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig {


	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DataSource dataSource;

	@Value("${spring.websecurity.debug:false}")
	boolean webSecurityDebug;

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


		http

				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/", "/login", "/signup", "signin", "/register", "/contact_us", "/static/**",
								"/csrf").permitAll()
						.requestMatchers("/logout").authenticated()
						.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
						.requestMatchers("/login", "/signup").anonymous()
						.anyRequest().authenticated()
				)
//				.formLogin((form) -> form
//						.loginPage("/login")
//						.permitAll()
//				)
				.logout((logout) -> logout
						.logoutUrl("/logout")
						.permitAll()
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.deleteCookies("JSESSIONID")
						.logoutSuccessUrl("/logout")
						.permitAll())
				.csrf(csrf -> csrf
						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

				);


		return http.build();
	}
}