package spookyButtonGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Spooky extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3130845282986037923L;

	private int counter = 0;
	private Dimension SIZE = new Dimension(400, 194);
	private ImageIcon skull;
	private Image icon;
	private JFrame window;
	private JPanel panel;
	private JPanel graphicsPanel;
	private JPanel buttonPanel;
	private JLabel skullLabel;
	private JLabel time;
	private JButton yes;
	private JButton hellYes;
	private URL url = this.getClass().getResource("/media/skull.png");

	public Spooky() {
		
		skull = new ImageIcon(url);
		icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		window= new JFrame("It's Nearly October");
		panel = new JPanel();
		graphicsPanel = new JPanel();
		buttonPanel = new JPanel();
		skullLabel = new JLabel(skull);
		time = new JLabel("Time to get spooky!");
		yes = new JButton("Yes");
		hellYes = new JButton("Hell Yes");

		window.setPreferredSize(SIZE);
		panel.setPreferredSize(SIZE);
		graphicsPanel.setPreferredSize(new Dimension(400, 87));
		buttonPanel.setPreferredSize(new Dimension(400, 97));
		yes.setPreferredSize(new Dimension(100, 30));
		hellYes.setPreferredSize(new Dimension(100, 30));
		
		window.setIconImage(icon);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);;
		window.setFont(new Font("Hellvetica", Font.PLAIN, 16));
		
		time.setFont(new Font("Hellvetica", Font.PLAIN, 14));
		yes.addActionListener(e -> {
			try {
				falseButton(counter);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		hellYes.addActionListener(hy -> {
			try {
				Yes hell = new Yes();
				
			} catch (LineUnavailableException | IOException | 
					UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
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
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	private void falseButton(int counter) throws UnsupportedAudioFileException, IOException
	, LineUnavailableException, InterruptedException {
		
		URL wrong = this.getClass().getResource("/media/wrong.wav");
		AudioInputStream ais1 = AudioSystem.getAudioInputStream(wrong);
		
		Clip clip = AudioSystem.getClip();
		
		if(counter == 0) {
			clip.open(ais1);
			clip.start();
			TimeUnit.MILLISECONDS.sleep(1250);
			JOptionPane.showMessageDialog(null,  "I can't HEAR you!");
			this.counter++;
			clip.close();
		}
		else if(counter == 1) {
			clip.open(ais1);
			clip.start();
			TimeUnit.MILLISECONDS.sleep(1500);
			JOptionPane.showMessageDialog(null,  "I SAID... I can't HEAR you!");
			this.counter++;
			clip.close();
		}
		else if(counter == 2) {
			clip.open(ais1);
			clip.start();
			yes.setEnabled(false);
			TimeUnit.MILLISECONDS.sleep(3500);
			JOptionPane.showMessageDialog(null,  "You clearly aren't enthusiastic enough... Let me help....");
			counter++;
			clip.close();
		}
		
	}
}
