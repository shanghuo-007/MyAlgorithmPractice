import java.util.*;

/**
 * 5G网络建设
 *
 * 理解：
 * 应该是图的最短路径
 */
public class FiveGNetworkConstruction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            ArrayList arrayList = new ArrayList(4);
            for (int j = 0; j < 4; j++) {
                arrayList.add(input.nextInt());
            }
            nums.add(arrayList);
        }

        System.out.println(calculateMinBaseStation(N,M,nums));


    }

    private static int calculateMinBaseStation(int N,int M,ArrayList<ArrayList<Integer>> nums) {
        HashSet<Integer> connected = new HashSet<>();
        int res = 0;

        //按成本排序
        Collections.sort(nums, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2)-o2.get(2);
            }
        });
        for (ArrayList<Integer> num : nums) {
            //已联通，全部添加到set中
            if (num.get(3) == 1) {
                connected.add(num.get(0));
                connected.add(num.get(1));
            }
        }

        for (ArrayList<Integer> num : nums) {
            if (num.get(3) == 0) {
                //如果都不在set中，累加成本价格
                if (!connected.contains(num.get(0)) || !connected.contains(num.get(1))) {
                    res += num.get(2);
                    connected.add(num.get(0));
                    connected.add(num.get(1));
                }
            }
        }
        return res;
    }
}
