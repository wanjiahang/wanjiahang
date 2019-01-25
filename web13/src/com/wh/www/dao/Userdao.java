package com.wh.www.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wh.www.entity.User;

public class Userdao extends BaseDao {
	public List<User>getList(String name){
		List<User>list=new ArrayList();
		ResultSet rs=executeQuery("SELECT*FROM t_user WHERE uname=?", name);
		
		try {
			while (rs.next()) {
			  User user=new User();
			  user.setUid(rs.getInt(1));
			  user.setUname(rs.getString(2));
			  user.setAge(rs.getInt(3));
			list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		Userdao userdao=new Userdao();
		
		
		System.out.println(userdao.getList("ÀîËÄ"));
	}
}
