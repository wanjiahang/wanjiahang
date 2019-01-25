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
import com.wh.www.dao.Topicdao;
import com.wh.www.entity.Topic;

import sun.nio.ch.DatagramSocketAdaptor;
@WebServlet("/GetTopicsevlet")
public class GetTopicsevlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Topicdao dao=new Topicdao();
			List<Topic>list=dao.getlist();
			// 这个集合要响应ajax
			//封装一个json对象
			JSONObject object=new JSONObject();
			object.put("topic", list);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter out=resp.getWriter();
			out.print(object);
			out.close();
		}
}
