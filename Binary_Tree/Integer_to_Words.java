import java.util.Scanner;

public class Integer_to_Words {
    static String[] till_twenty = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"} ;

    static String[] tens = {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"} ;
    
    public static String get_nums(int num) {
        
        String s = "" ;
        if (num > 19) {
            s += tens[num/10] ;
            
            if(num % 10 != 0){
            s += " " ;
            s += till_twenty[num % 10] ;
            }
        }
        else{
            s = till_twenty[num] ;
        }

        return s ;
    }

    static String convertToWords(long n) {
        
        
        int crore = (int) (n / 10000000) ;
        n = n % 10000000 ;

        int lakh = (int) (n/ 100000) ;
        n = n % 100000 ;

        int thousand = (int) (n/1000) ;
        n  = n % 1000 ;

        int hundread = (int) (n/100) ;
        n = n % 100 ;

        int tens = (int) (n) ;
        n = n % 10 ;

        String word = "" ;

        if (crore != 0) {
            word += get_nums(crore) +" crore " ;
        }

        if(lakh != 0){
            word += get_nums(lakh) + " lakh " ;
        }

        if(thousand != 0){
            word += get_nums(thousand) + " thousand " ;
        }

        if(hundread != 0){
            word += get_nums(hundread) + " hundred " ;
        }

        if (tens!= 0 && word.length() == 0 ) {
            word += get_nums(tens) ;
        }
        else if(tens!= 0 && word.length() != 0 ) {
            word = word + "and " +get_nums(tens) ;
        }

        // System.out.println(word);
        return word ;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        System.out.println(convertToWords(num));
        scn.close();
    }
}
