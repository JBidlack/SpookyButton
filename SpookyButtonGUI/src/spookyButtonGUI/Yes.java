package spookyButtonGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
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
    private static LocalDate today = LocalDate.now();
    private static String halloween = "1031"+ today.getYear();
	private LocalDate hw = LocalDate.parse(halloween, dtf);
	private long duration = ChronoUnit.DAYS.between(today, hw);
	private Dimension SIZE = new Dimension(400, 400);
	private URL urlAudio = this.getClass().getResource("/media/trumpet.wav");
	private AudioInputStream ais = AudioSystem.getAudioInputStream(urlAudio);
	private URL urlImg = this.getClass().getResource("/media/doot.gif");
	private ImageIcon doot = new ImageIcon(urlImg);
	private Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
	private JFrame window = new JFrame("It's Nearly October");
	private JPanel panel = new JPanel();
	private JPanel countdownPanel = new JPanel();
	private JPanel graphicsPanel = new JPanel();
	private JLabel skelly = new JLabel(doot);
	private Clip clip = AudioSystem.getClip();
	private int counter = 0;
	
	
	
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
		countdownPanel.add(daysLeft(duration, hw));
		graphicsPanel.add(skelly);
		
		panel.add(countdownPanel);
		panel.add(graphicsPanel);
		clip.start();
		
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
	private JLabel daysLeft(long duration, LocalDate date) {
		JLabel daysRemaining = new JLabel();
		
        if(duration < 0) {
            halloween = "1031"+ (today.getYear()+1);
            hw = LocalDate.parse(halloween, dtf);
            duration = ChronoUnit.DAYS.between(today, hw);
        }
		
		if (duration == 0) {
			daysRemaining = new JLabel("IT'S TIME TO GET SPOOKY!!!!!");
			return daysRemaining;
		}
		
		if(duration > 0) {
			daysRemaining = new JLabel(Long.toString(duration) + " doots left!!");
			return daysRemaining;
		}

		return daysRemaining;
	}
}
