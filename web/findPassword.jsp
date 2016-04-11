<%--
  Created by IntelliJ IDEA.
  User: Uther
  Date: 2016/4/10
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>找回密码</title>
    <link rel="stylesheet" type="text/css" href="UI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="UI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="UI/demo/demo.css">
    <script type="text/javascript" src="UI/jquery.min.js"></script>
    <script type="text/javascript" src="UI/jquery.easyui.min.js"></script>
</head>
<body>
<h2>找回密码</h2>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="找回密码" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post" action="userLogin">
            <table cellpadding="5">
                <tr>
                    <td>Username:</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="username" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="login()">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
        </div>

    </div>
</div>
<style scoped="scoped">
    .textbox{
        height:20px;
        margin:0;
        padding:0 2px;
        box-sizing:content-box;
    }
</style>
<script>

    function login(){
        $('#ff').form('submit',{
            url:"findPassword",
            onSubmit: function(){
                return $(this).form('validate');
            },
            success:function (data) {
                var data = eval('(' + data + ')');
                if (data.success=="true"){
                    alert(data.message);
                    //跳转页面
                    window.location.href="index.jsp";
                }else{
                    alert(data.message);
                }
            }
        })
    }
    function clearForm(){
        $('#ff').form('clear');
    }

</script>
</body>
</html>
