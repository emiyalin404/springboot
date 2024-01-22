package net.javaguides.controller;

import net.javaguides.service.MailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/VueTestApi/api/VueTest")
public class MailController {
    @Autowired
    private MailService mailService;

    Logger logger = LogManager.getLogger(MailController.class);

    @GetMapping("/email")
    public String test(){
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
}
