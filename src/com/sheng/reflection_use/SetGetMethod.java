package com.sheng.reflection_use;

import java.lang.reflect.Method;

/**
 * 通过反射调用setter和getter方法
 */
public class SetGetMethod {

	public static void main(String[] args) {
		// 声明Class对象
		Class<?> class1 = null;
		// 声明Chinese对象
		Chinese chinese = null;
		try {
			// 1.实例化class对象
			class1 = Class.forName("com.sheng.reflection_use.Chinese");
			// 2.实例化Chinese对象
			chinese = (Chinese) class1.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setter(chinese, "name", "sheng", String.class);
		setter(chinese, "age", 100, int.class);
		System.out.print("姓名：");
		getter(chinese, "name");
		System.out.print("年龄：");
		getter(chinese, "age");
		

	}
	
	/**
	 * @param obj 操作的对象
	 * @param str 操作的属性
	 * @param value 设置的值
	 * @param type 参数的类型
	 */
	public static void setter(Object obj, String str, Object value, Class<?> type) {
		try {
			// 取得Method对象
			Method method = obj.getClass().getMethod("set" + initStr(str), type);
			// 对带有指定参数的指定对象调用由此 Method 对象表示的底层方法
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getter(Object obj, String str) {
		try {
			Method method = obj.getClass().getMethod("get" + initStr(str));
			System.out.println(method.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// 单词首写字母大写
	public static String initStr(String old) {
		String str = null;
		// 拼装setter方法，取得第一个字母，并转换成大写，+ 第二个字母之后得字符串
		// 取得首字母，substring(0, 1)意思是从0开始，1-1处结束
		str = old.substring(0, 1).toUpperCase() + old.substring(1);
		return str;
	}
}
