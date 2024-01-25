package net.javaguides.controller;

import net.javaguides.entity.Member;
import net.javaguides.service.MailService;
import net.javaguides.service.MemberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/VueTestApi/api/VueTest")
public class MailController {
    @Autowired
    private MailService mailService;

    @Autowired
    private MemberService memberService;

    Member member;

    Logger logger = LogManager.getLogger(MailController.class);

    public MailController(MailService mailService, MemberService memberService) {
        this.memberService = memberService;
        this.mailService = mailService;
    }

    @GetMapping("/email")
    public String test() {
        try {
            mailService.sendSimpleHtml(
                    List.of("ricky85320@gmail.com"),
                    "【測試用客服】",
                    "<html><body><p>親愛的用戶您好!</p></br><p>您的生日禮卷還尚未領取，請在本月月底前領取</p><p> <b>以上純屬測試請勿當真</b></p></body></html>"
            );
            return "Mail sent";
        } catch (Exception e) {
            logger.error("Error sending email", e);
            return "Error sending email";
        }
    }

    @PostMapping("/Updateemail")
    public String UpdatePasswordEmail(@RequestBody Member member) {
        try {
            String memberName = member.getMemberName();
            String email = member.getEmail();
            List<Member> memberdata = memberService.updatePasswordEmail(memberName, email);
            logger.info("這是memberdata" + memberdata);
            if (memberdata.size()!=0 ){
                String name = memberdata.get(0).getMemberName();
                String memberEmail = memberdata.get(0).getEmail();
                mailService.sendSimpleHtml(
                        List.of(memberEmail),
                        "【測試用客服】",
                        "<html><body><p>親愛的" + name + "您好!</p></br><p>您的生日禮卷還尚未領取，請在本月月底前領取</p><p> <b>以上純屬測試請勿當真</b></p></body></html>"
                );
                return "Mail sent";
            }
            return "失敗";
        } catch (Exception e) {
            logger.error("Error sending email", e);
            return "Error sending email";
        }
    }

}
