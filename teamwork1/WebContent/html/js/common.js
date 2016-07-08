function make_popup_msgbox(obj)
{
    return obj.appendTo("body")
            .css("width", "400px")
            .css("position", "fixed")
            .css("left", "50%")
            .css("top", "50%")
            .css("transform", "translate(-50%, -50%)")
            .css("z-index", "100");
}

var login_timeout_flag = false;
function do_login_timeout()
{
    if (!login_timeout_flag) {
        make_popup_msgbox(create_alert(document.createElement("div"), "danger", "操作失败", "登录超时，请重新登录"));
        setTimeout( function () {
            window.location = "login.html";
        }, 1000);
        login_timeout_flag = true;
    }
}

function check_login()
{
    var sdata = get_session_data();
    if (!sdata) {
        do_login_timeout();
        return false;
    }
    return true;
}

function init_navbar()
{
    var usernavbar =
        '<nav class="navbar navbar-fixed-top">'
        +'  <div class="container">'
        +'    <div class="navbar-header">'
        +'      <span class="navbar-brand">欢迎使用外卖系统 - 用户版</span>'
        +'    </div>'
        +'    <div id="navbar"><!--'
        +'      <ul class="nav navbar-nav">'
        +'        <li><a href="#">Link</a></li>'
        +'      </ul>-->'
        +''
        +'      <ul class="nav navbar-nav navbar-right">'
        +'        <li><a href="user.html">点餐</a></li>'
        +'        <li><a href="user-orders.html">我的订单</a></li>'
        +'        <li><a href="user-info.html">个人信息</a></li>'
        +'        <li><a href="logout.html">退出</a></li>'
        +'      </ul>'
        +'    </div>'
        +'  </div>'
        +'</nav>';
    var restnavbar =
        '<nav class="navbar navbar-fixed-top">'
        +'  <div class="container">'
        +'    <div class="navbar-header">'
        +'      <span class="navbar-brand">欢迎使用外卖系统 - 餐厅版</span>'
        +'    </div>'
        +'    <div id="navbar"><!--'
        +'      <ul class="nav navbar-nav">'
        +'        <li><a href="#">Link</a></li>'
        +'      </ul>-->'
        +''
        +'      <ul class="nav navbar-nav navbar-right">'
        +'        <li><a href="rest.html">最近订单</a></li>'
        +'        <li><a href="rest-editmenu.html">编辑菜单</a></li>'
        +'        <li><a href="rest-statistics.html">查看统计</a></li>'
//        +'        <li><a href="userinfo.html">个人信息</a></li>'
        +'        <li><a href="logout.html">退出</a></li>'
        +'      </ul>'
        +'    </div>'
        +'  </div>'
        +'</nav>';
    var deliverernavbar =
        '<nav class="navbar navbar-fixed-top">'
        +'  <div class="container">'
        +'    <div class="navbar-header">'
        +'      <span class="navbar-brand">欢迎使用外卖系统 - 送餐员版</span>'
        +'    </div>'
        +'    <div id="navbar"><!--'
        +'      <ul class="nav navbar-nav">'
        +'        <li><a href="#">Link</a></li>'
        +'      </ul>-->'
        +''
        +'      <ul class="nav navbar-nav navbar-right">'
        +'        <li><a href="deliverer.html">最近订单</a></li>'
        +'        <li><a href="deliverer-statistics.html">查看统计</a></li>'
//        +'        <li><a href="userinfo.html">个人信息</a></li>'
        +'        <li><a href="logout.html">退出</a></li>'
        +'      </ul>'
        +'    </div>'
        +'  </div>'
        +'</nav>';

    var adminnavbar =
        '<nav class="navbar navbar-fixed-top">'
        +'  <div class="container">'
        +'    <div class="navbar-header">'
        +'      <span class="navbar-brand">欢迎使用外卖系统 - 管理员版</span>'
        +'    </div>'
        +'    <div id="navbar"><!--'
        +'      <ul class="nav navbar-nav">'
        +'        <li><a href="#">Link</a></li>'
        +'      </ul>-->'
        +''
        +'      <ul class="nav navbar-nav navbar-right">'
        +'        <li><a href="admin.html">编辑餐厅</a></li>'
        +'        <li><a href="admin-order-statistics.html">订单统计</a></li>'
        +'        <li><a href="admin-user-statistics.html">用户统计</a></li>'
        +'        <li><a href="admin-rest-statistics.html">餐厅统计</a></li>'
//        +'        <li><a href="userinfo.html">个人信息</a></li>'
        +'        <li><a href="logout.html">退出</a></li>'
        +'      </ul>'
        +'    </div>'
        +'  </div>'
        +'</nav>';

    var loginnavbar =
        '<nav class="navbar navbar-fixed-top">'
        +'  <div class="container">'
        +'    <div class="navbar-header">'
        +'      <span class="navbar-brand">欢迎使用外卖系统</span>'
        +'    </div>'
        +'    <div id="navbar"><!--'
        +'      <ul class="nav navbar-nav">'
        +'        <li><a href="#">Link</a></li>'
        +'      </ul>-->'
        +'      <ul class="nav navbar-nav navbar-right">'
        +'        <li><a href="login.html">登录</a></li>'
        +'        <li><a href="register.html">注册</a></li>'
        +'      </ul>'
        +'    </div>'
        +'  </div>'
        +'</nav>';  
    var userrole = "";
    var sdata = get_session_data();
    if (sdata) userrole = sdata.userrole;
    
    if (userrole == "user") {
        $("#navbarbox").html(usernavbar);
    } else if (userrole == "rest") {
        $("#navbarbox").html(restnavbar);
    } else if (userrole == "deliverer") {
        $("#navbarbox").html(deliverernavbar);
    } else if (userrole == "admin") {
        $("#navbarbox").html(adminnavbar);
    } else {
        $("#navbarbox").html(loginnavbar);
    }
}

