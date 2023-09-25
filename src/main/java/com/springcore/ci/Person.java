package com.springcore.ci;


public class Person {
	private String name;
	private int personId;
	private Certi certi;
//	private List<String> list;
	public Person(String name, int personId, Certi certi/* ,List<String> list */) {
		this.name=name;
		this.personId=personId;
		this.certi=certi;
		/* this.list=list; */// We have added list so changes will be there in config.xml
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+" : "+this.personId+"{"+this.certi.getName()+"}";
	}
	
	
	
	
}
