package getweather;
import java.io.*;
import java.net.*;

import java.text.*;
import java.util.*;

import org.json.*;

public class Message{
	
    static class AutoGet extends TimerTask {
	static private  String url1="http://localhost:1234/api/weather/now";
	static private  String url2="http://localhost:1234/api/msg/push";
	static private  String url3="http://localhost:1234/api/user/login";
	static public  String clock_time="13:22:00";
	static private String session_id = "";
	static private String session_cookie_name = "";
	static private int login_times=10;
	
	public static String sendPost(String url, String param) throws IOException {
		DataOutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            
            conn.setRequestProperty("accept", "*/*");
            //conn.setRequestProperty("content-type", "application/json");
            //conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //conn.setRequestProperty(Utils.session_cookie_name, Utils.session_id);
            if(!(session_id.equals(""))&&!(session_cookie_name.equals(""))){
            	String cookies = String.format("%s=%s", session_cookie_name, session_id);
            	conn.setRequestProperty("Cookie", cookies);
            }
            // conn.setRequestProperty("session_cookie_name", Utils.session_cookie_name);
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            // out = new PrintWriter(conn.getOutputStream());
            out = new DataOutputStream(conn.getOutputStream());
            // �����������
            
            //out.print(param);
            out.write(param.getBytes("UTF-8"));
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
	
	public static String sendGet(String url) throws IOException{

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
		return response.toString();
	}
	
	public static String wrap(String input_str){
		if(input_str.equalsIgnoreCase("clouds")){
			return "����";
		}
		if(input_str.equalsIgnoreCase("rain")){
			return "��";
		}
		if(input_str.equalsIgnoreCase("clear")){
			return "��";
		}
		if(input_str.equalsIgnoreCase("snow")){
			return "ѩ";
		}
		if(input_str.equalsIgnoreCase("extreme")){
			return "����";
		}
		if(input_str.equalsIgnoreCase("thunderstorm")){
			return "������";
		}
		if(input_str.equalsIgnoreCase("drizzle")){
			return "ëë��";
		}
		if(input_str.equalsIgnoreCase("mist")){
			return "��";
		}
		return "δ֪";
	}
	
	public void run()  { 
               
			try{
			  int login_time=0;
			   while(session_id.equals("")||session_cookie_name.equals("")){
				   JSONObject login_input_json=new JSONObject();
				   login_input_json.put("username", "admin");
				   login_input_json.put("password", "1234");
    			   String login_output_str=sendPost(url3,login_input_json.toString());
    			   JSONObject login_output_json=new JSONObject(login_output_str);
    			   if(login_output_json.getInt("login")==1){
    				   session_id=login_output_json.getString("session_id");
    				   session_cookie_name=login_output_json.getString("session_cookie_name");
    			   }
    			   login_time++;
    			   if(login_time>login_times){
    				   throw new Exception("auto login failed!\n");
    			   }
			   }
			   Date date=new Date();
			   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   
			   String weather_output_str=sendGet(url1);
			   JSONObject weather_output_json=new JSONObject(weather_output_str);
			   JSONObject msg_input_json=new JSONObject();
			   String msg_input_str="��������"+wrap(weather_output_json.getJSONObject("weather").getString("main"))+",";
			   msg_input_str+=" ���� "+weather_output_json.getJSONObject("main").getDouble("temp_min")+" ~ ";
			   msg_input_str+=weather_output_json.getJSONObject("main").getDouble("temp_max")+",";
			   msg_input_str+=" ��ѹ "+weather_output_json.getJSONObject("main").getDouble("pressure")+"��";
			   msg_input_json.put("title", "����Ԥ��  "+df.format(date));
			   msg_input_json.put("editor", "");
			   msg_input_json.put("details", msg_input_str);
			   msg_input_json.put("url", "");
			   
			   String msg_output_str=sendPost(url2,msg_input_json.toString());
			   JSONObject msg_output_json=new JSONObject(msg_output_str);
               if(msg_output_json.getInt("success")==0){
            	   throw new Exception("auto push message failed!\n");
               }
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
    }
    
    public static void main(String[] args) throws ParseException { 
    	/*SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
    	Date date=new Date();
    	Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        
    	String ds1=df1.format(date);
    	String ds2=df2.format(date);
    	
    	String dgap=ds2+" "+AutoGet.clock_time;
    	Date first_time;
    	if(ds1.compareTo(dgap)<=0){
    		first_time=df1.parse(dgap);
    	}
    	else{
    		calendar.add(Calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�
        	date=calendar.getTime(); //���ʱ���������������һ��Ľ��
        	ds2=df2.format(date);
        	dgap=ds2+" "+AutoGet.clock_time;
        	first_time=df1.parse(dgap);
    	}
       */
        Timer timer = new Timer();  
        timer.schedule(new AutoGet(), 1000,1000*5); 
    	
    }  
}
