package calculator.application;

import javax.swing.JTextField;

public class Calculator {
	
	private boolean cleared;
	
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
	 * clear the screen when instructed to do so by the user
	 */
	public void clearScreen(String arg1, String arg2, String arg3, JTextField screen) {
		arg1 = arg2 = arg3 = "";
		screen.setText("");
		this.setCleared(true);
	}
	
	/**
	 * take in three strings, process, return result
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return
	 */
	public double evaluateArguments(String arg1, String arg2, String arg3, JTextField screen) {
		double result = 0;
       switch(arg2){
       case "+": 
    	   result = this.add(Double.parseDouble(arg1),Double.parseDouble(arg3));
       break;
       case "-":
    	   result = this.subtract(Double.parseDouble(arg1),Double.parseDouble(arg3));
    	   break;
       case "/":
    	   result = this.divide(Double.parseDouble(arg1),Double.parseDouble(arg3));
    	   break;
       case "*":
    	  result = this.multiply(Double.parseDouble(arg1),Double.parseDouble(arg3));
    	   break;
    	  
       }
        
       screen.setText(arg1 + arg2 + arg3 + "=" + result);
        
        return result;
	}

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}
	
}
