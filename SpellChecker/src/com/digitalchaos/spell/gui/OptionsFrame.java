package com.digitalchaos.spell.gui;
import java.awt.FlowLayout;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.config.SpellerConfigurator;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class OptionsFrame extends JDialog {
	private JPanel buttonsPanel;
	private JPanel selectingPanel;
	private JLabel spellsNames;
	private JComboBox spellersCombo;
	private JButton advancedBtn;

	SpellerConfigurator spellerConfigurator;
	
	public OptionsFrame( JFrame parent , SpellerConfigurator spellerConfigurator) throws HeadlessException {
		
		//JCheckBox cacheChecker = new JCheckBox("use cache");
		//this.add(cacheChecker);

		super(parent);
		
		this.spellerConfigurator = spellerConfigurator;
		
		BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
		getContentPane().setLayout(thisLayout);
		{
			selectingPanel = new JPanel();
			getContentPane().add(selectingPanel);
			{
				spellsNames = new JLabel();
				selectingPanel.add(spellsNames);
				spellsNames.setText("spells");
			}
			{
				ComboBoxModel spellersComboModel = 
					new DefaultComboBoxModel(
							spellerConfigurator.getConfigNames().toArray() );
				
				spellersComboModel.setSelectedItem(spellerConfigurator.getDefaultConfigName());
				spellersCombo = new JComboBox();
				selectingPanel.add(spellersCombo);
				spellersCombo.setModel(spellersComboModel);
			}
			{
				advancedBtn = new JButton();
				selectingPanel.add(advancedBtn);
				advancedBtn.setText("advanced");
				advancedBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						showAdancedOptions();
					}
				});
			}
		}
		{
			buttonsPanel = new JPanel();
			FlowLayout buttonsPanelLayout = new FlowLayout();
			buttonsPanelLayout.setAlignment(FlowLayout.RIGHT);
			buttonsPanel.setLayout(buttonsPanelLayout);
			getContentPane().add(buttonsPanel);
			{
				JButton closeBtn = new JButton("OK");
				buttonsPanel.add(closeBtn);
				closeBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						closeFrameRequest();
					}
				});
			}
		}
		//closeBtn.setBounds(0, 0, 116, 23);
	}

	protected void showAdancedOptions() {
		String name = String.valueOf( spellersCombo.getSelectedItem() );
		SpellerConfig spellerConfig = this.spellerConfigurator.getConfig( name );
		spellerConfig.configurate();
	}

	protected void closeFrameRequest() {
		
		String name = String.valueOf( spellersCombo.getSelectedItem() );
		spellerConfigurator.setDefaultConfig(name);
		
		this.setVisible(false);
		
		this.dispose();
	}

}
