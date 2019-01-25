package com.wh.www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.wh.www.util.ConfigMapper;



public class BaseDao {

	private Connection conn;
	private PreparedStatement ppst;
	private ResultSet rs;

	// 获取数据库连接
	public Connection getConn() {
		try {
			
			// 1、加载驱动
			Class.forName(ConfigMapper.get("driver"));
			// 2、获取数据库连接
			String url = ConfigMapper.get("url");
			conn = DriverManager.getConnection(url, ConfigMapper.get("user"), ConfigMapper.get("password"));
		
		//从jndi数据库连接池获取数据库链接
			//从初始化上下文对象
			//Context ctx=new InitialContext();
			//获取数据源
			//DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/company");
		    //获取链接
			//conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	// 增删改(update,insert,delete)
	public String executeUpdate(String sql, Object... objects) {
		try {
			// 获取数据库连接
			ppst = getConn().prepareStatement(sql);
			// 给通配符赋值
			for (int i = 0; i < objects.length; i++) {
				ppst.setObject(i + 1, objects[i]);
			}
			// 执行sql
			ppst.executeUpdate();
			return "ok";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close2();
		}
		return "error";
	}

	// 查询
	public ResultSet executeQuery(String sql, Object... objects) {
		try {
			// 获取数据库连接
			ppst = getConn().prepareStatement(sql);
			// 给通配符赋值
			if(objects!=null) {
				for (int i = 0; i < objects.length; i++) {
					ppst.setObject(i + 1, objects[i]);
				}
			}
			// 执行sql
			rs = ppst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}


	// 关闭连接
	public void close1() {
		try {
			rs.close();
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭连接
	public void close2() {
		try {
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
