package com.zy1202.rich04.model;

import com.zy1202.rich04.manager.GameManager;

public class DollMachine extends Prop{

	public DollMachine() {
		super();
		this.setName("机器娃娃");
		this.setIntroduce("清除前方10格所有道具");
		this.setPoint(300);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void useProp(int loacation) {
		// TODO Auto-generated method stub
		int position=GameManager.getCurrentPlayer().getPosition();
		for(int i=1;i<=10;i++){
			GameManager.getMap().get(position+1).getCell().moveAllBomb();
			GameManager.getMap().get(position+1).getCell().moveAllRoadBlock();
		}
	}
	

	
}
