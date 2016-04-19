<%@ page contentType="text/html;charset=UTF-8" %>
<%
//获取异常类
Throwable ex = ExceptionUtil.getThrowable(request);
if (ex != null){
	LoggerFactory.getLogger("500.jsp").error(ex.getMessage(), ex);
}
%>
<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@page import="com.cherong.mock.common.base.util.ExceptionUtil"%>
<html>
<head>
	<title>系统错误</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
			<label>未知错误</label>
		</div>
</body>
</html>