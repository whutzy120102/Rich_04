package com.zy1202.rich04.view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

import com.zy1202.rich04.manager.GameManager;
import com.zy1202.rich04.model.Money;
import com.zy1202.rich04.model.Player;


public class StartGame_View extends JFrame{

	/**
	 * @param nifengchao
	 */

		static JFrame startFrame;
	    JLayeredPane layeredPane_1,layeredPane_2;  
	    JPanel jp_1,jp_2;  
	    JLabel jl_1,jl_2;  
	    ImageIcon background_1,background_2,icon1,icon2,icon3,start,apic_1,apic_2,apic_3,apic_4,reset_pic;  
	    JButton jb1,jb2,jb3,start_bt,actor_1,actor_2,actor_3,actor_4,reset_bt;  
	    
	    //输入文本
	    JTextField jtf;
	    
	    //文本
	    JLabel tA,aname_1,aname_2,aname_3,aname_4;
	    
	    //人数
	    int n=0;
	    int n2;//规定的人数
	    //金额
	    int w;
	    
	    private ButtonListener_1 bl = new ButtonListener_1();
	    
	    private ButtonListener_2 startlistener = new ButtonListener_2();
	    
	    private ButtonListener_3 actorlistener = new ButtonListener_3();
	    
	    private ButtonListener_4 resetListener = new ButtonListener_4();
	    
	    public static void main(String[] args)  
	    {  
	    	startFrame=new StartGame_View();  
	    	
	    	
	    }
	
	    public StartGame_View()  
	    {  
	        init();
	            
	    }
	    
	    /*点击选择游戏人物的事件响应*/
	    class ButtonListener_1 implements ActionListener{
			public void actionPerformed(ActionEvent e){
				int i = ((JButton)e.getSource()).getY();
				switch(i){
				case 240:n2=2;break;
				case 293:n2=3;break;
				case 346:n2=4;break;
				}
				init_2();
			}
		}
	    
