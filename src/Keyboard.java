import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Keyboard extends JPanel implements KeyListener, ActionListener {

	// drawing document sizes: 1148.33 by 376.05 pixels

	Timer timer;
	int delay = 100;
	static int state = 1;

	BufferedImage img;
	
	String blankImage = "/images/Base Keyboard.png";
	String ctrlImage = "/images/Control Keyboard.png";
	String ctrlAltImage ="/images/Ctrl + Alt Keyboard.png";
	String ctrlShiftImage ="/images/Control Shift Keyboard.png";
	String altImage ="/images/Alt Keyboard.png";
	String userHelpImage = "/images/userHelp (2).PNG";
	String windowsImage = "/images/Windows.png";
	String shiftImage = "/images/Shift Keyboard.png";
	
	String line1 = "How to use:";
	String line2 = "\tIn order to find a keyboard shortcut, hold the access key (for example control or alt).";
	String line3 = "\tThis will then light up the key(s) pressed, and display in orange which keys have keyboard shortcuts and what they do.";
	String line4 = "IMPORTANT:";
	String line5 = "\tNot all keyboard shortcuts are listed in this application.";
	String line6 = "\tIf you feel that any keyboard shortcuts should be added, please send an email to lo04068@student.isllondon.org";
	String line7 = "\tAdditionally, many keyboard shortcuts listed have multiple functions.";
	String line8 = "\tThis can change depending on the program you are trying to use these keyboard shortcuts in.";
	String line9 = "\tIf the desired keyboard shortcut is not working or is doing something you dont think it should, check on google by searching what the shortcut should do.";
	String line10 = "\tIf it turns out that a keyboard shortcut within this application is wrong, please email lo04068@student.isllondon.org to let us know.";
	String line11 = "This program was created by Justin Everett, Garrett Berry, and Walter Machado.";
	
	private static boolean ctrl = false;
	private static boolean shift = false;
	private static boolean alt = false;
	private static boolean windows = false;

	public void setState(int i) {
		state = i;
	}

	public Keyboard() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();

	}

	private void loadImage(String str) {
		try {
			img = ImageIO.read(Keyboard.class.getResource(str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println("State: " + state);
		//System.out.println("Alt: " + alt);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1170, 10000);
		if (state == 0) {
			loadImage(userHelpImage);
		} else if (state == 1) {
			loadImage(blankImage);
		} else if (state == 2) {
			loadImage(ctrlImage);
		} else if (state == 3) {
			loadImage(shiftImage);
		} else if (state == 4) {
			loadImage(altImage);
		} else if (state == 5) {
			loadImage(windowsImage);
		} else if (state == 6) {
			loadImage(ctrlShiftImage);
		} else if (state == 7) {
			loadImage(ctrlAltImage);
		}
		g.drawImage(img, 0, 0, 1148, 376, this);
	}

	public void checkState() {
		if (ctrl && shift && windows) {
			state = 15;
		} else if (ctrl && alt && windows) {
			state = 14;
		} else if (shift && alt && windows) {
			state = 13;
		} else if (ctrl && shift && alt) {
			state = 12;
		} else if (alt && windows) {
			state = 11;
		} else if (shift && windows) {
			state = 10;
		} else if (shift && alt) {
			state = 9;
		} else if (ctrl && windows) {
			state = 8;
		} else if (ctrl && alt) {
			state = 7;
		} else if (ctrl && shift) {
			state = 6;
		} else if (windows) {
			state = 5;
		} else if (alt) {
			state = 4;
		} else if (shift) {
			state = 3;
		} else if (ctrl) {
			state = 2;
		} else {
			state = 1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		e.consume();
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			this.ctrl = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			this.shift = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ALT) {
			this.alt = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_WINDOWS) {
			this.windows = true;
		}
		checkState();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		e.consume();
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			this.shift = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			this.ctrl = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_ALT) {
			this.alt = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_WINDOWS) {
			this.windows = false;
		}
		checkState();
		repaint();

	}

}
