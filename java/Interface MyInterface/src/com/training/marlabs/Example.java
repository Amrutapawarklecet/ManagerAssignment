package com.training.marlabs;

public class Example implements MyInterface{ 
	// implementing abstract method
    public void existingMethod(String str){           
        System.out.println("Java 8 is easy to learn");  
    }  
    public static void main(String[] args) {  
    	Example obj = new Example();
    	
    	//calling the default method of interface
        obj.newMethod();    
        
        //static method
        MyInterface.anotherNewMethod();

        //calling the abstract method of interface
        obj.existingMethod(null); 
  
    }  
}