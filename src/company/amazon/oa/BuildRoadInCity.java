package company.amazon.oa;

import java.util.PriorityQueue;

/**
 * numTotalAvailableCities = 6
 * numTotalAvailableRoads = 3
 * roadsAvailable = [[1, 4], [4, 5], [2, 3]]
 * numNewRoadsConstruct = 4
 * costNewRoadsConstruct = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
 * Output 应该是： 7
 * 解释：numTotalAvailableCities = 6 意思是城市的编号从 1 到 6。基于提供的 roadsAvailable list, 这 6 个城市中 已经形成了三个岛， 分别为 [1, 4, 6], [2, 3] 和 [6]。 现在要从 costNewRoadsConstruct list 中选一些路来建使得所有的城市都被连接。这个例子中，显然要选择[1, 2, 5] 和 [1, 6, 2] 这两条路。总的 cost 就是 5 + 2 = 7。
 */
public class BuildRoadInCity {

    public static int getMinimumCost(int numTotalAvailableCities,
                                     int numTotalAvailableRoads,
                                     int[][] roadsAvailable,
                                     int numNewRoadsConstruct,
                                     int[][] costNewRoadsConstruct) {
        if (numTotalAvailableCities < 2 || numTotalAvailableRoads < 1) {
            return 0;
        }

        UnionFind uf = new UnionFind(numTotalAvailableCities);
        // Union all connected cities
        for (int i = 0; i < numTotalAvailableRoads; i++) {
            int city1 = roadsAvailable[i][0];
            int city2 = roadsAvailable[i][1];
            if (uf.isConnected(city1, city2)) {
                uf.union(city1, city2);
            }
        }
        // Populate cost in Priority Queue
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);

        for (int i = 0; i < numNewRoadsConstruct; i++) {
            int city1 = costNewRoadsConstruct[i][0];
            int city2 = costNewRoadsConstruct[i][1];
            int cost = costNewRoadsConstruct[i][2];
            pq.offer(new Node(city1, city2, cost));
        }

        // Select min cost to connect cities
        int cost = 0;
        while (uf.getNumOfComponent() > 1 && !pq.isEmpty()) {
            Node node = pq.poll();
            uf.union(node.city1, node.city2);
            cost += node.cost;
        }
        return uf.getNumOfComponent() > 1 ? -1 : cost;
    }

    public static void main(String[] args) {
        int[][] roadsAvailable = {{1, 4}, {4, 5}, {2, 3}};
        int[][] costNewRoadsConstruct = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        System.out.println(getMinimumCost(6, 3, roadsAvailable, 4, costNewRoadsConstruct));
    }

    public static class Node {
        int city1;
        int city2;
        int cost;

        public Node(int city1, int city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            this.parent = new int[size + 1];
            for (int i = 1; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getNumOfComponent() {
            int count = 0;
            for (int i = 1; i < parent.length; i++) {
                if (i == parent[i]) {
                    count++;
                }
            }
            return count;
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
