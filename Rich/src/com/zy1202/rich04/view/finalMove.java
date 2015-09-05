package com.zy1202.rich04.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class finalMove {
	private static CellView[] eachLocation=initCell();
	private static JFrame frame=new JFrame();
	private static JPanel panel=null;
	private static JButton btn=new JButton();
	private static JButton btnOver=new JButton("结束回合");
	private static JLabel label=new JLabel();
	private static int currentStep=0;
	
	public static void main(String args[]){
		frame.setTitle("");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(908, 608);
		
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕对象

		frame.getSize();//获取frame尺寸

		int w=(screen.width-frame.getWidth())/2;
		int h=(screen.height-frame.getHeight())/2;
		

		frame.setLocation(w,h);
		
		panel = new JPanel() {  
  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("f:\\road.jpg");  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(),  
                        icon.getIconHeight(), icon.getImageObserver());  
                
  
            }  
  
        };  
		panel.setSize(908,608);
		frame.setVisible(true);
		
		label.setOpaque(true);
		label.setBackground(Color.YELLOW);
		label.setBounds(78,524, 5,5);
		btn.setBounds(370, 319, 120, 120);
		btn.setMargin(new Insets(0, 0, 0, -10));
		btn.setBorderPainted(false);
		//btn.setContentAreaFilled(false);
		//ImageIcon iconBeginBtn = new ImageIcon("f:\\dice.png");  
		//btn.setIcon(iconBeginBtn);
		btnOver.setBounds(620, 119, 110, 20);
		panel.add(label);
		panel.add(btn);
		panel.add(btnOver);
		panel.setLayout(null);
		frame.add(panel);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					new Thread() {
					    public void run() {

					    	
					     int x=label.getX();
				    	 int y=label.getY();
				    	 java.util.Random random=new java.util.Random();
				    	 int randomNum=random.nextInt(6)+1;
				    	 
					     for(int i=0;i<randomNum;i++){
					    	 currentStep++;
					    	 if(currentStep>69)
					    		 currentStep=0;
					    	 
					    	 //label.repaint();
					    	 x=label.getX()+20;
					    	 y=label.getY();
					    	 label.setLocation(eachLocation[currentStep].getX(),eachLocation[currentStep].getY());
					    	 label.setBackground(Color.BLACK);
					    	 //btn.setText(randomNum+"");
					    	 String filePath=null;
					    	 switch(randomNum){
					    	 	case 1:filePath="f:\\1.png";break;
					    	 	case 2:filePath="f:\\2.png";break;
					    	 	case 3:filePath="f:\\3.png";break;
					    	 	case 4:filePath="f:\\4.png";break;
					    	 	case 5:filePath="f:\\5.png";break;
					    	 	case 6:filePath="f:\\6.png";break;
					    	 }
					    	 ImageIcon icon = new ImageIcon(filePath);  
					    	 btn.setIcon(icon);
					    	 btn.setEnabled(false);
					      try { sleep(200); } catch(Exception ex) {}
					     }
					    }
					   }.start();
					  
			}
		});
		btnOver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btn.setEnabled(true);
			}
		});
	}

	private static CellView[] initCell() {
		CellView[] location=new CellView[70];
		location[0]=new CellView(0,75,80);
		location[1]=new CellView(1,115,63);
		location[2]=new CellView(2,135,63);
		location[3]=new CellView(3,155,63);
		location[4]=new CellView(4,175,63);
		location[5]=new CellView(5,195,63);
		location[6]=new CellView(6,218,63);
		location[7]=new CellView(7,239,63);
		location[8]=new CellView(8,260,63);
		location[9]=new CellView(9,283,63);
		location[10]=new CellView(10,303,63);
		location[11]=new CellView(11,327,63);
		location[12]=new CellView(12,352,63);
		location[13]=new CellView(13,375,63);
		location[14]=new CellView(14,420,63);
		location[15]=new CellView(15,462,63);
		location[16]=new CellView(16,484,63);
		location[17]=new CellView(17,510,63);
		location[18]=new CellView(18,536,63);
		location[19]=new CellView(19,559,63);
		location[20]=new CellView(20,581,63);
		location[21]=new CellView(21,604,63);
		location[22]=new CellView(22,626,63);
		location[23]=new CellView(23,650,63);
		location[24]=new CellView(24,677,63);
		location[25]=new CellView(25,702,63);
		location[26]=new CellView(26,725,63);
		location[27]=new CellView(27,747,63);
		location[28]=new CellView(28,786,63);
		location[29]=new CellView(29,786,120);
		location[30]=new CellView(30,786,185);
		location[31]=new CellView(31,786,250);
		location[32]=new CellView(32,786,320);
		location[33]=new CellView(33,786,390);
		location[34]=new CellView(34,786,460);
		location[35]=new CellView(35,790,530);
		location[36]=new CellView(36,755,524);
		location[37]=new CellView(37,737,524);
		location[38]=new CellView(38,714,524);
		location[39]=new CellView(39,690,524);
		location[40]=new CellView(40,668,524);
		location[41]=new CellView(41,648,524);
		location[42]=new CellView(42,625,524);
		location[43]=new CellView(43,603,524);
		location[44]=new CellView(44,580,524);
		location[45]=new CellView(45,558,524);
		location[46]=new CellView(46,535,524);
		location[47]=new CellView(47,513,524);
		location[48]=new CellView(48,490,524);
		location[49]=new CellView(49,449,524);
		location[50]=new CellView(50,412,524);
		location[51]=new CellView(51,392,524);
		location[52]=new CellView(52,369,524);
		location[53]=new CellView(53,343,524);
		location[54]=new CellView(54,317,524);
		location[55]=new CellView(55,292,524);
		location[56]=new CellView(56,269,524);
		location[57]=new CellView(57,245,524);
		location[58]=new CellView(58,222,524);
		location[59]=new CellView(59,199,524);
		location[60]=new CellView(60,174,524);
		location[61]=new CellView(61,149,524);
		location[62]=new CellView(62,123,524);
		location[63]=new CellView(63,75,524);
		location[64]=new CellView(64,75,460);
		location[65]=new CellView(65,75,395);
		location[66]=new CellView(66,75,325);
		location[67]=new CellView(67,75,260);
		location[68]=new CellView(68,75,205);
		location[69]=new CellView(69,75,148);
		
		return location;
	}
}
