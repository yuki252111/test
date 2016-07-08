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
    $("#signinForm").submit(function(e){
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
        var fdata={
        	action:"login",
        	username:userValue,
        	password:passwordValue
        };
        $("#signinBtn").text("登录中...");
        request_data(fdata).then(function(jsonData){
        	console.log(jsonData);
        	if(jsonData.result=="ok"){
        		$.cookie("username",userValue);
        		alert("登录成功");
        		setTimeout(function(){
        			window.location="userInfo.html";
        		},500);
        	}
        	else{
        		$("#signinBtn").text("登录");
        		alert("登录失败:"+jsonData.reason);
        	}
        });
    })
});