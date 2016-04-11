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
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="UI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="UI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="UI/demo/demo.css">
    <script type="text/javascript" src="UI/jquery.min.js"></script>
    <script type="text/javascript" src="UI/jquery.easyui.min.js"></script>
</head>
<body>
<h2>用户登录</h2>

<s:form action="userLogin" method="POST">
    <s:textfield name="username" label="用户名"></s:textfield>
    <s:password name="username" label="密码"></s:password>
    <s:submit value="登录"></s:submit>
</s:form>
</body>
</html>
