package com.digitalchaos.spell.spellers.yandexspeller.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JDialog;
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
public class YandexSpellerOptionsDialog extends JDialog {
	
	public YandexSpellerOptionsDialog()
	{
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				actionsPanel = new JPanel();
				getContentPane().add(actionsPanel, BorderLayout.CENTER);
				{
					okBtn = new JButton();
					actionsPanel.add(okBtn);
					okBtn.setText("OK");
					okBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							close();
						}
					});
				}
			}
			{
				cachePanel = new JPanel();
				getContentPane().add(cachePanel, BorderLayout.NORTH);
				{
					useCacheCheckBox = new JCheckBox();
					cachePanel.add(useCacheCheckBox);
					useCacheCheckBox.setText("cache enable");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void close() {
		this.setVisible(false);
		
	}
	private JPanel actionsPanel;
	private JPanel cachePanel;
	private JButton okBtn;
	private JCheckBox useCacheCheckBox;

	public boolean isCacheEnabled()
	{
		return useCacheCheckBox.isSelected();
	}
	
	public void setCacheEnabled(boolean isCacheEnabled)
	{
		this.useCacheCheckBox.setSelected(isCacheEnabled);
	}
	
}
