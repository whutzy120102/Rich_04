package com.zy1202.rich04.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Help_View extends JFrame{
	
	
	Help_View help_view;
	
	private  JLayeredPane layeredPane_1;  
	
	private ImageIcon helpview_pic;
 
	private JButton jb_1,jb_2;
	
	public static void main(String[] args) {
		
		 
	}
	
	
	
	Help_View(){
		init();
	}
	
	public void init(){
		help_view = this;
		layeredPane_1 = new JLayeredPane();
		JPanel jp = new JPanel();
		helpview_pic = new ImageIcon("pic/help_view.jpg");
		JLabel jl = new JLabel(helpview_pic);
		jp.add(jl);
		jp.setBounds(0, 0, helpview_pic.getIconWidth(), helpview_pic.getIconHeight());
		
		
		jb_1 = new JButton("检查更新");
		jb_1.setBounds(280, 400, 100, 20);
		jb_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("检查更新");
				JLayeredPane layeredPane_2 = new JLayeredPane();
			    JLabel jl_1 = new JLabel("暂时无更新，敬请期待！");
			    jl_1.setBounds(0, 0, 200, 50);
				layeredPane_2.add(jl_1,JLayeredPane.POPUP_LAYER);
			    frame.setLayeredPane(layeredPane_2);
			    frame.setBounds(444, 444, 300, 100);
			    frame.setVisible(true);				
			}
			
		});
		
		
		jb_2 = new JButton("关闭");
		jb_2.setBounds(420, 400, 80, 20);
		jb_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				help_view.setVisible(false);
			}
			
		});
		
		layeredPane_1.add(jp,JLayeredPane.DEFAULT_LAYER);
		layeredPane_1.add(jb_1,JLayeredPane.PALETTE_LAYER);
		layeredPane_1.add(jb_2,JLayeredPane.PALETTE_LAYER);

		
		
		
		
		
		
		this.setTitle("帮助");
		
		
		
		
		
		this.setLayeredPane(layeredPane_1);

		this.setLocation(222, 222);
		this.setSize(helpview_pic.getIconWidth(),helpview_pic.getIconHeight());
		this.setVisible(true);
		
	}

}
