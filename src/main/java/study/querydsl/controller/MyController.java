package study.querydsl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.repository.MemberJpaRepository;
import study.querydsl.repository.MemberRepository;

import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;


    @GetMapping("/my/members")
    public String searchMemberMy(MemberSearchCondition condition, Pageable pageable, Model model) {
        Page<MemberTeamDto> page = memberRepository.searchPageSimple(condition, pageable);
        int[] pages = IntStream.rangeClosed(1, page.getTotalPages()).toArray();
        model.addAttribute("pages",pages);
        model.addAttribute("content",page.getContent());
        return "index";
    }


}
