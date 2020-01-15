package company.oracle.phone;
// TODO
public class LongestConsecutiveSequence {
    class UnionFind {
        int array[];

        public UnionFind(int n) {
            this.array = new int[n];
            for(int i=0;i<n;i++){
                array[i] = i;
            }
        }

        public void union(int a, int b) {
            array[find(a)] = find(b);
        }

        public int find(int a) {
            while (array[a] != a) {
                a = array[a];
            }
            return a;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public int longestConsecutive(int[] nums) {
        return 0;
    }
}
