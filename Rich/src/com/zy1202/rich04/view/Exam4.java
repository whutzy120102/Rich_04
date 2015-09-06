package com.zy1202.rich04.view;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zy1202.rich04.model.Bomb;
import com.zy1202.rich04.model.Money;
import com.zy1202.rich04.model.Player;
import com.zy1202.rich04.model.Prop;


public class Exam4{
	static JFrame frame = new JFrame();
	static private List<Player> players=new ArrayList<>();
	
	
	public static void main(String[] args) {
		//add players
		Player player1=new Player(1, "banzi", "b", Color.BLUE, new Money(100, 0),null);
		Player player2=new Player(2, "yc", "b", Color.BLUE, new Money(0, 0),null);
		Player player3=new Player(3, "wgl", "b", Color.BLUE, new Money(100, 0),null);
		Player player4=new Player(4, "wgl", "b", Color.BLUE, new Money(100, 0),null);
		
		player1.getProps().add(new Bomb());
		player1.getProps().add(new Bomb());
		player1.getProps().add(new Bomb());
		
		player2.getProps().add(new Bomb());
		player2.getProps().add(new Bomb());
		player2.getProps().add(new Bomb());

		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		
		frame.setSize(800,300);             //第一个窗口
		frame.setLocation(500,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container=frame.getContentPane();
		container.setBackground(Color.white);   //容器
		container.setLayout(null);
		
		JPanel pnl=new JPanel();
		pnl.setSize(760,250);                  //面板
		pnl.setBackground(Color.white);
		pnl.setLocation(1,1);
		
		for(int i=0;i<players.size();i++){
		
		JButton button =new JButton("" +i);
		button.setSize(123,124);                                 //按钮  
		button.setLocation(10+200*i,40);
		ImageIcon icon=new ImageIcon("pic/actor_"+players.get(i).getId()+".jpg");
		button.setIcon(icon);
		button.setText(i+"");
		
		JLabel lae=new JLabel();
		lae.setText(players.get(i).getName());
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
				
				JButton button=(JButton)e.getSource();
				Player player=players.get(Integer.parseInt(button.getText()));
				
				lbl[0]=new JLabel("资产：");    //标签及其设置
				lbl[1]=new JLabel(player.getMoney().getCash()+"");
				lbl[2]=new JLabel();
				lbl[3]=new JLabel("点数:");
				lbl[4]=new JLabel(player.getMoney().getPoint()+"");
				lbl[5]=new JLabel("道具");
				lbl[6]=new JLabel();
				lbl[7]=new JLabel();
				lbl[8]=new JLabel();
				lbl[9]=new JLabel();
				
				
				
			    btn[0]=new JButton();
				btn[1]=new JButton();
				btn[2]=new JButton();
				btn[3]=new JButton();
				btn[4]=new JButton();
				btn[5]=new JButton();
				btn[6]=new JButton();
				btn[7]=new JButton();
				btn[8]=new JButton();
				btn[9]=new JButton();
				
				
				for(int i=0;i<player.getProps().size();i++){
					btn[i].setText(player.getProps().get(i).getName());
				}
				
				lbl[0].setForeground(Color.BLUE);
				lbl[3].setForeground(Color.BLUE);
				lbl[5].setForeground(Color.BLUE);
				Font fnt=new Font("楷体",Font.BOLD,20);
				lbl[0].setFont(fnt);
				lbl[3].setFont(fnt);
				lbl[5].setFont(fnt);
				
				for(int m=0;m<10;m++){container1.add(lbl[m]);}
				for(int t=0;t<10;t++){container1.add(btn[t]);}
			  
				
			}
				
			});
		
		
		}
		
		
	}
}
	
