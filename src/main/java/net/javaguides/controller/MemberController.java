package net.javaguides.controller;

import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import net.javaguides.service.JwtService;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import javax.servlet.http.HttpServletResponse;
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
    @ApiOperation(value = "Login API", response = ResponseEntity.class)
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
    @ApiOperation(value = "Login API", response = ResponseEntity.class)  //value 說明這是"Login API" response 的類型是泛型
    public ResponseEntity<List<Map<String, Object>>> Login(HttpServletRequest request, @RequestBody Member member) {

        String memberName = member.getMemberName();
        String password = member.getPassword();
        List<Member> login = memberService.Login(memberName, password);
//        HttpSession session = request.getSession();
        //token:
        try {
            if (login != null && !login.isEmpty()) {
                // 如果有匹配的成员
                Member logginMember = login.get(0);
                String newAccessToken = jwtService.generateToken(logginMember);
        
                logginMember.setAccessToken(newAccessToken);
                memberService.Save(logginMember);
        
                logger.info("[logincontroller 登入成功]");
        
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("Message", "登入成功");
                resultMap.put("Status", "Y");
                resultMap.put("member", logginMember);
                resultMap.put("accessToken", newAccessToken);
                return ResponseEntity.ok(Collections.singletonList(resultMap));
            } else {
                // 如果没有匹配的成员
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("Message", "登入失败，用户名或密码错误");
                resultMap.put("Status", "N");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonList(resultMap));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String generateAccessToken(Member logginMember) {
        String newAccessToken = BCrypt.hashpw(logginMember.getPassword() + (new Date().getTime() / 1000L), BCrypt.gensalt(12));
        logginMember.setAccessToken(newAccessToken);
        return newAccessToken;
    }


}
