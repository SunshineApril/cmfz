<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/echarts/china.js"></script>
<script type="text/javascript">
	function addTabs(menuName,menuUrl){
		var b=$("#tt").tabs("exists",menuName);
		console.log(menuUrl);
		if (b){
			$("#tt").tabs("select",menuName);
		} else {
			$("#tt").tabs("add",{
			    title:menuName,
                closable:true,
				href:"${pageContext.request.contextPath}"+menuUrl,
			});
		}
	}
    $(function () {
        $.ajax({
			url:"${pageContext.request.contextPath}/mgr/menu",
			dataType:"json",
			success:function (res) {
				console.log(res)
				//遍历响应集合
				//res遍历的集合 index当前遍历的集合 obj遍历的临时变量
				 $.each(res,function (index,obj) {
				 	console.log(obj);

					var content="";

					$.each(obj.childMenu,function (index1,obj1) {

					    content +="<p style=\"text-align: center\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'"+obj1.menoIcon+"',plain:true\" onclick=\"addTabs('"+obj1.menuName+"','"+obj1.menuUrl+"')\">"+obj1.menuName+"</a></p>"
                    })

					$("#aa").accordion("add",{
					    title:obj.menuName,
						iconCls:obj.menoIcon,
						content:content,
					})
                 });
            }
		});
        $('#aa').accordion({
            animate:false

        });
        // $.post("/mgr/menu",function(menuList){
        //     // $("#cities").empty().append("<option value='-1'>请选择</option>");
        //     //var data JSON.parse(menuList);
			// console.log(data);
        //     // for(var key in cityMap){
        //     //     $("#cities").append("<option value='"+key+"'>"+cityMap[key]+"</option>");
        //     // }
        // });
    });
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
			<%--<c:forEach items="${requestScope.menus}" var="menu">
				<div title="${menu.menuName}" data-options="iconCls:'${menu.menoIcon}'">
					<c:forEach items="${menu.childMenu}" var="child">
						<a class="easyui-linkbutton"
						   data-options="plain:true,iconCls:'${child.menoIcon}'" style="width: 100%;">${child.menuName}</a>
					</c:forEach>
				</div>
			</c:forEach>--%>
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>