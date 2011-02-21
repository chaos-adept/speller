package com.digitalchaos.spell.spellers.yandexspeller.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import com.digitalchaos.cache.CacheFactories;
import com.digitalchaos.cache.CacheFactory;
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
				BoxLayout cachePanelLayout = new BoxLayout(cachePanel, javax.swing.BoxLayout.Y_AXIS);
				cachePanel.setLayout(cachePanelLayout);
			}
			{
				actionsPanel = new JPanel();
				FlowLayout actionsPanelLayout = new FlowLayout();
				actionsPanelLayout.setAlignment(FlowLayout.RIGHT);
				actionsPanel.setLayout(actionsPanelLayout);
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
			
			getEnablingPanel();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void onCahngedProviderValue() {
		Object newValue = this.providerComboBox.getSelectedItem();
	 	CacheFactory cacheFactory = cacheFactories.getFactory(String.valueOf(newValue));
		
	 	if (cacheFactory == null)
	 	{
	 		return;
	 	}
	 	
	 	maxCountSpinner.setEnabled( cacheFactory.isCanBeLimited() );
	 	
	}

	protected void close() {
		this.setVisible(false);
		
	}
	private JPanel actionsPanel;
	private JPanel cachePanel;
	private JButton okBtn;
	private JPanel enablingPanel;
	private JLabel providerLabel;
	private JPanel providerPanel;
	private JLabel maxSizeLabel;
	private JPanel maxSizePanel;
	private JSpinner maxCountSpinner;
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
	
	public void setCacheOptions(CacheOptions options)
	{
		if (options == null)
			return;
		
		this.providerComboBox.setSelectedItem(options.providerName);
		
		this.maxCountSpinner.setValue( options.maxElementCount );
		
		onCahngedProviderValue();
	}
	
	public CacheOptions genCacheOptions()
	{
		CacheOptions cacheOptions = new CacheOptions();
		cacheOptions.maxElementCount = (Integer) this.maxCountSpinner.getValue();
		cacheOptions.providerName = (String) this.providerComboBox.getSelectedItem();
		return cacheOptions;
	}
	
	private JSpinner getMaxCountSpinner() {
		if(maxCountSpinner == null) {
			SpinnerNumberModel maxCountSpinnerModel = 
				new SpinnerNumberModel(
						);
			
			maxCountSpinnerModel.setMinimum(0);
			
			maxCountSpinner = new JSpinner();
			maxCountSpinner.setModel(maxCountSpinnerModel);
			maxCountSpinner.setEnabled(false);
			maxCountSpinner.setPreferredSize(new java.awt.Dimension(53, 23));
		}
		return maxCountSpinner;
	}
	
	private JPanel getMaxSizePanel() {
		if(maxSizePanel == null) {
			maxSizePanel = new JPanel();
			GridLayout maxSizePanelLayout = new GridLayout(1, 1);
			maxSizePanelLayout.setHgap(5);
			maxSizePanelLayout.setVgap(5);
			maxSizePanelLayout.setColumns(1);
			maxSizePanel.setLayout(maxSizePanelLayout);
			maxSizePanel.add(getMaxSizeLabel());
			maxSizePanel.add(getMaxCountSpinner());
		}
		return maxSizePanel;
	}
	
	private JLabel getMaxSizeLabel() {
		if(maxSizeLabel == null) {
			maxSizeLabel = new JLabel();
			maxSizeLabel.setText("maxsize");
		}
		return maxSizeLabel;
	}
	
	private JPanel getProviderPanel() {
		if(providerPanel == null) {
			providerPanel = new JPanel();
			GridLayout providerPanelLayout = new GridLayout(1, 1);
			providerPanelLayout.setHgap(5);
			providerPanelLayout.setVgap(5);
			providerPanelLayout.setColumns(1);
			providerPanel.setLayout(providerPanelLayout);
			{
				ComboBoxModel providerComboBoxModel = 
					new DefaultComboBoxModel(
							cacheFactories.getCacheProviders() );
				providerComboBox = new JComboBox();
				providerPanel.add(getProviderLabel());
				providerPanel.add(providerComboBox);
				cachePanel.add(getEnablingPanel());
				cachePanel.add(getProviderPanel());
				cachePanel.add(getMaxSizePanel());
				providerComboBox.setModel(providerComboBoxModel);
				providerComboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						onCahngedProviderValue();
					}
				});
				
			}
		}
		return providerPanel;
	}
	
	private JLabel getProviderLabel() {
		if(providerLabel == null) {
			providerLabel = new JLabel();
			providerLabel.setText("cache provider");
		}
		return providerLabel;
	}
	
	private JPanel getEnablingPanel() {
		if(enablingPanel == null) {
			enablingPanel = new JPanel();
			FlowLayout enablingPanelLayout = new FlowLayout();
			enablingPanelLayout.setAlignment(FlowLayout.LEFT);
			enablingPanel.setLayout(enablingPanelLayout);
			{
				useCacheCheckBox = new JCheckBox();
				enablingPanel.add(useCacheCheckBox);
				useCacheCheckBox.setText("cache enable");
			}
		}
		return enablingPanel;
	}

}
