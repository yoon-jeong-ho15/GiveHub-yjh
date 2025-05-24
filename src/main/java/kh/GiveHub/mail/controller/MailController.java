package kh.GiveHub.mail.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.mail.MessagingException;
import kh.GiveHub.mail.model.service.MailService;
import lombok.RequiredArgsConstructor;







import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @ResponseBody
    @PostMapping("/emailCheck") // ajax로 보낸 email을 받아서 넘기기
    public String emailCheck(@RequestParam("email") String mail) throws MessagingException, UnsupportedEncodingException {
        return mailService.sendSimpleMessage(mail);
    }
    
    @ResponseBody
    @PostMapping("/findIdemailCheck") // ajax로 보낸 email을 받아서 넘기기
    public String emailCheck2(@RequestParam("email") String mail) throws MessagingException, UnsupportedEncodingException {
        return mailService.sendSimpleMessage(mail);
    }
    
    @ResponseBody
    @PostMapping("/findPwdemailCheck") // ajax로 보낸 email을 받아서 넘기기
    public String emailCheck3(@RequestParam("email") String mail) throws MessagingException, UnsupportedEncodingException {
        return mailService.sendSimpleMessage(mail);
    }
    
}
