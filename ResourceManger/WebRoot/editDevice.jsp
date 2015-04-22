<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>QA资源管理</title>
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
                <li><a href="#" target="_blank">网站首页</a></li>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="devicelist.jsp">设备管理</a><span class="crumb-step">&gt;</span><span>编辑设备</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="deviceOpt!update.action" method="post">
                    <table class="insert-tab" width="80%">
                        <tbody><tr>
                                <th><i class="require-red">*</i>设备名称：</th>
                                <td>
                                	<input type="hidden" name="Id" value=<%=request.getAttribute("Id") %>>
                                    <input class="common-text required"  name="devicename" value ='<%=request.getAttribute("devicename") %>' size="50" type="text">
                                    <font color="red"><s:property value="errors.devicename[0]"/></font>   
                                </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>所有者：</th>
                                <td>
                                    <input class="common-text required" name="ower" value ='<%=request.getAttribute("ower") %>' size="50" type="text">
                                    <font color="red"><s:property value="errors.ower[0]"/></font> 
                                </td>
                            </tr>
                            <tr>
                            <tr>
                                <th><i class="require-red">*</i>使用者：</th>
                                <td>
                                    <input class="common-text required" name="user" size="50" value ='<%=request.getAttribute("user") %>' type="text">
                                    <font color="red"><s:property value="errors.user[0]"/></font> 
                                </td>
                            </tr>
                            <tr>                            
                                <th>备注：</th>
                                <td><textarea name="content" class="common-textarea" cols="30" style="width: 98%;" rows="10"><%=request.getAttribute("content") %> </textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>