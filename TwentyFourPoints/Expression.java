//This class is used to do the maths
// When user gives input in the field this class will identify that input
// And solve the expression since it's the String it is first converted
// into normal format and solved as per mathematics rules
// then the answer is sent back to the method from where it was called

import java.util.ArrayList;
import java.util.Stack;

public class Expression<E> {
	private String infix; 
	
	private String postfix;
	// postfix method will hold the result from infixToPostfix method
	
	/**
	 * GenericStack<E> list being used as medium to manipulate the expression
	 */
	private  GenericStack<E> list = new GenericStack<E>();
	  
	
	
	public Expression(){
	}
	
	public Expression(String infix){
		this.infix = infix;
		postfix = "";
	}
	
	
	/*
	  precedence is the helper method that will help to make the postFix results 
	  Mathematically correct i-e it follows the orders via which a maths operation shall be carried
	 */
	static int Prec(char ch){ 
	        switch (ch) 
	        { 
	        case '+': 
	        case '-': 
	            return 1; 
	       
	        case '*': 
	        case '/': 
	            return 2; 
	       
	        case '^': 
	            return 3; 
	        } 
	        return -1; 
	    } 
	       // infix is expression like 2+3+4*5
	    	// postfix is expression like 23+45*+ which is easier to solve in computer programming
	    // The main method that converts given infix expression 
	    // to postfix expression.  
	public ArrayList<String> infixToPostfix(){
			
			ArrayList<String> list = new ArrayList<String>();
	        // initializing empty String for result 
	         postfix = new String(""); 
	          
	        // initializing empty stack 
	        Stack<Character> stack = new Stack<>(); 
	          String temp = ""; // a temporary variable
	        for (int i = 0; i<infix.length(); ++i) 
	        { 
	            char c = infix.charAt(i); 
	              
	             // If the scanned character is an operand, add it to list. 
	            if (Character.isLetterOrDigit(c)) { 
	                postfix += c; 
	                list.add(c+"");
	            }
	               
	            // If the scanned character is an '(', push it to the generic stack. 
	            else if (c == '(') 
	                stack.push(c); 
	              
	            //  If the scanned character is an ')', pop and output from the generic stack  
	            // until an '(' is encountered. 
	            else if (c == ')') 
	            { 
	                while (!stack.isEmpty() && stack.peek() != '(') { 
	                    temp = stack.pop()+"";
	                	postfix+= temp; 
	                    list.add(temp);
	                }
	                  
	                if (!stack.isEmpty() && stack.peek() != '(') 
	                    return null; // invalid expression                 
	                else
	                    stack.pop(); 
	            } 
	            else // an operator is encountered 
	            { 
	                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
	                    if(stack.peek() == '(') 
	                        return null; // if it's empty through NullStack Exception
	                    temp = stack.pop()+"";
	                    postfix += temp; // otherwise push the operands and operator in String from Generic Stack 
	                    list.add(temp);
	             } 
	                stack.push(c); 
	            } 
	       
	        } 
	       
	        // pop all the operators from the stack 
	        while (!stack.isEmpty()){ 
	            if(stack.peek() == '(') 
	                return null; // if it's empty through NullStack Exception
	            temp = stack.pop()+"";
                postfix += temp;  // otherwise push the operands and operator in String pop from Generic Stack 
                list.add(temp); 
	         } 
	        return list; 
	    } 
	    
	
	public int evaluate(){
	   
	     //  taking expression in postfix format
	     // from infixToPostfix method
	    
			
		
			infixToPostfix();
			
			//saving the postfix expression into exp
			String exp = postfix;
			//create a stack 
			Stack<Integer> stack=new Stack<>(); 
	          
	        // Scan all characters one by one 
	        for(int i=0;i<exp.length();i++) 
	        { 
	            char c=exp.charAt(i); 
	              
	            // If the scanned character is an operand (number here), 
	            // push it to the stack. 
	            if(Character.isDigit(c)) 
	            stack.push(c - '0'); 
	              
	            //  If the scanned character is an operator, pop two 
	            // elements from stack apply the operator 
	            else
	            { 
	                int val1 = stack.pop(); 
	                int val2 = stack.pop(); 
	                  
	                switch(c) 
	                {  // checking the operation to be performed
	                    case '+': 
	                    stack.push(val2+val1);  //performing that operation as we already have operands 
	                    break; 
	                      
	                    case '-': 
	                    stack.push(val2- val1);//performing that operation as we already have operands 
	                    break; 
	                      
	                    case '/': 
	                    stack.push(val2/val1); //performing that operation as we already have operands
	                    break; 
	                      
	                    case '*': 
	                    stack.push(val2*val1); //performing that operation as we already have operands
	                    break; 
	              } 
	            } 
	        } 
	        return stack.pop();  // return last element of stack
	}
	
	 // Method to convert the list items all in  a string
	// ppassig that String to variable in order to evaluate
	 	public String postfixToString(ArrayList<String> list) {
		String result = "";
		for(int i=0; i<list.size(); i++) {
			result+=list.remove(i);
		}
		return result;
	}
}
