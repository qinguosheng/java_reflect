package com.sheng.reflection;

/**
 * 类中带有无参构造方法，此类的实例化方法
 */
public class NewInstanceTest {

	public static void main(String[] args) {
		// 声明Class对象
		Class<?> c = null;
		try {
			// 1.实例化c对象
			c = Class.forName("com.sheng.reflection.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 声明Person对象
		Person person = null;
		try {
			// 2.通过newInstance()方法实例化person对象
			person = (Person) c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置姓名和年龄
		person.setName("sheng");
		person.setAge(100);
		
		System.out.println(person);
	}
		
}


class Person {
	// name属性
	private String name;
	// age属性
	private int age;
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
	// 重写toString()方法
	@Override
	public String toString() {
		return "姓名：" + this.name + "/n年龄：" + this.age;
	}
	
}
