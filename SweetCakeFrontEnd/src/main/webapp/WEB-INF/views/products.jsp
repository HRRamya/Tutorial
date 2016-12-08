<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
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
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600' rel='stylesheet' type='text/css'>
		<!---//webfonts--->
	</head>
	<body>
	
	<!-- container -->
		<!-- top-header -->
		<div class="top-header">
			<div class="container">
				<div class="top-header-left">
					<ul><c1:if test="${pageContext.request.userPrincipal.name!=null}" >
		<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/Admin"/>">Admin</a></li>
				</security:authorize>
				
				<li><a>Welcome ${pageContext.request.userPrincipal.name }</a></li>
			<li><a href="<c:url value="/j_spring_security_logout"></c:url>">logout</a></li>
		</c1:if >
						<li><a href=""></a></li>
						<li><a href=""></a></li>
						<div class="clearfix"> </div>
					</ul>
				</div>
				<div class="top-header-center">
					<p><span class=""> </span><label></label></p>
				</div>
				<div class="top-header-right">
					<ul>
					
						<li>
							<form>
								<input type="text">
								<input type="submit" value="" />
								
							</form>
							<li class="active"><a href="checkout">Checkout</a></li>
						</li>
						<c1:if test="${pageContext.request.userPrincipal.name==null}">
					<li><a href="<c:url value="/login"></c:url>">Login</a></li>
					<c:url value="/register" var="url"></c:url>
					<li><a href="${url}">Register</a></li>
					</c1:if>
					</ul>
					
				</div>
				<div class="clearfix"> </div>
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
					<a href="index"><img src="${images}/logo.png" title="Sweetcake" /></a>
				</div>
				<!-- logo -->
			</div>
		</div>
		<!-- /main-menu -->
	<!-- service -->
<div class="biseller-info">
<div class="container">
<h2>Products</h2>
<c1:forEach var="product" items="${pro}">

</c1:forEach>
<h3 class="new-models">new varieties</h3>
<ul id="flexiselDemo3">
			<c1:forEach var="product" items="${pro}">
		     	<li>
				
					<div class="biseller-column">
					<img src="${img}/${product.getImage()}" alt="" class="veiw-img">
						<div class="veiw-img-mark">
							<a href="singlepage/${product.getP_Id()}">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>${product.getP_Description()}</h4>
						<p>RS-${product.getP_Price()}</p>
					</div>
						<a href="singlepage"><button class="add2cart">
							<%-- <a href="<c:url value="/buy/${pro.getP_Id()}"/>"><span> Buy</span></a> --%>
							
							
<!-- 						    <span>|<a href="cart_Checkout"></a>Buy</span> -->
<!-- 							<span> <input type="submit" name="_eventId_submitShippingAddress" value="Save"></span> -->
<!-- 						    <span>|<input type="submit" name="_eventId_cancel" value="cancel">Cancel</span> -->
						    
						</button></a>					
					</div>
				</li>
				
				</c1:forEach>
				</ul>
				
				<ul id="flexiselDemo3">
			<c1:forEach var="product" items="${pro}">
		     	<li>
				
					<div class="biseller-column">
					<img src="${img}/${product.getImage()}" alt="" class="veiw-img">
						<div class="veiw-img-mark">
							<a href="singlepage/${product.getP_Id()}">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>Delicious</h4>
						<p>RS-${product.getP_Price()}</p>
					</div>
						<a href="singlepage"><button class="add2cart">
							<%-- <a href="<c:url value="/buy/${pro.getP_Id()}"/>"><span> Buy</span></a> --%>
							
							
<!-- 						    <span>|<a href="cart_Checkout"></a>Buy</span> -->
<!-- 							<span> <input type="submit" name="_eventId_submitShippingAddress" value="Save"></span> -->
<!-- 						    <span>|<input type="submit" name="_eventId_cancel" value="cancel">Cancel</span> -->
						    
						</button></a>					
					</div>
				</li>
				</c1:forEach>
				</ul>
				

			</div>
		</div>	

			<script type="text/javascript">
				 $(window).load(function() {
					$("#flexiselDemo3").flexisel({
						visibleItems: 4,
						animationSpeed: 1000,
						autoPlay: false,
						autoPlaySpeed: 3000,    		
						pauseOnHover: true,
						enableResponsiveBreakpoints: true,
				    	responsiveBreakpoints: { 
				    		portrait: { 
				    			changePoint:480,
				    			visibleItems: 1
				    		}, 
				    		landscape: { 
				    			changePoint:640,
				    			visibleItems: 2
				    		},
				    		tablet: { 
				    			changePoint:768,
				    			visibleItems: 3
				    		}
				    	}
				    });
				    
				});
			   </script>
			   <script type="text/javascript" src="${js}/jquery.flexisel.js"></script>
			
				<div class="best-seller">
				<div class="container">
					<div class="biseller-info">
					 <h3 class="new-models">Upcoming</h3>
					<ul id="flexiselDemo1">
											
<%-- 						<c1:forEach var="product" items="${pro}"> --%>
<!-- 		     	<li> -->
				
