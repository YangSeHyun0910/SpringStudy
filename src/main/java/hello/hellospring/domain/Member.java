package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    // Primary Key 설정해준다.
    // id는 쿼리문으로 생성하는게 아닌, db에 데이터가 삽입될때 자동으로 생성되기 때문에
    // @GeneratedValue(strategy = GenerationType.IDENTITY) 어노테이션 사용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
