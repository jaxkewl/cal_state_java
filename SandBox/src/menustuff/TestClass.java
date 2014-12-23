package menustuff;

import java.awt.TextArea;

public class TestClass {

	private String[] myArray;

	public TestClass() {

	}

	public static void main(String[] args) {
		System.out.println("HelloWorld");
		TestClass xClass = new TestClass();
		InnerClass iClass = xClass.new InnerClass();
		iClass.method1();
	}

	public class InnerClass {

		public void method1() {
			int size = myArray.length;
		}
	}
}
