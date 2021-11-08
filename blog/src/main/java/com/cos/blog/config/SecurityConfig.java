package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration //빈등록: 스프링 컨테이너에서 객체를 관리할 수 있도록
@EnableWebSecurity //시큐리티필터를 추가, controller로 가기전에 먼저 필터
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //request가 들어오면
                .antMatchers("/auth/**") // /auth/**로 오는건 누구나 들어올 수 있다
                .permitAll()
                .anyRequest() //나머지 경로는
                .authenticated()  // 인증을 해야해
                .and()
                .formLogin()
                .loginPage("/auth/loginForm"); //인증이 필요한 요청을 했을 때는 loginPage로 이동시킴
    }
}
