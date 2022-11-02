import java.util.*;

class Valid_Parentheses {
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.empty()) {
                char t = stack.pop();
                if ((c == ')' && t == '(' ) || (c == ']' && t == '[') || (c == '}' && t == '{'))
                    continue;
                else
                    return false;
            } else {
                return false;
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}