import java.util.HashSet;
import java.util.Random;

public class CountOfEqual {
    public static void main(String... args) {
        /*Integer[] an = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] bn = {1, 2, 3, 4, 5};
        System.out.println(countOfEqual(an, bn));*/
        Random random = new Random();
        HashSet<Integer> hm = new HashSet<>();
        int nc = 100;
        int mc = 5;
        int ok = 0, fail = 0;
        for (int j = 10; j <= 300; j += 10) {
            int n = nc * j, m = mc * j;
            Integer[] a = new Integer[n];
            long count = 0;
            for (int i = 0; i < n; i++) {
                int k = random.nextInt();
                if (hm.add(k)) {
                    a[i] = k;
                    System.out.print(k + " ");
                } else {
                    i--;
                }
            }
            System.out.println();
            Integer[] b = new Integer[m];
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int k = random.nextInt();
                if (hs.add(k)) {
                    b[i] = k;
                    System.out.print(k + " ");
                    if (hm.contains(k)) {
                        count++;
                    }
                } else {
                    i--;
                }
            }
            System.out.println();
            if (count == countOfEqual(a, b)) {
                System.out.println("Ok " + count);
                ok++;
            } else {
                System.out.println("Fail " + count);
                fail++;
            }
        }
        System.out.println("Ok = " + ok + " Fail = " + fail);
    }

    public static long countOfEqual(Integer[] a, Integer[] b) {
        int n = a.length;
        int m = b.length;
        if (n < m) {
            Integer[] c = a;
            a = b;
            b = c;
        }
        long count = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer i : b) {
            hashSet.add(i);
        }
        for (Integer i : a) {
            count += hashSet.contains(i) ? 1 : 0;
        }
        return count;
    }
}
