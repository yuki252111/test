package getweather;
import java.io.IOException;

import net.aksingh.owmjapis.*;
import net.aksingh.owmjapis.HourlyForecast.Forecast;

import org.json.*;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class GetWeather{
    static class UpdateWeather extends TimerTask {
	public static final String url = "jdbc:mysql://localhost:3306/bxweather";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "baixing";  
    public static final String password = "baixing"; 
    public static Connection conn = null;
    public static int days=5;
    public static int int_default=-1000;
    public static float float_default=-1000;
    public static String string_default="";
    
    public static void refreshCur() throws IOException, JSONException, SQLException, ClassNotFoundException{
    	OpenWeatherMap owm = new OpenWeatherMap("50b95478c6c326f917e43f8573170c6f");
		// getting current weather data for the "London" city
    	owm.setUnits(OpenWeatherMap.Units.METRIC);
    	Class.forName(name);//指定连接类型  
        conn = DriverManager.getConnection(url, user, password);//获取连接
        Statement stmt = conn.createStatement();
    	
        DecimalFormat df  =  new  DecimalFormat("#.#");
    	
		CurrentWeather cwd = owm.currentWeatherByCityName("Shanghai");
		//printing city name from the retrieved data
		if (cwd.isValid()) {
			// checking if city name is available
            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
            String dt=dateFm.format(new java.util.Date());
             
            JSONObject main=new JSONObject();
            if(cwd.hasMainInstance()){
            	if(cwd.getMainInstance().hasTemperature())
            		main.put("temp",Float.valueOf(df.format(cwd.getMainInstance().getTemperature())));
            	else
            		main.put("temp",float_default);
            	if(cwd.getMainInstance().hasMinTemperature())
            		main.put("temp_min", Float.valueOf(df.format(cwd.getMainInstance().getMinTemperature())));
            	else
            		main.put("temp_min",float_default);
            	if(cwd.getMainInstance().hasMaxTemperature())
            		main.put("temp_max", Float.valueOf(df.format(cwd.getMainInstance().getMaxTemperature())));
            	else
            		main.put("temp_max", float_default);
            	if(cwd.getMainInstance().hasPressure())
            		main.put("pressure", Float.valueOf(df.format(cwd.getMainInstance().getPressure())));
            	else
            		main.put("pressure", float_default);
            	if(cwd.getMainInstance().hasHumidity())
            		main.put("humidity", Float.valueOf(df.format(cwd.getMainInstance().getHumidity())));
            	else
            		main.put("humidity", float_default);
            }
            
            JSONObject weather=new JSONObject();
            if(cwd.hasWeatherInstance()){
            	if(cwd.getWeatherInstance(0).hasWeatherCode())
            		weather.put("id", cwd.getWeatherInstance(0).getWeatherCode());
            	else
            		weather.put("id", int_default);
            	if(cwd.getWeatherInstance(0).hasWeatherName())
            		weather.put("main", cwd.getWeatherInstance(0).getWeatherName());
            	else
            		weather.put("main", string_default);
            	if(cwd.getWeatherInstance(0).hasWeatherDescription())
            		weather.put("description", cwd.getWeatherInstance(0).getWeatherDescription());
            	else
            		weather.put("description", string_default);
            	if(cwd.getWeatherInstance(0).hasWeatherIconName())
            		weather.put("icon", cwd.getWeatherInstance(0).getWeatherIconName());
            	else
            		weather.put("icon", string_default);
            }
            
            JSONObject cloud=new JSONObject();
            if(cwd.hasCloudsInstance()){
            	if(cwd.getCloudsInstance().hasPercentageOfClouds())
            		cloud.put("clouds", Float.valueOf(df.format(cwd.getCloudsInstance().getPercentageOfClouds())));
            	else
            		cloud.put("clouds", float_default);
            }
            
            JSONObject wind=new JSONObject();
            if(cwd.hasWindInstance()){
            	if(cwd.getWindInstance().hasWindSpeed())
            		wind.put("speed", Float.valueOf(df.format(cwd.getWindInstance().getWindSpeed())));
            	else
            		wind.put("speed", float_default);
            	if(cwd.getWindInstance().hasWindDegree())
            		wind.put("deg", Float.valueOf(df.format(cwd.getWindInstance().getWindDegree())));
            	else
            		wind.put("deg", float_default);
            }
            
            JSONObject sys=new JSONObject();
            if(cwd.hasSysInstance()){
            	if(cwd.getSysInstance().hasCountryCode())
            		sys.put("pod", cwd.getSysInstance().getCountryCode());
            	else
            		sys.put("pod", string_default);
            }
            
            HourlyForecast hw=owm.hourlyForecastByCityName("Shanghai");
            JSONObject future5=new JSONObject();
            JSONArray arr=new JSONArray();
            if(hw.isValid()){
            	int count=hw.getForecastCount();
            	String prev_dt="none";
            	for(int i=0;i<count;i++){
            		Forecast fc=hw.getForecastInstance(i);
            		if(fc.hasDateTime()){
            			SimpleDateFormat prevFm = new SimpleDateFormat("yyyy-MM-dd");
            			if(!prev_dt.equals(prevFm.format(fc.getDateTime()))){
            				if(!prev_dt.equals("none"))
            					future5.put(prev_dt,arr);
            				prev_dt=prevFm.format(fc.getDateTime());
            				arr=new JSONArray("[]");
            			}
            		}
            		
            		String fc_dt="";
            		if(fc.hasDateTimeText()) fc_dt=fc.getDateTimeText();
            		else if(fc.hasDateTime()){
            			dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            			fc_dt=dateFm.format(fc.getDateTime());
            		}
            		
            		JSONObject fc_main=new JSONObject();
                    if(fc.hasMainInstance()){
                    	if(fc.getMainInstance().hasTemperature())
                    		fc_main.put("temp",Float.valueOf(df.format(fc.getMainInstance().getTemperature())));
                    	else
                    		fc_main.put("temp", float_default);
                    	if(fc.getMainInstance().hasMinTemperature())
                    		fc_main.put("temp_min", Float.valueOf(df.format(fc.getMainInstance().getMinTemperature())));
                    	else
                    		fc_main.put("temp_min", float_default);
                    	if(fc.getMainInstance().hasMaxTemperature())
                    		fc_main.put("temp_max",Float.valueOf(df.format(fc.getMainInstance().getMaxTemperature())));
                    	else
                    		fc_main.put("temp_max", float_default);
                    	if(fc.getMainInstance().hasPressure())
                    		fc_main.put("pressure", Float.valueOf(df.format(fc.getMainInstance().getPressure())));
                    	else
                    		fc_main.put("pressure", float_default);
                    	if(fc.getMainInstance().hasHumidity())
                    		fc_main.put("humidity", Float.valueOf(df.format(fc.getMainInstance().getHumidity())));
                    	else
                    		fc_main.put("humidity",float_default );
                    }
                    
                    JSONObject fc_weather=new JSONObject();
                    if(fc.hasWeatherInstance()){
                    	if(fc.getWeatherInstance(0).hasWeatherCode())
                    		fc_weather.put("id", fc.getWeatherInstance(0).getWeatherCode());
                    	else
                    		fc_weather.put("id", int_default);
                    	if(fc.getWeatherInstance(0).hasWeatherName())
                    		fc_weather.put("main", fc.getWeatherInstance(0).getWeatherName());
                    	else
                    		fc_weather.put("main", string_default);
                    	if(fc.getWeatherInstance(0).hasWeatherDescription())
                    		fc_weather.put("description", fc.getWeatherInstance(0).getWeatherDescription());
                    	else
                    		fc_weather.put("description", string_default);
                    	if(fc.getWeatherInstance(0).hasWeatherIconName())
                    		fc_weather.put("icon", fc.getWeatherInstance(0).getWeatherIconName());
                    	else
                    		fc_weather.put("icon", string_default);
                    }
                    
                    JSONObject fc_cloud=new JSONObject();
                    if(fc.hasCloudsInstance()){
                    	if(fc.getCloudsInstance().hasPercentageOfClouds())
                    		fc_cloud.put("clouds",Float.valueOf(df.format(fc.getCloudsInstance().getPercentageOfClouds())));
                    	else
                    		fc_cloud.put("clouds", float_default);
                    }
                    
                    JSONObject fc_wind=new JSONObject();
                    if(fc.hasWindInstance()){
                    	if(fc.getWindInstance().hasWindSpeed())
                    		fc_wind.put("speed", Float.valueOf(df.format(fc.getWindInstance().getWindSpeed())));
                    	else
                    		fc_wind.put("speed", float_default);
                    	if(fc.getWindInstance().hasWindDegree())
                    		fc_wind.put("deg", Float.valueOf(df.format(fc.getWindInstance().getWindDegree())));
                    	else
                    		fc_wind.put("deg", float_default);
                    }
                    
                    JSONObject fc_sys=new JSONObject();
                    if(fc.hasSysInstance()){
                    	if(fc.getSysInstance().hasPod())
                    		fc_sys.put("pod", fc.getSysInstance().getPod());
                    	else
                    		fc_sys.put("pod", string_default);
                    }
                    JSONObject fc_one=new JSONObject();
                    fc_one.put("dt", fc_dt);
                    fc_one.put("main", fc_main);
                    fc_one.put("weather", fc_weather);
                    fc_one.put("clouds", fc_cloud);
                    fc_one.put("wind", fc_wind);
                    fc_one.put("sys", fc_sys);
                    arr.put(fc_one);
            	}
            }
            JSONObject modifyFuture=new JSONObject();
            
            Date date=new Date();//取时间
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            modifyFuture.put("0", future5.get(dateString));
            
            days=future5.length();
            for(int i=1;i<days;i++){
            	calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
            	date=calendar.getTime(); //这个时间就是日期往后推一天的结果
            	dateString = formatter.format(date);
            	if(future5.has(dateString))
            		modifyFuture.put(i+"", future5.get(dateString));
            }
            
            String sql="update curweather set main='"+main+"',weather='"+weather+"',clouds='"+cloud+"',wind='"+wind+"',sys='"+sys+"',future='"+modifyFuture+"' where dt='"+dt+"';";
            int res=stmt.executeUpdate(sql);
            if(res==0){
            	System.out.println("update wrong");
            	sql="insert into curweather values ('"+dt+"','"+main+"','"+weather+"','"+cloud+"','"+wind+"','"+sys+"','"+modifyFuture+"');";
            	res=stmt.executeUpdate(sql);
            	if(res==0){
            		System.out.println("insert wrong");
            	}
            }
		}
		stmt.close();
        conn.close();
    }

	public void run()  {
		// TODO Auto-generated method stub {
			// declaring object of "OpenWeatherMap" class
			System.out.println("exe");
			try {
				refreshCur();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
    public static void main(String[] args) {  
        Timer timer = new Timer();  
        timer.schedule(new UpdateWeather(), 2000,5000);// 两秒后启动任务  
    }  
}
