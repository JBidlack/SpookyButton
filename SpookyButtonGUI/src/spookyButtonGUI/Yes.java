package spookyButtonGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Yes extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7163980045351978118L;
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
	private String halloween = "10312022";
	private LocalDate today = LocalDate.now();
	private LocalDate hw = LocalDate.parse(halloween, dtf);
	private long duration = ChronoUnit.DAYS.between(today, hw);
	private String remaining = Long.toString(duration);
	private Dimension SIZE = new Dimension(400, 400);
	private File audio = new File("trumpet.wav");
	private AudioInputStream ais = AudioSystem.getAudioInputStream(audio.getAbsoluteFile());
	private ImageIcon doot = new ImageIcon("doot.gif");
	private Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
	private JFrame window = new JFrame("It's Nearly October");
	private JPanel panel = new JPanel();
	private JPanel countdownPanel = new JPanel();
	private JPanel graphicsPanel = new JPanel();
	private JLabel skelly = new JLabel(doot);
	private Clip clip = AudioSystem.getClip();
	
	
	public Yes() 
			throws LineUnavailableException, IOException, 
			UnsupportedAudioFileException {

		
		window.setPreferredSize(SIZE);
		panel.setPreferredSize(SIZE);
		countdownPanel.setPreferredSize(new Dimension(400, 50));
		graphicsPanel.setPreferredSize(new Dimension(400, 350));
		
		window.setResizable(false);
		window.setIconImage(icon);
		panel.setLayout(new FlowLayout());
		countdownPanel.setLayout(new FlowLayout());
		graphicsPanel.setLayout(new FlowLayout());
	
		clip.open(ais);
		countdownPanel.add(daysLeft(duration));
		graphicsPanel.add(skelly);
		
		panel.add(countdownPanel);
		panel.add(graphicsPanel);
		clip.start();
		
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
	private JLabel daysLeft(long duration) {
		JLabel daysRemaining = new JLabel();
		
		if (duration == 0) {
			daysRemaining = new JLabel("IT'S TIME TO GET SPOOKY!!!!!");
		}
		
		if(duration > 0) {
			daysRemaining = new JLabel(remaining + " doots left!!");
		}
		else {
			hw.plusYears(1); 
			daysLeft(duration);
		}
		return daysRemaining;
	}
}
