package simple100;

import java.util.Scanner;

public class APICounter {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //第一行 输入日api条数n
        int n = scanner.nextInt();
        //接下来n行 输入api
        String[] apis = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            apis[i] = str;
        }
        //最后一行 输入层级和待匹配关键字
        int level = scanner.nextInt();
        String keyword = scanner.next();
        //输出结果
        int res = getApiCount(apis, level, keyword);
        System.out.println(res);
    }

    private static int getApiCount(String[] apis, int level, String keyword) {
        int count = 0;
        for (String api : apis) {
            String[] temp = api.split("/");
            if(temp.length > level && temp[level].equals(keyword)){
                count++;
            }
        }
        return count;
    }

}


