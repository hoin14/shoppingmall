package com.sp.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.domain.CartListVO;
import com.sp.domain.CartVO;
import com.sp.domain.GoodsViewVO;
import com.sp.domain.MemberVO;
import com.sp.domain.OrderDetailVO;
import com.sp.domain.OrderVO;
import com.sp.domain.ReplyListVO;
import com.sp.domain.ReplyVO;
import com.sp.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController {

	private static final Logger logger = LoggerFactory
			.getLogger(ShopController.class);

	@Inject
	ShopService service;

	// Category List
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode,
			@RequestParam("l") int level, Model model) throws Exception {
		logger.info("get list");
		System.out.println(cateCode + "." + level);
		List<GoodsViewVO> list = null;
		list = service.list(cateCode);

		model.addAttribute("list", list);
	}

	// 상품 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model)
			throws Exception {
		logger.info("get view");

		GoodsViewVO view = service.goodsView(gdsNum);
		model.addAttribute("view", view);
		/*
		 * List<ReplyListVO> reply = service.replyList(gdsNum);
		 * model.addAttribute("reply", reply);
		 */
	}

	/*
	 * // 상품 댓글작성
	 * 
	 * @RequestMapping(value = "/view", method = RequestMethod.POST) public
	 * String registReply(ReplyVO reply, HttpSession session) throws Exception {
	 * logger.info("get view");
	 * 
	 * MemberVO member = (MemberVO) session.getAttribute("member");
	 * reply.setUserId(member.getUserId());
	 * 
	 * service.registReply(reply); return "redirect:/shop/view?n=" +
	 * reply.getGdsNum(); }
	 */

	// 상품 댓글작성
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(ReplyVO reply, HttpSession session)
			throws Exception {
		logger.info("regist reply");

		MemberVO member = (MemberVO) session.getAttribute("member");
		reply.setUserId(member.getUserId());

		service.registReply(reply);
	}

	// 상품댓글 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum)
			throws Exception {
		logger.info("get reply list");

		List<ReplyListVO> reply = service.replyList(gdsNum);

		return reply;
	}

	// 상품댓글 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyVO reply, HttpSession session)
			throws Exception {
		logger.info("POST delete reply");

		int result = 0;

		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());

		if (member.getUserId().equals(userId)) {

			reply.setUserId(member.getUserId());
			service.deleteReply(reply);

			result = 1;
		}
		return result;
	}

	// 상품 소감(댓글) 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyVO reply, HttpSession session)
			throws Exception {
		logger.info("modify reply");

		int result = 0;

		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());

		if (member.getUserId().equals(userId)) {

			reply.setUserId(member.getUserId());
			service.modifyReply(reply);
			result = 1;
		}

		return result;
	}

	// 카트 담기
	@ResponseBody
	@RequestMapping(value = "/view/addCart", method = RequestMethod.POST)
	public int addCart(CartVO cart, HttpSession session) throws Exception {

		int result = 0;

		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member != null) {
			cart.setUserId(member.getUserId());
			service.addCart(cart);
			result = 1;
		}

		return result;
	}

	// 카트 목록
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception {
		logger.info("get cart list");

		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = member.getUserId();

		List<CartListVO> cartList = service.cartList(userId);

		model.addAttribute("cartList", cartList);

	}

	// 카트 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public int deleteCart(HttpSession session,
			@RequestParam(value = "chbox[]") List<String> chArr, CartVO cart)
			throws Exception {
		logger.info("delete cart");

		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = member.getUserId();

		int result = 0;
		int cartNum = 0;

		if (member != null) {
			cart.setUserId(userId);

			for (String i : chArr) {
				cartNum = Integer.parseInt(i);
				cart.setCartNum(cartNum);
				service.deleteCart(cart);
			}
			result = 1;
		}
		return result;
	}

	// 주문
	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
	public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) throws Exception {
	 logger.info("order");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");  
	 String userId = member.getUserId();
	 
	 Calendar cal = Calendar.getInstance();
	 int year = cal.get(Calendar.YEAR);
	 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	 String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
	 String subNum = "";
	 
	 for(int i = 1; i <= 6; i ++) {
	  subNum += (int)(Math.random() * 10);
	 }
	 
	 String orderId = ymd + "_" + subNum;
	 
	 order.setOrderId(orderId);
	 order.setUserId(userId);
	  
	 service.orderInfo(order);
	 
	 orderDetail.setOrderId(orderId);   
	 service.orderInfo_Details(orderDetail);
	 
	 service.cartAllDelete(userId);
	 
	 return "redirect:/shop/orderList";  
	}
	
}
