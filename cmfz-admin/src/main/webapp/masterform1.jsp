<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	
	// $.extend($.fn.validatebox.defaults.rules, {
	//     trueLength: {
	//         validator: function(value){
	//             return (value.length == 11 || value.length == 8);
	//         },
	//         message: "请输入正确的手机号码"
	//     }
	// });


    $(function() {
        $("#user").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输入文件名",
        });


        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right'
        })

        $("#sub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#ff4").form("submit",{
                    //?
                    url : 'http://localhost:8484/cmfz-admin/master/updateMas',
                    onSubmit : function() {
                        console.log("提交前执行");
                        //验证
                        return $("#ff4").form("validate");
                    },
                    success : function(data) {
                        if(data==1){
                            $.messager.alert("提示","添加成功,请刷新页面！");

                        } else {
                            $.messager.alert("提示","添加失败！");
                        }
                        $("form").dialog({
                            closed:true,
                        });
                        // $('#tt2').datagrid({});
                    }
                });
            },
        });

        $("#cal").linkbutton({
            text : "取消",
            onClick : function() {
                closed:true
            },
        });
    });
</script>


<form id="ff4" method="post">
	<input id="id"  name="masterId" type="hidden">
	<table>


		<tr>
			<td>大师简介：</td>
			<td><input id="user" name="masterSummary"></td>
		</tr>


		<tr>
			<td><a id="sub"></a></td>
			<td><a id="cal"></a></td>
		</tr>



	</table>

</form>

