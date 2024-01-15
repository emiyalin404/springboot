package net.javaguides.controller;

import io.jsonwebtoken.Jwts;
import net.javaguides.service.JwtService;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguides.entity.Member;
import net.javaguides.service.MemberService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

    Member member;
    @Autowired
    private JwtService jwtService;

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

    @PostMapping("/updatemember")
    public List<Map<String, Object>> UpdateMember(@RequestBody Member member) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();

        String email = member.getEmail();
        String password = member.getPassword();

        if (password.length() > 5 && !password.isBlank()) {

            memberService.UpdateMember(email, password);
            resultMap.put("Message", "修改成功");
            resultList.add(resultMap);
        } else {
            resultMap.put("Message", "修改失敗");
            resultList.add(resultMap);
        }
        return resultList;
    }

    @PostMapping("/Login")
    @CrossOrigin("*")
    public ResponseEntity<List<Map<String, Object>>> Login(@RequestBody Member member) {

        String memberName = member.getMemberName();
        String password = member.getPassword();
        List<Member> login = memberService.Login(memberName, password);

//        List<Map<String, Object>> resultList = new ArrayList<>();

//        token:
        try {
            Member logginMember = login.get(0);
            String newAccessToken = jwtService.generateToken(logginMember);
            logginMember.setAccessToken(newAccessToken);
            memberService.Save(logginMember);

            Map<String,Object> resultMap=new HashMap<>();
                resultMap.put("Message", "登录成功");
                resultMap.put("Status", "Y");
                resultMap.put("memeber",logginMember);
                resultMap.put("accessToken",newAccessToken);
                return ResponseEntity.ok(Collections.singletonList(resultMap));
//            BCrypt:
//            Member logginMember = login.get(0);
//            String newAccessToken = generateAccessToken(logginMember);
//            logginMember.setAccessToken(newAccessToken);
//            memberService.Save(logginMember);
//            for (Member memberItem : login) {
//                Map<String, Object> resultMap = new HashMap<>();
//                resultMap.put("Message", "登录成功");
//                resultMap.put("Status", "Y");
//                resultMap.put("member", memberItem);
//                resultList.add(resultMap);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
//        return resultList;
    }

    private String generateAccessToken(Member logginMember) {
        String newAccessToken = BCrypt.hashpw(logginMember.getPassword() + (new Date().getTime() / 1000L), BCrypt.gensalt(12));
        logginMember.setAccessToken(newAccessToken);
        return newAccessToken;
    }


}
