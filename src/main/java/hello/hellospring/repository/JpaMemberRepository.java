package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    //JPA는 EntityManager 를 통해서 동작한다.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        //persist = 영속하다, 영구 저장하다 라는 의미.
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //조회 할 타입과 식별자(pk)를 넣어준다
        //=>Member.class , id
        Member member = em.find(Member.class, id);

        //메서드가 Optional 타입이기 때문에 리턴값도 Optional 로 한다
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        //파라미터로 전달받은 name값을 name으로 set하고
        //=>setParameter로 저장된 name을 쿼리문에서 :name 으로 사용
       List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                             .setParameter("name", name)
                             .getResultList();
       return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //쿼리문에서 m은 entity 객체다. 즉, entity 객체 전체를 가리킨다
        List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
        return result;
    }
}
