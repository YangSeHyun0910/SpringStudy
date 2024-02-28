package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//다른곳에서 사용할게 아니니 public 안붙여도 된다.
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /*
    @Test 테스트는 메서드 작성 순서를 따지지 않고 실행된다.
    즉, 다른 메서드로 인한 변수 값의 변화가 생길 수 있다 -> 테스트의 오류 발생 가능

    @AfterEach = class 내에서 메서드가 실행되고 난 후 마다 메서드 실행
    --> 테스트 메서드 1개 실행 후, afterEach() 실행
    --> 내부 코드에 clear 설정. 매 테스트 후 값들 클리어.
    */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findeById(member.getId()).get();
        System.out.println("result = " + (result == member));
        Assertions.assertEquals(member, result);

        // alt + enter 임포트여부 고를 수 있음
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

        Member result = repository.findeByName("spring1").get();

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
