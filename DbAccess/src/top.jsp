<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <p>IDとPASSを入力してください。  </p>
  <form action="login" method="post">
    ID <input type="text" name="id" value="${fn:escapeXml(param.id)}"><br>
    PASS <input type="password" name="pass" value="${fn:escapeXml(param.pass)}"><br>
    <button type="submit">クエリ送信</button>
  </form>
</body>
</html>