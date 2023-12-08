package com.restApi.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.DispatcherType;

@EnableWebSecurity
@Configuration
//@EnableMethodSecurity
//@RequiredArgsConstructor
public class SecurityConfig {
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
            	.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
            	.requestMatchers(new AntPathRequestMatcher("/api/**")).permitAll()
            	.requestMatchers(new AntPathRequestMatcher("/thymeleaf/**")).permitAll()
            	.requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
            	.anyRequest().authenticated()
            )
            .csrf((csrf) -> csrf
            	//.disable()
                .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))	// 예외처리
            )
            .headers((headers) -> headers
                    .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
            )
            .formLogin(login -> login	// form 방식 로그인 사용
            		.defaultSuccessUrl("/swagger-ui/index.html", true)	// 성공 시 index.html로
            		.permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
            )
            .logout(withDefaults())	// 로그아웃은 기본설정으로 (/logout으로 인증해제)
        ;
        return http.build();
    }
	
	
	/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(
                    authorize -> authorize
                            .requestMatchers("/api/member").permitAll()
                            //.requestMatchers("/swagger-ui/index.html").permitAll()
                            .anyRequest().authenticated()
            );
        return http.build();
    }
    
/*
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/api/member", "/thymeleaf");
    }
	
	@Bean
    protected SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
		//http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(
        		authorize -> authorize
	                .requestMatchers("/로그인페이지", "/css/**", "/images/**", "/js/**").permitAll()
	                .anyRequest().authenticated()
        	 );
        
/*
            .and()
                .formLogin()
                .loginPage("/로그인페이지")
                .loginProcessingUrl("/실제 로그인이 되는 url")
                .permitAll()
                .successHandler(로그인 성공 시 실행할 커스터마이즈드 핸들러)
                .failureHandler(로그인 실패 시 실행할 커스터마이즈드 핸들러);
/*
        http
                .sessionManagement()
                .invalidSessionUrl("/로그인페이지")

            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/실제 로그아웃이 되는 url"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();


        //CSRF 토큰
        //http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        return http.build();
    }
*/
	
	
/*
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user =
                User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }

    
    */
            
/*            
         http.csrf(AbstractHttpConfigurer::disable)
		     .cors(Customizer.withDefaults())
		     .authorizeHttpRequests((authorizeRequests) ->
		                authorizeRequests
		                        .requestMatchers("/**").hasRole("USER")
		        ); 
		        
        /*
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));
        http.cors(Customizer.withDefaults())
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/**").hasRole("USER")
                )
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/main")
                                .permitAll()
                );
        return http.build();
		*/
        
        /*
        http.csrf().disable().cors().disable()
        .authorizeHttpRequests(request -> request
        	.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
        )
        .formLogin(login -> login	// form 방식 로그인 사용
                .defaultSuccessUrl("/view/dashboard", true)	// 성공 시 dashboard로
                .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
        )
        .logout(withDefaults());	// 로그아웃은 기본설정으로 (/logout으로 인증해제)
        */
    	/*
        http    .csrf(AbstractHttpConfigurer::disable)
		        .cors(Customizer.withDefaults())
		        .authorizeHttpRequests((authorizeRequests) ->
		                authorizeRequests
		                        .requestMatchers("/**").hasRole("USER")
		        ); 
		        .formLogin((formLogin) ->
		                formLogin
		                        .loginPage("/login")
		                        .defaultSuccessUrl("/main")
		                        .permitAll()
		        );*/
   
}
