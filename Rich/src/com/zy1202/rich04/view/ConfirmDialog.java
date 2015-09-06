package com.zy1202.rich04.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ConfirmDialog extends JDialog{
	private String AreYoutSure;
	public ConfirmDialog(String AreYouSure){
		this.AreYoutSure=AreYouSure;
		this.setTitle(AreYouSure);
		this.setVisible(true);
		this.setLayout(null);
		
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕对象
		this.setSize(300, 120);
		this.getSize();//获取frame尺寸

		int w=(screen.width-this.getWidth())/2;
		int h=(screen.height-this.getHeight())/2+50;
		this.setLocation(w,h);

	}
	
}
