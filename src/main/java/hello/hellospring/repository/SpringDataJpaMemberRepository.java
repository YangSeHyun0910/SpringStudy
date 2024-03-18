package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //인터페이스(SpringDataJpaMemberRepository) 만들고 JpaRepository를 extends하게되면,
    //SpringDataJpa가 인터페이스에 대한 구현체를 스스로 만들고 bean에 등록함
    //인터페이스가 인터페이스를 받을 때에는 extends(O) implements(X)


    @Override
    Optional<Member> findByName(String name);
}
