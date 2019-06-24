package testString;

public class StringPattern {

    public int findAppearance(String A, int lena, String B, int lenb) {
        // write code here
        if (A == null || B == null){
            return -1;
        }
        if (lena < lenb){
            return -1;
        }
        if (lena == lenb){
            if (A.equals(B)){
                return 0;
            }else {
                return -1;
            }

        }
//        int indexOfB = 0;
        int i = 0;

        while (i <= lena - lenb){
            if (A.charAt(i) == B.charAt(0)){
                String temp = A.substring(i,i + lenb);
                if (temp.equals(B)){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
     public int findAppearance2(String a, int lena, String b, int  lenb){
        return a.indexOf(b);
     }

    public static void main(String[] args) {
        StringPattern stringPattern = new StringPattern();
        int res = stringPattern.findAppearance("123",3,"3",1);
        System.out.println(res);
    }

}