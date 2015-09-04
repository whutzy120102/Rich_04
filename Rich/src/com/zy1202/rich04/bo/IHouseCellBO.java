package com.zy1202.rich04.bo;

import com.zy1202.rich04.model.House;
import com.zy1202.rich04.model.Player;

public interface IHouseCellBO {
	void setOwner(Player player);
	Player getOwner();
	void setHouse(House house);
	House getHouse();
}
