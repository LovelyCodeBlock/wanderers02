<%@page import="java.text.SimpleDateFormat"%>
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
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
  </head>
  
  <body>
    <!-- top -->
    
    <br>
    我在这里，你的眼神又在哪呢？
    <s:debug></s:debug>
    <br>
    
  	<%@ include file="../top.jsp" %>
  	<%@ include file="../middle.jsp" %>

	<%
		/*获取系统时间的代码*/
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String systemDate = f.format(c.getTime());
	%>



	<!-- page content -->
  	<div class="page-container">
  		<
  		<div class="container">
	  		<div class="row">
	  			<div class="span8 page-content">
					<article class=" type-post format-standard hentry clearfix">
					<s:iterator value="article" status="status">
						<h1 class="post-title"><s:property value="title"></s:property></h1>
						<div class="post-meta clearfix">
							<span class="date"><s:property value="time"></s:property></span>
							<span class="category"><s:property value="publisher"></s:property></span>
							<span class="comments"><s:property value="comments"></s:property> Comments</span>
                            <span class="like-count">66</span>
						</div>
						<p><s:property value="summary"></s:property></p>
					</article>
					<section id="comments">
						<h3 id="comments-title">评论数(${comments})</h3>
				</s:iterator>	
						<ol class="commentlist">
							<!-- foreach page -->
							
							<s:iterator value="articleContent" status="status">
								<li class="comment even thread-even depth-1" id="li-comment-2">
									<article id="comment-2">
										<img alt="" src="images/touxiang.jpg" class="avatar avatar-60 photo" height="60" width="60">
										<div class="comment-meta">
											<h5 class="author">
												<cite class="fn">
													<span style="color:rgb(240, 183, 12)">${answerName }</span>
												</cite>
											</h5>
											 <p class="date">
												<time datetime="2013-02-26T13:18:47+00:00" style="color:rgb(240, 183, 12)">${time }</time>
											</p>								
										</div>
										<div class="comment-body">
			                                <p>${content }</p>
										</div>
									</article>
								</li>
							</s:iterator>
							
						</ol>
						<div id="pagination">
					
						 <a href="comment_BeautyArticle?id=${id }&pageNo=${pageNo-1}&mold=${mold}" class="btn">«上一页 </a>
						 <a href="comment_BeautyArticle?id=${id }&pageNo=1&mold=${mold}"  class="btn active">1</a>
                         <a href="comment_BeautyArticle?id=${id }&pageNo=2&mold=${mold}" class="btn">2</a>
                         <a href="comment_BeautyArticle?id=${id }&pageNo=3&mold=${mold}" class="btn">3</a>
                         <a href="comment_BeautyArticle?id=${id }&pageNo=${pageNo+1}&mold=${mold}" class="btn">下一页 »</a>
                       
                        </div>
					</section>
					<form action="comment" method="post">
					<hr>
				
					<hr>
						<tr>
							<td align="center"><h3>评论内容</h3></td>
							<td>
								<!-- 提交评论内容 -->
								<textarea class="ckeditor" cols="80" id="content"
									name="content" rows="10"> 
								</textarea>
							</td>
						</tr>
						<br/>
						<!-- 提交帖子ID -->
						<input type="hidden" name="questionId" value="${ questionId}" />
						
						<!--提交评论时间（系统时间）-->
						<input type="hidden" name="systemDate" value="<%=systemDate%>"/>
						<!--提交页面-->
						<input type="hidden" name="page" value="beauty"/>
						<input type="hidden" name="pageUrl" value="BeautyArticle_comment?id=${ questionId}&mold=${mold}"/>
						<input type="submit" class="btn btn-primary" value="发表"/>
						<c:if test="${currentUser==null }">
						 	<h4 >
						 		<a href="login.jsp"  style="color:red">（登录后才能评论   请点击登录或注册）</a>
						 	</h4>
						</c:if>
						
					</form>
				</div>
	  		
		  		<aside class="span4 page-sidebar">
						<section class="wiget">
						<c:if test="<%=currentUser!=null %>">
						<div class="support-widget">
							<h3 class="title">用户名:<%=currentUser.getNickname() %></h3>
							<p class="intro">用户介绍:性别<%=currentUser.getSex()%></p>
							<button class="btn btn-link "><a href="postArticles.jsp" style="color:#FF9933">发布新帖</a></button>
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
  	<%@ include file="../foot.jsp" %>  
  	 <!-- script -->
  	 <script type="text/javaScript"
		src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
		<script type="text/javascript">   
 			var editor = CKEDITOR.replace('content');   
 		</script>  
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
