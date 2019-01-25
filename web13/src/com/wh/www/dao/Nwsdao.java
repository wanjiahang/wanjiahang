package com.wh.www.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wh.www.entity.News;

public class Nwsdao extends BaseDao {
	public List<News>getList(){
	ResultSet rs=executeQuery("select*from`news_detail`",null);
    List<News>list=new ArrayList<>();
    try {
		while (rs.next()) {
		News news=new News();
		
		news.setNtitle(rs.getString(3));
		news.setNsummary(rs.getString(4));
		news.setNcontent(rs.getString(5));
		news.setNauthor(rs.getString(7));
		news.setNcreatedate(rs.getDate(8));
		list.add(news);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}
//	public static void main(String[] args) {
//		News news =new News();
//		Nwsdao nwsdao=new Nwsdao();
//		System.out.println(nwsdao.getList(news.getNid(),news.getNtitle(), news.getNsummary(), news.getNcontent()));
//	}
}