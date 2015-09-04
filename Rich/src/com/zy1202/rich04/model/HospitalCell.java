package com.zy1202.rich04.model;

import com.zy1202.rich04.manager.GameManager;

public class HospitalCell extends Cell{
	
	public HospitalCell(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public void addPlayer(Player player){
		GameManager.getCurrentPlayer().addStopDay(3);
	}

}
