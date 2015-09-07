package com.zy1202.rich04.model;

import java.util.List;

import com.zy1202.rich04.biz.IGiftCellBiz;
import com.zy1202.rich04.bo.IGiftCellBO;
import com.zy1202.rich04.manager.GameManager;

public class GiftCell extends Cell implements IGiftCellBO,IGiftCellBiz{
	List<Gift> gifts;
	public GiftCell(String type,List<Gift> gifts) {
		super(type);
		this.gifts=gifts;
		this.setName("礼品屋");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useGift(Gift gift) {
		// TODO Auto-generated method stub
		switch(gift.getId()){
		case Gift.CASH:
			GameManager.getCurrentPlayer().getMoney().addCash(2000);
			break;
		case Gift.FREE:
			GameManager.getCurrentPlayer().addFree(5);
			break;
		case Gift.POINT:
			GameManager.getCurrentPlayer().getMoney().addPoint(200);
			break;
		default:break;
		}
	}

	@Override
	public void setGifts(List<Gift> gifts) {
		// TODO Auto-generated method stub
		this.gifts=gifts;
	}

	@Override
	public List<Gift> getGifts() {
		// TODO Auto-generated method stub
		return gifts;
	}

}
