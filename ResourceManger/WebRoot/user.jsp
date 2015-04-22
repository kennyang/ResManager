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
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="userlist.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="userOpt!register.action" method="post">
                    <table class="insert-tab" width="75%">
                        <tbody>
                           <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" name="username" size="50" type="text">
                                	<font color="red"><s:property value="errors.username[0]"/></font>
                                </td>

                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>密码：</th>
                                <td>
                                    <input class="common-text required" name="password" size="50" type="password">
                                	<font color="red"><s:property value="errors.password[0]"/></font>                    
                                </td>
                             
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>确认密码：</th>
                                <td>
                                    <input class="common-text required" name="repassword" size="50" type="password">
                                	<font color="red"><s:property value="errors.repassword[0]"/></font>                                 
                                </td>
                            
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>真实姓名：</th>
                                <td>
                                    <input class="common-text required" name="chinesename" size="50" type="text">   
                                	<font color="red"><s:property value="errors.chinesename[0]"/></font>                              
                                </td>
                            
                            </tr>
                            <tr>
                                <th>手机号码：</th>
                                <td>
                                    <input class="common-text" name="phonenumber" size="50" type="text">
                                	<font color="red"><s:property value="errors.phonenumber[0]"/></font>                                    
                                </td>
                            </tr>
                            <tr>
                                <th>电子邮件：</th>
                                <td>
                                    <input class="common-text" name="email" size="50" type="text">
                                	<font color="red"><s:property value="errors.email[0]"/></font>                                    
                                </td>
                            </tr>
                      <!--  
                            <tr>
                                <th>是否在职：</th>
                                <td>
                                    <input type="radio" name="isworker" value="在职"  />在职
                                    <input type="radio" name="isworker" value="离职" />离职
                                </td>
                            </tr>                          
                     -->       
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