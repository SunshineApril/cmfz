<%--
  Created by IntelliJ IDEA.
  User: GTX
  Date: 2018.07.06
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    // $.extend($.fn.validatebox.defaults.rules, {
    //     equals : {
    //         validator : function(value, param) {
    //             return value == $(param[0]).val();
    //         },
    //         message : "两次输入的密码 不一致"
    //     }
    // });

    <%--$.extend($.fn.validatebox.defaults.rules, {--%>
    <%--checkEmail : {--%>
    <%--validator : function(value) {--%>
    <%--var result = "";--%>
    <%--$.ajax({--%>
    <%--type : "post",--%>
    <%--async : false,--%>
    <%--url : "${pageContext.request.contextPath}/emps/checkEmail",--%>
    <%--data : {--%>
    <%--"email" : value--%>
    <%--},--%>
    <%--success : function(data) {--%>
    <%--result = data;--%>
    <%--}--%>
    <%--});--%>
    <%--if (result == "success") {--%>
    <%--return true;--%>
    <%--} else {--%>
    <%--return false;--%>
    <%--}--%>
    <%--},--%>
    <%--message : "您的邮箱已经存在"--%>
    <%--}--%>
    <%--});--%>




    $(function() {
        $("#user").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输入大师名",
        });
        $("#user1").textbox({
            required : true,
            validateOnCreate : false,
            validateOnBlur : true,
            prompt : "请输入大师介绍",
        });

        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right'
        })

        $("#sub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#form1").form("submit",{
                    //?
                    url : 'http://localhost:8484/cmfz-admin/master/addMas',
                    onSubmit : function() {
                        console.log("提交前执行");
                        //验证
                        return $("#form1").form("validate");
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


<form id="form1" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>大师名：</td>
            <td><input id="user" name="des"></td>
        </tr>

        <tr>
            <td>大师简介：</td>
            <td><input id="user1" name="des1"></td>
        </tr>
        <tr>
            <td>大师照片：</td>
            <td><input id="fb" type="text" name="myFile" style="width:300px"></td>
        </tr>


        <tr>
            <td><a id="sub"></a></td>
            <td><a id="cal"></a></td>
        </tr>



    </table>

</form>