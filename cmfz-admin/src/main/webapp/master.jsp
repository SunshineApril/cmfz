<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    $(function() {
        $("#dg").datagrid({
            url : 'http://localhost:8484/cmfz-admin/master/getMas',
            columns : [ [ {
                field : "masterId",
                title : "上师简介"
            }, {
                field : "masterName",
                title : "上师名称"
            }, {
                field : "masterPhoto",
                title : "上师照片"
            },  {
                field : "masterSummary",
                title : "简介"
            } ] ],
            fitColumns : true,
            striped : true,
            pagination : true,
            singleSelect : true,
            pageSize : 5,
            pageList : [ 5, 10, 15, 20 ],
            toolbar : "#tb",
        });

    });
    function qq(value, name) {
        /*$("#dg").datagrid("load", {
            name:name,
            value:value
        });  */

        console.log(value);
        $("#dg").datagrid({
            url : 'http://localhost:8484/cmfz-admin/master/selectByOther',
            queryParams:{
                value:value,
                name:name
            },
            columns : [ [ {
                field : "masterId",
                title : "上师编号"
            }, {
                field : "masterName",
                title : "上师名称"
            }, {
                field : "masterPhoto",
                title : "照片名称"
            },   {
                field : "masterSummary",
                title : "简介"
            } ] ],
            fitColumns : true,
            striped : true,
            pagination : true,
            singleSelect : true,
            pageSize : 5,
            pageList : [ 5, 10, 15, 20 ],
            toolbar : "#tb",
        });
    }
</script>
<table id="dg"></table>
<form id="form"></form>
<div id="tb" style="display: none">
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-edit',plain:true,text:'修改',onClick: function(){
				var rowData = $('#dg').datagrid('getSelected');
				console.log(rowData);
				$('#form').dialog({
					    title:'修改',
					    width:600,
					    height:300,
					    href: '${pageContext.request.contextPath}/form1.jsp',
					    onLoad:function(){
							$('#ff').form('load',rowData); //在加载表单时将行数据加载到表单元素中
						}
					});

				}"></a>
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'新增',onClick: function(){
					$('#form').dialog({
					    title:'注册',
					    width:600,
					    height:300,
					    href: '${pageContext.request.contextPath}/masterform.jsp',
					    modal: true
					});
				}"></a>
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true,text:'删除',onClick: function(){
				var rowData = $('#dg').datagrid('getSelected');
				var result = '';
				$.ajax({
	                type : 'post',
	                async : false,
	                url : '${pageContext.request.contextPath}/emps/deleteEmail',
	                data : {
	                    'empid' : rowData.emp_id
	                },
	                success : function(data) {
	                    result = data;
	                }
	            });
				 if (result == 1 ) {
				 	$.messager.alert('提示','删除成功,请刷新页面！');
				} else {
					$.messager.alert('提示','删除失败！');
				}

				}"></a>
    <input id="ss" class="easyui-searchbox" style="width:300px"
           data-options="searcher:qq,prompt:'Please Input Value',menu:'#mm'"></input>
    <div id="mm">
        <div data-options="name:'master_name',iconCls:'icon-ok'">姓名</div>
        <div data-options="name:'address',iconCls:'icon-ok'">地址</div>
        <div data-options="name:'sex',iconCls:'icon-ok'">性别</div>
    </div>
</div>