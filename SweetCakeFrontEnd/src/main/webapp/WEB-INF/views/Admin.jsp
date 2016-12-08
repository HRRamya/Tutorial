<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c"%>
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
<!-- 					<li class="active"><a href="home">Home</a></li> -->
					<li><a href="manageProduct">Product</a></li>
					<li><a href="manageCategory">Category</a></li>
					<li><a href="manageSupplier">Supplier</a></li>
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
	<!-- banner -->
	<div class="container">
		<div class="img-slider">
			<!----start-slider-script---->
			<script src="${js}/responsiveslides.min.js"></script>
			<script>
					    // You can also use "$(window).load(function() {"
					    $(function () {
					      // Slideshow 4
					      $("#slider4").responsiveSlides({
					        auto: true,
					        pager: true,
					        nav: true,
					        speed: 500,
					        namespace: "callbacks",
					        before: function () {
					          $('.events').append("<li>before event fired.</li>");
					        },
					        after: function () {
					          $('.events').append("<li>after event fired.</li>");
					        }
					      });
					
					    });
					  </script>
			<!----//End-slider-script---->
			<!-- Slideshow 4 -->
			<div id="top" class="callbacks_container">
				<ul class="rslides" id="slider4">
					<li><img src="${img}/banner1.jpg" class="img-responsive"
						alt="">
						<div class="slider-caption">


							<div class="clearfix"></div>
						</div> <!-- share-on -->
						<div class="share-on">
							<div class="share-on-grid">
								<div class="share-on-grid-left">
									<h3>Share On</h3>
								</div>
								<div class="share-on-grid-right">
									<a href="#"><span class="facebook"> </span></a> <a href="#"><span
										class="twitter"> </span></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix"></div>
						</div> <!-- share-on --></li>
					<li><img src="${img}/banner2.jpg" class="img-responsive"
						alt="">
						<div class="slider-caption">
							<div class="clearfix"></div>
						</div> <!-- share-on -->
						<div class="share-on">
							<div class="share-on-grid">
								<div class="share-on-grid-left">
									<h3>Share On</h3>
								</div>
								<div class="share-on-grid-right">
									<a href="#"><span class="facebook"> </span></a> <a href="#"><span
										class="twitter"> </span></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix"></div>
						</div> <!-- share-on --></li>
					<li><img src="${img}/banner3.jpg" class="img-responsive"
						alt="">
						<div class="slider-caption">

							<div class="clearfix"></div>
						</div> <!-- share-on -->
						<div class="share-on">
							<div class="share-on-grid">
								<div class="share-on-grid-left">
									<h3>Share On</h3>
								</div>
								<div class="share-on-grid-right">
									<a href="#"><span class="facebook"> </span></a> <a href="#"><span
										class="twitter"> </span></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix"></div>
						</div> <!-- share-on --></li>
					<li><img src="${img}/banner4.jpg" class="img-responsive"
						alt="">
						<div class="slider-caption">

							<a class="buy-btn" href="#">Buy Now</a>


							<div class="clearfix"></div>
						</div> <!-- share-on -->
						<div class="share-on">
							<div class="share-on-grid">
								<div class="share-on-grid-left">
									<h3>Share On</h3>
								</div>
								<div class="share-on-grid-right">
									<a href="#"><span class="facebook"> </span></a> <a href="#"><span
										class="twitter"> </span></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix"></div>
						</div> <!-- share-on --></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- /banner -->
	</div>
	<!-- top-grids -->
	<div class="top-grids">
		<div class="container">
			<div class="col-md-4 top-grid">
				<div class="top-grid-head">
					<h3>BIRTHDAY</h3>
				</div>
				<div class="top-grid-info">
					<img src="${img}/kid1.jpg" class="img-responsive" title="name" />
					<p>We make Birthday cakes for all ages! Whether you are
						celebrating your 1st birthday or your 90th, we can make a cake
						that fits your style and needs to celebrate that special day.
						Unique designs can be created as requested.</p>
					<span>Rs.1600</span>
					<div class="clearfix"></div>
					<a class="btn" href="#">Buy Now</a>
				</div>
			</div>
			<div class="col-md-4 top-grid">
				<div class="top-grid-head">
					<h3>OUR CAKES</h3>
				</div>
				<div class="top-grid-info">
					<img src="${img}/11.jpg" class="img-responsive" title="name" />
					<p>
						When u look for something extraordinary, you combine few
						ingredients and reach to a new flavor. Come visit us for an
						assortment of Whole Cakes, Cakes by the slice and other delicious
						desserts available now for pick-up.Coordinating your cake to your
						special event is easy. <span>Rs.3800</span>
					<div class="clearfix"></div>
					<a class="btn" href="#">Buy Now</a>
				</div>
			</div>
			<div class="col-md-4 top-grid">
				<div class="top-grid-head">
					<h3>WEDDING</h3>
				</div>
				<div class="top-grid-info">
					<img src="${img}/wed12.jpg" class="img-responsive" title="name" />
					<p>Our cakes are priced per serving based on amount of
						decoration, time, handmade sugar flowers and assembly that goes
						into making your cake. All of our cakes are custom made and are
						made using your style to mind.</p>
					<span>$Rs.3200</span>
					<div class="clearfix"></div>
					<a class="btn" href="#">Buy Now</a>
				</div>
			</div>
		</div>
		<!-- top-grids-bg -->
		<div class="top-grids-bg">
			<span> </span>
		</div>
		<!-- top-grids-bg -->
	</div>
	<!-- top-grids -->
	<!-- bottom-grids -->
	<div class="bottom-grids">
		<div class="container">
			<div class="col-md-8 bottom-grid-left">
				<div class="col-md-3 bottom-grid-left-grid text-center">
					<img src="${img}/k3.jpg" title="name" height=150 width=150 />
					<h4>kids birthday cake</h4>
					<p>Rs.1200</p>
				</div>
				<div class="col-md-3 bottom-grid-left-grid text-center">
					<img src="${img}/ba1.jpg" title="name" height=150 width=150 />
					<h4>kids birthday cake</h4>
					<p>Rs.1700</p>
				</div>
				<div class="col-md-3 bottom-grid-left-grid text-center">
					<img src="${img}/9.jpg" title="name" height=150 width=150 />
					<h4>wedding cake</h4>
					<p>Rs.1100</p>
				</div>
				<div class="col-md-3 bottom-grid-left-grid text-center">
					<img src="${img}/abcd2.jpg" title="name" height=150 width=150 />
					<h4>delicious cake</h4>
					<p>Rs.1400</p>
				</div>
				<div class="clearfix"></div>
				<span class="best-sale">Best sellers</span> <a href="#"
					class="order"> </a>
			</div>
			<div class="col-md-4 bottom-grid-right">
				<h3>
					<span class="tweet"> </span> latest tweet
				</h3>
				<p>
					For all the Chocolate cake pastry lover. Visit the website.<label>1
						day ago</label>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- bottom-grids -->
	<!-- /container -->
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

