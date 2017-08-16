package knapsackProblem;

import java.io.*;

public class Test {
	public static void main(String[] args) throws IOException {

		KnapsackProblem knapsack = new KnapsackProblem();

		int vertex = 10;
		int edges = 48;
		KruskalAlgo kr_algo = new KruskalAlgo(vertex, edges);
		kr_algo.arrayReader();
		int m = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (KruskalAlgo.matrix[i][j] != 0) {

					kr_algo.Gr_edge[m].source = KruskalAlgo.var[i];
					kr_algo.Gr_edge[m].destination = KruskalAlgo.var[j];
					kr_algo.Gr_edge[m].weight = KruskalAlgo.matrix[i][j];
					m++;
				}

			}
		}

		int total = kr_algo.MST();

		System.out.println("Total Lenghth of the MST:" + total + "m\n");
		System.out.println("KNAPSACK");
		knapsack.inputReadTxt();
	}
}
