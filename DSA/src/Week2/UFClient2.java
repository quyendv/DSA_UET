package Week2;

import java.util.Scanner;

public class UFClient2 {
    private final int[] id;
    private final int[] sz;
    private int rNum;  // số gốc khác nhau

    public UFClient2(int n) {
        id = new int[n];
        sz = new int[n];
        rNum = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int i) {
        while (i != id[i]) { i = id[i]; }
        return i;
    }

    public int root(int i) {
        while (i != id[i]) {
            if (id[i] != id[id[i]]){
                id[i] = id[id[i]];
                rNum--;
            }
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
        rNum--;
    }

    public static void main(String[] args) {
        // em dùng Scanner thay cho thư viện algs4
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UFClient2 ufClient2 = new UFClient2(n);
        int index = 1;
        while (sc.hasNextInt()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (!ufClient2.connected(p, q)) {
                ufClient2.union(p, q);
            }
            if (ufClient2.rNum == 1) {  // khi số gốc về 1 <-> liên thông N đối tượng
                System.out.println(index);
                break;
            }
            index++;
        }
        if (ufClient2.rNum != 1) System.out.println("FAILED");
    }
}
