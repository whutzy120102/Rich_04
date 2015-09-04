package com.zy1202.rich04.model;

import com.zy1202.rich04.manager.GameManager;

public class DollMachine extends Prop{

	public DollMachine(String name, String introduce) {
		super(name, introduce);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void useProp(int loacation) {
		// TODO Auto-generated method stub
		int position=GameManager.getCurrentPlayer().getPosition();
		for(int i=1;i<=10;i++){
			GameManager.getMap().get(position+1).moveAllBomb();
			GameManager.getMap().get(position+1).moveAllRoadBlock();
		}
	}
	

	
}
