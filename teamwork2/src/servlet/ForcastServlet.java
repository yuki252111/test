package servlet;

import java.io.IOException;
import java.sql.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.JSONException;
import org.json.JSONObject;



public class ForcastServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private static Boolean isOn=false;
	public static final String url = "jdbc:mysql://localhost:3306/weather";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root"; 
    public static Connection conn = null; 
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForcastServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ok");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		//doGet(request, response);
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);//获取连接
	        Statement stmt = conn.createStatement();
	        
	        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
	        String dt=dateFm.format(new java.util.Date());
	        
	        String sql="select * from curweather where dt='"+dt+"';";
	        ResultSet rs=stmt.executeQuery(sql);
	        JSONObject we=new JSONObject();
	        if(rs.next()){
	        	we.put("dt",dt );
	        	we.put("main",new JSONObject( rs.getString(2)));
	        	we.put("weather", new JSONObject(rs.getString(3)));
	        	we.put("clouds", new JSONObject(rs.getString(4)));
	        	we.put("wind",new JSONObject(rs.getString(5)));
	        	we.put("sys", new JSONObject(rs.getString(6)));
	        }
	        rs.close();stmt.close();conn.close();
	        response.getWriter().append(we.toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//指定连接类型   
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
