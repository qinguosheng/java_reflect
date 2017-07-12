package com.sheng.reflection_use;

import java.lang.reflect.Array;

public class ArryDemo {

	public static void main(String[] args) throws Exception {
		// ================取得数组信息，并修改内容=====================
		// 声明一个整型数组
		int[] temp = { 1, 2, 3, 4 };
		// 取得数组的Class对象
		Class<?> c = temp.getClass().getComponentType();
		// 得到数组类型名称
		System.out.println("类型：" + c.getName());
		// 得到数组长度
		System.out.println("长度：" + Array.getLength(temp));
		// 取得数组里某个元素的值
		System.out.println("数组里第二个元素的值：" + Array.getInt(temp, 1));
		// 修改数组里某个元素的值
		Array.set(temp, 1, 9);
		System.out.println("数组里第二个元素修改后的值：" + Array.getInt(temp, 1));

		// ================取得数组信息，并修改内容=====================

		/**
		 * 使用Array类还可以修改数组的大小。 修改的过程实际上是一个创建的过程，创建一个新的数组，所以还要把旧的内容拷贝到新的数组里
		 */

		// ================改变数组的长度=====================
		int[] newTemp = (int[]) arrayIns(temp, 7);
		print(newTemp);

		// ================改变数组的长度=====================

	}

	/**
	 * 新建数组
	 * @param oldArray
	 *            传入的旧数组
	 * @param len
	 *            新建数组的长度
	 * @return 返回新的newArray数组
	 */
	public static Object arrayIns(Object oldArray, int len) {
		// 通过数组得到Class对象
		Class<?> c = oldArray.getClass();
		// 得到数组的Class对象
		Class<?> arr = c.getComponentType();
		// 开辟新的数组
		Object newArray = Array.newInstance(arr, len);
		// 取得旧数组的长度
		int oLen = Array.getLength(oldArray);
		// 复制数组的内容arraycopy(被复制的数组,开始复制的位置，要复制到的数组，开始粘贴的位置，需要复制元素的个数)
		System.arraycopy(oldArray, 1, newArray, 0, oLen-1);

		return newArray;
	}

	/**
	 * 打印数组
	 * @param object 出入要打印的数组 
	 */
	public static void print(Object object) {
		Class<?> c = object.getClass();
		if (!c.isArray()) {
			return;
		}
		Class<?> arr = c.getComponentType();
		System.out.println(arr.getName()
				+ "数组长度：" + Array.getLength(object));
		for(int i = 0; i < Array.getLength(object); i++) {
			System.out.print(Array.get(object, i));
			if (i < Array.getLength(object)-1) {
				System.out.print("、");
			}
		}
		
	}

}
