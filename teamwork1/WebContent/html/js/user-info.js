function request_data(parameters)
{
    var url = "";
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

function deleteUser(usr){
	request_data({
        action: "deleteuser",
        username:usr
    }).then( function (data) {
        if (data.result != "ok") {
            show_error("getcuisinelist error: " + data.reason);
            return;
        }
        window.location="userInfo.html";
    });
}

$(document).ready( function () {
	$("[href='signup.html']").click(function(){
		$.cookie("username",null);
	});
    var fdata={
        action:"userlist"
    };
    request_data(fdata).then(function(jsonData){
    	if(jsonData.result=="ok"){
    		var ulist=jsonData.data;
    		var tobj = $("#userTable").children("tbody");
    		tobj.empty();
    		if(ulist.length==0){
    			alert("暂无数据");
    		}
    		else{
    			ulist.forEach( function (ritem) {
    				tobj.append(
    		                $(document.createElement("tr"))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.username))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.tel))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.contact))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.department1))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.department2))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.station))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.job))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.address))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.manager))
    		                    .append($(document.createElement("td"))
    		                        .text(ritem.date))
    		                    .append($(document.createElement("td"))
    		                    		.append($(document.createElement("button"))
    		                    				.attr("type", "button")
    		                    				.addClass("btn btn-primary btn-lg")
    		                    				.text("删除")
    		                    				.click( function () {
    		                    					deleteUser(ritem.username);
    		                    				})))
    		                    .append($(document.createElement("td"))
    		                    		.append($(document.createElement("button"))
    		                    				.attr("type", "button")
    		                    				.addClass("btn btn-primary btn-lg")
    		                    				.text("修改")
    		                    				.click( function () {
    		                    					//load_cuisine_list(robj);
    		                    				})))
    		            );
    				
    	        });
    		}
    	}
    	else{
    		alert("查询失败:"+jsonData.reason);
    	}
    });
});
