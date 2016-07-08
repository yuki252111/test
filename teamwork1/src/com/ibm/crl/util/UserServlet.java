package com.ibm.crl.util;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject chk;
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdFormatter.format(nowTime);
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		try {
			chk = new JSONObject (request.getParameter("data"));
			if (chk.get("action").equals("searchuser"))
			{
				JSONObject jout = new JSONObject();
				String sid = chk.get("id").toString();
				int id = Integer.parseInt(sid);
				User u = new User();
				u.setId(id);
				u.setUsername(chk.get("username").toString());
				u.setTel(chk.get("tel").toString());
				u.setContact(chk.get("contact").toString());
				u.setDepartment1(chk.get("department1").toString());
				u.setDepartment2(chk.get("department2").toString());
				u.setStation(chk.get("station").toString());
				u.setJob(chk.get("job").toString());
				u.setAddress(chk.get("address").toString());
				u.setManager(chk.get("manager").toString());
				u.setDate(chk.get("date").toString());
				
				response.getWriter().append(jout.toString());
			}
			if (chk.get("action").equals("setuserinfo"))
			{
				JSONObject jout = new JSONObject();
				String sid = chk.get("id").toString();
				int id = Integer.parseInt(sid);
				User u = new User();
				u.setId(id);
				u.setUsername(chk.get("username").toString());
				u.setTel(chk.get("tel").toString());
				u.setContact(chk.get("contact").toString());
				u.setDepartment1(chk.get("department1").toString());
				u.setDepartment2(chk.get("department2").toString());
				u.setStation(chk.get("station").toString());
				u.setJob(chk.get("job").toString());
				u.setAddress(chk.get("address").toString());
				u.setManager(chk.get("manager").toString());
				u.setDate(chk.get("date").toString());
				UserBean.updateUserInfo (u);
				jout.put("result","ok");
				response.getWriter().append(jout.toString());
			}
			
			if (chk.get("action").equals("userlist"))
			{
				JSONObject jout = new JSONObject();
				JSONArray arr = new JSONArray();
				arr = makeJsonArray.MakeList();
				jout.put("result","ok");
				jout.put("data",arr);
				response.getWriter().append(jout.toString());
			}
			if (chk.get("action").equals("deleteuser"))
			{
				JSONObject jout = new JSONObject();
				String sid = chk.get("username").toString();
				User u = UserBean.getUser (sid);
				u.setExist(0);
				UserBean.updateUserInfo (u);
				jout.put("result","ok");
				response.getWriter().append(jout.toString());
			}
			
			if (chk.get("action").equals("register"))
			{
				JSONObject jout = new JSONObject();
				User u = new User();
				String username = chk.get("username").toString();
				String password = chk.get("password").toString();
				u.setUsername(chk.get("username").toString());
				u.setTel(chk.get("tel").toString());
				u.setContact(chk.get("contact").toString());
				u.setDepartment1(chk.get("department1").toString());
				u.setDepartment2(chk.get("department2").toString());
				u.setStation(chk.get("station").toString());
				u.setJob(chk.get("job").toString());
				u.setAddress(chk.get("address").toString());
				u.setManager(chk.get("manager").toString());
				u.setDate(chk.get("date").toString());
				if (UserBean.addUser (u)){UserBean.addAccount(username, password);jout.put("result","ok");}
				else {jout.put("result","error");jout.put("reason","用户已存在");}
				response.getWriter().append(jout.toString());
			}
			if (chk.get("action").equals("login"))
			{
				JSONObject jout = new JSONObject();
				String username = chk.get("username").toString();
				String password = chk.get("password").toString();
				int tmp = UserBean.checkAccount(username, password);
				if (tmp == 0){jout.put("result","error");jout.put("reason","用户不存在");}
				else if (tmp == 1)jout.put("result","ok");
				else if (tmp == 2){jout.put("result","error");jout.put("reason","密码错误");}
				response.getWriter().append(jout.toString());
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
