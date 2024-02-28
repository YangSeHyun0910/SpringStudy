package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        // @RequestParam() 어노테이션으로 전달받은 파라미터 값을 String 타입의 name 에 저장
        // model.addAttribute("name", name)에서 value 값 name == String name
        // 형식 : http://localhost:8080/hello-mvc?name=Yang
        // ? 뒤에 오는게 파라미터 name(키) = Yang(벨류)

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    /* @ResponseBody 란?
    http 통신 프로토콜은 header와 body가 있는데 여기의 body에 직접 넣어주겠다 라는 의미

    **템플릿 엔진과의 차이는 ??
    템플릿 엔진은 return 값이 view 처리하는 파일을 찾아서 보여준다
    @ResponseBody 는 따로 view 처리하는게 파일이 없고, 어노테이션을 가지고있고, 요청명이 일치하면
    해당 메서드가 바로 view 처리된다.

    페이지를 실행하고 우클릭 > 페이지 소스보기 클릭시 차이를 알 수 있다.
    템플릿 엔진 : html 코드가 보임
    @ResponseBody : 메서드의 return 값만 보임
    */
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    /*
    Spring에서 @ResponseBody를 사용하고, 객체를 반환하면(return 객체;) json 형태로 반환한다. => default
    json converter, spring converter
    json 검색해서 공부해 보자.
    json 방식 = 키 : 값 구조
    */
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //static 객체 생성
    //getter setter 단축키 : alt + insert
    static class Hello {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
