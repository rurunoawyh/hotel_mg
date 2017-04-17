<%--
  Created by IntelliJ IDEA.
  User: wb-wyh270612
  Date: 2017/4/17
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${pageContext.request.servletPath}</h1>
<h1><%= request.getServletPath() %></h1>
</body>
</html>
