package com.ibm.crl.util;

public class User {
	private int id;
    private String username;
    private String tel;
    private String contact;
    private String department1;
    private String department2;
    private String station;
    private String job;
    private String address;
    private String manager;
    private String date;
    private int exist;
    public void setId(int i)
    {
    	id = i;
    }
    public void setUsername(String name)
    {
    	username = name;
    }
    public void setTel(String t)
    {
    	tel = t;
    }
    public void setContact(String c)
    {
    	contact = c;
    }
    public void setDepartment1(String d)
    {
    	department1 = d;
    }
    public void setDepartment2(String d)
    {
    	department2 = d;
    }
    public void setStation(String s)
    {
    	station = s;
    }
    public void setJob(String j)
    {
    	job = j;
    }
    public void setAddress(String a)
    {
    	address = a;
    }
    public void setDate(String d)
    {
    	date = d;
    }
    public void setManager(String m)
    {
    	manager = m;
    }
    public void setExist(int i)
    {
    	exist = i;
    }
    public int getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getTel()
    {
        return tel;
    }
    
    public String getContact()
    {
        return contact;
    }
    
    public String getDepartment1()
    {
        return department1;
    }
    
    public String getDepartment2()
    {
        return department2;
    }
    
    public String getStation()
    {
        return station;
    }
    
    public String getJob()
    {
        return job;
    }
    
    public String getManager()
    {
        return manager;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public int getExist()
    {
        return exist;
    }
}
