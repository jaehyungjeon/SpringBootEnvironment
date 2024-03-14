package com.example.personal.Controller.Main;

import com.example.personal.Dto.Member;
import com.example.personal.Service.Main.MainService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller
@RequestMapping(value="/main/*", method={RequestMethod.POST, RequestMethod.GET})
@Slf4j
public class MainController extends MainApiController {

	@Autowired
	private MainService mainService;

	@PostMapping("initMain.action")
	public ModelAndView initMain(Member member) throws Exception {
		System.out.println("메인 페이지 출력!!");
		ModelAndView mav = new ModelAndView();
		mainService.initMain(member);
		mav.addObject("data", mainService.returnQueryMemberList(member));

		return forward("main.html", mav.getModel());
	}

	@PostMapping("mainNoLayout.action")
	public ModelAndView mainNoLayout() {
		return forward("mainNoLayout.html");
	}

	@PostMapping("mainLayout.action")
	public ModelAndView mainLayout() {
		return forward("mainLayout.html");
	}

	@PostMapping("mainGrid.action")
	public ModelAndView mainGrid(ModelAndView modelAndView) throws Exception {
		return forward("mainGrid.html");
	}

	@PostMapping("ajaxSearchGrid.action")
	@ResponseBody
	public List<Member> searchMember(Member member) throws Exception {
		return mainService.searchMember(member);
	}

	@GetMapping("ajaxSearchGridGet.action")
	@ResponseBody
	public List<Member> searchMemeberGet(Member member) throws Exception {
		return mainService.searchMember(member);
	}

	@PostMapping("ajaxSearchGridJson.action")
	@ResponseBody
	public JSONArray searchMemberJson(Member member) throws Exception {
		log.info("강제 더미데이터 넣기");
		JSONArray jsonArray = new JSONArray();
		for(int i=0; i<10; i++){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", StringUtils.concat("jeonjaehyung", i));
			jsonObject.put("name", StringUtils.concat("전제형", i));

			log.info("jObject={}", jsonObject);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@PostMapping("mainBootStrap.action")
	public ModelAndView mainBootStrap(Member member) throws Exception {
		return forward("mainBootStrap.html");
	}

	@PostMapping("updateQueryDSL.action")
	public ModelAndView updateMember(Member member) {
		mainService.updateMember();
		return forward("complete.html");
	}
}