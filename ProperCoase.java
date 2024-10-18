import java.util.Scanner;

public class ProperCoase {
  public static String toProperCase(String str) {
     String[] words = str.toLowerCase().split("\\s+");
     for (int i = 0; i < words.length; i++) {
     words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
     }
     StringBuffer res = new StringBuffer();
     for (int i = 0; i < words.length; i++) {
     res.append(words[i]+" ");

     }

    return new String(res);
  }

//  public static String catAndMouse(int x, int y, int z) {
//    String ans="";
//    int n=scanner.nextInt();
//    scanner.nextLine();
//    for(int i=0;i<n;i++){
//        x=scanner.nextInt();
//        y=scanner.nextInt();
//        z=scanner.nextInt();
//        int diffA=Math.abs(z-x);
//        int diffB=Math.abs(z-y);
//        if(diffA==diffB){
//        ans=ans+"Mouse C\n";
//        }else{
//        if(diffA>diffB){
//        ans=ans+"Cat A\n";
//
//        }else{
//        ans=ans+"Cat B\n";
//        }
//    }
//    }
//    return ans;
//
//
//}
//
//  private static final Scanner scanner = new Scanner(System.in);
//
//
//  public static String dayOfProgrammer(int year) {
//        String s=Integer.toString(year);
//        if((year<1918 )){
//            if(year%4==0){
//               return "12.09."+s;
//             }else{
//                return "13.09."+s;
//        }
//
//        }
//        else{
//            if(year==1918){
//            return "26.09."+s;
//
//            }else if(((year%4==0 && year%100!=0)||year%400==0)){
//
//              return "12.09."+s;
//            }else{
//
//              return "13.09."+s;
//            }
//        }
//
//    }
//

    public static void main(String[] args) {
      // System.out.println(dayOfProgrammer(1918));
        //      System.out.println(catAndMouse(0,0,0));
        System.out.println(toProperCase("adanJSJa KJKSA xc"));
    }

  
}
