package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

//public 안붙혀도됨 ( 다른곳에서 쓸거 아니니까 )
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //@AfterEach 테스트가 하나 끝날 때마다, 실행되는 콜백함수
    // 왜 사용하냐?? 각 테스트 함수에서 보면, member에 동일한 이름으로 계속 생성했기 때문에, store이 쌓여있는 채로 다음 테스트로 넘어간다.
    // 그래서 그러한 문제를 해결하기 위해서, MemoryMemberRepository()에 store.clear();을 해주는 clearStore()함수를 추가해서 호출하는 것
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); // 반환타입이 Optional이었으니 Optional get()으로 가져올 수 있음
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}