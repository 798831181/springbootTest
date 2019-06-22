package test;


import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        String key;
        String path;
        String filename;
        while (scanner.hasNext()){
            path = scanner.next();
            int id = path.lastIndexOf("\\");
            filename = id < 0 ? path : path.substring(id + 1);
            int lineNum = scanner.nextInt();
            key = filename + " " + lineNum;
            if (map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else {
                map.put(key, 1);
            }

        }
        scanner.close();
        /*
        对记录进行排序
         */
        List<Map.Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
            //降序
            @Override
            public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                return(arg1.getValue()-arg0.getValue()) == 0 ? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
            }
        });
        //只输出前8条
        int m=0;
        for(Map.Entry<String, Integer> mapping : list){
            m++;
            if(m<=8){
                String[] str = mapping.getKey().split(" ");
                String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String n = str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());
            }else{
                break;
            }

        }

    }
}
