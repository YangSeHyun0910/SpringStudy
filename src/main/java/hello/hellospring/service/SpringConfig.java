package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); /* 구현체 MemberRepository 를 생성한다.
                                             => public class MemoryMemberRepository implements MemberRepository
                                             인터페이스는 new 할수없기 때문에. MemberRepository 는 interface 이기 때문이다.
                                             ==> 즉, 인터페이스는 new 불가 / 구현체는 new 가능
                                             */
    }
}
