// package net.javaguides.controller;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// // import org.springframework.stereotype.Repository;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.fasterxml.jackson.databind.ObjectMapper;

// import net.javaguides.entity.Member;
// // import net.javaguides.entity.User;
// import net.javaguides.service.MemberService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @RequestMapping("/VueTestApi/Api/VueTest")
// @RestController
// public class LoginController {

// @Autowired
// private MemberService memberService;

// public LoginController(MemberService memberService) {
// this.memberService = memberService;
// }

// @PostMapping("/Login")
// @CrossOrigin("*")
// public List<Map<String, Object>> Login(@RequestBody Member member) {
// System.out.println("有東西");
// String memberName = member.getMemberName();
// String password = member.getPassword();
// List<Member> login = memberService.Login(memberName, password);

// List<Map<String, Object>> resultList = new ArrayList<>();
// for (Member memberItem : login) {
// Map<String, Object> resultMap = new HashMap<>();
// resultMap.put("Message", "登录成功");
// resultMap.put("Status", "Y");
// resultMap.put("member", memberItem);
// resultList.add(resultMap);
// }

// ObjectMapper mapper = new ObjectMapper();
// try {
// String jsonResult = mapper.writeValueAsString(resultList);
// System.out.println(jsonResult);
// } catch (Exception e) {
// e.printStackTrace();
// }
// return resultList;
// }

// }
