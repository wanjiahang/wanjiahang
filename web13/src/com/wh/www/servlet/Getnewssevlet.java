package com.wh.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.wh.www.dao.Nwsdao;
import com.wh.www.entity.News;
@WebServlet("/Getnewssevlet")
public class Getnewssevlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Nwsdao n=new Nwsdao();
		List<News>list=n.getList();
		JSONObject obj=new JSONObject();
		obj.put("news", list);
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(obj);
		out.close();

}
}