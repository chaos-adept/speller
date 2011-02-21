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
			

			providerComboBox = new JComboBox();

			cachePanel.add(getEnablingPanel());
			cachePanel.add(getProviderPanel());
			cachePanel.add(getMemoryManagmentPanel());
			cachePanel.add(getMaxDiskElCountPanel());
			cachePanel.add(getDiskMangrAlgPanel());
			cachePanel.add(getMaxSizePanel());

				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void onChangedProviderValue() {
		Object newValue = this.providerComboBox.getSelectedItem();
	 	CacheFactory cacheFactory = cacheFactories.getFactory(String.valueOf(newValue));
		
	 	if (cacheFactory == null)
	 	{
	 		return;
	 	}
	 	
	 	this.memMangrComboModel.removeAllElements();
	 	for (String name : cacheFactory.getMemoryManagmentAlgorithmNames()) {
	 		this.memMangrComboModel.addElement(name);
		}
	 	
	 	this.diskManagrAlgthComboModel.removeAllElements();
	 	for (String name : cacheFactory.getDiskManagmentAlgorithmNames()) {
	 		this.diskManagrAlgthComboModel.addElement(name);
		}
	 	
	 	maxCountSpinner.setEnabled( cacheFactory.isCanBeLimited() );
	 	maxDiskElCountSpinner.setEnabled( cacheFactory.isCanBeLimited() );
	}

	protected void close() {
		this.setVisible(false);
		
	}
	private JPanel actionsPanel;
	private JPanel cachePanel;
	private JButton okBtn;
	private JComboBox diskManagrAlgthCombo;
	private JLabel diskMagrAlgLabel;
	private JPanel diskMangrAlgPanel;
	private JSpinner maxDiskElCountSpinner;
	private JLabel maxDiskElCountLabel;
	private JPanel maxDiskElCountPanel;
	private JComboBox memMangrCombo;
	private JLabel memoryMangLabel;
	private JPanel memoryManagmentPanel;
	private JPanel enablingPanel;
	private JLabel providerLabel;
	private JPanel providerPanel;
	private JLabel maxSizeLabel;
	private JPanel maxSizePanel;
	private JSpinner maxCountSpinner;
	private JComboBox providerComboBox;
	private JCheckBox useCacheCheckBox;
	protected DefaultComboBoxModel memMangrComboModel;
	protected DefaultComboBoxModel diskManagrAlgthComboModel;

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
		{
			this.providerComboBox.setSelectedIndex(0);
			return;
		}
			
		
		this.providerComboBox.setSelectedItem(options.providerName);
		
		this.maxCountSpinner.setValue( options.maxMemoryElementCount );
		this.maxDiskElCountSpinner.setValue( options.maxMemoryElementCount );
		
		onChangedProviderValue();
		
		this.memMangrCombo.setSelectedItem( options.diskManagmentAlgorithName );
		
		this.diskManagrAlgthCombo.setSelectedItem( options.diskManagmentAlgorithName );
		
		
		
	}
	
	public CacheOptions genCacheOptions()
	{
		CacheOptions cacheOptions = new CacheOptions();
		cacheOptions.providerName = (String) this.providerComboBox.getSelectedItem();
		cacheOptions.maxMemoryElementCount = (Integer) this.maxCountSpinner.getValue();
		cacheOptions.maxDiskElementCount = (Integer) this.maxDiskElCountSpinner.getValue();
		cacheOptions.memoryManagmentAlgorithmName = (String) this.memMangrCombo.getSelectedItem();
		cacheOptions.diskManagmentAlgorithName = (String) this.diskManagrAlgthCombo.getSelectedItem();
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
			maxSizeLabel.setText("max memory elements count");
		}
		return maxSizeLabel;
	}
	
	private JPanel getProviderPanel() {

		if ( providerPanel == null )
		{
			providerPanel = new JPanel();
			GridLayout providerPanelLayout = new GridLayout(1, 1);
			providerPanelLayout.setHgap(5);
			providerPanelLayout.setVgap(5);
			providerPanelLayout.setColumns(1);
			providerPanel.setLayout(providerPanelLayout);
			
			
			ComboBoxModel providerComboBoxModel = 
				new DefaultComboBoxModel(
						cacheFactories.getCacheProviders() );			
			providerComboBox = new JComboBox(providerComboBoxModel);
			providerComboBox.setModel(providerComboBoxModel);
			providerComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					onChangedProviderValue();
				}
			});		
			
			providerPanel.add(getProviderLabel());
			providerPanel.add(providerComboBox);			
			
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
	
	private JPanel getMemoryManagmentPanel() {
		if(memoryManagmentPanel == null) {
			memoryManagmentPanel = new JPanel();
			GridLayout memoryManagmentPanelLayout = new GridLayout(1, 1);
			memoryManagmentPanelLayout.setHgap(5);
			memoryManagmentPanelLayout.setVgap(5);
			memoryManagmentPanelLayout.setColumns(1);
			memoryManagmentPanel.setLayout(memoryManagmentPanelLayout);
			memoryManagmentPanel.add(getMemoryMangLabel());
			memoryManagmentPanel.add(getMemMangrCombo());
		}
		return memoryManagmentPanel;
	}
	
	private JLabel getMemoryMangLabel() {
		if(memoryMangLabel == null) {
			memoryMangLabel = new JLabel();
			memoryMangLabel.setText("memory management algorithm");
		}
		return memoryMangLabel;
	}
	
	private JComboBox getMemMangrCombo() {
		if(memMangrCombo == null) {
			memMangrComboModel = new DefaultComboBoxModel(
					new String[] { "Item One", "Item Two" });
			memMangrCombo = new JComboBox();
			memMangrCombo.setModel(memMangrComboModel);
		}
		return memMangrCombo;
	}
	
	private JPanel getMaxDiskElCountPanel() {
		if(maxDiskElCountPanel == null) {
			maxDiskElCountPanel = new JPanel();
			GridLayout maxDiskElCountPanelLayout = new GridLayout(1, 1);
			maxDiskElCountPanelLayout.setHgap(5);
			maxDiskElCountPanelLayout.setVgap(5);
			maxDiskElCountPanelLayout.setColumns(1);
			maxDiskElCountPanel.setLayout(maxDiskElCountPanelLayout);
			maxDiskElCountPanel.add(getMaxDiskElCountLabel());
			maxDiskElCountPanel.add(getMaxDiskElCountSpinner());
		}
		return maxDiskElCountPanel;
	}
	
	private JLabel getMaxDiskElCountLabel() {
		if(maxDiskElCountLabel == null) {
			maxDiskElCountLabel = new JLabel();
			maxDiskElCountLabel.setText("max disk element count");
		}
		return maxDiskElCountLabel;
	}
	
	private JSpinner getMaxDiskElCountSpinner() {
		if(maxDiskElCountSpinner == null) {
			SpinnerNumberModel maxDiskElCountSpinnerModel = 
				new SpinnerNumberModel(
						);
			maxDiskElCountSpinnerModel.setMinimum(0);
			maxDiskElCountSpinner = new JSpinner();
			maxDiskElCountSpinner.setModel(maxDiskElCountSpinnerModel);
		}
		return maxDiskElCountSpinner;
	}
	
	private JPanel getDiskMangrAlgPanel() {
		if(diskMangrAlgPanel == null) {
			diskMangrAlgPanel = new JPanel();
			GridLayout diskMangrAlgPanelLayout = new GridLayout(1, 1);
			diskMangrAlgPanelLayout.setHgap(5);
			diskMangrAlgPanelLayout.setVgap(5);
			diskMangrAlgPanelLayout.setColumns(1);
			diskMangrAlgPanel.setLayout(diskMangrAlgPanelLayout);
			diskMangrAlgPanel.add(getDiskMagrAlgLabel());
			diskMangrAlgPanel.add(getDiskManagrAlgthCombo());
		}
		return diskMangrAlgPanel;
	}
	
	private JLabel getDiskMagrAlgLabel() {
		if(diskMagrAlgLabel == null) {
			diskMagrAlgLabel = new JLabel();
			diskMagrAlgLabel.setText("disk managment algorithm");
		}
		return diskMagrAlgLabel;
	}
	
	private JComboBox getDiskManagrAlgthCombo() {
		if(diskManagrAlgthCombo == null) {
			diskManagrAlgthComboModel = new DefaultComboBoxModel(
					new String[] { "Item One", "Item Two" });
			diskManagrAlgthCombo = new JComboBox();
			diskManagrAlgthCombo.setModel(diskManagrAlgthComboModel);
		}
		return diskManagrAlgthCombo;
	}

}
