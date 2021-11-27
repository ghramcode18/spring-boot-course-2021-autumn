package org.closure.course.config;

import org.closure.course.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin").hasAnyAuthority(ADMIN).antMatchers("/user")
				.hasAnyAuthority(ADMIN, USER).antMatchers("/all").permitAll().
				antMatchers("/api/v1/auth/register")
				.permitAll().and().formLogin().and().httpBasic();
		// http.authorizeRequests()
		// .antMatchers("/admin").hasRole(ADMIN).and().formLogin()
		// // .anyRequest().authenticated()
		// .and()
		// .httpBasic();
		// // .authenticationEntryPoint(authenticationEntryPoint);
	}

}

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
//     @Bean
//     public UserDetailsService userDetailsService() {
//         return new UserDetailsServiceImpl();
//     }
     
//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
     
//     @Bean
//     public DaoAuthenticationProvider authenticationProvider() {
//         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//         authProvider.setUserDetailsService(userDetailsService());
//         authProvider.setPasswordEncoder(passwordEncoder());
         
//         return authProvider;
//     }
 
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.authenticationProvider(authenticationProvider());
//     }
 
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//             .antMatchers("/admin").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
//             .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
//             .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
//             .antMatchers("/delete/**").hasAuthority("ADMIN")
//             .anyRequest().authenticated()
//             .and()
//             .formLogin().permitAll()
//             .and()
//             .logout().permitAll()
//             .and()
//             .exceptionHandling().accessDeniedPage("/403")
//             ;
//     }
// }