package test;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Collection<?>[] collections =
                {new HashSet<String>(), new ArrayList<String>(), new HashMap<String, String>().values()};
        Super subToSuper = new Sub();//Upcasting
        for(Collection<?> collection: collections) {
            System.out.println(subToSuper.getType(collection));//为什么不执行sub的getType()方法？
        }
        //test upcasting
//        System.out.println(subToSuper.getType(new ArrayList<>()));
    }
    abstract static class Super {
        public static String getType(Collection<?> collection) {
            return "Super:collection";
        }
        public static String getType(List<?> list) {
            return "Super:list";
        }
        public String getType(ArrayList<?> list) {
            return "Super:arrayList";
        }
        public static String getType(Set<?> set) {
            return "Super:set";
        }
        public String getType(HashSet<?> set) {
            return "Super:hashSet";
        }
    }
    static class Sub extends Super {

        /**
         * 静态方法不能被覆盖
         * @param collection
         * @return
         */
        public static String getType(Collection<?> collection) {
            return "Sub:collection";
        }




        @Override
        public String getType(ArrayList<?> list) {
            return "sub:arrayList";
        }
    }
}