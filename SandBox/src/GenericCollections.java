import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericCollections {

	private static String[] colors = { "RED", "BLUE", "GREEN", "PURPLE",
			"VIOLET", "NAVY" };
	private static String[] removeColors = { "BLUE", "VIOLET" };

	public GenericCollections() {

		// create our Array List of strings
		List<String> list = new ArrayList<String>();

		for (String str : colors) {
			list.add(str);
		}

		List<String> removeList = new ArrayList<String>();

		for (String str : removeColors) {
			removeList.add(str);
		}

		// now remove the colors
		Iterator<String> iter = list.iterator();
		// Iterator<String> str2 = removeList.iterator();

		while (iter.hasNext()) {

			if (removeList.contains(iter.next())) {
				iter.remove();
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericCollections genericCollections = new GenericCollections();

		// code for some linked list stuff

		List<String> colorList = new LinkedList<>();

		for (String color : colors) {
			colorList.add(color);
		}

		List<String> colorList2 = new LinkedList<>();
		for (String color : removeColors) {
			colorList2.add(color);
		}

		printList(colorList);
		printList(colorList2);

		// append colorList2 to colorList
		colorList.addAll(colorList2);
		colorList2 = null;

		printList(colorList);
	}

	private static void printList(Collection<String> list) {
		System.out.println("Printing out list");
		Iterator<String> iter = list.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}

		// for (String str : list) {
		// System.out.println(str);
		// }
	}

}