function do_logout()
{
    remove_session_data().then( function () {
        window.location = "login.html";
    });
}

function get_session_data()
{
    var sdata = Cookies.getJSON("sessiondata");
    if (sdata && sdata.expires > new Date().getTime()) {
        // sdata is valid
        return sdata;
    }
    return undefined;
}

function remove_session_data()
{
    var sdata = get_session_data();
    Cookies.remove("sessiondata");
    return new Promise ( function (resolve, reject) {
        if (sdata) {
            request_data({
                action: "logout",
                userrole: sdata.userrole,
                rid: sdata.rid,
                uid: sdata.uid,
                id: sdata.id,
                delivererid: sdata.delivererid,
            }).then ( function () {
                resolve();
            }, function (reason) {
                reject("logout failed: " + reason);
            });
        } else {
            resolve();
        }
    });
}

function save_session_data(sdata)
{
    console.log("SAVE SESSION DATA: ", sdata);
    if (sdata.rememberme) {
        Cookies.set("sessiondata", sdata, { expires: sdata.expires });
    } else {
        Cookies.set("sessiondata", sdata);
    }
}

function show_error(str)
{
    console.log("error: " + str);
    if (!login_timeout_flag) {
        make_popup_msgbox(create_alert(document.createElement("div"), "danger", "错误", str + "\n请刷新页面后重试\n"));
    }
}
/*
    universal data requester
*/
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

/*
    title should be: success, info, warning, danger
*/
function create_alert(selector, type, title, content)
{
    return $(selector).empty().append(
        $(document.createElement("div"))
            .addClass("alert alert-" + type)
            .attr("role", "alert")
            .append($(document.createElement("div"))
                .css("display", "inline-block")
                .css("vertical-align", "top")
                .append($(document.createElement("strong"))
                    .text(title))
                .append($(document.createElement("span"))
                    .html("&nbsp;&nbsp;&nbsp;")))
            .append($(document.createElement("div"))
                .css("white-space", "pre-wrap")
                .css("display", "inline-block")
                .text(content))
    );
}



function ostat2str(stat)
{
    //   ->   制作中      ->      运送中    ->     已完成
    // 用户下单       餐厅选择配送员        用户确认
    switch (stat) {
        case "finished": return "已完成";
        case "pending": return "制作中";
        case "needconfirm": return "待确认";
        case "delivering": return "运送中";
        default: return "未知 (" + stat + ")";
    }
}

function is_user_confirmable(stat)
{
    return stat == "needconfirm"
}

function is_rest_confirmable(stat)
{
    return stat == "pending";
}

function is_deliverer_confirmable(stat)
{
	return stat == "delivering";
}