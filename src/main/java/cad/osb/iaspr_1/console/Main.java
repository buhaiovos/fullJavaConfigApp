package cad.osb.iaspr_1.console;

public class Main {
    public static void main(String... args) {
        Integer int1 = 1;
        Integer int2 = 1;
        System.out.println(int1 == int2);
        int1 = 127;
        int2 = 127;
        System.out.println(int1 == int2);
        int1 = 128;
        int2 = 128;
        System.out.println(int1 == int2);

    }
}
