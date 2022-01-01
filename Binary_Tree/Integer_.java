public class Integer_ {
    static String[] tilltwenty = {"", "one", "two", "three", "four", "five", "six", "seven", "eight",
                                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                                "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
    static String[] tens = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};                            
    
    public static String getNum(int n){
        String s = "";
        if(n > 19){
            s += tens[n/10];
            if(n % 10 != 0){
                s += " ";
                s += tilltwenty[n % 10];
            }
        }
        else{
            s += tilltwenty[n];
        }
        return s;
    }

    public static String convertToWords(long n){
        int crore = (int)n / 10000000;
        n = n % 10000000;

        int lakh = (int)n / 100000;
        n = n % 100000;

        int thousands = (int)n / 1000;
        n = n % 1000;

        int hundred = (int)n / 100;
        n = n % 100;

        // int ten = n;

        String word = "";

        if(crore != 0){
            word += getNum(crore) + " crore ";
        }

        if(lakh != 0){
            word += getNum(lakh) + " lakh ";
        }

        if(thousands != 0){
            word += getNum(thousands) + " thousand ";
        }

        if(hundred != 0){
            word += getNum(hundred) + " hundred ";
        }

        if(n != 0){
            if(word.length() == 0){
                word += getNum( (int)n);
            }
            else{
                word = word + "and " + getNum((int)n);
            }
        }

        return word;
    }
    public static void main(String[] args) {
        System.out.println(convertToWords(123));
    }
}
