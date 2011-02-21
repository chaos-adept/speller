package com.digitalchaos.spell.spellers.yandexspeller.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.digitalchaos.cache.CacheFactories;
import com.digitalchaos.cache.CacheOptions;


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
	
	CacheFactories cacheFactories;
	
	public YandexSpellerOptionsDialog( CacheFactories cacheFactories )
	{
		super();
		this.cacheFactories = cacheFactories;
		initGUI();
		
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			{
				cachePanel = new JPanel();
				getContentPane().add(cachePanel);
				FlowLayout cachePanelLayout = new FlowLayout();
				cachePanel.setLayout(cachePanelLayout);
				{
					useCacheCheckBox = new JCheckBox();
					cachePanel.add(useCacheCheckBox);
					useCacheCheckBox.setText("cache enable");
				}
				{
					ComboBoxModel providerComboBoxModel = 
						new DefaultComboBoxModel(
								cacheFactories.getCacheProviders() );
					providerComboBox = new JComboBox();
					cachePanel.add(providerComboBox);
					providerComboBox.setModel(providerComboBoxModel);
				}
			}
			{
				actionsPanel = new JPanel();
				getContentPane().add(actionsPanel);
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
	private JComboBox providerComboBox;
	private JCheckBox useCacheCheckBox;

	public boolean isCacheEnabled()
	{
		return useCacheCheckBox.isSelected();
	}
	
	public void setCacheEnabled(boolean isCacheEnabled)
	{
		this.useCacheCheckBox.setSelected(isCacheEnabled);
	}
	
	public CacheOptions genCacheOptions()
	{
		CacheOptions cacheOptions = new CacheOptions();
		cacheOptions.providerName = (String) this.providerComboBox.getSelectedItem();
		return cacheOptions;
	}
	
}
