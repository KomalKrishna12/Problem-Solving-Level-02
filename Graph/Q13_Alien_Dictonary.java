import java.io.*;
public class Q13_Alien_Dictonary {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
    
        String[] words = br.readLine().split(" ");
    
        System.out.println(alienOrder(words));
      }
    
      public static String alienOrder(String[] words) {
    
      }
}
