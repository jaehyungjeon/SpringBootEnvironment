package com.example.personal.Controller.Root;

import com.example.personal.BaseController.BaseController;
import com.example.personal.Dto.Member;
import com.example.personal.Service.Main.MainService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller
@Slf4j
public class RootController extends BaseController {

	/*
	 * Root Domain redirect to Main Page
	 **/
	@RequestMapping(path = {"/", ""})
	public ModelAndView test() throws Exception {
		return redirect("/main/initMain.action");
	}
}