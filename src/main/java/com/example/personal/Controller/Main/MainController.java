package com.example.personal.Controller.Main;

import com.example.personal.Dto.Member;
import com.example.personal.Dto.MemberDto;
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

	/*
	 * 작성일 : 2024.03.04
	 * 내 용 : 메인 페이지 조회
	 **/
	@PostMapping("initMain.action")
	public ModelAndView initMain(Member member) throws Exception {
		System.out.println("메인 페이지 출력!!");
		ModelAndView mav = new ModelAndView();
		mainService.initMain(member);
		mav.addObject("data", mainService.returnQueryMemberList(member));
		mav.addObject("dataDto", mainService.searchMember(new MemberDto()));

		return forward("main.html", mav.getModel());
	}

	/*
	 * 작성일 : 2024.03.04
	 * 내 용 : 메인 페이지 조회 - 타임리프 레이아웃 미반영
	 **/
	@PostMapping("mainNoLayout.action")
	public ModelAndView mainNoLayout() {
		return forward("mainNoLayout.html");
	}

	/*
	 * 작성일 : 2024.03.04
	 * 내 용 : 메인 페이지 조회 - 타임리프 레이아웃 반영
	 **/
	@PostMapping("mainLayout.action")
	public ModelAndView mainLayout() {
		return forward("mainLayout.html");
	}

	/*
	 * 작성일 : 2024.03.05
	 * 내 용 : 그리드 반영
	 **/
	@PostMapping("mainGrid.action")
	public ModelAndView mainGrid() throws Exception {
		return forward("mainGrid.html");
	}

	/*
	 * 작성일 : 2024.03.05
	 * 내 용 : 그리드 ajax 데이터 POST
	 **/
	@PostMapping("ajaxSearchGrid.action")
	@ResponseBody
	public List<Member> searchMember(Member member) throws Exception {
		return mainService.searchMember(member);
	}

	/*
	 * 작성일 : 2024.03.05
	 * 내 용 : 그리드 ajax 데이터 GET
	 **/
	@GetMapping("ajaxSearchGridGet.action")
	@ResponseBody
	public List<Member> searchMemeberGet(Member member) throws Exception {
		return mainService.searchMember(member);
	}

	/*
	 * 작성일 : 2024.03.05
	 * 내 용 : 그리드 ajax 데이터 POST - DUMMY
	 **/
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

	/*
	 * 작성일 : 2024.03.06
	 * 내 용 : 메인 부트스트랩 적용 페이지 - IMPORT 이슈로 상대경로 X
	 **/
	@PostMapping("mainBootStrap.action")
	public ModelAndView mainBootStrap(Member member) throws Exception {
		return forward("mainBootStrap.html");
	}

	/*
	 * 작성일 : 2024.03.08
	 * 내 용 : 회원정보 갱신 - queryDSL을 활용한 update
	 * 데이터가 있는 경우, 2가지 타입으로 return 가능
	 * 1. Mav 모델 형식 : modelAndView.getModel();
	 * 2. Mav 형식 : mav
	 * @ref : BaseController.java
	 **/
	@PostMapping("updateQueryDSL.action")
	public ModelAndView updateMember(Member member) {
		ModelAndView mav = new ModelAndView();
		try {
			mainService.updateMember(member);
			mav.addObject("data", "완료 되었습니다.");
		} catch (Exception e){
			mav.addObject("data", "실패 하였습니다.");
		}

//		return forward("complete.html", mav.getModel());
		return forward("complete.html", mav);
	}

	/*
	 * 작성일 : 2024.03.06
	 * 내 용 : 메인 VUE3 적용 페이지
	 * vue Adapt Control
	 **/
	@PostMapping("initVueMain.action")
	public ModelAndView initVueMain() throws Exception {
		return forward("vue/vueMain.html");
	}
}