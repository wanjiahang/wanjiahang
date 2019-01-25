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

	// ��ȡ���ݿ�����
	public Connection getConn() {
		try {
			
			// 1����������
			Class.forName(ConfigMapper.get("driver"));
			// 2����ȡ���ݿ�����
			String url = ConfigMapper.get("url");
			conn = DriverManager.getConnection(url, ConfigMapper.get("user"), ConfigMapper.get("password"));
		
		//��jndi���ݿ����ӳػ�ȡ���ݿ�����
			//�ӳ�ʼ�������Ķ���
			//Context ctx=new InitialContext();
			//��ȡ����Դ
			//DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/company");
		    //��ȡ����
			//conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	// ��ɾ��(update,insert,delete)
	public String executeUpdate(String sql, Object... objects) {
		try {
			// ��ȡ���ݿ�����
			ppst = getConn().prepareStatement(sql);
			// ��ͨ�����ֵ
			for (int i = 0; i < objects.length; i++) {
				ppst.setObject(i + 1, objects[i]);
			}
			// ִ��sql
			ppst.executeUpdate();
			return "ok";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close2();
		}
		return "error";
	}

	// ��ѯ
	public ResultSet executeQuery(String sql, Object... objects) {
		try {
			// ��ȡ���ݿ�����
			ppst = getConn().prepareStatement(sql);
			// ��ͨ�����ֵ
			if(objects!=null) {
				for (int i = 0; i < objects.length; i++) {
					ppst.setObject(i + 1, objects[i]);
				}
			}
			// ִ��sql
			rs = ppst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}


	// �ر�����
	public void close1() {
		try {
			rs.close();
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �ر�����
	public void close2() {
		try {
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
