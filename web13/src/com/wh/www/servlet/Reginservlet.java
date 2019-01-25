package com.wh.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wh.www.dao.Userdao;
@WebServlet("/Reginservlet")
public class Reginservlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uname=req.getParameter("name");
		System.out.println(uname+"++++++++++++++++++++++++");
		//查询是否有这个人
		Userdao userdao=new Userdao();
		String result="";
		if (userdao.getList(uname).size()>0) {
			result="err";//代表数据库有了  就不能使用
		}else {
			result="ok";//代表可以用
		}
		//响应ajax
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.write(result);
		out.close();
	}
}
