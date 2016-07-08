package com.ibm.crl.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.NamingException;

import org.json.JSONException;

public class UserBean {
	public static boolean addUser(User user) throws ClassNotFoundException
	{
		if (user==null) return false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = DBControl.connect();
			st = conn.createStatement();
			String query = "select * from staff where username = '" + user.getUsername() + "' and tel = '" + user.getTel() + "';";
			rs = st.executeQuery(query);
			if (rs.next())return false;
			String sql = "select max(id) from staff";
			rs = st.executeQuery(sql);
			int id;
			if(rs.next())
			{
				id = rs.getInt(1) + 1;
			}
			else
				id = 1;
			user.setId(id);
			sql = "insert into Staff(id,username,tel,contact,department1,department2,station,job,address,manager,date,exist) " + "values('" + user.getId() + "','" + user.getUsername() +
			"','" + user.getTel() + "','" + user.getContact() + "','" + user.getDepartment1() + "','" + user.getDepartment2() + "','" + user.getStation()
			+ "','" + user.getJob() + "','" + user.getAddress() + "','"+ user.getManager() + "','" + user.getDate () + "','1' );";
			int nResult = st.executeUpdate(sql);
			//st.executeUpdate(sql);
			return nResult == 1;
		}
		catch(SQLException e){
			e.printStackTrace(System.err);
			return false;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			SQLException te = null;
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}
			
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					te = e;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}

		}
	}
	public static boolean addAccount(String username,String password) throws ClassNotFoundException
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = DBControl.connect();
			st = conn.createStatement();
			String sql = "select max(id) from user";
			rs = st.executeQuery(sql);
			int id;
			if(rs.next())
			{
				id = rs.getInt(1) + 1;
			}
			else
				id = 1;
			sql = "insert into user(id,username,password) " + "values('" + id + "','" + username + "','" + password + "');";
			int nResult = st.executeUpdate(sql);
			st.executeUpdate(sql);
			return nResult == 1;
		}
		catch(SQLException e){
			e.printStackTrace(System.err);
			return false;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			SQLException te = null;
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}
			
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					te = e;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}

		}
	}
	public static int checkAccount(String username,String password) throws ClassNotFoundException
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = DBControl.connect();
			st = conn.createStatement();
			String sql = "select password from user where username = '" + username + "';";
			rs = st.executeQuery(sql);
			if(!rs.next())
			{
				return 0;
			}
			String tmp=rs.getString(1);
			if (password.equals(tmp))return 1;
			else return 2;
		}
		catch(SQLException e){
			e.printStackTrace(System.err);
			return 0;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			SQLException te = null;
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}
			
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					te = e;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}

		}
	}
	public static User getUser(String id) throws ClassNotFoundException
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = DBControl.connect();
			st = conn.createStatement();
			String sql = "select * from staff where username = '" + id + "' and exist='1';";
			rs = st.executeQuery(sql);
			User u = new User();
			if (!rs.next())System.out.print("error");
			u.setId(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setTel(rs.getString(3));
			u.setContact(rs.getString(4));
			u.setDepartment1(rs.getString(5));
			u.setDepartment2(rs.getString(6));
			u.setStation(rs.getString(7));
			u.setJob(rs.getString(8));
			u.setAddress(rs.getString(9));
			u.setManager(rs.getString(10));
			u.setDate(rs.getString(11));
			u.setExist(rs.getInt(12));
			return u;
		}
		catch(SQLException e){
			e.printStackTrace(System.err);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			SQLException te = null;
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}
			
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					te = e;
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					if (te == null) {
						te = e;
					}
				}
			}

		}
		return null;
	}
	
	public static void updateUserInfo(User u) throws ClassNotFoundException, JSONException
	{
		try{
			String sql = "update staff set username = '" + u.getUsername() + "', tel = '" + u.getTel()
					+ "' , contact = '" + u.getContact()
					+ "' , department1 = '" + u.getDepartment1()
					+ "' , department2 = '" + u.getDepartment2()
					+ "' , station = '" + u.getStation()
					+ "' , job = '" + u.getJob()
					+ "' , address = '" + u.getAddress()
					+ "' , manager = '" + u.getManager()
					+ "' , date = '" + u.getDate()
					+ "' , exist = '" + u.getExist()
					+ "' where id = '" + u.getId() + "';";
			DBOperateTool.update(sql);
			}
		catch(SQLException e)
		{
			e.printStackTrace(System.err);
		}
		
	}
	public static void searchUser(User u) throws ClassNotFoundException, JSONException
	{
		try{
			String sql = "select * from staff where ";
			if (u.getId() != 0)sql += "id = '" + u.getId() + "' and ";
			if (u.getUsername() != null)sql += "username = '" + u.getUsername() + "' and ";
			if (u.getTel() != null)sql += "tel = '" + u.getTel() + "' and ";
			if (u.getContact() != null)sql += "contact = '" + u.getContact() + "' and ";
			if (u.getDepartment1() != null)sql += "department1 = '" + u.getDepartment1() + "' and ";
			if (u.getDepartment2() != null)sql += "department2 = '" + u.getDepartment2() + "' and ";
			if (u.getStation() != null)sql += "station = '" + u.getStation() + "' and ";
			if (u.getJob() != null)sql += "job = '" + u.getJob() + "' and ";
			if (u.getAddress() != null)sql += "address = '" + u.getAddress() + "' and ";
			if (u.getManager() != null)sql += "manager = '" + u.getManager() + "' and ";

			sql += "exsit = '1';";
			DBOperateTool.update(sql);
			}
		catch(SQLException e)
		{
			e.printStackTrace(System.err);
		}
		
	}
}
