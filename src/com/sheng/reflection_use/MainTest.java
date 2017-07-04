package com.sheng.reflection_use;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.text.GapContent;

public class MainTest {

	public static void main(String[] args) {
		// 声明Class对象
		Class<?> c = null;
		// 实例化Class
		try {
			c = Class.forName("com.sheng.reflection_use.Chinese");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ---1-取得Chinese类实现的全部接口---------------------------
		Class<?> chineseInter[] = c.getInterfaces();
		for(int i=0; i < chineseInter.length; i++) {
			System.out.println("实现的接口的名称：" + chineseInter[i]);
		}
		
		// ---2-取得Chinese类实的父类---------------------------------
		Class superClass = null;
		superClass = c.getSuperclass();
		System.out.println("父类的名称：" + superClass.getName());
		
		// ---3-取得全部的构造方法------------------------------------
		System.out.println("类中的构造方法===========================");
		Constructor<?> constructors[] = null;
		constructors = c.getConstructors();
		for(int i=0; i<constructors.length; i++) {
			System.out.println("类中的构造方法：" + constructors[i]);
		}
		// --- 修饰符、形参类型、
		for(int i=0; i<constructors.length; i++) {
			// 取出权限，并将代表权限的数字转换成字符型，如public等
			int mod = constructors[i].getModifiers();
			String modifier = Modifier.toString(mod);
			// 列出构造方法中的参数类型
			Class<?>[] parm = constructors[i].getParameterTypes();
			// 取得构造方法的名称
			String conName = constructors[i].getName();
			
			System.out.print(modifier);
			System.out.print(" " + conName);
			System.out.print("(");
			for(int j=0; j<parm.length; j++) {
				System.out.print(parm[j].getName() + " arg" + i);
				if(j<parm.length -1) {
					System.out.print(", ");
				}
			}
			System.out.print("){}");
			System.out.println();
		}
		System.out.println("类中的构造方法===========================");
		
		
		// ---4-取得所有方法-----------------------------------------
		Method[] method = null;
		method = c.getMethods();
		for(int i=0; i<method.length; i++) {
			System.out.println("所有得方法" + method[i]);
		}
		
		// ---5-取得本类中的属性-----------------------------------------
		Field[] f1 = c.getDeclaredFields();
		for(int i=0; i<f1.length; i++) {
			System.out.println("类里的属性" + f1[i]);
		}
		// ---6-取得父类公共属性-------------------------------------
		Field[] f2 = c.getFields();
		for(int i=0; i<f1.length; i++) {
			System.out.println("父类的公共属性" + f2[i]);
		}
		// ---7-通过反射调用类中的无参的方法---------------------
		// 声明chinese对象
		Chinese chinese = null;
		try {
			chinese = (Chinese) c.newInstance();
			// 取得sayChinese()方法
			Method method2 = c.getDeclaredMethod("sayChinese");
			// 传入对象，调用sayChinese()方法
			method2.invoke(chinese);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ---8-通过反射调用类中有参的方法---------------------
		try {
			// 获得Method，要传入方法名和此方法需要的两个参数
			Method method3 = c.getDeclaredMethod("sayHello", String.class, int.class);
			// 调用方法，必须传入对象实例，同时传递两个参数值
			String rv = (String) method3.invoke(chinese, "sheng",100);
			System.out.println(rv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
