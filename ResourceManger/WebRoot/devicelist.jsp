<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
 <meta charset="uft-8">
    <title>QA资源管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    
    
<script type="text/javascript">

	var checkedIds;
	        //将所有的checkbox全部选中
        function checkedAll() {
            //var objs = document.getElementsByTagName("input");
            checkedIds="";
            var objs = document.getElementsByName("ids");
            if(document.getElementsByName("allids")[0].checked)
            	{
            		for (var i = 0; i < objs.length; i++)
            		{
            			var obj = objs[i];
            			obj.checked = 1;
            			checkedIds += obj.value+",";
            		}
            	}
            else
            	{
           			for (var i = 0; i < objs.length; i++)
        			{
	        			var obj = objs[i];
	        			obj.checked = 0;
	        			checkedIds="";
        			}	
            	}
            //alert(checkedIds);
        }

        //取得选中的checkbox的值
        function getCheckboxValues() {
            //var objs = document.getElementsByTagName("input");
            var objs = document.getElementsByName("ids");
            checkedIds = '';
            for (var i = 0; i < objs.length; i++) {
                var obj = objs[i];
                if (obj.type == "checkbox" && obj.checked == true) { 	
                	checkedIds += obj.value + ",";
                	//alert(checkedIds);
                }
            }
        }


function checkInvalidate(){
    var chk=document.getElementsByName("ids");
    for(var i=0;i<chk.length;i++){
	    if(chk[i].type=="checkbox"){
		    if(chk[i].checked==true){
		    	//document.myform.submit();
		    	post('batchdelete.action', {ids : checkedIds});
		    	return;
		    }
	    }
    }
    alert("请选择需要删除的设备");
}



        function post(URL, PARAMS) {      
            var temp = document.createElement("form");      
            temp.action = URL;      
            temp.method = "post";      
            temp.style.display = "none";      
            for (var x in PARAMS) {      
                var opt = document.createElement("textarea");      
                opt.name = x;      
                opt.value = PARAMS[x];      
                // alert(opt.name)      
                temp.appendChild(opt);      
            }      
            document.body.appendChild(temp);      
            temp.submit();      
            return temp;      
        }  
        
        function update(obj){
        	//var node = obj.parentNode.parentNode;
        	//alert(node.childNodes[1].innerHTML);
        	//alert(obj.id);
        	//window.location.href="deviceOpt!update.action?Id="+obj.id;
        	post('deviceOpt!get.action', {Id :obj.id,devicename:obj.devicename,ower:obj.ower,user:obj.user,content:obj.content});  
        }
        
        function view(obj)
        {
        	//alert(obj.id);
        	post('deviceOpt!view.action', {Id :obj.id,devicename:obj.devicename,ower:obj.ower,user:obj.user,content:obj.content});  
        }
       
        
        function deleteDevice(obj)
        {
        	//alert(obj.id);
        	post('deviceOpt!delete.action', {Id :obj.id,devicename:obj.devicename,ower:obj.ower,user:obj.user,content:obj.content});  
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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">资源管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="devicequery.action" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="70">设备名称:</th>
                            <td><input class="common-text" placeholder="设备名称" name="devicename" type="text"></td>
                            <th width="70">所有者:</th>
                            <td><input class="common-text" placeholder="所有者" name="ower" type="text"></td>
                            <td>
                            	<input class="btn btn-primary btn2" name="sub" value="查询" type="submit">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="device.jsp"><i class="icon-font"></i>新增设备</a>
                        <a id="batchDel" href="javascript:checkInvalidate();"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="allids" type="checkbox" onclick="checkedAll()"></th>
                            <th width="5%" style="text-align:center;">编号</th>
                            <th width=40% style="text-align:center;">设备名称</th>
                            <th width=10%>所有者</th>
                            <th width=10%>使用者</th>
                            <th style="text-align:center;">最近修改时间</th>
                            <th style="text-align:center;">操作</th>
                        </tr>
                        <s:iterator value="devicelist" id="dev" status="ss">
                        <tr>
                            <td class="tc"><input name="ids" value=<s:property value="#dev.Id"/> type="checkbox"  onclick="getCheckboxValues()"></td>
                            <td> 
                               <input class="common-input sort-input" id="Id" value=<s:property value="#dev.Id"/> type="text">
                            </td>
                            <td id="devicename"><a target="_blank" style="cursor:pointer"  id='<s:property value="#dev.Id"/>' onclick="view(this)"><s:property value="#dev.devicename"/></a>
                            </td>
                            <td id="ower"><s:property value="#dev.ower"/></td>
                            <td id="user"><s:property value="#dev.user"/></td>
                            <td style="text-align:center;"><s:property value="#dev.modifytime"/></td>
                            <td>
                                <a class="link-update" id='<s:property value="#dev.Id"/>' 
                               						   devicename='<s:property value="#dev.devicename"/>'
                               						   ower='<s:property value="#dev.ower"/>'
                               						   user='<s:property value="#dev.user"/>'
                               						   content='<s:property value="#dev.content"/>'
                               	style="cursor:pointer" onclick="update(this)">修改</a>
                                <a class="link-del" style="cursor:pointer" id='<s:property value="#dev.Id"/>' onclick="deleteDevice(this)">删除</a>
                            </td>
                        </tr>
                        </s:iterator>
                    </table>
                    <div class="list-page"> 
                        <tr>
							<td align="center">
								<s:if test="#request.page.hasPrePage">
									<a href="showsearchdevice.action?currentPage=1">首页</a>
									<a href="showsearchdevice.action?currentPage=${page.currentPage -1 }">上一页</a>
								</s:if>
								<s:else>
									首页
									上一页
								</s:else>
												
							    <s:if test="#request.page.hasNextPage">
									<a href="showsearchdevice.action?currentPage=${page.currentPage + 1 }">下一页</a>
									<a href="showsearchdevice.action?currentPage=${page.totalPage }">尾页</a>			
								</s:if>
								<s:else>
									下一页
									尾页
								</s:else>
							</td>
						</tr>                    
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>