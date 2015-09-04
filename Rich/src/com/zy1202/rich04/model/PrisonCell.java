package com.zy1202.rich04.model;

public class PrisonCell extends Cell{

	public PrisonCell(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public void addPlayer(Player player){
		player.addStopDay(2);
	}

}
