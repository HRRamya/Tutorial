//package com.niit.sweetcakefrontend.webflow;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.niit.sweetcake.model.Orders;
//
//
//@Component
//public class OrderWebFlow {
//	
//	@Autowired
//	Orders orders;
//	
//	public Orders initFlow()
//		{
//		orders= new Orders();
//		return orders;
//	}
//	
//	public String addShippingAddress(Orders orders, String shipping)
//	{
//		orders.setS_address(shipping);
//		return "success";
//	}
//
//}
