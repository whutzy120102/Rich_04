package com.zy1202.rich04.view;

import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JFrame frame;
	private JPanel panel;
	private JButton btn;
	private JButton btnOver;
	private JLabel label;

	
	public MapFrame(){
		eachLocation=initCell();
		GameManager.initMap(eachLocation);
		frame=new JFrame();
		panel=null;
		btn=new JButton();
		btnOver=new JButton("结束回合");
		//label=new JLabel();
		doMain();
	}
	
	public void doMain(){
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
		
		//获取玩家数量
//		int playerCount=GameManager.getPlayers().size();
//		switch(playerCount){
//		case 1:;break;
//		case 2:;break;
//		case 3:;break;
//		case 4:;break;
//		default:System.out.println("Error occerred");
//		}
		Player player=null;
		Iterator it=GameManager.getPlayers().iterator();
		while(it.hasNext()){
			player=(Player) it.next();
			panel.add(player.getLabel());
		}
//		label.setOpaque(true);
//		label.setBackground(Color.YELLOW);
//		label.setBounds(78,524, 5,5);
		btn.setBounds(370, 319, 120, 120);
		btn.setMargin(new Insets(0, 0, 0, -10));
		btn.setBorderPainted(false);
		//btn.setContentAreaFilled(false);
		//ImageIcon iconBeginBtn = new ImageIcon("f:\\dice.png");  
		//btn.setIcon(iconBeginBtn);
		btnOver.setBounds(620, 119, 110, 20);
		//panel.add(label);
		
		panel.add(btn);
		panel.add(btnOver);
		panel.setLayout(null);
		frame.add(panel);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					new Thread() {
					    public void run() {

					     //int x=label.getX();
				    	 //int y=label.getY();
				    	 //TODO 添加人物 通过Player的throwDice获取随机数
				    	 java.util.Random random=new java.util.Random();
				    	 //int randomNum=random.nextInt(6)+1;
				    	 int randomNum=GameManager.getCurrentPlayer().throwDice();
				    	 
				    	 Player player=GameManager.getCurrentPlayer();
				    	 label=player.getLabel();
				    	 int position=player.getPosition();
					     for(int i=0;i<randomNum;i++){
					    	 
					    	 position++;
					    	 if(position>69)
					    		 position=0;
					    	 player.setPositioin(position);
					    	 //x=label.getX()+20;
					    	 //y=label.getY();
					    	 label.setLocation(eachLocation.get(position).getX(),eachLocation.get(position).getY());
					    	 //label.setBackground(Color.BLACK);
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
					    	 
					    	 if(GameManager.getMap().get(position).getCell().hasRoadBlock()){
					    		 GameManager.getMap().get(position).getCell().reduceRoadBlock();
					    		 break;//碰到路障
					    	 }
					    	 try { sleep(200); } catch(Exception ex) {}
					     
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
					    		 	}else{//收过路费
					    		 		player.getMoney().reduceCash(cell.getHouse().getPrice()/2);
					    		 	}
					    	 	}else{//空地
					    	 		//TODO 问他买不买
					    	 		
					    	 	}
					    	 	break;}
					     	case Cell.MAGIC:{break;}
					     	case Cell.MINE:{
					    	 MineCell cell=(MineCell)GameManager.getMap().get(player.getPosition()).getCell();
					    	 player.getMoney().addPoint(cell.getPoint());
					    	 break;}
					     	case Cell.PRISION:{
					    	 player.addStopDay(2);
					    	 break;}
					     case Cell.PROP:{break;}
					     case Cell.START:{break;}
					     default:System.out.println("Error occerred");
					     }
					    }
					   }.start();
					  
			}
		});
		btnOver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btn.setEnabled(true);
				GameManager.toNextPlayer();
			}
		});
	}

	private List initCell() {
		List<CellView> location=new ArrayList<>();
		//第一个是起点
		location.add(new CellView(0,75,80,new Cell(Cell.START)));
		
		//1-13是200的房子
		HouseCell houseCell_200=new HouseCell(Cell.HOUSE,new House(200));
		location.add(new CellView(1,115,63,houseCell_200));
		location.add(new CellView(2,135,63,houseCell_200));
		location.add(new CellView(3,155,63,houseCell_200));
		location.add(new CellView(4,175,63,houseCell_200));
		location.add(new CellView(5,195,63,houseCell_200));
		location.add(new CellView(6,218,63,houseCell_200));
		location.add(new CellView(7,239,63,houseCell_200));
		location.add(new CellView(8,260,63,houseCell_200));
		location.add(new CellView(9,283,63,houseCell_200));
		location.add(new CellView(10,303,63,houseCell_200));
		location.add(new CellView(11,327,63,houseCell_200));
		location.add(new CellView(12,352,63,houseCell_200));
		location.add(new CellView(13,375,63,houseCell_200));
		
		//14是医院
		location.add(new CellView(14,420,63,new HospitalCell(Cell.HOSPITAL)));
		
		//15-27是200的房子
		location.add(new CellView(15,462,63,houseCell_200));
		location.add(new CellView(16,484,63,houseCell_200));
		location.add(new CellView(17,510,63,houseCell_200));
		location.add(new CellView(18,536,63,houseCell_200));
		location.add(new CellView(19,559,63,houseCell_200));
		location.add(new CellView(20,581,63,houseCell_200));
		location.add(new CellView(21,604,63,houseCell_200));
		location.add(new CellView(22,626,63,houseCell_200));
		location.add(new CellView(23,650,63,houseCell_200));
		location.add(new CellView(24,677,63,houseCell_200));
		location.add(new CellView(25,702,63,houseCell_200));
		location.add(new CellView(26,725,63,houseCell_200));
		location.add(new CellView(27,747,63,houseCell_200));
		
		//28是道具屋
		List<Prop> props=new ArrayList<>();
		props.add(new DollMachine());
		props.add(new Bomb());
		props.add(new RoadBlock());
		PropCell propCell=new PropCell(Cell.PROP, props);
		location.add(new CellView(28,786,63,propCell));
		
		//29-34是500的房子
		HouseCell houseCell_500=new HouseCell(Cell.HOUSE, new House(500));
		
		location.add(new CellView(29,786,120,houseCell_500));
		location.add(new CellView(30,786,185,houseCell_500));
		location.add(new CellView(31,786,250,houseCell_500));
		location.add(new CellView(32,786,320,houseCell_500));
		location.add(new CellView(33,786,390,houseCell_500));
		location.add(new CellView(34,786,460,houseCell_500));
		//35是礼品屋
		List<Gift> gifts=new ArrayList<>();
		gifts.add(new Gift(Gift.CASH, "现金","奖励现金2000"));
		gifts.add(new Gift(Gift.FREE, "财神附体", "5个回合免过路费"));
		gifts.add(new Gift(Gift.POINT, "点数", "奖励200点数"));
		GiftCell giftCell=new GiftCell(Cell.HOUSE, gifts);
		location.add(new CellView(35,790,530,giftCell));
		
		//36-48是300的房子
		HouseCell houseCell_300=new HouseCell(Cell.HOUSE,new House(300));
		
		
		location.add(new CellView(36,755,524,houseCell_300));
		location.add(new CellView(37,737,524,houseCell_300));
		location.add(new CellView(38,714,524,houseCell_300));
		location.add(new CellView(39,690,524,houseCell_300));
		location.add(new CellView(40,668,524,houseCell_300));
		location.add(new CellView(41,648,524,houseCell_300));
		location.add(new CellView(42,625,524,houseCell_300));
		location.add(new CellView(43,603,524,houseCell_300));
		location.add(new CellView(44,580,524,houseCell_300));
		location.add(new CellView(45,558,524,houseCell_300));
		location.add(new CellView(46,535,524,houseCell_300));
		location.add(new CellView(47,513,524,houseCell_300));
		location.add(new CellView(48,490,524,houseCell_300));
		//49是监狱
		PrisonCell prisonCell=new PrisonCell(Cell.PRISION);
		location.add(new CellView(49,449,524,prisonCell));

		
		//50-62是300的房子
		
		location.add(new CellView(50,412,524,houseCell_300));
		location.add(new CellView(51,392,524,houseCell_300));
		location.add(new CellView(52,369,524,houseCell_300));
		location.add(new CellView(53,343,524,houseCell_300));
		location.add(new CellView(54,317,524,houseCell_300));
		location.add(new CellView(55,292,524,houseCell_300));
		location.add(new CellView(56,269,524,houseCell_300));
		location.add(new CellView(57,245,524,houseCell_300));
		location.add(new CellView(58,222,524,houseCell_300));
		location.add(new CellView(59,199,524,houseCell_300));
		location.add(new CellView(60,174,524,houseCell_300));
		location.add(new CellView(61,149,524,houseCell_300));
		location.add(new CellView(62,123,524,houseCell_300));

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
}
