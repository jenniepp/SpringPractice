package com.study.spring.controller;

import com.study.spring.domain.Member;
import com.study.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //spring controller라는 통에 이 클래스가 들어감. =스프링빈 관리
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자를 이용하여 의존 관계 주입
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";

    }
}
