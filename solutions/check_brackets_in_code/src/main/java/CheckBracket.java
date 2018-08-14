import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckBracket {

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Bracket firstUnmatchedClosingBracket = null;
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position));
                continue;
            }

            if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.isEmpty() || !opening_brackets_stack.pop().match(next)) {
                    firstUnmatchedClosingBracket = new Bracket(next, position);
                    break;
                }
            }
        }

        if (firstUnmatchedClosingBracket != null) {
            System.out.println(firstUnmatchedClosingBracket.position+1);
        } else {
            if (opening_brackets_stack.size() != 0) {
                System.out.println(opening_brackets_stack.pop().position+1);
            } else {
                System.out.println("Success");
            }
        }
    }
}
