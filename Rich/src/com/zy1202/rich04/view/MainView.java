package com.zy1202.rich04.view;



import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import com.zy1202.rich04.manager.GameManager;
import com.zy1202.rich04.model.Bomb;
import com.zy1202.rich04.model.Cell;
import com.zy1202.rich04.model.DollMachine;
import com.zy1202.rich04.model.HouseCell;
import com.zy1202.rich04.model.Player;
import com.zy1202.rich04.model.RoadBlock;

	public class MainView { 

		static private List<Player> players;
		
		
		
	private JFrame jframeMain = new JFrame();
	JLayeredPane layeredPane_1,layeredPane_2;
	ImageIcon house_pic,location_pic,actor_pic,daojubt_pic,
	magicbt_pic,touzibt_pic,overbt_pic,buybt_pic,helpbt_pic,exitbt_pic;
	JButton daojubt,magicbt,touzibt,overbt,buybt,helpbt,exitbt;
	JLabel j1,j2,actor_now,house;
	int index;
	int t;

	// 用于分割两个（只能两个）component
	private JSplitPane jsplitPaneTestOne = new JSplitPane();
	private JSplitPane jsplitPaneTextTwo = new JSplitPane(  
			JSplitPane.VERTICAL_SPLIT);
	
	public MapFrame mf = new MapFrame();
	
	public MainView() {
	// 设置分隔条的位置
	
		init_RightView();
		init_LeftView();
	
	
	
	
	
	
	
	
	
	
	
	//设置jpanelMain的布局管理
	jframeMain.add(jsplitPaneTestOne);
	jframeMain.setTitle("Rich_v1.0_by RICH_04");
	jframeMain.setSize(910+location_pic.getIconWidth(), 766);
	jframeMain.setLocationRelativeTo(null);
	jframeMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframeMain.setVisible(true);
	}
	
	public void init_RightView(){
		
		
		//对左右整个分割线进行基本设定
		jsplitPaneTestOne.setDividerLocation(910);
		jsplitPaneTestOne.setDividerSize(1);
		jsplitPaneTestOne.setEnabled(false);
		
		
		
		// 将组件分配到分隔符的左边
		layeredPane_1 = new JLayeredPane();
		
		
		
		location_pic = new ImageIcon("pic/rightbackground.jpg");
		JLabel jl_2 = new JLabel(location_pic);
		jl_2.setBounds(0, 0, location_pic.getIconWidth(), location_pic.getIconHeight());
		
//		house_pic = new ImageIcon("pic/start_line.png");
		house = new JLabel();
		CellView cellView=GameManager.getMap().get(GameManager.getCurrentPlayer().getPosition());
		if(cellView.getCell().getType()==Cell.HOUSE){
			HouseCell cell=(HouseCell)cellView.getCell();
			if(cell.hasOwner()){
				house.setText(cell.getOwner().getName()+"的"+cell.getHouse().getRank()+"级房子");
			}else{
				house.setText("空地");
			}
			
		}else{
			house.setText(cellView.getCell().getName());
		}
		house.setBounds(70, 20, 100, 50);
		
		
		/*buybt_pic = new ImageIcon("pic/buybt.png");
		buybt = new JButton(buybt_pic);
        buybt.setBorderPainted(false);
		buybt.setBounds(location_pic.getIconWidth()-buybt_pic.getIconWidth()-20, 30, buybt_pic.getIconWidth(), buybt_pic.getIconHeight());
		buybt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// 响应对土地进行操作
				
				
				
			}
			
		});
		*/
		actor_pic = new ImageIcon("pic/actornow_0"+GameManager.getCurrentPlayer().getId()+".jpg");
		actor_now = new JLabel(actor_pic);
		actor_now.setBounds(70,150, actor_pic.getIconWidth(), actor_pic.getIconHeight());
		
		j1 = new JLabel("资金:"+GameManager.getCurrentPlayer().getMoney().getCash());
		j2 = new JLabel("点数:"+GameManager.getCurrentPlayer().getMoney().getPoint());
		j1.setBounds(100, 140+actor_pic.getIconHeight(),100, 50);
		j2.setBounds(100, 160+actor_pic.getIconHeight(),100, 50);
		
		
		
		/*掷骰子button*/
		touzibt_pic= new ImageIcon("pic/touzi_pic.jpg");
		touzibt = new JButton(touzibt_pic);
		touzibt.setBorderPainted(false);
		touzibt.setBounds(50, 250+actor_pic.getIconHeight(), touzibt_pic.getIconWidth(), touzibt_pic.getIconHeight());
		touzibt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// 掷骰子点击事件响应
				touzibt.setVisible(false);
				overbt.setVisible(true);
				mf.click(j1,j2,house);
			}
		});
		
		
		/*结束游戏button*/
		overbt_pic = new ImageIcon("pic/over_pic.jpg");
		overbt = new JButton(overbt_pic);
		overbt.setBorderPainted(false);
		overbt.setBounds(50, 250+actor_pic.getIconHeight(), touzibt_pic.getIconWidth(), touzibt_pic.getIconHeight());
		overbt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//结束回合点击事件响应
				mf.click_over();
				overbt.setVisible(false);
				
				Player currentPlayer=GameManager.getCurrentPlayer();
				j1.setText("资金:"+currentPlayer.getMoney().getCash());
				j2.setText("点数:"+currentPlayer.getMoney().getPoint());
				actor_pic = new ImageIcon("pic/actornow_0"+GameManager.getCurrentPlayer().getId()+".jpg");
				actor_now.setIcon(actor_pic);
				actor_now.setBounds(70,150, actor_pic.getIconWidth(), actor_pic.getIconHeight());
				
				//更新位置
				CellView cellView=GameManager.getMap().get(GameManager.getCurrentPlayer().getPosition());
				if(cellView.getCell().getType()==Cell.HOUSE){
					HouseCell cell=(HouseCell)cellView.getCell();
					if(cell.hasOwner()){
						house.setText(cell.getOwner().getName()+"的"+cell.getHouse().getRank()+"级房子");
					}else{
						house.setText("空地");
					}
				}else{
					house.setText(cellView.getCell().getName());
				}
				
				touzibt.setVisible(true);
			}
		});
		
		
		/*使用道具button*/
		daojubt_pic = new ImageIcon("pic/usedaoju_bt.jpg");
		daojubt = new JButton(daojubt_pic);
		daojubt.setBorderPainted(false);
		daojubt.setBounds(75, 280+overbt_pic.getIconHeight()+actor_pic.getIconHeight(), daojubt_pic.getIconWidth(), daojubt_pic.getIconHeight());
		daojubt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//使用道具点击事件响应
				
				GridLayout grid=new GridLayout(2,5);
				JFrame frame2=new JFrame();
				frame2.setTitle("道具");
				frame2.setLocation(250,250);
				frame2.setSize(500,300);
				frame2.setVisible(true);
				frame2.setResizable(false);
				
				Container container1=frame2.getContentPane();//容器
				container1.setLayout(grid);
				
				JButton[] btn=new JButton[10];
		
