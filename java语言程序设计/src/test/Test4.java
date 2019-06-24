package test;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        int M = 0;
        int N = 0;
        int A = 0;
        int B = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            int[] score = new int[N];
            for (int i = 0; scanner.hasNext() && i < N; i++) {
                score[i] = scanner.nextInt();
            }
            String c = null;
            for (int i = 0; scanner.hasNext(); i++) {
                c = scanner.next();
                A = scanner.nextInt();
                B = scanner.nextInt();
                process(c,A,B,score);
            }

        }
    }

    private static void process(String c, int a, int b, int[] score) {
        int begin,end;

        if(c.equals("Q")){
            end = Math.max(a, b);
            begin = Math.min(a, b)-1;
            int max = score[begin];
            for(int i=begin;i<end;i++){
                if(max<score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
            score[a-1] = b;
        }
    }

}