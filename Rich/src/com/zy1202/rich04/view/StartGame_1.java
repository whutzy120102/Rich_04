package com.zy1202.rich04.view;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class StartGame_1 extends JFrame{

	/**
	 * @param args
	 */
		private JButton b1 = new JButton("开始游戏"),
		b2 = new JButton("结束游戏");
		
		private JTextField txt = new JTextField(10);
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String name = ((JButton)e.getSource()).getText();
				txt.setText(name);
			}
		}
		
		private ButtonListener bl = new ButtonListener();
		public StartGame_1() {
			b1.addActionListener(bl);
			b1.setBorderPainted(false);
			b2.addActionListener(bl);
			setLayout(new FlowLayout());
			add(b1);
			add(b2);
			add(txt);
			
		}
		
		public static void main(String[] args){
			SwingConsole.run(new StartGame_1(),1000,600);
			
		}

}
