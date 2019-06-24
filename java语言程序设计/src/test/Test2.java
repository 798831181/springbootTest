package test;

public class Test2 {
    public static double fun1(double base, int exp){
        if(exp == 0)
            return 1;
        if(exp == 1)
            return base;
        double result = fun1(base, exp >> 1);
        result *= result;
        if((exp & 1) == 1){
            result *= base;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fun1(3,2));

    }
}
