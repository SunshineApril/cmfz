<%--
  Created by IntelliJ IDEA.
  User: GTX
  Date: 2018.07.05
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <script type="application/javascript">
            $(function() {
                $('#tt2').datagrid({
                    title:'DataGrid - DetailView',
                    //width:100,
                    //height:50,
                    remoteSort:false,
                    singleSelect:true,
                    nowrap:false,
                    fitColumns:true,
                    url:'${pageContext.request.contextPath}/mgr/pic',
                    columns:[[
                        {field:'pictureId',title:'标识编号',width:80},
                        {field:'picturePath',title:'文件名',width:100,sortable:true},
                        {field:'pictureDate',title:'轮播图创建时间',width:80,align:'right',sortable:true},
                        {field:'pictureDescription',title:'描述信息',width:80,align:'right',sortable:true},
                        {field:'status',title:'轮播图状态',width:60,align:'center'}
                    ]],
                    view: detailview,
                    pagination:true,
                    pagination : true,
                    singleSelect : true,
                    pageSize : 5,
                    pageList : [ 5, 10, 15, 20 ],
                    // toolbar: [{
                    //     iconCls: 'icon-edit',
                    //     handler: function(){alert('编辑按钮')}
                    // },'-',{
                    //     iconCls: 'icon-help',
                    //     handler: function(){alert('帮助按钮')}
                    // }],
                    toolbar:"#tb",
                    detailFormatter: function(rowIndex, rowData){
                        return '<table><tr>' +
                            '<td rowspan=2 style="border:0"><img src="images/' + rowData.itemid + '.png" style="height:50px;"></td>' +
                            // '<td style="border:0">' +
                            // '<p>Attribute: ' + rowData. + '</p>' +
                            // '<p>Status: ' + rowData.status + '</p>' +
                            // '</td>' +
                            '</tr></table>';
                    }
                });
            });
    </script>

<table id="tt2">
    <%--<td><h1>轮播</h1></td>--%>
</table>
<div id="tb" style="display: none">
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-edit',plain:true,text:'修改',onClick: function(){
				var rowData = $('#dg').datagrid('getSelected');
				console.log(rowData);
				$('#form').dialog({
					    title:'icon-help',
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
					    title:'新增轮播图',
					    width:600,
					    height:300,
					    href: '${pageContext.request.contextPath}/form.jsp',
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
</div>

