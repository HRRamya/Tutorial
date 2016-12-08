<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="Spring"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
<c:url value="/resources/css" var="css" />
<c:url value="/resources/images" var="images" />
<c:url value="/resources/js" var="js" />
<c:url value="/resources/img" var="img" />
<title>Sweet-cakes</title>
<link href="${css}/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${js}/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="${css}/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</script>
<!----webfonts--->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
</head>
<body>
	<!-- container -->
	<!-- top-header -->
	<div class="top-header">
		<div class="container">
			<div class="top-header-left">
				<ul>
				<c1:if test="${pageContext.request.userPrincipal.name!=null}" >
		<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/Admin"/>">Admin</a></li>
				</security:authorize>
				
				<li><a>Welcome ${pageContext.request.userPrincipal.name }</a></li>
			<li><a href="<c:url value="/j_spring_security_logout"></c:url>">logout</a></li>
		</c1:if >
				
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="top-header-center">
				<p>
					<span class=""> </span><label></label>
				</p>
			</div>
			<div class="top-header-right">
				<ul>
					<li>
						<form>
							<input type="text"> <input type="submit" value="" />
						</form>

					</li>
					<c1:if test="${pageContext.request.userPrincipal.name==null}">
					<li><a href="<c:url value="/login"></c:url>">Login</a></li>
					<c:url value="/register" var="url"></c:url>
					<li><a href="${url}">Register</a></li>
					</c1:if>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- /top-header -->
	<!-- main-menu -->
	<div class="main-menu">
		<div class="container">
			<div class="head-nav">
				<span class="menu"> </span>
				<ul>
					<li class="active"><a href="<c:url value="/home"/>">Home</a></li>
					<li><a href="<c:url value="/products"/>">Products</a></li>
					<li><a href="<c:url value="/about"/>">about</a></li>
					<li><a href="<c:url value="/contact"/>">Contact</a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<!-- script-for-nav -->
			<script>
						$( "span.menu" ).click(function() {
						  $( ".head-nav ul" ).slideToggle(300, function() {
							// Animation complete.
						  });
						});
					</script>
			<!-- script-for-nav -->

			<!-- logo -->
			<div class="logo">
				<a href="home"><img src="${images}/logo.png" title="Sweetcake" /></a>
			</div>
			<!-- logo -->
		</div>
	</div>
	<!-- /main-menu -->
<body>
		<!-- /main-menu -->
	<!---start-content----->
	<div class="content">
	<div class="main">
	   <div class="container">
		  <div class="register">
		  
		  	  <form action="<c:url value="/BillingAddress" />" method="post"> 
				 <div class="register-top-grid">
					<h3>Shipping Address</h3>
					 <div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span><label>Shipping Address</label><label>*</label></span>
						<input type="text"  name="ShippingAddress" class="form-control" /> 
					 </div>
						
				<div class="clearfix"> </div>
				<div class="register-but">
				<div class="btn_form">
<%-- 				 <a href="<c:url value="/" />" >Submit</a> --%>
					 <input type="submit" value="submit"/>
					   </form>
					   <a href="<c:url value="/cancel" />" >Cancel</a></div>
					   <div class="clearfix"> </div>
				   
				</div>
		   </div>
	     </div>
	    </div>
		</div>
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<div class="col-md-3 location">
					<h4>location</h4>
					<p>Bangalore, Karnataka, India</p>
					<h4>hours</h4>
					<p>Weekdays 7 a.m.-7 p.m.</p>
					<p>Weekends 8 a.m.-7 p.m.</p>
					<p>Call for Holidays Hours.</p>
				</div>
				<div class="col-md-3 customer">
					<h4>customer service</h4>
					<p>CUSTOMER SERVICE IS NOT OUR DEPARTMENT, IT'S OUR JOB.</p>
					<h4>phone</h4>
					<h6>080- 87654321</h6>
					<h4>contact us</h4>
					<h6>contact us page.</h6>
				</div>
				<div class="col-md-3 social">
					<h4>get social</h4>
					<div class="face-b">
						<img src="${images}/foot.png" title="name" />
						<a href="facebook.com"><i class="fb"> </i></a>
					</div>
					<div class="twet">		
						<img src="${images}/foot.png" title="name" />
							<a href="twitter.com"><i class="twt"> </i></a>
					</div>	
				</div>
				<div class="col-md-3 sign">
					<h4>sign up for news letter</h4>	
						<form>
						<input type="text" class="text" value="YOUR EMAIL"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'YOUR EMAIL ';}">
						</form>
				</div>
					<div class="clearfix"> </div>
			</div>
			<div class="footer-bottom">
				<p>Designed By Sweetcakes </a>
				</p>
			</div>
		</div>
	</div>
	<!-- /footer -->
	</body>
</html>

