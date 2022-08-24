package spookyButtonGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HellYes extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5229950398104396393L;

	private Dimension SIZE = new Dimension(400, 400);
	private File audio = new File("hauntedHouse.wav");
	private AudioInputStream ais = AudioSystem.getAudioInputStream(audio.getAbsoluteFile());
	private Clip clip = AudioSystem.getClip();
	private ImageIcon doot = new ImageIcon("spookyhouse.gif");
	private Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
	private JFrame window= new JFrame("It's Nearly October");
	private JPanel panel = new JPanel();
	private JPanel countdownPanel = new JPanel();
	private JPanel graphicsPanel = new JPanel();
	private JLabel msg = new JLabel("");
	private JLabel skelly = new JLabel(doot);

	public HellYes() 
			throws LineUnavailableException, IOException, 
			UnsupportedAudioFileException  {


		window.setPreferredSize(SIZE);
		panel.setPreferredSize(SIZE);
		countdownPanel.setPreferredSize(new Dimension(400, 50));
		graphicsPanel.setPreferredSize(new Dimension(400, 350));
		
		window.setResizable(false);
		window.setIconImage(icon);
		
		panel.setLayout(new FlowLayout());
		countdownPanel.setLayout(new FlowLayout());
		graphicsPanel.setLayout(new FlowLayout());
		
		countdownPanel.add(skelly);
		graphicsPanel.add(skelly);
		
		panel.add(countdownPanel);
		panel.add(graphicsPanel);
		
		window.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				try {
					clip.open(ais);
				} catch (LineUnavailableException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				clip.flush();
				clip.stop();
			}	
		});

		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	
}
