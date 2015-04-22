<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>QA资源管理</title>
<!--     <script language="javascript">  
   		function reloadurl(){ window.location.href="userlist.jsp"; }  
 		 window.setTimeout("reloadurl();",2000);
    </script>  -->    
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首页</a></li>
                <li><a href="http://www.byosoft.com.cn/" target="_blank">百敖首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="login.jsp">管理员</a></li>
                <li><a href="userlist.jsp" onclick="alert('正在前往用户管理页面进行修改密码!')">修改密码</a></li>
                <li><a href="login.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="devicelist.jsp"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="devicelist.jsp"><i class="icon-font">&#xe008;</i>资源管理</a></li>
                        <li><a href="toollist.jsp"><i class="icon-font">&#xe008;</i>工具管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="userlist.jsp"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="userlist.jsp"><i class="icon-font">&#xe017;</i>用户管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
         <div class="crumb-wrap">
         <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span></span></div>
    </div>
		    <div style="text-align:center;margin-top:150px;color:#F00;margin-left: 250px">  
   	      			<tr height="100">
								<td align="center">
									<table width="500" border="0">
										<tr align="center" height="100">
											<td>${request.info }</td>
											<% 
												String url = (String)request.getAttribute("url");
												response.setHeader("Refresh","3;url=" + url);
											%>
										</tr>
										<tr align="center">
										<td>
											<input class="btn btn-primary btn6 mr10" onclick="history.go(-1)" value="返回" type="button">
										<td>
										</tr>
										<tr height="50" align="center">
											<td></td>
										</tr>
									</table>
								</td> 
   	</div> 
    </div>
    <!--/main-->
</div>
</body>
</html>