import java.util.Arrays;
import java.util.List;

/*
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            int sum = i + 1;
            boolean a = sum % 3 == 0;
            boolean b = sum % 5 == 0;
            arr[i] = a && b ? "FizzBuzz" : a ? "Fizz" : b ? "Buzz" : sum + "";
        }
        List<String> list = Arrays.asList(arr);
        return list;
    }
}