	    /*点击开始游戏的事件响应*/
	    class ButtonListener_2 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				w = Integer.parseInt(jtf.getText());
				GameManager.setCash(w);
				System.out.println(w);
				for(Player player:GameManager.getPlayers()){
					System.out.println(player.toString());
				}
				startFrame.setVisible(false);
				new MapFrame();
			}
	    }
	    
	    
	    /*选择人物的button事件*/
	    
	    class ButtonListener_3 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(n<n2)
				{
					int i = ((JButton)e.getSource()).getX();
					switch(i){
					case 210:{
						aname_1.setForeground(Color.BLUE);
						n++;
						JLabel label_1=new JLabel();
						label_1.setOpaque(true);
						label_1.setBackground(Color.BLUE);
						label_1.setBounds(75,80, 5,5);
						Player player=new Player(1, "banzi", "b", Color.BLUE, new Money(0, 0),label_1);
						GameManager.addPlayer(player);
						break;
					}
					
					case 343:{
						aname_2.setForeground(Color.RED);
						n++;
						JLabel label_2=new JLabel();
						label_2.setOpaque(true);
						label_2.setBackground(Color.RED);
						label_2.setBounds(75,80, 5,5);
						Player player=new Player(2, "yc", "y", Color.RED, new Money(0, 0),label_2);
						GameManager.addPlayer(player);
						break;
					}
					case 476:{
						aname_3.setForeground(Color.yellow);
						n++;
						JLabel label_3=new JLabel();
						label_3.setOpaque(true);
						label_3.setBackground(Color.YELLOW);
						label_3.setBounds(75,80, 5,5);
						Player player=new Player(3, "wgl", "w", Color.YELLOW, new Money(0,0),label_3);
						GameManager.addPlayer(player);
						break;
					}
					case 609:{
						aname_4.setForeground(Color.GREEN);
						n++;
						JLabel label_4=new JLabel();
						label_4.setOpaque(true);
						label_4.setBackground(Color.GREEN);
						label_4.setBounds(75,80, 5,5);
						Player player=new Player(1, "pjh", "p", Color.GREEN, new Money(0,0),label_4);
						GameManager.addPlayer(player);
						break;
					}					}
				}
			}
	    }
	    /*点击重置游戏的事件响应*/
	    
	    class ButtonListener_4 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane_2.removeAll();
				init();
				n=0;
				w=0;
				GameManager.getPlayers().clear();
			}
	    }
	    
	    public int init_2(){
	    	layeredPane_1.removeAll();
	    	this.repaint();
	    	background_2 = new ImageIcon("pic/background_2.jpg");
	    	layeredPane_2 = new JLayeredPane(); 
	    	jp_2 = new JPanel();
	    	jp_2.setBounds(0, 0, background_2.getIconWidth(), background_2.getIconHeight());
	    	jl_2 = new JLabel(background_2);
	    	jp_2.add(jl_2);
	    	
	    	
	    	jtf = new JTextField(10);
	    	jtf.setBounds(200, 325, 200, 30);
	    	
	    	
	    	tA = new JLabel(" 提示：输入金额1000-50000");
	    	tA.setBounds(200+jtf.getWidth(), 325, 400,30);
	    	
	    	
	    	
	    	start = new ImageIcon("pic/start_bt.jpg");
	    	start_bt = new JButton(start);
	    	start_bt.setBorderPainted(false);
	        start_bt.setBounds(330,400,start.getIconWidth(),start.getIconHeight());
	        start_bt.addActionListener(startlistener);
	    	
	        
	        apic_1 = new ImageIcon("pic/actor_1.jpg");
	    	actor_1 = new JButton(apic_1);
	    	actor_1.setBorderPainted(false);
	    	actor_1.setBounds(210,100,apic_1.getIconWidth(),apic_1.getIconHeight());
	    	actor_1.addActionListener(actorlistener);
	    	
    	    apic_2 = new ImageIcon("pic/actor_2.jpg");
	    	actor_2 = new JButton(apic_2);
	    	actor_2.setBorderPainted(false);
	    	actor_2.setBounds(220+apic_1.getIconWidth(),100,apic_2.getIconWidth(),apic_2.getIconHeight());
	    	actor_2.addActionListener(actorlistener);
	    	
	    	apic_3 = new ImageIcon("pic/actor_3.jpg");
	    	actor_3 = new JButton(apic_3);
	    	actor_3.setBorderPainted(false);
	    	actor_3.setBounds(230+2*apic_1.getIconWidth(),100,apic_3.getIconWidth(),apic_3.getIconHeight());
	    	actor_3.addActionListener(actorlistener);
	    	
	    	apic_4 = new ImageIcon("pic/actor_4.jpg");
	    	actor_4 = new JButton(apic_4);
	    	actor_4.setBorderPainted(false);
	    	actor_4.setBounds(240+3*apic_1.getIconWidth(),100,apic_4.getIconWidth(),apic_4.getIconHeight());
	    	actor_4.addActionListener(actorlistener);
	    	
	    	aname_1 = new JLabel("阿土伯");
	    	aname_1.setBounds(250, 110+apic_1.getIconHeight(), 400,30);
	    	
	    	aname_2 = new JLabel("钱夫人");
	    	aname_2.setBounds(260+apic_1.getIconWidth(), 110+apic_1.getIconHeight(), 400,30);
	    	
	    	aname_3 = new JLabel("孙美美");
	    	aname_3.setBounds(270+2*apic_1.getIconWidth(), 110+apic_1.getIconHeight(), 400,30);
	    	
	    	aname_4 = new JLabel("金贝贝");
	    	aname_4.setBounds(280+3*apic_1.getIconWidth(), 110+apic_1.getIconHeight(), 400,30);
	    	
	    	reset_pic = new ImageIcon("pic/reset.jpg");
	    	reset_bt = new JButton(reset_pic);
	    	reset_bt.setBorderPainted(false);
	    	reset_bt.setBounds(304+start.getIconWidth()/2,470,reset_pic.getIconWidth(),reset_pic.getIconHeight());
	    	reset_bt.addActionListener(resetListener);
	    	
	    	
	    	
	    	layeredPane_2.add(jp_2,JLayeredPane.DEFAULT_LAYER);
	    	layeredPane_2.add(jtf,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(tA,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(start_bt,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(actor_1,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(actor_2,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(actor_3,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(actor_4,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(aname_1,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(aname_2,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(aname_3,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(aname_4,JLayeredPane.PALETTE_LAYER);
	    	layeredPane_2.add(reset_bt,JLayeredPane.PALETTE_LAYER);

	    	
	    	
	    	System.out.println(background_2.getIconWidth()+" "+background_2.getIconHeight());
	        SwingConsole.run(this,layeredPane_2,background_2.getIconWidth(),background_2.getIconHeight());
			return w;
	    }
	    
	    
	    
	    /*初始化界面一*/
		public void init() {

	    	this.repaint();
			layeredPane_1=new JLayeredPane();  
	        background_1=new ImageIcon("pic/background_1.jpg");
	        jp_1=new JPanel();  
	        jp_1.setBounds(0,0,background_1.getIconWidth(),background_1.getIconHeight());  
	        jl_1=new JLabel(background_1);  
	        jp_1.add(jl_1); 
	        icon1 = new ImageIcon("pic/TP_bt.jpg");
	        icon2 = new ImageIcon("pic/ThP_bt.jpg");
	        icon3 = new ImageIcon("pic/FP_bt.jpg");
	        
	        
	        
	        jb1=new JButton(icon1);
	        jb1.setBorderPainted(false);
	        jb1.setBounds(215,240,icon1.getIconWidth(),icon1.getIconHeight());
	        jb1.addActionListener(bl);
	        
	        
	        jb2=new JButton(icon2);  
	        jb2.setBorderPainted(false);
	        jb2.setBounds(215,250+icon1.getIconHeight(),icon2.getIconWidth(),icon2.getIconHeight());
	        jb2.addActionListener(bl);
	        
	        jb3=new JButton(icon3);  
	        jb3.setBorderPainted(false);
	        jb3.setBounds(215,260+icon2.getIconHeight()+icon1.getIconHeight(),icon3.getIconWidth(),icon3.getIconHeight());
	        jb3.addActionListener(bl);
	        
	        
	        
	        layeredPane_1.add(jp_1,JLayeredPane.DEFAULT_LAYER);  
	        layeredPane_1.add(jb1,JLayeredPane.PALETTE_LAYER);  
	        layeredPane_1.add(jb2,JLayeredPane.PALETTE_LAYER);
	        layeredPane_1.add(jb3,JLayeredPane.PALETTE_LAYER);
	        SwingConsole.run(this,layeredPane_1,background_1.getIconWidth(),background_1.getIconHeight());
	        
		}  
	}  


