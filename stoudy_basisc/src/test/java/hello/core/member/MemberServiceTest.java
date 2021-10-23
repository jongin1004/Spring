package hello.core.member;

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
