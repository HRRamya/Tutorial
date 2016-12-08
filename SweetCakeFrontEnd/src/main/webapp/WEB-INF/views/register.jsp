<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="Spring"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
					<li><a href="login">Login</a></li>
					<li><a href="register">Register</a></li>
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
					<li class="active"><a href="home">Home</a></li>
					<li><a href="products">Product</a></li>
					<li><a href="about">about</a></li>
					<li><a href="contact">Contact</a></li>
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
		  <c:url var="subt" value="/Submit"/>
		  	  <form:form method="POST" commandName="user" action="${subt}"> 
				 <div class="register-top-grid">
					<h3>PERSONAL INFORMATION</h3>
					 <div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span><form:label path="userName">User Name</form:label><label>*</label></span>
						<form:input path="userName" type="text" required="required"  /> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						<span><form:label path="address">Address</form:label><label>*</label></span>
						<form:input path="address" type="text" required="required"/> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span><form:label path="emailId">Email Id</form:label><label>*</label></span>
						 <form:input path="emailId" type="email" required="required"/> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span><form:label path="mobile">Mobile</form:label><label>*</label></span>
						 <form:input path="mobile"  type="tel" required="required" /> 
<!-- 						 <input type="tel" pattern="^\d{4}-\d{3}-\d{4}$" > -->
						 
					 </div>
					 
					   
				     <div class="register-bottom-grid">
						    <h3>LOGIN INFORMATION</h3>
							 <div class="wow fadeInLeft" data-wow-delay="0.4s">
								<span><form:label path="password">Password</form:label><label>*</label></span>
								<form:input path="password" type="password" min="1" max="5" required="required" />
							 </div>
							 <div class="wow fadeInRight" data-wow-delay="0.4s">
								<span>Confirm Password<label>*</label></span>
								<input type="password" name="ConfirmPassword" min="1" max="5" required="required"  />
							 </div>
					 </div>
				
				<div class="clearfix">
				<div class="register-but"><br><br>
					  
					   <div class="clearfix">  <input type="submit" value="Submit"/></div> </div>
				   </form:form>
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

