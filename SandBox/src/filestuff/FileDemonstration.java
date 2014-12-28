package filestuff;

import java.io.File;
import java.util.Scanner;

public class FileDemonstration {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a directory");
		String dir = input.nextLine();
		analyzePath(dir);
	}

	// perform path analyzation
	public static void analyzePath(String path) {
		File name = new File(path);
		char bslash = File.separatorChar;

		if (name.exists()) {
			if (name.isDirectory()) {
				System.out.println("This is a directory");
				// do directory stuff
				File[] files = name.listFiles();
				for (File f : files) {
					System.out.println(name.getAbsolutePath() + bslash
							+ f.getName());
				}
			} else {
				System.out.println("This is a file");
				// do file stuff
				System.out.println(name.getAbsolutePath() + bslash
						+ name.getName());
			}
		}
	}
}
