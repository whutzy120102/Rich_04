package com.zy1202.rich04.model;

import java.util.List;

import com.zy1202.rich04.bo.IPropCellBO;

public class PropCell extends Cell implements IPropCellBO{
	List<Prop> props;
	public PropCell(String type,List<Prop> props) {
		super(type);
		this.props=props;
		// TODO Auto-generated constructor stub
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
