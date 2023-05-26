import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    class Solution {
        public static String solution(String input_string) {
            String answer = "";
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                char ch = (char) ((char) 'a' + i);
                int count = 0;
                int firstIndex = input_string.length();
                int lastIndex = -1;
                for (int j = 0; j < input_string.length(); j++) {
                    if (input_string.charAt(j) == ch) {
                        count++;
                        firstIndex = j < firstIndex ? j : firstIndex;
                        lastIndex = j > lastIndex ? j : lastIndex;
                    }
                }
                if (count >= 2 && firstIndex + count != lastIndex + 1) {
                    list.add(String.valueOf(ch));
                }
            }
            if (list.size() == 0) return "N";
            list.sort(Comparator.naturalOrder());
            for (String str : list)
                answer += str;

            return answer;
        }
    }

    // add test code
    public static void main(String[] args) {
        System.out.println(Solution.solution("edeaaabbccd"));
        System.out.println(Solution.solution("eeddee"));
        System.out.println(Solution.solution("string"));
        System.out.println(Solution.solution("zbzbz"));
    }
}