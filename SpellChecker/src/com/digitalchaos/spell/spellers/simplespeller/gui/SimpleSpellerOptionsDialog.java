package com.digitalchaos.spell.spellers.simplespeller.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;



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
public class SimpleSpellerOptionsDialog extends javax.swing.JDialog {
	private JPanel actBtnPanel;
	private JTextArea wordsTextArea;
	private JButton okBtn;
	private JScrollPane wordsScrollPane;
	private JPanel textsPanel;
	private JButton cancelBtn;

	
	boolean isAccepted;
	
	/**
	* Auto-generated main method to display this JDialog
	*/
		
	public SimpleSpellerOptionsDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			{
				textsPanel = new JPanel();
				getContentPane().add(textsPanel);
				textsPanel.setPreferredSize(new java.awt.Dimension(384, 218));
				{
					wordsScrollPane = new JScrollPane();
					textsPanel.add(wordsScrollPane);
					{
						wordsTextArea = new JTextArea();
						wordsScrollPane.setViewportView(wordsTextArea);

						wordsTextArea.setText("");
						wordsTextArea.setRows(50);
						wordsTextArea.setColumns(30);

					}
				}
			}
			{
				actBtnPanel = new JPanel();
				FlowLayout actBtnPanelLayout = new FlowLayout();
				actBtnPanelLayout.setAlignment(FlowLayout.RIGHT);
				actBtnPanel.setLayout(actBtnPanelLayout);
				getContentPane().add(actBtnPanel);
				actBtnPanel.setPreferredSize(new java.awt.Dimension(384, 29));
				{
					okBtn = new JButton();
					actBtnPanel.add(okBtn);
					okBtn.setText("Save");
					okBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							save();
						}
					});
				}
				{
					cancelBtn = new JButton();
					actBtnPanel.add(cancelBtn);
					cancelBtn.setText("Cancel");
					cancelBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							cancel();
						}
					});
				}
			}
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getWords()
	{
	     StringTokenizer st = new StringTokenizer( wordsTextArea.getText() );
	     
	     ArrayList<String> words = new ArrayList<String>();
	     
	     while (st.hasMoreTokens()) {
	    	 words.add(st.nextToken());
	     }		
		
		return words;
	}

	public void setWords(List<String> correctWords) {
		
		StringBuffer strBuff = new StringBuffer();
		
		for (String string : correctWords) {
			strBuff.append(string + "\n");
		}
		
		 wordsTextArea.setText(strBuff.toString());
		
	}

	
	
	
	public boolean isAccepted() {
		
		return isAccepted;
	}
	
	public void save()
	{
		isAccepted = true;
		setVisible(false);
	}
	
	public void cancel()
	{
		isAccepted = false;
		setVisible(false);
	}

}
