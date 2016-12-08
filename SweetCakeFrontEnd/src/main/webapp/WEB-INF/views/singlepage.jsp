<%@ taglib uri="http://www.springframework.org/tags" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
	<head>
	<c:url value="/resources/css" var="css" />
	<c:url value="/resources/images" var="images" />
	<c:url value="/resources/js" var="js" />
	<c:url value="/resources/img" var="img" />
		<title>Sweet-cakes </title>
		<link href="${css}/bootstrap.css" rel='stylesheet' type='text/css' />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${js}/jquery.min.js"></script>
		 <!-- Custom Theme files -->
		<link href="${css}/style.css" rel='stylesheet' type='text/css' />
   		 <!-- Custom Theme files -->
   		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		</script>
		<script src="js/jquery.easydropdown.js"></script>
		<!----webfonts--->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,800,400,600' rel='stylesheet' type='text/css'>
		<!---//webfonts--->
		<script src="${js}/jquery.min.js"></script>
		<script type="text/javascript" src="${js}/move-top.js"></script>
		<script type="text/javascript" src="${js}/easing.js"></script>
		<link rel="stylesheet" href="${css}/etalage.css">
		<link href="${css}/form.css" rel="stylesheet" type="text/css" media="all" />
		<script src="${js}/jquery.easydropdown.js"></script>

		<script src="${js}/jquery.etalage.min.js"></script>
<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 800,
					source_image_height: 1000,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>

	</head>
	<body>
	<!-- container -->
		<!-- top-header -->
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
							<li class="active"><a href="<c:url value="/checkout"></c:url>">Checkout</a></li>
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
				
				<div class="logo">
					<a href="index"><img src="${images}/logo.png" title="Sweetcake" /></a>
				</div>
				
			</div>
		</div>
		<h4>${done}</h4>
	<div class="details">
<div class="container">
<div class="row single">
<div class="col-md-9">
				  <div class="single_left">
				 
					<div class="grid images_3_of_2">
						<ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image" src="${img}/${pro.getImage()}" class="img-responsive" />
									<img class="etalage_source_image" src="${img}/${pro.getImage()}" class="img-responsive" title="" />
								</a>
							</li>
							<li>
								<img class="etalage_thumb_image" src="${img}/product0FB5FC.jpg" class="img-responsive" />
								<img class="etalage_source_image" src="${img}/product0FB5FC.jpg" class="img-responsive" title="" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="${img}/e3.jpg" class="img-responsive"  />
								<img class="etalage_source_image" src="${img}/e3.jpg"class="img-responsive"  />
							</li>
						    <li>
								<img class="etalage_thumb_image" src="${img}/k5.jpg" class="img-responsive"  />
								<img class="etalage_source_image" src="${img}/k5.jpg"class="img-responsive"  />
							</li>
						</ul>
						 <div class="clearfix"></div>		
				  </div>
				  <div class="desc1 span_3_of_2">
					<h3>${pro.getP_Description()}</h3>
					<p>Rs. ${pro.getP_Price()} <a href="#">click for offer</a></p>
					
					<div class="det_nav">
						<h4>related cakes :</h4>
						
						<ul>
					
							<li><a href="#"><img src="${img}/${pro.getImage()}" class="img-responsive" alt=""/></a></li>
							<li><a href="#"><img src="${img}/product0FB5FC.jpg" class="img-responsive" alt=""/></a></li>
							<li><a href="#"><img src="${img}/e3.jpg" class="img-responsive" alt=""/></a></li>
							<li><a href="#"><img src="${img}/k5.jpg" class="img-responsive" alt=""/></a></li>
						
						</ul>
					</div>
					
    				
					<div class="det_nav1">
						<h4>Select a cake :</h4>
							<div class=" sky-form col col-4">
								<ul>
									<li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>1kg</label></li>
									<li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>2kg</label></li>
									<li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>3kg</label></li>
									<li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>4kg</label></li>
									 <div class="clearfix"></div>
								</ul>
							</div>
							 <div class="clearfix"></div>
					</div>
					<div class="btn_form">
					<a href="<c:url value="/addtoCart/${pro.getP_Id()}"/>">Add To Cart</a>
						<a href="<c:url value="/buy/${pro.getP_Id()}"/>">buy</a>
					</div>
					<a href="#"><span>login to save in wishlist </span></a>
			   	 </div>
          	    <div class="clearfix"></div>
          	   </div>
          	    <div class="single-bottom1">
					<h6>Details</h6>
					<p class="prod-desc">write something here...........</p>
				</div>
				<div class="single-bottom2">
					<h6>Related Products</h6>
						<div class="product">
						   <div class="product-desc">
								<div class="product-img">
		                           <img src="${images}/15.jpg" class="img-responsive " alt=""/>
		                       </div>
		                       <div class="prod1-desc">
		                           <h5><a class="product_link" href="#">Excepteur sint</a></h5>
		                           <p class="product_descr"> Vivamus ante lorem, eleifend nec interdum non, ullamcorper et arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. </p>									
							   </div>
							  <div class="clearfix"></div>
					      </div>
						  <div class="product_price">
								<span class="price-access">$597.51</span>								
								<button class="button1"><span>Add to cart</span></button>
		                  </div>
						 <div class="clearfix"></div>
				     </div>
					  <div class="product">
						   <div class="product-desc">
								<div class="product-img">
		                           <img src="${images}/16.jpg" class="img-responsive " alt=""/>
		                       </div>
		                       <div class="prod1-desc">
		                           <h5><a class="product_link" href="#">Excepteur sint</a></h5>
		                           <p class="product_descr"> Vivamus ante lorem, eleifend nec interdum non, ullamcorper et arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. </p>									
							   </div>
							   <div class="clearfix"></div>
					      </div>
						  <div class="product_price">
								<span class="price-access">$597.51</span>								
								<button class="button1"><span>Add to cart</span></button>
		                  </div>
						 <div class="clearfix"></div>
				     </div>
				     <div class="product">
						   <div class="product-desc">
								<div class="product-img">
		                           <img src="${images}/17.jpg" class="img-responsive " alt=""/>
		                       </div>
		                       <div class="prod1-desc">
		                           <h5><a class="product_link" href="#">Excepteur sint</a></h5>
		                           <p class="product_descr"> Vivamus ante lorem, eleifend nec interdum non, ullamcorper et arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. </p>									
							   </div>
							   <div class="clearfix"></div>
					      </div>
						  <div class="product_price">
								<span class="price-access">$597.51</span>								
								<button class="button1"><span>Add to cart</span></button>
		                  </div>
						 <div class="clearfix"></div>
				     </div>
		   	  </div>
	       </div>
