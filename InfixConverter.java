import java.util.Stack;

public class InfixConverter {

    // Returns precedence level of an operator
    static int precedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return -1;
    }

    // Checks if character is an operand (letter or digit)
    static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    // -----------------------------------------------
    // INFIX TO POSTFIX
    // -----------------------------------------------
    static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Skip spaces
            if (ch == ' ') continue;

            // If operand, add directly to output
            if (isOperand(ch)) {
                output.append(ch);
            }

            // If opening bracket, push to stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // If closing bracket, pop until opening bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop(); // remove the '(' itself
            }

            // If operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators from stack
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    // -----------------------------------------------
    // INFIX TO PREFIX
    // -----------------------------------------------
    static String infixToPrefix(String expression) {

        // Step 1: Reverse the expression
        StringBuilder reversed = new StringBuilder(expression).reverse();

        // Step 2: Swap '(' and ')' in the reversed string
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            } else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }

        // Step 3: Apply postfix algorithm on modified string
        String postfix = infixToPostfix(reversed.toString());

        // Step 4: Reverse the postfix result to get prefix
        return new StringBuilder(postfix).reverse().toString();
    }

    // -----------------------------------------------
    // MAIN METHOD
    // -----------------------------------------------
    public static void main(String[] args) {

        String[] expressions = {
            "A+B*C",
            "(A+B)*(C-D)",
            "A+B*C-D/E",
            "A*(B+C)-D^E"
        };

        System.out.println("=".repeat(55));
        System.out.printf("%-20s %-17s %-15s%n", "Infix", "Postfix", "Prefix");
        System.out.println("=".repeat(55));

        for (String expr : expressions) {
            String postfix = infixToPostfix(expr);
            String prefix  = infixToPrefix(expr);
            System.out.printf("%-20s %-17s %-15s%n", expr, postfix, prefix);
        }

        System.out.println("=".repeat(55));
    }
}
