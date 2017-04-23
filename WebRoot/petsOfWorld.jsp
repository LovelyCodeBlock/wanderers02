<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="# ">
  
    <title>世界${kind }谱</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel='stylesheet' id='bootstrap-css-css'  href='bootstrap3/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css'  href='bootstrap3/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css'  href='bootstrap3/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css'  href='bootstrap3/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css'  href='bootstrap3/css/custom5152.html?ver=1.0' type='text/css' media='all' />
	
  </head>
  
  <body style="background-image:url(images/bg.jpg)"> 
  
  	<s:debug></s:debug>
  	
  
  	 <!-- Start of Header -->
      <%@ include file="top.jsp" %>
      <!-- End of Header -->

      <!-- Start of Search Wrapper -->
     <%@ include file="middle.jsp"  %>
      <!-- End of Search Wrapper -->
      
	<div class="container-fluid" style="padding:5% 5% 0 5%">
	
		<s:iterator  value ="petList" status ="status">
	   	  <s:if test ="#status.modulus(4)==0"><%out.print("<div class='row-fluid'>"); %></s:if>
	   	  <div class="span3">
			    <img src=${photoAddress }  height="192.844" width="270" />
				<h3>品种：<s:property value="name" ></s:property></h3>
				 <h4>生活习性：<s:property value="habit"></s:property></h4>
				 <h4>爱好：<s:property value="hobby"></s:property></h4>
		</div>
		<s:if test="#status.modulus(4)==0"><%out.print("</div>"); %></s:if>	  	  
	 	</s:iterator>
	 </div>
	
	<div class="pagination pagination-centered" >
  		<ul >
	  		<li><a href="petsOfWorld?kind=${kind }&pageNo=${ pageNo-1 }" class="btn" style="color:#2396f0">上一页</a></li>
		   	<li><a href="petsOfWorld?kind=${kind }&pageNo=1" class="btn active" style="color:#2396f0">1</a></li>
			<li><a href="petsOfWorld?kind=${kind }&pageNo=2" class="btn" style="color:#2396f0">2</a></li>
			 <li><a href="petsOfWorld?kind=${kind }&pageNo=3" class="btn" style="color:#2396f0">3</a></li>
		    <li><a href="petsOfWorld?kind=${kind }&pageNo=4" class="btn" style="color:#2396f0">4</a></li>
		    <li><a href="petsOfWorld?kind=${kind }&pageNo=5" class="btn" style="color:#2396f0">5</a></li>
		    <li><a href="petsOfWorld?kind=${kind }&pageNo=${ pageNo+1 } " class="btn" style="color:#2396f0">下一页</a></li>
		 </ul>
	</div>
	

      <a href="#top" id="scroll-top"></a>
	<%@ include file="foot.jsp" %>
      <!-- script -->
        <script type='text/javascript' src='bootstrap3/js/jquery-1.8.3.min.js'></script>
        <script type='text/javascript' src='bootstrap3/js/jquery.easing.1.3.js'></script>
        <script type='text/javascript' src='bootstrap3/js/prettyphoto/jquery.prettyPhoto.js'></script>
        <script type='text/javascript' src='bootstrap3/js/jflickrfeed.js'></script>
		<script type='text/javascript' src='bootstrap3/js/jquery.liveSearch.js'></script>
		<script type='text/javascript' src='bootstrap3/js/jquery.form.js'></script>
		<script type='text/javascript' src='bootstrap3/js/jquery.validate.min.js'></script>
		<script type='text/javascript' src='bootstrap3/js/custom.js'></script>
  </body>
</html>