<div class="col-md-3 single_left">
			   <div class="block block-layered-nav first">
                  <p class="block-subtitle">Shopping Options</p>
            <dl id="narrow-by-list">
                 <dt class="odd">Price</dt>
                    <dd class="odd">
					<ol>
					    <li>
					                <a href="#"><span class="price">$100.00</span> - <span class="price">$199.99</span></a>
					                        (3)
					            </li>
					    <li>
					                <a href="#"><span class="price">$200.00</span> - <span class="price">$299.99</span></a>
					                        (2)
					            </li>
					    <li>
					                <a href="#"><span class="price">$300.00</span> and above</a>
					                        (1)
					            </li>
					</ol>
					</dd>
					                                                                    <dt class="even">Items</dt>
					                    <dd class="even">
					<ol>
					    <li>
					                <a href="#">Pineapple</a>
					                        (1)
					            </li>
					    <li>
					                <a href="#">Black Forest</a>
					                        (1)
					            </li>
					    <li>
					                <a href="#">Chocolate</a>
					                        (2)
					            </li>
					    <li>
					                <a href="#">Blueberry</a>
					                        (1)
					            </li>
					    
					</ol>
					</dd>
                                                                    <dt class="last odd">Flavours</dt>
                    <dd class="last odd">
					<ol>
					    <li>
					                <a href="#">Vennela</a>
					                        (2)
					            </li>
					    <li>
					                <a href="#">Strawberry</a>
					                        (2)
					            </li>
					    <li>
					                <a href="#">Butterscotch</a>
					                        (2)
					            </li>
					</ol>
					</dd>
                                            </dl>
          
                </div>
				
		     
			  <div class="tags">
				    	<h4 class="tag_head">Popular cakes</h4>
				         <ul class="tags_links">
							<li><a href="#">FlowerAura</a></li>
							<li><a href="#">My Flower Tree</a></li>
							<li><a href="#">Butterscotch</a></li>
							<li><a href="#">Strawberry</a></li>
							<li><a href="#">Vennela</a></li>
							<li><a href="#">Blueberry</a></li>
							<li><a href="#">Chocolate</a></li>
							<li><a href="#">Pineapple</a></li>
							
						</ul>
						<a href="#" class="link1">View all tags</a>
				 </div>
		   </div>		   
				<div class="clearfix"></div>	
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
