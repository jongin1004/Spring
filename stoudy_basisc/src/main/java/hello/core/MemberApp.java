package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //ApplicationContext는  스프링컨테이너라 한다.
        //@Configuration이 붙은 AppConfig를 설정 정보로 사용하여, @Bean이 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록
        // 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라고 한다. @Bean이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. (memberService)
        //AppConfig에 있는 함수들을 모두 스프링 컨테이너에 등록을해서 관리를 해라
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //getBean()을 이용해서 스프링빈을 찾을 수 있다. 파라미터로는 스프링 빈의 이름과 타입을 받는다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}


