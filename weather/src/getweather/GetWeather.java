package getweather;
import java.io.IOException;
import java.net.MalformedURLException;
import net.aksingh.owmjapis.*;
import net.aksingh.owmjapis.HourlyForecast.Forecast;

import org.json.*;

import java.sql.*;
import java.text.*;

public class GetWeather {
	public static final String url = "jdbc:mysql://localhost:3306/weather";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root"; 
    public static Connection conn = null;
    
    public static void refreshCur() throws IOException, JSONException, SQLException, ClassNotFoundException{
    	OpenWeatherMap owm = new OpenWeatherMap("50b95478c6c326f917e43f8573170c6f");
		// getting current weather data for the "London" city
    	owm.setUnits(OpenWeatherMap.Units.METRIC);
    	Class.forName(name);//指定连接类型  
        conn = DriverManager.getConnection(url, user, password);//获取连接
        Statement stmt = conn.createStatement();
    	
    	
		CurrentWeather cwd = owm.currentWeatherByCityName("Shanghai");
		//printing city name from the retrieved data
		if (cwd.isValid()) {
			// checking if city name is available
            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
            String dt=dateFm.format(new java.util.Date());
            
            JSONObject main=new JSONObject();
            if(cwd.hasMainInstance()){
            main.put("temp",cwd.getMainInstance().getTemperature() );
            main.put("temp_min", cwd.getMainInstance().getMinTemperature());
            main.put("temp_max", cwd.getMainInstance().getMaxTemperature());
            main.put("pressure", cwd.getMainInstance().getPressure());
            main.put("humidity", cwd.getMainInstance().getHumidity());
            }
            
            JSONObject weather=new JSONObject();
            if(cwd.hasWeatherInstance()){
            weather.put("id", cwd.getWeatherInstance(0).getWeatherCode());
            weather.put("main", cwd.getWeatherInstance(0).getWeatherName());
            weather.put("description", cwd.getWeatherInstance(0).getWeatherDescription());
            weather.put("icon", cwd.getWeatherInstance(0).getWeatherIconName());
            }
            
            JSONObject cloud=new JSONObject();
            if(cwd.hasCloudsInstance()){
            cloud.put("clouds", cwd.getCloudsInstance().getPercentageOfClouds());
            }
            
            JSONObject wind=new JSONObject();
            if(cwd.hasWindInstance()){
            wind.put("speed", cwd.getWindInstance().getWindSpeed());
            wind.put("deg", cwd.getWindInstance().getWindDegree());
            }
            
            JSONObject sys=new JSONObject();
            if(cwd.hasSysInstance()){
            sys.put("pod", cwd.getSysInstance().getCountryCode());
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
                    fc_main.put("temp",cwd.getMainInstance().getTemperature() );
                    fc_main.put("temp_min", cwd.getMainInstance().getMinTemperature());
                    fc_main.put("temp_max", cwd.getMainInstance().getMaxTemperature());
                    fc_main.put("pressure", cwd.getMainInstance().getPressure());
                    fc_main.put("humidity", cwd.getMainInstance().getHumidity());
                    }
                    
                    JSONObject fc_weather=new JSONObject();
                    if(fc.hasWeatherInstance()){
                    	fc_weather.put("id", cwd.getWeatherInstance(0).getWeatherCode());
                    	fc_weather.put("main", cwd.getWeatherInstance(0).getWeatherName());
                    	fc_weather.put("description", cwd.getWeatherInstance(0).getWeatherDescription());
                    	fc_weather.put("icon", cwd.getWeatherInstance(0).getWeatherIconName());
                    }
                    
                    JSONObject fc_cloud=new JSONObject();
                    if(fc.hasCloudsInstance()){
                    	fc_cloud.put("clouds", cwd.getCloudsInstance().getPercentageOfClouds());
                    }
                    
                    JSONObject fc_wind=new JSONObject();
                    if(fc.hasWindInstance()){
                    	fc_wind.put("speed", cwd.getWindInstance().getWindSpeed());
                    	fc_wind.put("deg", cwd.getWindInstance().getWindDegree());
                    }
                    
                    JSONObject fc_sys=new JSONObject();
                    if(fc.hasSysInstance()){
                    	fc_sys.put("pod", cwd.getSysInstance().getCountryCode());
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
            
            String sql="update curweather set main='"+main+"',weather='"+weather+"',clouds='"+cloud+"',wind='"+wind+"',sys='"+sys+"',future='"+future5+"' where dt='"+dt+"';";
            int res=stmt.executeUpdate(sql);
            if(res==0){
            	System.out.println("update wrong");
            	sql="insert into curweather values ('"+dt+"','"+main+"','"+weather+"','"+cloud+"','"+wind+"','"+sys+"','"+future5+"');";
            	res=stmt.executeUpdate(sql);
            	if(res==0){
            		System.out.println("insert wrong");
            	}
            }
		}
		stmt.close();
        conn.close();
    }

	public static void main(String[] args) throws ClassNotFoundException, IOException, JSONException, SQLException {
		// TODO Auto-generated method stub {
			// declaring object of "OpenWeatherMap" class
			refreshCur();
	}
	
}
