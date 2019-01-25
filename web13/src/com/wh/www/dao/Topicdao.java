package com.wh.www.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wh.www.entity.Topic;

public class Topicdao extends BaseDao {
     //查询所有主题
	public List<Topic>getlist(){
		List<Topic>list=new ArrayList<Topic>();
		ResultSet rs=executeQuery("SELECT*FROM`news_category`", null);
		try {
			while (rs.next()) {
				Topic t=new Topic();
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
