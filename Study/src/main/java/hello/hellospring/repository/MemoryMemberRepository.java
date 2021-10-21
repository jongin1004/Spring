package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository 어노테이션을 붙히는 이유는, @Autowired를 이용해서 스프링 컨테이너에 있는 클래스와 연결하고 싶은데, 아무 어노테이션도 붙어있지 않은
//Java 클래스는 스프링에서 알 수가 없음. @Repository 있으면, 스프링 컨테이너가 스프링 컨테이너에서 관리할 수 있도록 등록합니다.
@Repository
public class MemoryMemberRepository  implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //key값을 생성해줌

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional.ofNullable() 을 사용하면 값이 null이여도 (member가 없어도)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //하나라도 찾아라
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear(); //store에 있는 데이터를 모두 지워라, 테스트에서 사용하기 위한 함수
    }
}
