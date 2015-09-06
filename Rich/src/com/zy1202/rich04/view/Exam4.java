package com.zy1202.rich04.view;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Exam4{
	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		frame.setSize(760,250);             //第一个窗口
		frame.setLocation(500,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container=frame.getContentPane();
		container.setBackground(Color.white);   //容器
		container.setLayout(null);
		
		JPanel pnl=new JPanel();
		pnl.setSize(760,250);                  //面板
		pnl.setBackground(Color.white);
		pnl.setLocation(1,1);
		
		for(int i=0;i<=3;i++){
		
		JButton button =new JButton("" +i);
		button.setSize(123,124);                                 //按钮  
		button.setLocation(10+200*i,40);
		ImageIcon icon=new ImageIcon("pic/actor_"+(i+1)+".jpg");
		button.setIcon(icon);
		
		JLabel lae=new JLabel();
		lae.setText("阿土伯");
		lae.setBounds(45+200*i,160,100,30);
		Font fnt1=new Font("楷体",Font.BOLD,13);
		lae.setFont(fnt1);
		
		pnl.setLayout(null);
		pnl.add(button);
		pnl.add(lae);
		container.add(button);
		container.add(lae);
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					
				GridLayout grid1=new GridLayout(4,5);   //grid布局 
				JFrame frame1 = new JFrame();
				frame1.setTitle("玩家详细信息");            //第二个窗口
				frame1.setLocation(250,250);
				frame1.setSize(500,300);
				frame1.setVisible(true);
				
				
				Container container1=frame1.getContentPane();//容器
				container1.setLayout(grid1);
				
				JLabel[] lbl=new JLabel[10];
				JButton[] btn=new JButton[10];
				
				lbl[0]=new JLabel("资产：");    //标签及其设置
				lbl[1]=new JLabel();
				lbl[2]=new JLabel();
				lbl[3]=new JLabel("点数:");
				lbl[4]=new JLabel();
				lbl[5]=new JLabel("道具");
				lbl[6]=new JLabel();
				lbl[7]=new JLabel();
				lbl[8]=new JLabel();
				lbl[9]=new JLabel();
				
			    btn[0]=new JButton(new ImageIcon(""));
				btn[1]=new JButton(new ImageIcon(""));
				btn[2]=new JButton(new ImageIcon(""));
				btn[3]=new JButton(new ImageIcon(""));
				btn[4]=new JButton(new ImageIcon(""));
				btn[5]=new JButton(new ImageIcon(""));
				btn[6]=new JButton(new ImageIcon(""));
				btn[7]=new JButton(new ImageIcon(""));
				btn[8]=new JButton(new ImageIcon(""));
				btn[9]=new JButton(new ImageIcon(""));
				
				lbl[0].setForeground(Color.BLUE);
				lbl[3].setForeground(Color.BLUE);
				lbl[5].setForeground(Color.BLUE);
				Font fnt=new Font("楷体",Font.BOLD,20);
				lbl[0].setFont(fnt);
				lbl[3].setFont(fnt);
				lbl[5].setFont(fnt);
				
				for(int m=0;m<10;m++){container1.add(lbl[m]);}
				for(int t=0;t<10;t++){container1.add(btn[t]);}
				
			  
				
			}});
		
		
		}
		
		
	}
}
	
