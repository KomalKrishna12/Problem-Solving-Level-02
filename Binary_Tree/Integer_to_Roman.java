import java.util.HashMap;

public class Integer_to_Roman {

    static HashMap<Integer, String> hm;

    public static String intToRoman(int num) {
        String s = "";

        if (hm.containsKey(num))
            return hm.get(num);

        HashMap<Integer, String> onedigit = new HashMap<>();
        onedigit.put(1, "I");
        onedigit.put(2, "II");
        onedigit.put(3, "III");
        onedigit.put(4, "IV");
        onedigit.put(5, "V");
        onedigit.put(6, "VI");
        onedigit.put(7, "VII");
        onedigit.put(8, "VIII");
        onedigit.put(9, "IX");

        if (onedigit.containsKey(num))
            return onedigit.get(num);
        if (hm.containsKey(num + 1))
            return s += hm.get(1) + hm.get(num + 1);
        if (hm.containsKey(num - 1))
            return s += hm.get(num - 1) + hm.get(1);

        if (num > 10 && num < 51) {

            while (num >= 10) {
                s += hm.get(10);
                num -= 10;
            }
            if (num != 0)
                s += onedigit.get(num);
        }

        if (num > 100 && num < 501) {
            while (num >= 100) {
                s += hm.get(100);
                num -= 100;
            }
            while (num >= 50) {
                s += hm.get(50);
                num -= 50;
            }

            while (num >= 10) {
                s += hm.get(10);
                num -= 10;
            }

            if (num != 0)
                s += onedigit.get(num);
        } else if (num > 500 && num < 1001) {
            while (num >= 500) {
                s += hm.get(500);
                num -= 500;
            }
            while (num >= 100) {
                s += hm.get(100);
                num -= 100;
            }
            while (num >= 50) {
                s += hm.get(50);
                num -= 50;
            }

            while (num >= 10) {
                s += hm.get(10);
                num -= 10;
            }

            if (num != 0)
                s += onedigit.get(num);
        } else {
            while (num >= 1000) {
                s += hm.get(1000);
                num -= 1000;
            }
            while (num >= 500) {
                s += hm.get(500);
                num -= 500;
            }
            while (num >= 100) {
                s += hm.get(100);
                num -= 100;
            }
            while (num >= 50) {
                s += hm.get(50);
                num -= 50;
            }

            while (num >= 10) {
                s += hm.get(10);
                num -= 10;
            }

            if (num != 0)
                s += onedigit.get(num);
        }

        return s;
    }

    public static void main(String[] args) {
        int num = 1994; 
        hm = new HashMap<>();
        hm.put(1, "I");
        hm.put(5, "V");
        hm.put(10, "X");
        hm.put(50, "L");
        hm.put(100, "C");
        hm.put(500, "D");
        hm.put(1000, "M");

        System.out.println(intToRoman(num));
    }

}
