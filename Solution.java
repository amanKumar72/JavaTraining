import java.util.Scanner;
import java.util.regex.Pattern;

class MyRegex{
    public static void main(String[] args) {
    }
    public Pattern pattern(){
        return Pattern.compile("[0-255].[0-255].[0-255].[0-255]");
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        s.matches(new MyRegex().pattern());
    }
}