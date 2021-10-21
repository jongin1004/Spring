package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service 어노테이션을 붙히는 이유는, @Autowired를 이용해서 스프링 컨테이너에 있는 클래스와 연결하고 싶은데, 아무 어노테이션도 붙어있지 않은
//Java 클래스는 스프링에서 알 수가 없음. @Service가 있으면, 스프링 컨테이너가 스프링 컨테이너에서 관리할 수 있도록 등록합니다.
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //Autowired어노테이션은 스프링의 컨테이너에 있는 클래스와 연결을 하겠다는 의미
    //MemberService 생성이되면, 스프링 컨테이너에 있는 MemberRepository 가져와서 넣어줌 ( 연결한다.) = 의존관계 주입 = 의존관계 설정
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원x
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*전체회원 조회*/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
