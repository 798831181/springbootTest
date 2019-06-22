package xiaozhao2018;

import java.util.Scanner;

public class SimulateMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        int[] res = new int[strings[0].length() + strings[1].length()];
        for (int i = strings[0].length() - 1; i > 0; i--){
            int x = strings[0].charAt(i) - '0';
            for (int j = strings[1].length() - 1; j > 0; j--){
                int y = strings[1].charAt(j) - '0';
                res[i + j] += (res[i + j + 1] + x * y) / 10;
                res[i + j + 1] += (res[i + j + 1] + x * y) % 10;
            }
        }
        String s = "";
        for (int i = 0; i < res.length; i++){
            if (i == 0 && res[i] == 0){
                continue;
            }
            s += res[i];
        }
        
        System.out.println(s);
    }
}
