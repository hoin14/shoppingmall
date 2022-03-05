package com.sp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sp.domain.CategoryVO;
import com.sp.domain.GoodsVO;
import com.sp.domain.GoodsViewVO;
import com.sp.service.AdminService;
import com.sp.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	@Inject
	AdminService adminService;

	/* @Resource(name = "uploadPath") */
	private String uploadPath;

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
	public String getGoodsRegister(GoodsVO vo, MultipartFile file)
			throws Exception {
		logger.info("post goods register");

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath,
					file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator
					+ "none.png";
			fileName = File.separator + "images" + File.separator + "none.png";
		}

		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator
				+ fileName);
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath
				+ File.separator + "s" + File.separator + "s_" + fileName);

		System.out.println(vo.getGdsName());
		System.out.println(vo.getCateCode());
		System.out.println(vo.getGdsPrice());
		System.out.println(vo.getGdsStock());
		System.out.println(vo.getGdsDes());
		System.out.println(vo.getGdsNum());

		/*
		 * vo.setGdsImg("1"); vo.setGdsThumbImg("2");
		 */
		adminService.register(vo);
		return "redirect:/admin/index";
	}

	// 상품 목록
	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		logger.info("get goods list");

		List<GoodsViewVO> list = adminService.goodslist();
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

	// ck 에디터에서 파일 업로드
	@RequestMapping(value = "/goods/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req,
			HttpServletResponse res, @RequestParam MultipartFile upload)
			throws Exception {
		logger.info("post CKEditor img upload");

		// 랜덤 문자 생성
		UUID uid = UUID.randomUUID();

		OutputStream out = null;
		PrintWriter printWriter = null;

		// 인코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		try {

			String fileName = upload.getOriginalFilename(); // 파일 이름 가져오기
			byte[] bytes = upload.getBytes();

			// 업로드 경로
			String ckUploadPath = uploadPath + File.separator + "ckUpload"
					+ File.separator + uid + "_" + fileName;

			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush(); // out에 저장된 데이터를 전송하고 초기화

			String callback = req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			String fileUrl = "/ckUpload/" + uid + "_" + fileName; // 작성화면

			// 업로드시 메시지 출력
			printWriter.println("<script type='text/javascript'>"
					+ "window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",'" + fileUrl + "','이미지를 업로드하였습니다.')" + "</script>");

			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return;

	}
}
