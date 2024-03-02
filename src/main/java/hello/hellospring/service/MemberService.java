package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //직접 생성하지 않고, 외부에서 주입받아서 써보자. DI
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //DI 완료
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public long join(Member member) {
        //같은 이름이 있는 중복 회원X
//      Optional<Member> result = memberRepository.findeByName(member.getName());
//      result.ifPresent(m -> {
//          throw new IllegalStateException("이미 존재하는 회원입니다.");
//      });
        // 위 코드를 아래처럼 바꿀 수 있다.
        // ctrl+alt+shift+T -> Extract Method 메서드 화 시킴.
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    // 중복 이름 회원가입 불가
    // ctrl+alt+shift+T -> Extract Method 메서드 화 시킴.
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }

}
