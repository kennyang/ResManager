<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>QA资源管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    
    <script type="text/javascript">
    	window.onload=function()
    	{

    		oFtpUsername = document.getElementsByName("ftpusername")[0];
    		oFtpPassword = document.getElementsByName("ftppassword")[0];
    		if(oFtpUsername.value=="null"){
    			oFtpUsername.value="";
    		}
    		if(oFtpPassword.value=="null"){
    			oFtpPassword.value="";
    		}   		
    	}
    	
    </script>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="userlist.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>编辑用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="mydownload.action" method="post">
                    <table class="insert-tab" width="75%">
                        <tbody>
                           <tr>
                                <th><i class="require-red">*</i>文件别名：</th>
                                <td>
                               		 <input type="hidden" name="Id" value=<%=request.getAttribute("Id") %>>
                                    <input class="common-text required" name="alias" size="50" value ='<%=request.getAttribute("alias") %>' type="text" readonly="readonly">
                                </td>

                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>资源路径：</th>
                                <td>
                                    <input class="common-text required" name="path" size="50" value ='<%=request.getAttribute("path") %>' type="text" readonly="readonly">                   
                                </td>
                             
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>文件名：</th>
                                <td>
                                    <input class="common-text required" name="filename" size="50" value ='<%=request.getAttribute("filename") %>' type="text" readonly="readonly">                                
                                </td>
                            
                            </tr>

                            <tr>
                                <th>ftp用户名：</th>
                                <td>
                                    <input class="common-text" name="ftpusername"  size="50" type="text" value="<%=session.getAttribute("ftpusername") %>">
                                	<font color="red"><s:property value="errors.ftpusername[0]"/></font>                                    
                                </td>
                            </tr>
                            <tr>
                                <th>ftp密码：</th>
                                <td>
                                    <input class="common-text" name="ftppassword"  size="50" type="password" value="<%=session.getAttribute("ftppassword") %>">
                                	<font color="red"><s:property value="errors.ftppassword[0]"/></font>                                    
                                </td>
                            </tr>
                            <tr>
                                                  
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