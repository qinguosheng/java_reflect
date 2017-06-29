package com.sheng.reflection;

public class GetClassTest {

	public static void main(String[] args) {
		// 实例化X类的对象，X没有继承任何一个类，所以是Object的子类
		X x = new X();
		// 得到对象x所在的类
		System.out.println("对象x所在的类名：" + x.getClass().getName());

	}

}
class X{
	
}
