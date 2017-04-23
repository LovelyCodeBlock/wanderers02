<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>
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
	

  </head>
  
  <body>
  
  <br>我在这里，请你看到我。
  <s:debug></s:debug>
  <br>
  
  	<!-- top -->
  	<%@ include file="../top.jsp" %>
  	<%@ include file="../middle.jsp" %>
  	
  	
  	<!-- start of the page content -->
     <div class="page-container">
     	<div class="container">
        	<div class="row">
            	<!-- start of page content -->
              	<div class="span8 main-listing">
              		<s:iterator value="articleList" status="status">
              			<article class="format-standard type-post hentry clearfix">
	                         	<header class="clearfix">
	                            	<h3 class="post-title">
	                                	<a href="comment_BeautyArticle?id=${id }&mold=${mold}"><s:property value="title"></s:property></a>
	                                </h3>
              						<div class="post-meta clearfix">
	                                	<span class="date"><s:property value="time"></s:property></span>
	                                	<span class="category"><s:property value="publisher"></s:property></span>
	                                    <span class="comments"><a style="color:gray" href="comment_BeautyArticle?id=${id }&mold=${mold}"><s:property value="comments"></s:property>&nbsp;Comments</a></span>
	                                	<span class="like-count">66</span>
	                                 </div>
	                               <!-- end of post meta -->
	                            </header>
	                            <p><s:property value="summary"></s:property>......<a class="readmore-link" href="comment_BeautyArticle?id=${id }&mold=${mold }">Read more</a></p>
	                      </article>
              		
              	
              		</s:iterator>
              	
                        <div id="pagination">
                          	 	<a href="share_BeautyArticle" class="btn">首页</a>
                                <a href="share_BeautyArticle?pageNo=1&mold=${mold}" class="btn">1</a>
                      		 	<a href="share_BeautyArticle?pageNo=2&mold=${mold}" class="btn">2</a>
                                <a href="share_BeautyArticle?pageNo=3&mold=${mold}" class="btn">3</a>
                                <a href="share_BeautyArticle?pageNo=${pageNo-1 }&mold=${mold} "class="btn">上一页 »</a>
                                <a href="share_BeautyArticle?pageNo=${pageNo-1 }&mold=${mold}" class="btn">下一页»</a>
                                <h4>共${total}页</h4>
                        </div>
			</div>
				
				<aside class="span4 page-sidebar">
					<section class="wiget">
						<c:if test="<%=currentUser!=null %>">
						<div class="support-widget">
							<h3 class="title">用户名:<%=currentUser.getNickname() %></h3>
							<p class="intro">用户介绍:性别<%=currentUser.getSex()%></p>
							<button class="btn btn-link "><a href="postArticles.jsp">发表新文章</a></button>
						</div>
						</c:if>
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
    <%@ include file="../foot.jsp" %>  
      
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
