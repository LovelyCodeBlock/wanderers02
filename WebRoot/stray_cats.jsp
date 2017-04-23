<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="#">
    
    <title>pets</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="bootstrap3/style.css"/>
    <link rel='stylesheet' id='bootstrap-css-css'  href='bootstrap3/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='responsive-css-css'  href='bootstrap3/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='pretty-photo-css-css'  href='bootstrap3/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
    <link rel='stylesheet' id='main-css-css'  href='bootstrap3/css/main5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='green-skin-css'  href='bootstrap3/bootstrap3/css/green-skin5152.css?ver=1.0' type='text/css' media='all' />
    <link rel='stylesheet' id='custom-css-css'  href='bootstrap3/css/custom5152.html?ver=1.0' type='text/css' media='all' />
	
	<script type="text/javascript">
		function show(kind,name,sex,hobby,foundAddress){
			var n = name;
			document.getElementById("name").innerHTML = "<h3 class='title' >品种："+kind+"</h3><p class='intro' >"
			+"名字："+n+"</p>"
			+"<p class='intro' >性别："+sex+"</p><p class='intro' >爱好："+hobby+"</p><button class='btn btn-link'>领养</button>";
			
		}
	</script>
  </head>
  
  <body>
  	<!-- top -->

	<s:debug></s:debug>
	<br>
  	<%@ include file="top.jsp" %>
  	<%@ include file="middle.jsp" %>
  	
  	
  	
  	<!-- start of the page content -->
     <div class="page-container">
     	<div class="container">
        	<div class="row">
            	<!-- start of page content -->
              	<div class="span8 main-listing">
              	
              	<s:iterator  value ="strayCatsList" status ="status">
	   	 			 <div class="span3">
			  			 <img src="images/cat01.jpg"  height="192.844" width="270" />
						 <h3>品种：<s:property value="strayCatsList.kind" ></s:property></h3>
						 <h4>姓名：<s:property value="strayCatsList.name"></s:property></h4>
						 <button class="btn btn-info" onclick="show('${kind}','${name }','${sex }','${hobby }','${foundAddress }')">详情</button>
					</div>
	 			</s:iterator>
              		
              		<div class="span6" style="margin-top:20px">
					<div id="pagination">
						<a href="stray_cats?pageNo=${pageNo-1}" class="btn">上一页</a>
                      	<a href="stray_cats?pageNo=1" class="btn active">1</a>
                        <a href="stray_cats?pageNo=2" class="btn">2</a>
                        <a href="stray_cats?pageNo=3" class="btn">3</a>
                        <a href="stray_cats?pageNo=${pageNo+1}" class="btn">下一页 »</a>
                   </div>
                   </div>
			</div>
				<aside class="span4 page-sidebar">
					<section class="wiget">
						<div class="widget" id="name">
							
						</div>
					</section>
					<section class="wiget">
						<div class="widget">
							<h3 class="title">热门交流帖</h3>
							<ul class="articles">
								<li class="article-entry standard">
									<h4><a>帖子标题</a></h4>
									<span class="article-meta">
										帖子时间&nbsp;&nbsp;<a>发布者</a>
									</span>
									<span class="like-count">6</span>
								</li>
								<li class="article-entry standard">
									<h4><a>帖子标题</a></h4>
									<span class="article-meta">
										帖子时间&nbsp;&nbsp;<a>发布者</a>
									</span>
									<span class="like-count">6</span>
								</li>
							</ul>
						</div>
					</section>
				</aside>
			
			</div>
		</div>
	
	
	</div>
     <!-- end of page content -->
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
