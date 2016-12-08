package com.niit.sweetcake.dao;

import java.util.List;

import com.niit.sweetcake.model.Product;

public interface ProductDao 
{
  public boolean saveorupdate(Product product);
  public boolean delete(String p_Id);
  public Product get(String p_Id);
  public List<Product> list();
  void editProduct(Product product);
}
