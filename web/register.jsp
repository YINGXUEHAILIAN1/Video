<%--
  Created by IntelliJ IDEA.
  User: Uther
  Date: 2016/4/10
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="UI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="UI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="UI/demo/demo.css">
    <script type="text/javascript" src="UI/jquery.min.js"></script>
    <script type="text/javascript" src="UI/jquery.easyui.min.js"></script>
</head>
<body>
<h2>注册用户</h2>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="注册用户" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post" action="saveUser">
            <table cellpadding="5">
                <tr>
                    <td>Name:</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="username" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input class="easyui-validatebox textbox" type="password" name="password" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
                </tr>
                <tr>
                    <td>Birthday:</td>
                    <td><input class="easyui-datebox" name="birthday"/></td>
                </tr>
                <tr>
                    <td>注册类别:</td>
                    <td>
                        <select class="easyui-combobox" name="type">
                            <option value="normal">普通用户</option>
                            <option value="artist">媒体人</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
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
    function submitForm(){
        $('#ff').form('submit',{
            url: "saveUser",
            dataType: "json",
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){

            }
        });
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>

</body>
</html>
