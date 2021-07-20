package calculator.application;

public class Calculator {

	public Calculator () {
		
	} 
	
	/**
	 * takes two doubles, adds them, and returns their sum
	 * @param args
	 * @return
	 */
	public double add(double arg1, double arg2) {

		return arg1+arg2;
	}
	
	/**
	 * takes two doubles, subtracts them, and returns their difference
	 * @param args
	 * @return
	 */
	public double subtract(double arg1, double arg2) {
		return arg1-arg2;
	} 
	
	/**
	 * takes two doubles, divides them, and returns their quotient
	 * @param args
	 * @return
	 */
	public double divide(double arg1, double arg2) {

		return arg1/arg2;
	}
	
	/**
	 * takes two doubles, multiplies them, and returns their product
	 * @param args
	 * @return
	 */
	public double multiply(double arg1, double arg2) {
		return arg1*arg2;
	}
	
	/**
	 * take in three strings, process, return result
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return
	 */
	public double evaluateArguments(String arg1, String arg2, String arg3) {
		double result;
		 
       switch(arg2){
       case "+": 
    	   this.add(Double.parseDouble(arg1),Double.parseDouble(arg3));
       break;
       case "-":
    	   this.subtract(Double.parseDouble(arg1),Double.parseDouble(arg3));
    	   break;
       case "/":
    	   this.divide(Double.parseDouble(arg1),Double.parseDouble(arg3));
    	   break;
       case "*":
    	   this.multiply(Double.parseDouble(arg1),Double.parseDouble(arg3));
    	   break;
    	  
       }
        if (arg2.equals("+"))
        	result = this.add(Double.parseDouble(arg1),Double.parseDouble(arg3));
        else if (arg2.equals("-"))
        	result = this.subtract(Double.parseDouble(arg1),Double.parseDouble(arg3));
        else if (arg2.equals("/"))
        	result = this.divide(Double.parseDouble(arg1),Double.parseDouble(arg3));
        else
        	result = this.multiply(Double.parseDouble(arg1),Double.parseDouble(arg3));
        
        return result;
	}
	
	
}
