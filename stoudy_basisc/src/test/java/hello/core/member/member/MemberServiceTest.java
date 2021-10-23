package hello.core.member.member;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        Member member2 = new Member(2L, "memberB", Grade.VIP);

        memberService.join(member);
        memberService.join(member2);
        Member findMember = memberService.findMember(2L);

        Assertions.assertThat(member2).isEqualTo(findMember);
    }
}
