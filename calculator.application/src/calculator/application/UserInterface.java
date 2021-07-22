package calculator.application;

import java.awt.event.*;
import javax.swing.*;
public class UserInterface extends JFrame implements ActionListener {

	/**
	 * From https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
	 * The serialization runtime associates with each serializable 
	 * class a version number, called a serialVersionUID, which is 
	 * used during deserialization to verify that the sender and 
	 * receiver of a serialized object have loaded classes for 
	 * that object that are compatible with respect to serialization. 
	 * If the receiver has loaded a class for the object that has a 
	 * different serialVersionUID than that of the corresponding sender's 
	 * class, then deserialization will result in an InvalidClassException. A serializable 
	 * class can declare its own serialVersionUID explicitly by declaring a 
	 * field named serialVersionUID that must be static, final, and of type long
	 */
	private static final long serialVersionUID = 1L;
	
	private static Calculator calc = new Calculator();
	private static JFrame frame = new JFrame("Calculator"); 
	private static JTextField screen = new JTextField(16);
	private JPanel panel = new JPanel();
	private String arg1, arg2, arg3;
	
	private static JButton[] buttons = {new JButton("7"),new JButton("8"),new JButton("9"),new JButton("/"),new JButton("4"),
			new JButton("5"),new JButton("6"),new JButton("*"),new JButton("1"),new JButton("2"),new JButton("3"),new JButton("-"),new JButton("0"),
			new JButton("."),new JButton("CE"),new JButton("+"), new JButton("=")};
	
	public UserInterface() {
		arg1 = arg2 = arg3 = "";
		assembleParts();
	}
	
	/**
	 * Put together the parts of the calculator user interface
	 */
	private void assembleParts() {
		screen.setEditable(false);
		panel.add(screen);
		for(int button = 0; button<buttons.length; button++) {
			buttons[button].addActionListener(this);
			panel.add(buttons[button]);
		}
		frame.add(panel);
		frame.setSize(240, 300);
        frame.setVisible(true);	
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String input = arg0.getActionCommand();		
		char inputFirstChar = input.charAt(0);
		if ((Character.isDigit(inputFirstChar)) || inputFirstChar == '.') {
			// check if they entered an arg2

			if (!arg2.equals("")) {
				arg3 += input;
			}else {
				if(calc.isCleared()) {
					arg1=input;
				calc.setCleared(false);
				}
				else {					
					arg1 += input;
				}
			}

			// set the value of text
			screen.setText(arg1 + arg2 + arg3);

		} else if (input.charAt(0) == '=') {
			
			double result = calc.evaluateArguments(arg1, arg2, arg3, screen);

			//store result in arg1 as a string
			arg1 = Double.toString(result);

			arg2 = arg3 = "";
			
			calc.setCleared(true);
			
		} else if (inputFirstChar == 'C') {
			
			calc.clearScreen(arg1, arg2, arg3, screen);
			
		} else { 
			if (arg2.equals("") || arg3.equals("")){
            // if there was no operand
                arg2 = input;
			}
		 else {
                double result = calc.evaluateArguments(arg1,arg2,arg3,screen);
 
                // convert it to string
                arg1 = Double.toString(result);
 
                // place the operator
                arg2 = input;
 
                // make the operand blank
                arg3 = "";
            }
			screen.setText(arg1+arg2+arg3);
        }
		
	}
		
}

	

