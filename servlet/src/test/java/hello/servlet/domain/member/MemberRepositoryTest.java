package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void clearStore() {
        memberRepository.clearRepository();
    }

    @Test
    void save() {
        //given
        Member member = new Member("member1", 20);

        //when
        Member save = memberRepository.save(member);

        //then
        Assertions.assertThat(save).isEqualTo(member);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 25);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> memberAll = memberRepository.findAll();

        //then
        Assertions.assertThat(memberAll.size()).isEqualTo(2);
        Assertions.assertThat(memberAll).contains(member1, member2);

    }
}