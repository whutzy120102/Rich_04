package com.zy1202.rich04.model;

import java.util.ArrayList;
import java.util.List;

import com.zy1202.rich04.biz.IPlayerBiz;
import com.zy1202.rich04.bo.IPlayerBO;
import com.zy1202.rich04.manager.GameManager;

public class Player implements IPlayerBO,IPlayerBiz{
	private int id;
	private String name;
	private String ab;
	private int color;
	private Money money;
	private int freeDay;
	private int stopDay;
	private int position;
	private List<Prop> props;
	
	
	public Player(int id, String name, String ab, int color, Money money) {
		super();
		this.id = id;
		this.name = name;
		this.ab = ab;
		this.color = color;
		this.money = money;
		this.freeDay=0;
		this.stopDay=0;
		this.position=0;
		this.props=new ArrayList<Prop>();
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		if(freeDay==0){
		return false;
		}else{
			return true;
		}
	}

	@Override
	public int addFree(int day) {
		// TODO Auto-generated method stub
		freeDay+=day;
		return freeDay;
	}

	@Override
	public int reduceFree(int day) {
		// TODO Auto-generated method stub
		freeDay-=day;
		return freeDay;
	}

	@Override
	public boolean isStop() {
		// TODO Auto-generated method stub
		if(stopDay==0){
		return false;
		}else{
			return true;
		}
	}

	@Override
	public int addStopDay(int day) {
		// TODO Auto-generated method stub
		stopDay+=day;
		return stopDay;
	}

	@Override
	public int reduceStopDay(int day) {
		// TODO Auto-generated method stub
		stopDay-=day;
		return stopDay;
	}

	@Override
	public int throwDice() {
		// TODO Auto-generated method stub
		
		return (int)((Math.random())*6)+1;
	}

	@Override
	public void leaveGame() {
		// TODO Auto-generated method stub
		GameManager.deletePlayer(this);
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setAb(String ab) {
		// TODO Auto-generated method stub
		this.ab=ab;
	}

	@Override
	public String getAb() {
		// TODO Auto-generated method stub
		return ab;
	}

	@Override
	public void setColor(int color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void setMoney(Money money) {
		// TODO Auto-generated method stub
		this.money=money;
	}

	@Override
	public Money getMoney() {
		// TODO Auto-generated method stub
		return money;
	}

	@Override
	public void setFreeDay(int freeDay) {
		// TODO Auto-generated method stub
		this.freeDay=freeDay;
	}

	@Override
	public int getFreeDay() {
		// TODO Auto-generated method stub
		return freeDay;
	}

	@Override
	public void setStopDay(int stopDay) {
		// TODO Auto-generated method stub
		this.stopDay=stopDay;
	}

	@Override
	public int getStopDay() {
		// TODO Auto-generated method stub
		return stopDay;
	}

	@Override
	public void setPositioin(int position) {
		// TODO Auto-generated method stub
		this.position=position;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void setProps(List<Prop> props) {
		// TODO Auto-generated method stub
		this.props=props;
	}

	@Override
	public List<Prop> getProps() {
		// TODO Auto-generated method stub
		return props;
	}

}
