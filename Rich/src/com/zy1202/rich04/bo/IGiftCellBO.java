package com.zy1202.rich04.bo;

import java.util.List;

import com.zy1202.rich04.model.Gift;

public interface IGiftCellBO {
	void setGifts(List<Gift> gifts);
	List<Gift> getGifts();
}
