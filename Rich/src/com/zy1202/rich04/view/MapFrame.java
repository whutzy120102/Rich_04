package com.zy1202.rich04.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.util.Iterator;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.zy1202.rich04.manager.GameManager;
import com.zy1202.rich04.model.Bomb;
import com.zy1202.rich04.model.Cell;
import com.zy1202.rich04.model.DollMachine;
import com.zy1202.rich04.model.Gift;
import com.zy1202.rich04.model.GiftCell;
import com.zy1202.rich04.model.HospitalCell;
import com.zy1202.rich04.model.House;
import com.zy1202.rich04.model.HouseCell;
import com.zy1202.rich04.model.Magic;
import com.zy1202.rich04.model.MagicCell;
import com.zy1202.rich04.model.MineCell;
import com.zy1202.rich04.model.Player;
import com.zy1202.rich04.model.PrisonCell;
import com.zy1202.rich04.model.Prop;
import com.zy1202.rich04.model.PropCell;
import com.zy1202.rich04.model.RoadBlock;

public class MapFrame {
	private List<CellView> eachLocation;
	private List<JLabel> labelList;
	private JPanel panel;
	private JButton btn;
//	private JButton btnOver;
	private JLabel label;

	
	public MapFrame(){
		eachLocation=initCell();
		labelList=initLabel();
		initLabel();
		GameManager.initMap(eachLocation);
		panel=null;
		btn=new JButton();
	}
	
	public JPanel doMain(){
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕对象

		panel = new JPanel() {  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("pic/road.jpg");  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(),  
                        icon.getIconHeight(), icon.getImageObserver());  
            }  
        };  
		panel.setSize(908,608);
//		frame.setVisible(true);
		
		Player player=null;
		Iterator it=GameManager.getPlayers().iterator();
		while(it.hasNext()){
			player=(Player) it.next();
			panel.add(player.getLabel());
		}

		btn.setBounds(370, 319, 120, 120);
		btn.setMargin(new Insets(0, 0, 0, 0));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		ImageIcon iconBeginBtn = new ImageIcon("pic/dice.png");  
		btn.setIcon(iconBeginBtn);
//		btnOver.setBounds(620, 119, 110, 20);
		
		panel.add(btn);
//		panel.add(btnOver);
		panel.setLayout(null);
