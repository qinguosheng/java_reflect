package com.sheng.reflection;

public class GetClassTest2 {

	public static void main(String[] args) {
		// 指定泛型用通配符
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		
		try {
			// 1.在开发中最常用的一种，通过Class.forname()方法实例化;
			class1 = Class.forName("com.sheng.reflection.Y");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.通过 对象.getClasses() 方法实例化
		class2 = new Y().getClass();
		// 3.通过  类.class实例化
		class3 = Y.class;
		//得到类的名称
		System.out.println("类的名称：" + class1.getClass().getName());
		System.out.println("类的名称：" + class1.getClass().getName());
		System.out.println("类的名称：" + class1.getClass().getName());

	}

}
class Y{
	
}
