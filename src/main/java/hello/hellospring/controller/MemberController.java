package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자
    //@Autowired 를 사용하면, 스프링이 스프링컨테이너에서 관리하는 항목중에 일치하는것을 가져와서 알아서 사용함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
