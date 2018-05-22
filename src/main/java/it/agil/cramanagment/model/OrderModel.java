package it.agil.cramanagment.model;

import org.springframework.data.domain.Sort.Direction;

public class OrderModel {

	private String property;
	private Direction direction;

	public OrderModel(final String property, final Direction direction) {
		super();
		this.property = property;
		this.direction = direction;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(final String property) {
		this.property = property;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(final Direction direction) {
		this.direction = direction;
	}

}
