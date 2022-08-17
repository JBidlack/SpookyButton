package spookyButtonGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spooky extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3256383923985192098L;
	private Dimension SIZE = new Dimension(400, 194);

	public Spooky() {
		
		ImageIcon skull = new ImageIcon("skull.png");
		JLabel skullLabel = new JLabel(skull);
		JFrame window= new JFrame("It's nearly October");
		JPanel panel = new JPanel();
		JLabel time = new JLabel("Time to get spooky!");
		JButton distance = new JButton("Yes");
		JButton temp = new JButton("Hell Yes");
		
		window.setPreferredSize(SIZE);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setPreferredSize(SIZE);
		panel.setLayout(new FlowLayout());
		
		panel.add(skullLabel);
		
		window.add(panel);
		window.pack();
		window.setVisible(true);
	}
}
