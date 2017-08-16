package knapsackProblem;

import java.util.*;
import java.io.*;

public class KruskalAlgo {
	static int matrix[][] = new int[10][10];

	static String[] rooms = { "Psychology", "History", "Engineering",
			"Sociology", "Biology", "Business", "Languages", "Tourism",
			"Mathematics", "Theology" };

	static int[] var = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	methods m = new methods();

	class Graph_Edge implements Comparable<Graph_Edge> {

		int source, destination, weight;

		public int compareTo(Graph_Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	};

	class DataSubset {

		int parent, rank;
	};

	int Edge, Vertex;
	Graph_Edge Gr_edge[];

	KruskalAlgo(int vertex, int edge) {
		Vertex = vertex;
		Edge = edge;
		Gr_edge = new Graph_Edge[Edge];
		for (int i = 0; i < edge; ++i) {
			Gr_edge[i] = new Graph_Edge();
		}
	}

	int MST() {
		int count = 0;
		Graph_Edge resultSet[] = new Graph_Edge[Vertex];
		int edg = 0;
		int j = 0;
		for (j = 0; j < Vertex; ++j) {
			resultSet[j] = new Graph_Edge();
		}

		Arrays.sort(Gr_edge);

		DataSubset subsets[] = new DataSubset[Vertex];
		for (j = 0; j < Vertex; ++j) {
			subsets[j] = new DataSubset();
		}

		for (int k = 0; k < Vertex; ++k) {
			subsets[k].parent = k;
			subsets[k].rank = 0;
		}

		j = 0;

		while (edg < Vertex - 1) {

			Graph_Edge next_edge = new Graph_Edge();
			next_edge = Gr_edge[j++];

			int x = m.findSub(subsets, next_edge.source);
			int y = m.findSub(subsets, next_edge.destination);

			if (x != y) {
				resultSet[edg++] = next_edge;
				m.findUnion(subsets, x, y);
			}

		}

		System.out.println("KRUSKAL");

		for (j = 0; j < edg; ++j) {
			int x1 = resultSet[j].source;
			int x2 = resultSet[j].destination;
			String s1 = rooms[x1];
			String s2 = rooms[x2];
			System.out.println(s1 + " - " + s2 + "  " + resultSet[j].weight
					+ "m");
			count = count + resultSet[j].weight;
		}
		return count;
	}

	public void arrayReader() throws FileNotFoundException, IOException {
		File fileTxt = new File("input.txt");
		BufferedReader bf = null;
		bf = new BufferedReader(new FileReader(fileTxt));
		String row = bf.readLine();
		int n = 0;
		int m = 0;
		while (row != null) {

			m++;
			String[] sayi = row.split("\\s+");

			if (m > 10) {
				break;
			}
			for (int i = 0; i < 10; i++) {
				matrix[n][i] = Integer.parseInt(sayi[i]);
			}

			n++;

			row = bf.readLine();

		}

	}

}
