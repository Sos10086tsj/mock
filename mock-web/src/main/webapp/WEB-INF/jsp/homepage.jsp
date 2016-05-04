<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/jsp/base/baselib.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行自助模拟系统</title>
</head>
<body>
	<!-- 顶部信息栏 -->
	<div id="js_global_north" class="x-hide-display">
    </div>
	<!-- 左边菜单栏 -->
	<div id="js_global_west" class="x-hide-display">  
    </div>
    <div id="js_global_center" class="x-hide-display">
    </div>
    
    <div id="js_global_homepage_description" class="x-hide-display">
    	<p>欢迎使用银行自助模拟系统。</p>
    	<p>本系统目前处理测试阶段。</p>
    </div>
	
	<div id="js_global_east" class="x-hide-display">
        <p>暂时不开启</p>
    </div>
	
    <div id="js_global_south" class="x-hide-display">
        <p>银行自助模拟系统 @Copyright 2016</p>
    </div>
</body>
<script type="text/javascript" src="${ctx }/resources/js/index/homepageItem.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/index/homepage.js"></script>
</html>