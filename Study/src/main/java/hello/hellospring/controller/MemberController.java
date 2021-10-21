package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


//Controller 어노테이션이 붙어있으면, 스프링 서버거 시작될 때 스프링 컨테이너에서 해당 클래스를 가지고 관리하게 됩니다.
//그러면, new ()를 이용해서 객체를 생성하는 것 보다는 스프링 컨테이너에 있는 클래스(객체)와 연결해주는 것이 더욱 좋다. ( 부가 기능도 사용 가능)
@Controller
public class MemberController {

    private final MemberService memberService;

    //Autowired어노테이션은 스프링의 컨테이너에 있는 클래스와 연결을 하겠다는 의미
    //MemberController가 생성이되면, 스프링 컨테이너에 있는 memberService를 가져와서 넣어줌 ( 연결한다.) = 의존관계 주입 = 의존관계 설정
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createdMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
