import java.util.HashMap;

public class AnagramString {
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    StringBuilder sb1 = new StringBuilder(t);
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < sb1.length(); j++) {
        if (s.charAt(i) == sb1.charAt(j)) {
          sb1.deleteCharAt(j);
        }
      }
    }

    if (sb1.length() == 0) {
      return true;
    }
    return false;

  }

  public static boolean isAnagramHashMap(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Integer> hm = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!hm.containsKey(c)) {
        hm.put(c, 1);
      } else {
        hm.put(c, hm.get(c) + 1);
      }
    }
    System.out.println(hm);
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (hm.containsKey(c)) {
        if (hm.get(c) == 1) {
          hm.remove(c);
        } else {
          hm.put(c, hm.get(c) - 1);
        }
      }
      System.out.println(hm);
    }

    if (hm.isEmpty()) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("heart", "earth"));
    System.out.println(isAnagramHashMap("heart", "earth"));
  }
}
