package com.rich.View;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class SwingConsole {

	/**
	 * @param nifengchao
	 */
	public static void run(final JFrame f,final JLayeredPane jlayeredPane,final int width,final int height){
		SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					f.setLayeredPane(jlayeredPane);  
					f.setTitle(f.getClass().getSimpleName());
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(width,height);
					f.setVisible(true);
				}
		});
		
	}
}


