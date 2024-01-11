package net.javaguides.controller;

import net.javaguides.service.KeywordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguides.entity.Member;
import net.javaguides.service.MemberService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/VueTestApi/api/VueTest")
public class MemberController {

    Logger logger = LogManager.getLogger(MemberController.class);

    private MemberService memberService;
//    @Autowired
//    KeywordServiceImpl keywordService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/createmember")
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PostMapping("/Login")
    @CrossOrigin("*")
    public List<Map<String, Object>> Login( @RequestBody Member member) {

        String memberName = member.getMemberName();
        String password = member.getPassword();
        List<Member> login = memberService.Login(memberName, password);

//        HttpSession session =request.getSession();

        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Member memberItem : login) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("Message", "登录成功");
            resultMap.put("Status", "Y");
            resultMap.put("member", memberItem);
            resultList.add(resultMap);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonResult = mapper.writeValueAsString(resultList);

//            session.setAttribute("username",memberName);

            System.out.println(jsonResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }



}
