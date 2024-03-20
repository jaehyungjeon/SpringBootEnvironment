package com.example.personal.Boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class URLInterceptor implements HandlerInterceptor {

	public static List<String> rootDomain = new ArrayList<>(Arrays.asList("", "/"));

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		log.info("preHandle 경로 {}", request.getRequestURI());
		String requestURI = request.getRequestURI();

		if(requestURI.contains("/errors")) {
			response.sendRedirect("/error");
			return false;
		}
		return true;
	}
}
