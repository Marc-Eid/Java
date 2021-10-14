import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;

public class FirstWindow extends JFrame{
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	public FirstWindow(){
		super("Border Layout Demonstration");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("First Label");
		add(label1, BorderLayout.NORTH);
		
		JLabel label2 = new JLabel("Second Label");
		add(label2, BorderLayout.SOUTH);
		
		JLabel label3 = new JLabel("Third Label");
		add(label3, BorderLayout.CENTER);
		
//		JButton endButton = new JButton("Click To End Program");
//		endButton.setBackground(Color.black);
//		endButton.addActionListener(new EndingListener());
//		add(endButton);
		
		
	}


}




