import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_121683 {
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
