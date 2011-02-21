package com.digitalchaos.spell.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfigurator;

public class SpellerFrame extends JFrame {


	
	Speller speller;
	protected JTextArea inputArea;
	protected SpellerConfigurator spellerConfig;
	public SpellerFrame(Speller speller, SpellerConfigurator spellerConfig) {
		
		//JFrame.setDefaultLookAndFeelDecorated(true);
		this.speller = speller;
		this.spellerConfig = spellerConfig;
		
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
		optionsBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openSettings();
			}
		});
		
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
	
	protected void openSettings() {

		JDialog optionsDialog = new OptionsFrame( this , this.spellerConfig );
		
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		optionsDialog.setModal(true);
		optionsDialog.pack();

		optionsDialog.setVisible(true);	
		
		
		
		//TODO надо бы по хорошему спеллер вообще убрать из этого фрейма и сделать дата хелпер к которому он будет делать запросы
		speller = spellerConfig.getDefaultConfig().constructSpeller();
		
	}

	protected void checkText() {
		boolean isValid = speller.checkText( inputArea.getText() );
		JOptionPane.showMessageDialog(this,"text checked: " + isValid);
	}	
	
	protected void closeFrameRequest() {
		setVisible(false);
		dispose();
	}
	
}
