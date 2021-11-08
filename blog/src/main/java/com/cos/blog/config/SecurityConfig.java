package com.cos.blog.config;

import com.cos.blog.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration //빈등록: 스프링 컨테이너에서 객체를 관리할 수 있도록
@EnableWebSecurity //시큐리티필터를 추가, controller로 가기전에 먼저 필터
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean //IoC가 되어서 가져다 쓸 수 있음
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }
    //시큐리티가 대신 로그인할 때, password를 가로채기하는데
    //해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
    //같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //csrf 토큰 비활성화 (테스트할 때)
                .authorizeRequests() //request가 들어오면
                .antMatchers("/auth/**", "/js/**", "/css/**", "/image/**", "/") // /auth/**로 오는건 누구나 들어올 수 있다
                .permitAll()
                .anyRequest() //나머지 경로는
                .authenticated()  // 인증을 해야해
                .and()
                .formLogin()
                .loginPage("/auth/loginForm") //인증이 필요한 요청을 했을 때는 loginPage로 이동시킴
                .loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다. (로그인 로직을 구현할 필요 x)
                .defaultSuccessUrl("/");
    }
}
