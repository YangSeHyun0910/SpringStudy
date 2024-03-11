package hello.hellospring.service;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        //JdbcTemplate를 적용한 상태.
        return new JdbcTemplateMemberRepository(dataSource);

        //Jdbc를 적용한 리턴값
//        return new JdbcMemberRepository(dataSource);

        /* 구현체 MemberRepository 를 생성한다.
        => public class MemoryMemberRepository implements MemberRepository
        인터페이스는 new 할수없기 때문에. MemberRepository 는 interface 이기 때문이다.
        ==> 즉, 인터페이스는 new 불가 / 구현체는 new 가능
        */
//        return new MemoryMemberRepository(); //Jdbc를 사용하게 되면서 주석처리
    }
}