<!-- 					<div class="biseller-column"> -->
<%-- 					<img src="${img}/${product.getImage()}" alt="" class="veiw-img"> --%>
<!-- 						<div class="veiw-img-mark"> -->
<%-- 							<a href="singlepage/${product.getP_Id()}">Quick view</a> --%>
<!-- 						</div> -->
<!-- 					<div class="biseller-name"> -->
<%-- 						<h4>${product.getP_Description()}</h4> --%>
<%-- 						<p>RS-${product.getP_Price()}</p> --%>
<!-- 					</div> -->
						
							
<!-- 						</button></a>					 -->
<!-- 					</div> -->
<!-- 				</li> -->
				
<%-- 				</c1:forEach> --%>
<!-- 				</ul> -->
						<li>
							<div class="biseller-column">
							<img src="${img}/e1.jpg" alt="">
							<div class="veiw-img-mark">
							<a href="singlepage">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>Vanilla Fruit Cake </h4>
						<p>Rs.1000</p>
					</div>
							</div>
						</li>
						<li>
							<div class="biseller-column">
							<img src="${img}/coffee_cake.jpeg" alt="">
							<div class="veiw-img-mark">
							<a href="singlepage">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>Coffee Cake </h4>
						<p>Rs.900</p>
					</div>
							</div>
						</li>
						<li>
							<div class="biseller-column">
							<img src="${img}/e2.jpg" alt="">
							<div class="veiw-img-mark">
							<a href="singlepage">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>Choco Fruit Cake</h4>
						<p>Rs.1200</p>
					</div>
						
							</div>
						</li>
						<li>
							<div class="biseller-column">
							<img src="${img}/e3.jpg" alt="">
							<div class="veiw-img-mark">
							<a href="singlepage">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>Strawberry cake</h4>
						<p>Rs.1400</p>
					</div>
						
							</div>
						</li>
						<li>
							<div class="biseller-column">
							<img src="${img}/k3.jpg" alt="">
							<div class="veiw-img-mark">
							<a href="singlepage">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>Kids cake</h4>
						<p>Rs.1400</p>
					</div>
						
							</div>
						</li>
						<li>
							<div class="biseller-column">
							<img src="${img}/r2.jpg" alt="">
							<div class="veiw-img-mark">
							<a href="singlepage">Quick view</a>
						</div>
					<div class="biseller-name">
						<h4>Black forest cake</h4>
						<p>Rs.1100</p>
					</div>
						
							</div>
						</li>
<!-- 						<li> -->
<!-- 							<div class="biseller-column"> -->
<%-- 							<img src="${images}/16.jpg" alt=""> --%>
<!-- 							<div class="veiw-img-mark"> -->
<!-- 							<a href="singlepage">Quick view</a> -->
<!-- 						</div> -->
<!-- 					<div class="biseller-name"> -->
<!-- 						<h4>Flower Types </h4> -->
<!-- 						<p>Rs.650</p> -->
<!-- 					</div> -->
<!-- 						<a href="singlepage"><button class="add2cart"> -->
<%-- 						<a href="<c:url value="addtoCart"/>"><span> Add To Cart</span></a> --%>
<!-- 						    <span>| View</span> -->
<!-- 						</button></a> -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							<div class="biseller-column"> -->
<%-- 							<img src="${images}/17.jpg" alt=""> --%>
<!-- 							<div class="veiw-img-mark"> -->
<!-- 							<a href="singlepage">Quick view</a> -->
<!-- 						</div> -->
<!-- 					<div class="biseller-name"> -->
<!-- 						<h4>Sheet Cake </h4> -->
<!-- 						<p>Rs.550</p> -->
<!-- 					</div> -->
<!-- 						<a href="singlepage"><button class="add2cart"> -->
<%-- 						<a href="<c:url value="addtoCart"/>"><span> Add To Cart</span></a> --%>
<!-- 						    <span>| View</span> -->
<!-- 						</button></a> -->
<!-- 							</div> -->
<!-- 						</li> -->
			     	</ul>
					</div>
			</div>
			</div>
			<script type="text/javascript">
				 $(window).load(function() {
					$("#flexiselDemo1").flexisel({
						visibleItems: 4,
						animationSpeed: 1000,
						autoPlay: true,
						autoPlaySpeed: 3000,    		
						pauseOnHover: true,
						enableResponsiveBreakpoints: true,
				    	responsiveBreakpoints: { 
				    		portrait: { 
				    			changePoint:480,
				    			visibleItems: 1
				    		}, 
				    		landscape: { 
				    			changePoint:640,
				    			visibleItems: 2
				    		},
				    		tablet: { 
				    			changePoint:768,
				    			visibleItems: 3
				    		}
				    	}
				    });
				    
				});
			   </script>
			   <script type="text/javascript" src="${js}/jquery.flexisel.js"></script>
			
			<div class="clearfix"></div>


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
						<img src="${images}/foot.png" title="name" /> <a
							href="facebook.com"><i class="fb"> </i></a>
					</div>
					<div class="twet">
						<img src="${images}/foot.png" title="name" /> <a
							href="twitter.com"><i class="twt"> </i></a>
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
				<div class="clearfix"></div>
			</div>
			<div class="footer-bottom">
				<p>Template by SweetCakes</p>
			</div>
		</div>
	</div>
	<!-- /footer -->
</body>
</html>




