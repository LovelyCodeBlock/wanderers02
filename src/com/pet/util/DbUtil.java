package com.pet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	private static String dbUrl    = "jdbc:mysql://localhost:3306/pets";
	private static String userName = "root";
	private static String password = "root";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * ���ݿ�����
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getCon() throws SQLException, ClassNotFoundException {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, userName, password);
		return con;
	}
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws SQLException
	 */
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ر�PreparedStatement
	 * @param preparedStatement
	 */
	public static void close(PreparedStatement preparedStatement)
	{
		try
		{
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * �ر�ResultSet
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet)
	{
		try
		{
			if(resultSet != null)
			{
				resultSet.close();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
