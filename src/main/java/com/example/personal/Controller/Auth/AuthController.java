package com.example.personal.Controller.Auth;

import com.example.personal.Controller.Main.MainApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/auth/*", method = {RequestMethod.POST, RequestMethod.GET})
@Slf4j
public class AuthController extends MainApiController {

    /*
     * 작성일 : 2024.05.20
     * 내 용 : 카카오 인증
     **/
    @GetMapping("kakao.action")
    public ModelAndView kakaoOAuthRedirect() throws Exception {
        return forward("kakao.html");
    }
}