//				Player player=GameManager.getCurrentPlayer();
				Player player=new Player(1, "1", "1", null, null, null);
				player.getProps().add(new DollMachine());
				player.getProps().add(new Bomb());
				player.getProps().add(new RoadBlock());
				
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
				
				t=i;
				btn[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						
							
						JButton button=(JButton)e.getSource();
						
						
						
						switch(button.getText()){
						case "机器娃娃":{
							
							GridLayout grid1=new GridLayout(4,1);
							JFrame frame3=new JFrame();
							frame3.setLocation(400,250);
							frame3.setSize(300,300);
							frame3.setResizable(false);
							
							Container container=frame3.getContentPane();//容器
							container.setLayout(grid1);
							
							JLabel lab1=new JLabel("清除前方10格所有道具");
							JLabel lab2=new JLabel();
							JLabel lab3=new JLabel();
							JButton bttn1=new JButton("使用");
							bttn1.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									player.getProps().get(t).useProp(0);
									player.getProps().remove(player.getProps().get(t));
									btn[t].setText("");
									btn[t].removeActionListener(this);
									frame2.validate();
									frame3.setVisible(false);
									
								}
							});
							
							container.add(lab1);
							container.add(lab2);
							container.add(lab3);
							container.add(bttn1);
							frame3.setVisible(true);
							
							break;
						}
						
						
						
						
						case "炸弹" :{
							
							GridLayout grid1=new GridLayout(4,1);
							JFrame frame3=new JFrame();
							frame3.setLocation(400,250);
							frame3.setSize(300,300);
							frame3.setResizable(false);
							
							Container container=frame3.getContentPane();//容器
							container.setLayout(grid1);
							
							String[] data={"0","1","2","3","4","5","6","7","8","9","10"};
							
							JLabel lab1=new JLabel("可放置在前后10格，走到格子上时被扎伤送医院休息三个回合");
							JComboBox jc=new JComboBox(data);
							
							jc.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									JComboBox jb=(JComboBox)e.getSource();
									index=jb.getSelectedIndex();
									System.out.println(index);
								}
							});
							JButton bttn1=new JButton("在前面使用");
							bttn1.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									
									player.getProps().get(t).useProp(-index);
									player.getProps().remove(player.getProps().get(t));
									frame3.setVisible(false);
									btn[t].setText("");
									btn[t].removeActionListener(this);
									frame2.validate();
									
								}
							});
							JButton bttn2=new JButton("在后面使用");
							bttn2.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									player.getProps().get(t).useProp(index);
									player.getProps().remove(player.getProps().get(t));
									frame3.setVisible(false);
									btn[t].setText("");
									btn[t].removeActionListener(this);
									frame2.validate();
								}
							});
							
							
							container.add(lab1);
							container.add(jc);
							container.add(bttn1);
							container.add(bttn2);
							frame3.setVisible(true);
							
							break;
						}
						
						
						
						
						case "路障" :{ 
							
							
							GridLayout grid1=new GridLayout(4,1);
							JFrame frame3=new JFrame();
							frame3.setLocation(400,250);
							frame3.setSize(300,300);
							frame3.setResizable(false);
							
							Container container=frame3.getContentPane();//容器
							container.setLayout(grid1);
							
							String[] data={"0","1","2","3","4","5","6","7","8","9","10"};
							
							JLabel lab1=new JLabel("可在前后10格设置路障，经过的玩家被迫停止在该格");
							JComboBox jc=new JComboBox(data);
							jc.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									JComboBox jb=(JComboBox)e.getSource();
									index=jb.getSelectedIndex();
									System.out.println(index);

								}
							});
							JButton bttn1=new JButton("在前面使用");
							bttn1.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									player.getProps().get(t).useProp(-index);
									player.getProps().remove(player.getProps().get(t));
									
									frame3.setVisible(false);
									
									btn[t].setText("");
									btn[t].removeActionListener(this);
									frame2.validate();
								}
							});
							JButton bttn2=new JButton("在前面使用");
							bttn2.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									player.getProps().get(t).useProp(index);
									player.getProps().remove(player.getProps().get(t));
									frame3.setVisible(false);
									btn[t].setText("");
									btn[t].removeActionListener(this);
									frame2.validate();
								}
							});
							
							container.add(lab1);
							container.add(jc);
							container.add(bttn1);
							container.add(bttn2);
							frame3.setVisible(true);
							
							
							break;
						}
						default:break;
						}
						
						
						
					}
					
					
					
					
					
				});
				
				
				}
				
				for(int t=0;t<10;t++){container1.add(btn[t]);}
				
				
			}
		});
		
		
		
		/*使用魔法button*/
		magicbt_pic = new ImageIcon("pic/usemofa_bt.jpg");
		magicbt = new JButton(magicbt_pic);
		magicbt.setBorderPainted(false);
		magicbt.setBounds(75, 300+overbt_pic.getIconHeight()+actor_pic.getIconHeight()+daojubt_pic.getIconHeight(), magicbt_pic.getIconWidth(), magicbt_pic.getIconHeight());
		magicbt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//使用魔法点击事件响应
			}
		});
		
		
		/*帮助button*/
		helpbt_pic = new ImageIcon("pic/help_bt.jpg");
		helpbt = new JButton(helpbt_pic);
		helpbt.setBorderPainted(false);
		helpbt.setBounds(20, 690, helpbt_pic.getIconWidth(), helpbt_pic.getIconHeight());
		helpbt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//帮助点击事件响应
				new Help_View();
			}
		});
		
		
		/*退出游戏button*/
		exitbt_pic = new ImageIcon("pic/exit_bt.jpg");
		exitbt = new JButton(exitbt_pic);
		exitbt.setBorderPainted(false);
		exitbt.setBounds(150, 690, exitbt_pic.getIconWidth(), exitbt_pic.getIconHeight());
		exitbt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//退出点击事件响应
				new Exit_View();
				
				
				
			}
		});
		
		
		layeredPane_1.add(jl_2,JLayeredPane.DEFAULT_LAYER);
		layeredPane_1.add(house,JLayeredPane.PALETTE_LAYER);
