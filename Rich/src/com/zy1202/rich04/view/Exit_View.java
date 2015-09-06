package com.zy1202.rich04.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Exit_View extends JFrame{
	
	
	private JLayeredPane layeredPane_1 ;
	
	private JButton yesbt,nobt;
	public  Exit_View exit ;
	
	public static void main(String[] args) {
		
		 new Exit_View();
	}
	Exit_View(){
		init();
	}
	
	
	public void init(){
		exit=this;
		layeredPane_1 = new JLayeredPane();
		JLabel jl = new JLabel("确定退出？");
		jl.setBounds(10, 0, 100, 60);
		yesbt = new JButton("YES!");
		yesbt.setBounds(50, 60, 60, 30);
		yesbt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		
		
		nobt = new JButton("NO!");
		nobt.setBounds(150, 60, 60, 30);
		nobt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				exit.setVisible(false);
			}});
		
		
		
		layeredPane_1.add(jl,JLayeredPane.DEFAULT_LAYER);
		layeredPane_1.add(yesbt,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(nobt,JLayeredPane.PALETTE_LAYER);
		
		
		this.setLayeredPane(layeredPane_1);
		this.setLocation(555, 333);
		this.setSize(300,150);
		this.setVisible(true);
		
		
		
	}

}
