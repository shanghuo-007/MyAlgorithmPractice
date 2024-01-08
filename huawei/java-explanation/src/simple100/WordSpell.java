package simple100;

import java.util.Scanner;

public class WordSpell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = scanner.next();
        }
        String chars = scanner.next();

        int res = getSpellCount(words, chars);
        System.out.println(res);


    }

    private static int getSpellCount(String[] words, String chars) {
        int res = 0;
        //万能字符数量
        int wildcard = 0;
        //使用a-z的ASCII值作为数组存储
        char[] charArray = chars.toCharArray();
        int [] arr = new int[255];
        for (char c : charArray) {
            if (c == '?'){
                wildcard++;
                continue;
            }
            arr[c]++;
        }

        for (String word : words) {
            //每次都要重新拷贝一份，因为每次检查都会修改数组
            int [] temp = arr.clone();
            if (isSpellable(word, temp, wildcard)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isSpellable(String word, int[] arr, int wildcard) {
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            if (arr[c] > 0) {
                arr[c]--;
            } else if (wildcard > 0) {
                wildcard--;
            } else {
                return false;
            }
        }
        return true;
    }


}
