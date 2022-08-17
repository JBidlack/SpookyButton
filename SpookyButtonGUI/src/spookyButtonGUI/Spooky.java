package spookyButtonGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		JFrame window= new JFrame("It's Nearly October");
		JPanel panel = new JPanel();
		JPanel graphicsPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel skullLabel = new JLabel(skull);
		JLabel time = new JLabel("Time to get spooky!");
		JButton yes = new JButton("Yes");
		JButton hellYes = new JButton("Hell Yes");
		
		window.setPreferredSize(SIZE);
		panel.setPreferredSize(SIZE);
		graphicsPanel.setPreferredSize(new Dimension(400, 87));
		buttonPanel.setPreferredSize(new Dimension(400, 97));
		yes.setPreferredSize(new Dimension(100, 30));
		hellYes.setPreferredSize(new Dimension(100, 30));
		
		window.setIconImage(icon);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setFont(new Font("Hellvetica", Font.PLAIN, 16));
		
		time.setFont(new Font("Hellvetica", Font.PLAIN, 14));
		
		graphicsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
		graphicsPanel.add(skullLabel);
		graphicsPanel.add(time);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		buttonPanel.add(yes);
		buttonPanel.add(hellYes);
		
		panel.setLayout(new FlowLayout());
		panel.add(graphicsPanel);
		panel.add(buttonPanel);
		
		window.add(panel);
		window.pack();
		window.setVisible(true);
	}
}
