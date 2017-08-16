package knapsackProblem;

import knapsackProblem.KruskalAlgo.Graph_Edge;
import knapsackProblem.KruskalAlgo.DataSubset;

public class methods {
	static int maximum(int first, int next) {
		return (first > next) ? first : next;
	}

	static int knap(int maxCap, int weight[], int pageNumb[], int n) {
		int k, x;
		int[][] knapSack = new int[n + 1][maxCap + 1];

		for (k = 0; k <= n; k++) {
			for (x = 0; x <= maxCap; x++) {
				if (k == 0 || x == 0) {
					knapSack[k][x] = 0;
				} else if (weight[k - 1] <= x) {
					knapSack[k][x] = maximum(pageNumb[k - 1]
							+ knapSack[k - 1][x - weight[k - 1]],
							knapSack[k - 1][x]);
				} else {
					knapSack[k][x] = knapSack[k - 1][x];
				}
			}
		}

		return knapSack[n][maxCap];
	}

	int findSub(DataSubset subsets[], int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = findSub(subsets, subsets[i].parent);
		}

		return subsets[i].parent;
	}

	void findUnion(DataSubset subsets[], int x, int y) {
		int rootX = findSub(subsets, x);
		int rootY = findSub(subsets, y);

		if (subsets[rootX].rank > subsets[rootY].rank) {
			subsets[rootY].parent = rootX;
		} else if (subsets[rootX].rank < subsets[rootY].rank) {
			subsets[rootX].parent = rootY;
		} else {
			subsets[rootY].parent = rootX;
			subsets[rootX].rank++;
		}
	}

}