//		layeredPane_1.add(buybt,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(actor_now,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(j1,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(j2,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(touzibt,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(overbt,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(daojubt,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(magicbt,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(helpbt,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(exitbt,JLayeredPane.PALETTE_LAYER);

		jsplitPaneTestOne.setRightComponent(layeredPane_1);
	}
	
	
	
	public void init_LeftView(){
		jsplitPaneTextTwo.setDividerLocation(570);  
		//设置分隔条的大小  
		jsplitPaneTextTwo.setDividerSize(1);  
		//快速展开/折叠分隔条（默认为false）  
		jsplitPaneTextTwo.setOneTouchExpandable(false);
		house_pic = new ImageIcon("pic/background_1.jpg");
//		JPanel j  = new JPanel() {  
//  
//            protected void paintComponent(Graphics g) {  
//                ImageIcon icon = new ImageIcon("pic/background_1.jpg");  
//                Image img = icon.getImage();  
//                g.drawImage(img, 0, 0, icon.getIconWidth(),  
//                        icon.getIconHeight(), icon.getImageObserver());  
//            }  
//  
//        };  
		
		JPanel mapPanel=mf.doMain();

		
		
		jsplitPaneTextTwo.setLeftComponent(mapPanel);  
		jsplitPaneTextTwo.setRightComponent(new Exam4().bottomBut());
		jsplitPaneTestOne.setLeftComponent(jsplitPaneTextTwo);
		
		
		
		
		
	}
	




//	public static void main(String[] args) {
//		
//		new MainView();
//		
//		
//		
//	}

}
