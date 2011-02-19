package com.digitalchaos.spell.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.digitalchaos.spell.SimpleSpeller;
import com.digitalchaos.spell.Speller;

public class SpellerFrame extends JFrame {

	public static void main(String[] args) {
		
		Speller speller = new SimpleSpeller();
		JFrame frame = new SpellerFrame( speller );
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();

		frame.setVisible(true);		
		
	}
	
	Speller speller;
	protected JTextArea inputArea;

	public SpellerFrame(Speller speller) {
		
		//JFrame.setDefaultLookAndFeelDecorated(true);
		this.speller = speller;
		
		this.setTitle("Speller");

		this.setLayout(new FlowLayout());
		
		JLabel label = new JLabel();
		label.setText("text");
		this.add(label);
		
		inputArea = new JTextArea("word", 1, 10);
		this.add(inputArea);
		
		JButton checkBtn = new JButton("check");
		checkBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				checkText();
				
			}


		});
		
		this.add(checkBtn);
		
		JButton optionsBtn = new JButton("options");
		this.add(optionsBtn);	
		
		JButton closeBtn = new JButton("close");
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeFrameRequest();
				
			}


		});
		this.add(closeBtn);			
		
	}
	
	protected void checkText() {
		boolean isValid = speller.checkText( inputArea.getText() );
		JOptionPane.showMessageDialog(this,"texts is " + isValid);
	}	
	
	protected void closeFrameRequest() {
		setVisible(false);
		dispose();
	}
	
}