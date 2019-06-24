package test;

import org.junit.Test;

import java.io.*;

public class TestFileStream {
    @Test
    public void f1(){
        try {
            FileInputStream inputStream = new FileInputStream("temp.dat");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            byte[] b = new byte[2];
//            inputStream.read(b,0,b.length);
//            System.out.println(b.toString());
//            System.out.println(inputStream.read());

            String s = bufferedReader.readLine();
            while (null != s){
                System.out.println(s);
                s = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("temp.dat");
            for (int i = 0; i < 10; i++){
                outputStream.write(i);
            }
            FileInputStream inputStream = new FileInputStream("temp.dat");
            int value;
            while((value = inputStream.read()) != -1){
                System.out.print(value + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
