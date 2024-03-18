package hello.hellospring.service;

import hello.hellospring.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //Spring data Jpa를 사용하게 되면서 주석처리
    /*
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    //JPA를 사용하고 난 후 JDBC때 사용하던 dataSource는 사용 안해도 된다.
    /*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    //MemberRepository memberRepository() 메서드는 Spring data Jpa를 사용하게 되면서 주석처리
    /*
    @Bean
    public MemberRepository memberRepository() {

        //JPA를 사용한 상태
        return new JpaMemberRepository(em);


        *//* 구현체 MemberRepository 를 생성한다.
        => public class MemoryMemberRepository implements MemberRepository
        인터페이스는 new 할수없기 때문에. MemberRepository 는 interface 이기 때문이다.
        ==> 즉, 인터페이스는 new 불가 / 구현체는 new 가능
        *//*
//        return new MemoryMemberRepository(); //Jdbc를 사용하게 되면서 주석처리

        //Jdbc를 적용한 리턴값
//        return new JdbcMemberRepository(dataSource);

        //JdbcTemplate를 적용한 상태.
//        return new JdbcTemplateMemberRepository(dataSource);
    }
    */
}
