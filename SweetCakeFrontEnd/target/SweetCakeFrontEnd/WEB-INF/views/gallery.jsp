<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="Spring"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:url value="/resources/css" var="css" />
<c:url value="/resources/images" var="images" />
<c:url value="/resources/js" var="js" />
<c:url value="/resources/img" var="img" />
<c:url value="/resources/gallery" var="gallery" />

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
					<li><a href="home">Home</a></li>
					<li class="active"><a href="gallery">Gallery</a></li>
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


</head>
<style>
div.img {
	margin: 5px;
	border: 1px solid #ccc;
	float: left;
	width: 180px;
}

div.img:hover {
	border: 1px solid #777;
}

div.img img {
	width: 100%;
	height: auto;
}

div.desc {
	padding: 15px;
	text-align: center;
}
</style>
</head>
	<br>
	<br>
	<br>
	<div class="img">
		<a target="_blank" href="${gallery}/1.png"> <img src="${gallery}/1.png"
			alt="cake1" width="300" height="200">
		</a>
		<div class="desc">Add a description of the image here</div>
	</div>

	<div class="img">
		<a target="_blank" href="${gallery}/2.jpg"> <img
			src="${gallery}/2.jpg" alt="cake2" width="600" height="400">
		</a>
		<div class="desc">Add a description of the image here</div>
	</div>

	<div class="img">
		<a target="_blank" href="${gallery}/3.jpg"> <img
			src="${gallery}/3.jpg" alt="cake3" width="600" height="400">
		</a>
		<div class="desc">Add a description of the image here</div>
	</div>

	<div class="img">
		<a target="_blank" href="${gallery}/4.jpg"> <img
			src="${gallery}/4.jpg" alt="cake4" width="600" height="400">
		</a>
		<div class="desc">Add a description of the image here</div>
	</div>

</body>
</html>

