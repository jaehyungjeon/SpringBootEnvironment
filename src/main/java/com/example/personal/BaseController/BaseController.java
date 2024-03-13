package com.example.personal.BaseController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

public abstract class BaseController extends AbstractController {

    /*
     * return AbstractController override constructor
     **/
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return handleRequestInternal(request, response);
    }

    /*
     * redirect View
     **/
    protected ModelAndView redirect(String url) {
        RedirectView redirectView = new RedirectView(url);
        return new ModelAndView(redirectView);
    }

    /*
     * return forward overwrite
     **/
    protected ModelAndView forward(String url) {
        return forward(url, null);
    }

    protected ModelAndView forward(String url, Map<String, ?> model) {
        return new ModelAndView(url, model);
    }
}
