package com.sp.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;
import com.sp.domain.GoodsViewVO;
import com.sp.service.AdminService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	@Inject
	AdminService adminService;

	/* @Resource(name="uploadPath") */
	// private String uploadPath;

	// 관리자화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get Index");
	}

	// 상품 등록
	@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("get goods register");

		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	// 상품 등록
	@RequestMapping(value = "/goods/register", method = RequestMethod.POST)
	public String getGoodsRegister(GoodsVO vo) throws Exception {
		logger.info("post goods register");

		// String imgUploadPath = uploadPath + File.separator + "imgUpload";
		// String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		// String fileName = null;

		// if(file != null) {
		// fileName = UploadFileUtils.fileUpload(imgUploadPath,
		// file.getOriginalFilename(), file.getBytes(), ymdPath);
		// } else {
		// fileName = uploadPath + File.separator + "images" + File.separator +
		// "none.png";
		// }
		//
		// vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator
		// + fileName);
		// vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath +
		// File.separator + "s" + File.separator + "s_" + fileName);
		System.out.println(vo.getGdsName());
		System.out.println(vo.getCateCode());
		System.out.println(vo.getGdsPrice());
		System.out.println(vo.getGdsStock());
		System.out.println(vo.getGdsDes());
		System.out.println(vo.getGdsNum());

		vo.setGdsImg("1");
		vo.setGdsThumbImg("2");

		adminService.register(vo);
		return "redirect:/admin/index";
	}

	// 상품 목록
	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		logger.info("get goods list");

		List<GoodsVO> list = adminService.goodslist();
		model.addAttribute("list", list);
	}

	// 상품 조회
	@RequestMapping(value = "/goods/view", method = RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum, Model model)
			throws Exception {
		logger.info("get goods view");

		System.out.println(gdsNum);
		GoodsViewVO goods = adminService.goodView(gdsNum);
		model.addAttribute("goods", goods);
	}

	// 상품 수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model)
			throws Exception {
		logger.info("get goods modify");

		GoodsViewVO goods = adminService.goodView(gdsNum);
		model.addAttribute("goods", goods);

		System.out.println(goods.getCateCode());
		System.out.println(goods.getCateCodeRef());
		System.out.println(goods.getCateName());

		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	// 상품 등록
	@RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(@RequestParam("n") int gdsNum, GoodsVO vo)
			throws Exception {
		logger.info("post goods modify");

		vo.setGdsNum(gdsNum);

		System.out.println(vo.getGdsName());
		System.out.println(vo.getCateCode());
		System.out.println(vo.getGdsPrice());
		System.out.println(vo.getGdsStock());
		System.out.println(vo.getGdsDes());
		System.out.println(vo.getGdsNum());

		adminService.goodsModify(vo);
		return "redirect:/admin/index";
	}

	// 상품 삭제
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum)
			throws Exception {
		logger.info("post goods delete");

		adminService.goodsDelete(gdsNum);

		return "redirect:/admin/index";
	}
}
