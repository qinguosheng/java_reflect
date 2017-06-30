package com.sheng.reflection;

import java.lang.reflect.Constructor;

/**
 * 类带有有参的构造方法，此类实例化的方法
 */
public class NewInstanceTest2 {

	public static void main(String[] args) {
		// 声明Class对象
		Class<?> c = null;
		try {
			// 1.实例化Class对象
			c = Class.forName("com.sheng.reflection.Student");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.得到Student类的所有公共构造方法
		Constructor<?>[] cons = c.getConstructors();
		// 声明Student对象
		Student student = null;
		
		try {
			// 3.这类里里面只有一个构造方法，取cons[0]就行,并传入构造方法的参数
			student = (Student) cons[0].newInstance("sheng", "09007102");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(student);

	}

}

class Student {
	// 姓名属性
	private String name;
	// 学号属性
	private String stuNo;

	// 带有参数的构造方法
	public Student(String name, String stuNo) {
		super();
		this.name = name;
		this.stuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	@Override
	public String toString() {
		return "姓名：" + this.name + "学号：" + this.stuNo;
	}
}
