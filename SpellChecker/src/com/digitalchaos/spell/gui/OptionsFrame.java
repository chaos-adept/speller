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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class OptionsFrame extends JFrame {
	private JPanel buttonsPanel;
	private JPanel selectingPanel;
	private JLabel spellsNames;
	private JComboBox spellersCombo;
	private JButton advancedBtn;

	public OptionsFrame() throws HeadlessException {
		
		//JCheckBox cacheChecker = new JCheckBox("use cache");
		//this.add(cacheChecker);

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
							new String[] { "Item One", "Item Two" });
				spellersCombo = new JComboBox();
				selectingPanel.add(spellersCombo);
				spellersCombo.setModel(spellersComboModel);
			}
			{
				advancedBtn = new JButton();
				selectingPanel.add(advancedBtn);
				advancedBtn.setText("advanced");
			}
		}
		{
			buttonsPanel = new JPanel();
			FlowLayout buttonsPanelLayout = new FlowLayout();
			buttonsPanelLayout.setAlignment(FlowLayout.RIGHT);
			buttonsPanel.setLayout(buttonsPanelLayout);
			getContentPane().add(buttonsPanel);
			{
				JButton acceptBtn = new JButton("accept");
				buttonsPanel.add(acceptBtn);
				acceptBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						closeFrameRequest();
					}
				});
			}
			{
				JButton closeBtn = new JButton("close");
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

	protected void closeFrameRequest() {
		this.setVisible(false);
		
		this.dispose();
	}

}
