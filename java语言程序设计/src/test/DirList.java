package test;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        File path = new File("c:/");
        String[] list = path.list();
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}

