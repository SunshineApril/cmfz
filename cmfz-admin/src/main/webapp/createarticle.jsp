<%--
  Created by IntelliJ IDEA.
  User: GTX
  Date: 2018.07.08
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor demo</title>
</head>
<body>
<form id="form7" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td width="100px">文章标题</td>
            <td><input id="user" name="des"></td>
        </tr>
        <tr>
            <td>状态</td>
            <td> <input class="easyui-switchbutton" name="status" data-options="onText:'上架',offText:'未上架'"></td>
        </tr>
        <tr>
            <td width="100px">文章作者</td>
            <td><input id="cc" class="easyui-combobox" name="dept"
                       data-options="valueField:'masterId',textField:'masterName',url:'${pageContext.request.contextPath}/master/findMas'"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="editor">
                    <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
                </div>

            </td>
        </tr>
        <tr>
            <td> <a id="btn" href="#">easyui</a></td>
            <td><a id="btn1" href="#">easyui</a></td>
        </tr>



    </table>
</form>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()
    $(function () {
        $("#user").textbox({
            required: true,
            validateOnCreate: false,
            validateOnBlur: true,
            prompt: "请您输入文章的标题",
        });

        $('#btn').linkbutton({
            text: '创建文章',
            onClick: function () {
               // console.log($("#user").val());
                //console.log($("#cc").val())
                //window.location.href = "${pageContext.request.contextPath}/article/insertar?context="+(editor).txt.html();

                $('#form7').form('submit', {
                        url:"${pageContext.request.contextPath}/article/insertar",
                    onSubmit: function(param){
                    param.p1 = (editor).txt.html();
                }
            });



            },
        });
        $('#btn1').linkbutton({
            text: '重置内容',
            onClick: function () {
                $('#form7').form('reset');
               //括号内有东西是赋值没有事获取
                //(editor).txt.clear
                (editor).txt.html("");
            },
        });
    });
</script>

</body>
</html>