//		frame.add(panel);
		
		
		return panel;
	}
	
	public void click_over(){
		btn.setEnabled(true);
		GameManager.toNextPlayer();
	}
	
	public void click(JLabel lab_cash,JLabel lab_point,JLabel lab_position){
				new Thread() {
				    public void run() {
				    //获取随机数
			    	 int randomNum=GameManager.getCurrentPlayer().throwDice();
			    	 
			    	 Player player=GameManager.getCurrentPlayer();
			    	 label=player.getLabel();
			    	 int position=player.getPosition();
				     for(int i=0;i<randomNum;i++){
				    	 //角色移动，一步一步移
				    	 position++;
				    	 if(position>69)
				    		 position=0;
				    	 player.setPositioin(position);
				    	 label.setLocation(eachLocation.get(position).getX()-5,eachLocation.get(position).getY()-5);
				    	 String filePath=null;
				    	 switch(randomNum){
				    	 	case 1:filePath="pic/1.png";break;
				    	 	case 2:filePath="pic/2.png";break;
				    	 	case 3:filePath="pic/3.png";break;
				    	 	case 4:filePath="pic/4.png";break;
				    	 	case 5:filePath="pic/5.png";break;
				    	 	case 6:filePath="pic/6.png";break;
				    	 }
				    	 ImageIcon icon = new ImageIcon(filePath);  
				    	 btn.setIcon(icon);
//				    	 btn.setEnabled(false);
				    	 
				    	 if(GameManager.getMap().get(position).getCell().hasRoadBlock()){
				    		 GameManager.getMap().get(position).getCell().reduceRoadBlock();
				    		 break;//碰到路障
				    	 }
				    	 try { sleep(200); } catch(Exception ex) {}
				     }
				     //刷新主界面位置
				     CellView cellView=GameManager.getMap().get(GameManager.getCurrentPlayer().getPosition());
						if(cellView.getCell().getType()==Cell.HOUSE){
							HouseCell cell=(HouseCell)cellView.getCell();
							if(cell.hasOwner()){
								lab_position.setText(cell.getOwner().getName()+"的"+cell.getHouse().getRank()+"级房子");
							}else{
								lab_position.setText("空地");
							}
							
						}else{
							lab_position.setText(cellView.getCell().getName());
						}
						
				     switch(GameManager.getMap().get(player.getPosition()).getCell().getType()){
				     	case Cell.HOSPITAL:{
				     		// HospitalCell cell=(HospitalCell)GameManager.getMap().get(GameManager.getCurrentPlayer().getPosition()).getCell();
				     		break;}
				     	case Cell.HOUSE:{
				     		HouseCell cell=(HouseCell)GameManager.getMap().get(player.getPosition()).getCell();
				    	 	if(cell.hasOwner()){//土地有主
				    		 	if(cell.getOwner().equals(player)){
				    			 	//TODO 弹框提示升级
				    		 		ConfirmDialog dialogUpdate=new ConfirmDialog("是否升级现有房屋？");
				    		 		JButton yesButton=new JButton("确定");
				    				JButton noButton=new JButton("放弃");
				    				if(player.getMoney().getCash() < cell.getHouse().getPrice())
				    					yesButton.setEnabled(false);
				    				yesButton.setBounds(25, 15, 100, 50);
				    				yesButton.addActionListener(
				    					new ActionListener(){
				    						public void actionPerformed(ActionEvent e){
				    							player.getMoney().reduceCash(cell.getHouse().getPrice());
				    							
				    							lab_cash.setText("资金"+player.getMoney().getCash());
				    							cell.getHouse().upRank();
				    							int rank=cell.getHouse().getRank();
				    							int position=player.getPosition();
				    							CellView cellview=eachLocation.get(player.getPosition());
				    							JLabel label=labelList.get(position);
				    							if(position>=0&&position<=28)
				    								label.setBounds(cellview.getX()-7, cellview.getY()-40, 25	, 25);
				    							else if(position>28&&position<=35)
				    								label.setBounds(cellview.getX()+50, cellview.getY(), 25	, 25);
				    							else if(position>35&&position<=63)
				    								label.setBounds(cellview.getX()-7, cellview.getY()+40, 25	, 25);
				    							else if(position>63&&position<70)
				    								label.setBounds(cellview.getX()-50, cellview.getY()+40, 25	, 25);
				    							ImageIcon icon = new ImageIcon("pic/"+player.getId()+"-"+rank+".png");  
				    							label.setIcon(icon);
				    							panel.add(label);
				    							panel.repaint();
				    							
				    							
				    							dialogUpdate.dispose();
				    						}});
				    				noButton.addActionListener(
					    				new ActionListener(){
					    					public void actionPerformed(ActionEvent e){
					    						dialogUpdate.dispose();
					    					}});
				    				noButton.setBounds(165, 15, 100, 50);
				    				dialogUpdate.add(noButton);
				    				
				    				dialogUpdate.add(yesButton);
				    		 		
				    		 	}else{//收过路费
				    		 		player.getMoney().reduceCash(cell.getHouse().getPrice()/2);
    								lab_cash.setText("资金"+player.getMoney().getCash());

	    							
	    							if(player.getMoney().getCash()>0){
					    		 		ConfirmDialog dialogUpdate=new ConfirmDialog("您需要缴纳过路费： "+cell.getHouse().getPrice()/2);
					    		 		JButton yesButton=new JButton("确定");
					    				
					    				yesButton.setBounds(90, 15, 100, 50);
					    				yesButton.addActionListener(
					    					new ActionListener(){
					    						public void actionPerformed(ActionEvent e){
					    							cell.getOwner().getMoney().addCash(cell.getHouse().getPrice());
					    							dialogUpdate.dispose();
					    						}});
					    				dialogUpdate.add(yesButton);
	    							}else{
	    								ConfirmDialog dialogOver=new ConfirmDialog("GAME OVER");
	    								JLabel label=new JLabel("您已经死亡！");
	    								label.setBounds(125, 15, 100, 50);
	    								dialogOver.add(label);
	    								GameManager.deletePlayer(player);
	    								if(GameManager.getPlayers().size()<=1){
	    									label.setText("祝贺"+GameManager.getPlayers().get(0).getName()+"赢得了本局比赛的胜利！！！");
	    								}
	    							}

				    		 	}
				    	 	}else{//空地
				    	 		//TODO 问他买不买
			    		 		JDialog dialog=new ConfirmDialog("是否购买？");
			    		 		
			    		 		JButton yesButton=new JButton("确定");
			    				JButton noButton=new JButton("放弃");
			    				yesButton.setBounds(25, 15, 100, 50);
			    				
			    				if(player.getMoney().getCash() < cell.getHouse().getPrice())
			    					yesButton.setEnabled(false);
			    				yesButton.addActionListener(
			    					new ActionListener(){
			    						public void actionPerformed(ActionEvent e){
			    							//TODO 需要判断钱够不够
			    							int price=cell.getHouse().getPrice();
			    							player.getMoney().reduceCash(price);
			    							lab_cash.setText("资金"+player.getMoney().getCash());
			    							System.out.print(player.getMoney().getCash());
			    							cell.setOwner(player);
			    							//System.out.println(player.getName()+"   "+player.getPosition()+"    "+(HouseCell)GameManager.getMap().get(player.getPosition()).getCell());
			    							player.getMoney().addHouse(cell.getHouse());
			    							
			    							cell.getHouse().upRank();
			    							dialog.dispose();
			    							int position=player.getPosition();
			    							CellView cellview=eachLocation.get(player.getPosition());
			    							JLabel label=labelList.get(position);
			    							if(position>=0&&position<=28)
			    								label.setBounds(cellview.getX()-7, cellview.getY()-40, 25	, 25);
			    							else if(position>28&&position<=35)
			    								label.setBounds(cellview.getX()+30, cellview.getY()-7, 25	, 25);
			    							else if(position>35&&position<=63)
			    								label.setBounds(cellview.getX()-12, cellview.getY()+24, 25	, 25);
			    							else if(position>63&&position<70)
			    								label.setBounds(cellview.getX()-50, cellview.getY()+40, 25	, 25);
			    							ImageIcon icon = new ImageIcon("pic/"+player.getId()+"-1.png");  
			    							label.setIcon(icon);
			    							panel.add(label);
			    							panel.repaint();
			    						}});
			    				noButton.addActionListener(
				    				new ActionListener(){
				    					public void actionPerformed(ActionEvent e){
				    						dialog.dispose();
				    					}});
			    				noButton.setBounds(165, 15, 100, 50);
			    				dialog.add(noButton);
			    				
			    				dialog.add(yesButton);
				    	 	}
				    	 	break;}
				     	case Cell.GIFT:{
				     		switch(player.throwDice()%3){
				     		case 0:{
				     			player.getProps().add(new Bomb());
				     			ConfirmDialog dialog=new ConfirmDialog("恭喜您收获炸弹一个！");
			    		 		JButton yesButton=new JButton("确定");
			    				
			    				yesButton.setBounds(125, 15, 100, 50);
			    				yesButton.addActionListener(
			    					new ActionListener(){
			    						public void actionPerformed(ActionEvent e){
			    							dialog.dispose();
			    						}});
			    				dialog.add(yesButton);
				     			break;
				     		}
				     		case 1:{
				     			player.getProps().add(new DollMachine());
				     			ConfirmDialog dialog=new ConfirmDialog("恭喜您收获机器娃娃一个！");
			    		 		JButton yesButton=new JButton("确定");
			    				
			    				yesButton.setBounds(125, 15, 100, 50);
			    				yesButton.addActionListener(
			    					new ActionListener(){
			    						public void actionPerformed(ActionEvent e){
			    							dialog.dispose();
			    						}});
			    				dialog.add(yesButton);
				     			break;
				     		}
				     		case 2:{
				     			player.getProps().add(new RoadBlock());
				     			ConfirmDialog dialog=new ConfirmDialog("恭喜您收获路障一个！");
			    		 		JButton yesButton=new JButton("确定");
			    				
			    				yesButton.setBounds(125, 15, 100, 50);
			    				yesButton.addActionListener(
			    					new ActionListener(){
			    						public void actionPerformed(ActionEvent e){
			    							dialog.dispose();
			    						}});
			    				dialog.add(yesButton);
				     			break;
				     		}
				     		}
				     		break;}
				     	case Cell.MINE:{
				    	 MineCell cell=(MineCell)GameManager.getMap().get(player.getPosition()).getCell();
				    	 player.getMoney().addPoint(cell.getPoint());
				    	 lab_point.setText("点数："+player.getMoney().getPoint());
				    	 break;}
				     	case Cell.PRISION:{
				    	 player.addStopDay(2);
				    	 break;}
				     case Cell.PROP:{
				    	 JDialog dialogProp=new ConfirmDialog("请选择购买道具");
				    	 dialogProp.setSize(500, 200);
				    	 JButton bombBtn=new JButton("炸弹");
				    	 JButton roadblockBtn=new JButton("路障");
				    	 JButton dollBtn=new JButton("机器娃娃");
				    	 JButton exitBtn=new JButton("退出");
				    	 bombBtn.setBounds(25, 15, 100, 50);
				    	 bombBtn.addActionListener(
		    				new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									JDialog dialog_=new ConfirmDialog("是否确定购买？");
									JButton yesButton=new JButton("确定");
				    				JButton noButton=new JButton("放弃");
				    				
				    				yesButton.setBounds(25, 15, 100, 50);
				    				if(player.getMoney().getPoint()<50)
	    								yesButton.setEnabled(false);
				    				yesButton.addActionListener(
				    					new ActionListener(){
				    						public void actionPerformed(ActionEvent e){
				    							player.getProps().add(new Bomb());
				    							player.getMoney().reducePoint(50);
				    							dialog_.dispose();
				    						}});
				    				noButton.addActionListener(
					    				new ActionListener(){
					    					public void actionPerformed(ActionEvent e){
					    						dialog_.dispose();
					    					}});
				    				noButton.setBounds(165, 15, 100, 50);
				    				dialog_.add(noButton);
				    				
				    				dialog_.add(yesButton);
								}
		    					
		    				});
				    	 
				    	 roadblockBtn.setBounds(145, 15, 100, 50);
				    	 roadblockBtn.addActionListener(
		    				new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									JDialog dialog_=new ConfirmDialog("是否确定购买？");
									JButton yesButton=new JButton("确定");
				    				JButton noButton=new JButton("放弃");
				    				
				    				yesButton.setBounds(25, 15, 100, 50);
				    				if(player.getMoney().getPoint()<50)
	    								yesButton.setEnabled(false);
				    				yesButton.addActionListener(
				    					new ActionListener(){
				    						public void actionPerformed(ActionEvent e){
				    							player.getProps().add(new RoadBlock());
				    							player.getMoney().reducePoint(50);
				    							dialog_.dispose();
				    						}});
				    				noButton.addActionListener(
					    				new ActionListener(){
					    					public void actionPerformed(ActionEvent e){
					    						dialog_.dispose();
					    					}});
				    				noButton.setBounds(165, 15, 100, 50);
				    				dialog_.add(noButton);
				    				
				    				dialog_.add(yesButton);
								}
		    					
		    				});
				    	 
				    	 dollBtn.setBounds(265, 15, 100, 50);
				    	 dollBtn.addActionListener(
		    				new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									JDialog dialog_=new ConfirmDialog("是否确定购买？");
									JButton yesButton=new JButton("确定");
				    				JButton noButton=new JButton("放弃");
				    				
				    				yesButton.setBounds(25, 15, 100, 50);
				    				if(player.getMoney().getPoint()<30)
	    								yesButton.setEnabled(false);
				    				yesButton.addActionListener(
				    					new ActionListener(){
				    						public void actionPerformed(ActionEvent e){
				    							player.getProps().add(new DollMachine());
				    							player.getMoney().reducePoint(30);
				    							dialog_.dispose();
				    						}});
				    				noButton.addActionListener(
					    				new ActionListener(){
					    					public void actionPerformed(ActionEvent e){
					    						dialog_.dispose();
					    						dialog_.setVisible(false);
					    					}});
				    				noButton.setBounds(165, 15, 100, 50);
				    				dialog_.add(noButton);
				    				
				    				dialog_.add(yesButton);
								}
		    					
		    				});
				    	 
				    	 exitBtn.setBounds(365, 15, 80, 50);
				    	 exitBtn.addActionListener(
		    				new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									JDialog dialog_=new ConfirmDialog("是否确定购买？");
									JButton yesButton=new JButton("确定");
				    				JButton noButton=new JButton("放弃");
				    				
				    				yesButton.setBounds(25, 15, 100, 50);
				    				if(player.getMoney().getPoint()<30)
	    								yesButton.setEnabled(false);
				    				yesButton.addActionListener(
				    					new ActionListener(){
				    						public void actionPerformed(ActionEvent e){
				    							player.getProps().add(new DollMachine());
				    							dialog_.dispose();
				    						}});
				    				noButton.addActionListener(
					    				new ActionListener(){
					    					public void actionPerformed(ActionEvent e){
					    						dialog_.dispose();
					    						dialog_.setVisible(false);
					    					}});
				    				noButton.setBounds(165, 15, 100, 50);
				    				dialog_.add(noButton);
				    				
				    				dialog_.add(yesButton);
								}
		    					
		    				});
				    	 dialogProp.add(bombBtn);
				    	 dialogProp.add(roadblockBtn);
				    	 dialogProp.add(dollBtn);
				    	 break;}
				     case Cell.START:{break;}
				     default:System.out.println("Error occerred");
				     }
				    }
				   }.start();
	}
	private List initCell() {
		List<CellView> location=new ArrayList<>();
		//第一个是起点
		location.add(new CellView(0,75,80,new Cell(Cell.START)));
		
		//1-13是200的房子
		location.add(new CellView(1,115,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(2,135,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(3,155,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(4,175,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(5,195,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(6,218,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(7,239,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(8,260,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(9,283,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(10,303,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(11,327,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(12,352,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(13,375,63,new HouseCell(Cell.HOUSE,new House(200))));
		
		//14是医院
		location.add(new CellView(14,420,63,new HospitalCell(Cell.HOSPITAL)));
		
		//15-27是200的房子
		location.add(new CellView(15,462,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(16,484,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(17,510,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(18,536,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(19,559,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(20,581,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(21,604,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(22,626,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(23,650,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(24,677,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(25,702,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(26,725,63,new HouseCell(Cell.HOUSE,new House(200))));
		location.add(new CellView(27,747,63,new HouseCell(Cell.HOUSE,new House(200))));
		
		//28是道具屋
		List<Prop> props=new ArrayList<>();
		props.add(new DollMachine());
		props.add(new Bomb());
		props.add(new RoadBlock());
		PropCell propCell=new PropCell(Cell.PROP, props);
		location.add(new CellView(28,786,63,propCell));
		
		//29-34是500的房子
		
		location.add(new CellView(29,786,120,new HouseCell(Cell.HOUSE, new House(500))));
		location.add(new CellView(30,786,185,new HouseCell(Cell.HOUSE, new House(500))));
		location.add(new CellView(31,786,250,new HouseCell(Cell.HOUSE, new House(500))));
		location.add(new CellView(32,786,320,new HouseCell(Cell.HOUSE, new House(500))));
		location.add(new CellView(33,786,390,new HouseCell(Cell.HOUSE, new House(500))));
		location.add(new CellView(34,786,460,new HouseCell(Cell.HOUSE, new House(500))));
		//35是礼品屋
		List<Gift> gifts=new ArrayList<>();
		gifts.add(new Gift(Gift.CASH, "现金","奖励现金2000"));
		gifts.add(new Gift(Gift.FREE, "财神附体", "5个回合免过路费"));
		gifts.add(new Gift(Gift.POINT, "点数", "奖励200点数"));
		GiftCell giftCell=new GiftCell(Cell.GIFT, gifts);
		location.add(new CellView(35,790,530,giftCell));
		
		//36-48是300的房子

		location.add(new CellView(36,755,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(37,737,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(38,714,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(39,690,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(40,668,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(41,648,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(42,625,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(43,603,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(44,580,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(45,558,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(46,535,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(47,513,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(48,490,524,new HouseCell(Cell.HOUSE, new House(300))));
		//49是监狱
		PrisonCell prisonCell=new PrisonCell(Cell.PRISION);
		location.add(new CellView(49,449,524,prisonCell));

		
		//50-62是300的房子
		
		location.add(new CellView(50,412,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(51,392,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(52,369,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(53,343,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(54,317,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(55,292,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(56,269,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(57,245,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(58,222,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(59,199,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(60,174,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(61,149,524,new HouseCell(Cell.HOUSE, new House(300))));
		location.add(new CellView(62,123,524,new HouseCell(Cell.HOUSE, new House(300))));

		//63是魔法屋
		List<Magic> magics=new ArrayList<>();
		MagicCell magicCell=new MagicCell(Cell.MAGIC, magics);
		location.add(new CellView(63,75,524,magicCell));
		
		//64-69是矿地
		
		
		location.add(new CellView(64,75,460,new MineCell(Cell.MINE, 20)));
		location.add(new CellView(65,75,395,new MineCell(Cell.MINE, 80)));
		location.add(new CellView(66,75,325,new MineCell(Cell.MINE, 100)));
		location.add(new CellView(67,75,260,new MineCell(Cell.MINE, 40)));
		location.add(new CellView(68,75,205,new MineCell(Cell.MINE, 80)));
		location.add(new CellView(69,75,148,new MineCell(Cell.MINE, 60)));
		
		return location;
	}
	
	private List initLabel() {
		List<JLabel> labelList=new ArrayList<>();
		for(int i=0;i<70;i++)
			labelList.add(new JLabel());
		return labelList;
	}
}
