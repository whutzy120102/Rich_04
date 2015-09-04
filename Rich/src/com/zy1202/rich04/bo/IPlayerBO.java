package com.zy1202.rich04.bo;

import java.util.List;

import com.zy1202.rich04.model.Money;
import com.zy1202.rich04.model.Prop;

public interface IPlayerBO {
	void setId(int id);
	int getId();
	void setName(String name);
	String getName();
	void setAb(String ab);
	String getAb();
	void setColor(int color);
	int getColor();
	void setMoney(Money money);
	Money getMoney();
	void setFreeDay(int freeDay);
	int getFreeDay();
	void setStopDay(int stopDay);
	int getStopDay();
	void setPositioin(int position);
	int getPosition();
	void setProps(List<Prop> props);
	List<Prop> getProps();
}
