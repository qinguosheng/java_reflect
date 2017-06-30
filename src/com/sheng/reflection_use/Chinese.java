package com.sheng.reflection_use;

public class Chinese implements Person{
	private String name;
	private int age;
	
	public Chinese() {
		
	}
	public Chinese(String name) {
		this.name = name;
	}
	public Chinese(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void sayChinese() {
		System.out.println("作者：" + AUTHOR + "国籍：" + NATIONAL);
	}

	@Override
	public String sayHello(String name, int age) {
		return "姓名:" + this.name + "年龄：" + this.age;
	}
	

}
interface Person{
	public static final String AUTHOR = "李小龙";
	public static final String NATIONAL = "China";
	public void sayChinese();
	public String sayHello(String name, int age);
}
