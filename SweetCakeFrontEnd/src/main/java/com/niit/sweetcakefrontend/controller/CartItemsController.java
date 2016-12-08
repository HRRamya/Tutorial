package com.niit.sweetcakefrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.niit.sweetcake.dao.CartItemsDao;
import com.niit.sweetcake.model.CartItems;

@Controller
public class CartItemsController {
	
	@Autowired
	CartItemsDao cartitemsDao;
	
	@Autowired
	CartItems cartitems;

}
