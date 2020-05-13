import java.util.HashMap;
import java.util.Map;

/*
    In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

    If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.
    You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.



    Example 1:

    Input: N = 2, trust = [[1,2]]
    Output: 2
    Example 2:

    Input: N = 3, trust = [[1,3],[2,3]]
    Output: 3
    Example 3:

    Input: N = 3, trust = [[1,3],[2,3],[3,1]]
    Output: -1
    Example 4:

    Input: N = 3, trust = [[1,2],[2,3]]
    Output: -1
    Example 5:

    Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    Output: 3


    Note:

    1 <= N <= 1000
    trust.length <= 10000
    trust[i] are all different
    trust[i][0] != trust[i][1]
    1 <= trust[i][0], trust[i][1] <= N
    */

class PerfectSquare {

    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
//        for (int i = -1024; i <= 1024; i++) {
//            if (perfectSquare.isPerfectSquare(i))
        System.out.println("isPerfectSquare " + perfectSquare.isPerfectSquare(2147483647));
//        }
        int[][] arr = new int[][]{{1, 2}, {2, 1}};
//        System.out.println("findJudge " + perfectSquare.findJudge(2, arr));

    }

    public int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (N == 1)
            return 1;
        for (int i = 0; i < trust.length; i++) {
            int[] arr = trust[i];
            if (hashMap.containsKey(arr[1])) {
                hashMap.put(arr[1], hashMap.get(arr[1]) + 1);
            } else {
                hashMap.put(arr[1], 1);
            }
        }
        for (int i = 0; i < trust.length; i++) {
            int[] arr = trust[i];
            if (hashMap.containsKey(arr[0])) {
                hashMap.remove(arr[0]);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if ((int) entry.getValue() == N - 1)
                return (int) entry.getKey();
        }
        return -1;
    }

    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            num = -1 * num;
        }
        long sqr = 0;
        long i = 1;
        while (sqr < num) {
            try {

                sqr = i * i;
                if (sqr > Integer.MAX_VALUE)
                    return false;
                if (sqr == num) {
                    System.out.println("isPerfectSquare " + i);
                    return true;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


}