import javax.swing.*;
import java.awt.event.*;

class MyWindowBasic
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("My Window");

		frame.setSize(500,500);
		frame.setLayout(null);
		// frame.setLayout(new FlowLayout()); // makes everything left to right
		JButton btn1 = new JButton("Click me");
		btn1.setBounds(100,100,100,30);
		frame.add(btn1);
		
		// btn1.addActionListener(new ActionListener() // anonymous class
		// {
		// 	public void actionPerformed(ActionEvent e)
		// 	{
		// 		JOptionPane.showMessageDialog(null,"I cant believe you clicked me");
		// 	}
			
		// }); 
		btn1.addActionListener((ActionEvent e)->
		{
			JOptionPane.showMessageDialog(null,"I cant believe you clicked me");
		});


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}