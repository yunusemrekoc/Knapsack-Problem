package knapsackProblem;

import java.io.*;

public class KnapsackProblem {

	int[] pageNumber = new int[10];
	int[] weight = new int[10];
	static final int maxCap = 5;
	methods m = new methods();

	static String[] rooms = { "Psychology", "History", "Engineering",
			"Sociology", "Biology" };

	public void inputReadTxt() throws FileNotFoundException, IOException {

		File fileTxt = new File("input.txt");
		BufferedReader bf = null;
		bf = new BufferedReader(new FileReader(fileTxt));
		String row = bf.readLine();

		while (row != null) {

			for (int l = 0; l < 5; l++) {

				if (rooms[l].compareTo(row) == 0) {

					row = bf.readLine();
					String[] numb = row.split("\\s+");
					while (numb.length == 2 && row != null) {

						for (int k = 0; k < 10; k++) {
							if (numb.length != 2) {
								break;
							}
							pageNumber[k] = Integer.parseInt(numb[1]);
							weight[k] = Integer.parseInt(numb[0]);

							row = bf.readLine();
							if (row != null)
								numb = row.split("\\s+");
						}

					}

					System.out.println(rooms[l] + ":"
							+ m.knap(maxCap, weight, pageNumber, 10));
					weight = new int[10];
					pageNumber = new int[10];
				}

			}
			row = bf.readLine();
		}
	}

}
