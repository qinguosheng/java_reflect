package com.sheng.reflection_use;

import java.lang.reflect.Field;
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
		// ============1=通过setter和gettter操作属=========================
		setter(chinese, "name", "sheng", String.class);
		setter(chinese, "age", 100, int.class);
		System.out.print("姓名：");
		getter(chinese, "name");
		System.out.print("年龄：");
		getter(chinese, "age");
		// ============1=通过setter和gettter操作属=========================

		// ============2=或者通过反射直接操作属=========================
		// 表示name和age属性
		Field nameField = null;
		Field ageField = null;
		try {
			// 分别取得name和age属性
			nameField = class1.getDeclaredField("name");
			ageField = class1.getDeclaredField("age");
			// 将name和age属性设置成可被外部访问
			nameField.setAccessible(true);
			ageField.setAccessible(true);
			// 设置name和age属性得值
			nameField.set(chinese, "sheng");
			ageField.set(chinese, 100);
			// 取得name和age属性得值
			System.out.println(nameField.get(chinese));
			System.out.println(ageField.get(chinese));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ============2=或者通过反射直接操作属=========================
		
		/**
		 * 第二中方法，操作与调用与setter和getter无关，但为了保护程序得安全性，最好
		 * 还是通过setter及getter方法调用。就是第一中方法比较好
		 */

	}

	/**
	 * @param obj
	 *            操作的对象
	 * @param str
	 *            操作的属性
	 * @param value
	 *            设置的值
	 * @param type
	 *            参数的类型
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
