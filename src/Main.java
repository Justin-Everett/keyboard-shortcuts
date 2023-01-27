import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Main{


	public static void main(String[] args) {
		JButton button;
		JPanel panel;
		JButton goBack;
		JFrame obj;
		Keyboard keyboard;
		
		obj = new JFrame();
		keyboard = new Keyboard();
		obj.setBounds(0, 0, 1270, 412);
		obj.setBackground(Color.black);
		obj.setResizable(false);
		obj.setTitle("Keyboard Shortcuts CAS Project");
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(keyboard);
		
		
		panel = new JPanel();
		panel.setBackground(Color.black);
		//panel.setLayout(new FlowLayout());
		
		button = new JButton("User Help");
		System.out.println("here");
		button.setBounds(1150,100, 150, 50);
		button.setFont(new Font("Sans_Serif", Font.BOLD, 15));
		button.setForeground(Color.black);
		button.setBackground(Color.cyan);
		button.setFocusable(false);
		button.addActionListener(new ActionListener() { 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Keyboard.state != 0) {
					Keyboard.state = 0;
				}
			}
		});
		
		goBack = new JButton("Go Back");
		goBack.setBounds(1150,100, 150, 50);
		goBack.setFont(new Font("Sans_Serif", Font.BOLD, 15));
		goBack.setForeground(Color.black);
		goBack.setBackground(Color.cyan);
		goBack.setFocusable(false);
		goBack.addActionListener(new ActionListener() { 	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Keyboard.state == 0) {
					Keyboard.state = 1;
				}
			}
		});
		
		//System.out.println("here as well");
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		panel.add(button);
		panel.add(goBack);
		obj.add(panel, BorderLayout.EAST);
		
		obj.setVisible(true);
		panel.setVisible(true);
		button.setVisible(true);
		goBack.setVisible(true);
		
	}
}
