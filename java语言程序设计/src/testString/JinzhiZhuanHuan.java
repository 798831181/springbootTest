package testString;

        import java.util.Scanner;

public class JinzhiZhuanHuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.next();
            System.out.println(Integer.parseInt(string.substring(2),16));
        }
    }
}
