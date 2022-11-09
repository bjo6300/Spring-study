package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링이 뜰 때 컨트롤러 객체를 가지고 있다. -> 스프링 컨테이너에서 스프링 빈이 관리된다.
public class MemberController {

    private final MemberService memberService;

    /*@Autowired // setter 주 -> public 설정해야해서 노출된다.
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    //    @Autowired private MemberService memberService; // 필드 주입 -> 별로 안좋음, 중간에 변경할 수 없다.

    // 생성자 주입을 쓰는게 좋다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm"; // template으로 이동
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName()); // html form에서 받은걸 member의 name에 set

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";

    }
}
