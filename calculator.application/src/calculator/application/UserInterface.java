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
	
	
	private static JFrame frame = new JFrame("Calculator"); 
	private static JTextField screen = new JTextField(16);
	private JPanel panel = new JPanel();
	private String arg1, arg2, arg3;
	
	private static JButton[] numberButtons = {new JButton("0"),new JButton("1"),new JButton("2"),new JButton("3"),
			new JButton("4"),new JButton("5"),new JButton("6"),new JButton("7"),new JButton("8"),new JButton("9")};
	
	private static JButton[] functions = {new JButton("+"),new JButton("-"),new JButton("/"),
			new JButton("*"),new JButton("."),new JButton("C"), new JButton("=")};
	
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
		for(int button = 0; button<numberButtons.length; button++) {
			numberButtons[button].addActionListener(this);
			panel.add(numberButtons[button]);
		}
		for(int button = 0; button<functions.length; button++) {
			functions[button].addActionListener(this);
			panel.add(functions[button]);
		}
		
		frame.add(panel);
		frame.setSize(400, 450);
        frame.setVisible(true);		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	    }

	
}
