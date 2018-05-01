package pojava.lab1.zadB;

import java.util.ArrayList;
import java.util.List;

public class StringiZKonsoli {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		String[] tab = new String[4];
		if (args.length == 4) {
			try {
				for (int i = 0; i < 4; i++) {
					list.add(args[i]);
					tab[i] = args[i];
				}
				System.out.println(list);
				for (int i = 0; i < 4; i++) {
					System.out.println(tab[i]);
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Podaj 4 argumenty");
				e.printStackTrace();
			}
		}
	}

}
