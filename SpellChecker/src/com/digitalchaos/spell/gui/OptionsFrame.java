package com.digitalchaos.spell.gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class OptionsFrame extends JFrame {

	public OptionsFrame() throws HeadlessException {
		
		//JCheckBox cacheChecker = new JCheckBox("use cache");
		//this.add(cacheChecker);
		
		JButton acceptBtn = new JButton("accept");
		acceptBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeFrameRequest();
			}
		});
		this.add(acceptBtn);		
		
		JButton closeBtn = new JButton("close");
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeFrameRequest();
			}
		});
		this.add(closeBtn);				
	}

	protected void closeFrameRequest() {
		this.setVisible(false);
		this.dispose();
	}

}
