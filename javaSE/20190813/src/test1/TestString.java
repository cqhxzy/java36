package test1;

public class TestString {
    public static void main(String[] args) {
        String str = "";
        int max = 100000000;
        while (max > 0) {
            str = String.valueOf(Math.random()).intern();
            max--;
        }
    }
}
