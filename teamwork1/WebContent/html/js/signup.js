function request_data(parameters)
{
    var url = "";
    //url = "";

        url = "http://localhost:8080/teamwork1/UserServlet";

        return new Promise ( function (resolve, reject) {
            $.post(url, { data: JSON.stringify(parameters) }, null, "json").done( function (data, textStatus, jqXHR) {
            	console.log("REMOTE RESPONSE: " + JSON.stringify(data));
                resolve(data);
            }).fail( function (xhr, textStatus, errorThrown) {
                reject("post to " + url + " failed: " + textStatus + ", " + errorThrown);
            });
        });
}


$(document).ready(function()
  {
    $("#username").blur(function()
    	{
    	var userValue=$("#username").val();
        var userPattern=new RegExp("^[A-Za-z0-9]+$");
        var isValid=userPattern.test(userValue);
        if(!isValid) {
        	alert("*不合法的用户名");
            return false;
        }
        return true;
    });
    $("#password").blur(function(){
    	var passwordValue=$("#password").val();
        var passwordPattern=new RegExp("^[0-9]+$");
        var isValid=passwordPattern.test(passwordValue);
        if(!isValid||passwordValue.length!=6) {
        	alert("*不合法的密码");
            return false;
        }
        return true;
    });
    $("#tel").blur(function(){
    	var phoneValue=$("#tel").val();
        var phonePattern=new RegExp("^[0-9]+$");
        var isValid=phonePattern.test(phoneValue);
        if(!isValid||phoneValue.length!=11) {
        	alert("*不合法的电话号码");
            return false;
        }
        return true;
    });
    $("#signupForm").submit(function(e){
    	e.preventDefault();
    	var userValue=$("#username").val();
        var userPattern=new RegExp("^[A-Za-z0-9]+$");
        var isValid=userPattern.test(userValue);
        if(!isValid) {
        	alert("*不合法的用户名");
            return false;
        }
        var passwordValue=$("#password").val();
        var passwordPattern=new RegExp("^[0-9]+$");
            isValid=passwordPattern.test(passwordValue);
        if(!isValid||passwordValue.length!=6) {
        	alert("*不合法的密码");
            return false;
        }
        var phoneValue=$("#tel").val();
        var phonePattern=new RegExp("^[0-9]+$");
        	isValid=phonePattern.test(phoneValue);
        if(!isValid||phoneValue.length!=11) {
        	alert("*不合法的电话号码");
            return false;
        }
        var contactValue=$("#contact").val();
        var department1Value=$("#department1").val();
        var department2Value=$("#department2").val();
        var stationValue=$("#station").val();
        var jobValue=$("#job").val();
        var addressValue=$("#address").val();
        var managerValue=$("#manager").val();
        var dateValue=$("#date").val();
        var fdata={
        	action:"register",
        	username:userValue,
        	password:passwordValue,
        	tel:phoneValue,
        	contact:contactValue,
        	department1:department1Value,
        	department2:department2Value,
        	station:stationValue,
        	job:jobValue,
        	address:addressValue,
        	manager:managerValue,
        	date:dateValue
        };
        //alert("注册......");
        $("#signupBtn").text("注册中...");
        request_data(fdata).then(function(jsonData){
        	if(jsonData.result=="ok"){
        		$.cookie("username",userValue);
        		alert("注册成功");
        		setTimeout(function(){
        			window.location="userInfo.html";
        		},500);
        	}
        	else{
        		$("#signupBtn").text("注册");
        		alert("注册失败:"+jsonData.reason);
        	}
        });
    })
});