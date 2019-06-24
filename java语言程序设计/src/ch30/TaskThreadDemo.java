package ch30;
class PrintChar implements Runnable{
    private char aChar;
    private int times;
    public PrintChar(char c, int t) {
        aChar = c;
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++){
            System.out.println(aChar);
        }
    }
}
class PrintNum implements Runnable{
    public PrintNum() {
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(i + "");
        }

    }
}
public class TaskThreadDemo {
    public static void main(String[] args) {
        /*
        创建任务
         */
        Runnable printA = new PrintChar('a',100);
        Runnable printB = new PrintChar('b',100);
        Runnable printNum = new PrintNum();

        Thread t1 = new Thread(printA);
        Thread t2 = new Thread(printB);
        Thread t3 = new Thread(printNum);

        t1.start();
        t2.start();
        t3.start();
    }


}
