package com.marlabs.training.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamExample {
	    public static void main(String[] args) {  
	        List<Product> productsList = new ArrayList<Product>();  
	        //Adding Products  
	        productsList.add(new Product(1,"HP Laptop",25000f));  
	        productsList.add(new Product(2,"Dell Laptop",30000f));  
	        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product(4,"Sony Laptop",28000f));  
	        productsList.add(new Product(5,"Apple Laptop",90000f));  
	        List<String> productPriceList2 =productsList.stream()  
	                                     .filter(p -> p.price > 30000)// filtering data  
	                                     .map(p->p.name)        // fetching price  
	                                     .collect(Collectors.toList()); // collecting as list  
	        System.out.println(productPriceList2);  
	    }  
	}  

