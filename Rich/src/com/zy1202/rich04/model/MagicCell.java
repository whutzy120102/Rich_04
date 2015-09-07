package com.zy1202.rich04.model;

import java.util.List;

import com.zy1202.rich04.biz.IMagicCellBiz;
import com.zy1202.rich04.bo.IMagicCellBO;

public class MagicCell extends Cell implements IMagicCellBO,IMagicCellBiz{
	List<Magic> magics;
	public MagicCell(String type,List<Magic> magics) {
		super(type);
		this.magics=magics;
		this.setName("魔法屋");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useMagic(Magic magic) {
		// TODO Auto-generated method stub
		switch(magic.getId()){
		case Magic.TYPE_1:
			break;
		case Magic.TYPE_2:
			break;
			default:break;
		}
	}

	@Override
	public void setMagics(List<Magic> magics) {
		// TODO Auto-generated method stub
		this.magics=magics;
	}

	@Override
	public List<Magic> getMagics() {
		// TODO Auto-generated method stub
		return magics;
	}

}
