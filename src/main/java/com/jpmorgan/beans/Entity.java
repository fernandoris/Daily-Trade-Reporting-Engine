package com.jpmorgan.beans;

/**
 * Entities bean
 * @author Fernando
 *
 */
public class Entity implements IEntity {
	
	private String name;
	
	public Entity(String name) {		
		this.name = name;
	}
	
	public Entity(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}

}
