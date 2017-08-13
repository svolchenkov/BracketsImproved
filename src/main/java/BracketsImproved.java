import java.util.HashMap;
import java.util.Map;

/**
 * Created by sv120d on 8/7/2017.
 */
public class BracketsImproved {

    Map<Character, Integer> forward = new HashMap<>();
    Map<Character, Integer> backward = new HashMap<>();

    public BracketsImproved() {
        String[] strings = {
                "{()k}",
                "{[}",
                "{[}]",
                "{[()]}()",
                "{{{}[]}}{()}",
                "{}(){}",
                "{[()]}"
        };

        forward.put('{', 0);
        forward.put('(', 1);
        forward.put('[', 2);
        backward.put('}', 0);
        backward.put(')', 1);
        backward.put(']', 2);

        checkBrackets(strings);
    }

    public String[] checkBrackets (String[] input) {

        String[] retVal = new String[input.length];

        for ( int i = 0; i < input.length; i++) {
            retVal[i] = removeTwoBrackets(new StringBuilder(input[i])).toString();
            System.out.println(retVal[i]);
        }
        return retVal;
    }


    private StringBuilder removeTwoBrackets (StringBuilder input) {
        String flag = "";
        StringBuilder storagrSb = new StringBuilder();

        if (!input.toString().equals("")) {
            storagrSb.append(input.charAt(0));
            for (int i = 1; i < input.length(); i++) {
                if (forward.containsKey(input.charAt(i))) {
                    storagrSb.append(input.charAt(i));
                } else
                if (backward.containsKey(input.charAt(i))) {
                    if ( forward.get(storagrSb.charAt(storagrSb.length() - 1))  == backward.get(input.charAt(i))   ) {
                        storagrSb.setLength(storagrSb.length() - 1);
                    } else {
                        input.setLength(0);
                        flag = "NO";
                        break;
                    }
                } else {
                    flag = "NO";
                    break;
                }
                flag = i == input.length() - 1 ? "YES" : "NO";
            }
        }

        input = flag.equals("NO") ? new StringBuilder("NO") : new StringBuilder("YES");
        return input;
    }
}
