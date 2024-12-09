package bigIntegerCalculator;

import java.util.Scanner;

public class BigIntegerCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("BigInteger Calculator - Enter 'exit' to quit.");

        while (true) {
            System.out.print("Enter operation: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                System.out.println("Result: " + evaluate(input));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Main function to evaluate input
    public static String evaluate(String input) {
        input = input.trim();
        String[] parts;
        if (input.contains("+")) {
            parts = input.split("\\+");
            return add(parts[0].trim(), parts[1].trim());
        } else if (input.contains("-")) {
            parts = input.split("-");
            return subtract(parts[0].trim(), parts[1].trim());
        } else if (input.contains("*")) {
            parts = input.split("\\*");
            return multiply(parts[0].trim(), parts[1].trim());
        } else if (input.contains("/")) {
            parts = input.split("/");
            return divide(parts[0].trim(), parts[1].trim());
        } else if (input.contains("%")) {
            parts = input.split("%");
            return modulo(parts[0].trim(), parts[1].trim());
        } else if (input.contains("^")) {
            parts = input.split("\\^");
            return power(parts[0].trim(), parts[1].trim());
        } else if (input.startsWith("factorial")) {
            String num = input.split(" ")[1].trim();
            return factorial(num);
        } else {
            throw new IllegalArgumentException("Unsupported operation");
        }
    }

    // Addition
    public static String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

    // Subtraction
    public static String subtract(String num1, String num2) {
        if (isSmaller(num1, num2)) {
            throw new IllegalArgumentException("Negative result not supported");
        }

        StringBuilder result = new StringBuilder();
        int borrow = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0) {
            int digit1 = num1.charAt(i--) - '0';
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            digit1 -= borrow;
            if (digit1 < digit2) {
                digit1 += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.append(digit1 - digit2);
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }

    // Multiplication
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (!(sb.length() == 0 && r == 0)) {
                sb.append(r);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    // Division
    public static String divide(String num1, String num2) {
        if (num2.equals("0")) {
            throw new ArithmeticException("Division by zero");
        }

        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();

        for (char c : num1.toCharArray()) {
            current.append(c);
            int currentVal = Integer.parseInt(current.toString());
            int divisor = Integer.parseInt(num2);

            result.append(currentVal / divisor);
            current = new StringBuilder(String.valueOf(currentVal % divisor));
        }

        return result.toString().replaceFirst("^0+(?!$)", "");
    }

    // Modulo
    public static String modulo(String num1, String num2) {
        return subtract(num1, multiply(divide(num1, num2), num2));
    }

    // Exponentiation
    public static String power(String num1, String num2) {
        String result = "1";
        String base = num1;
        int exponent = Integer.parseInt(num2);

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exponent /= 2;
        }

        return result;
    }

    // Factorial
    public static String factorial(String num) {
        String result = "1";
        String counter = "1";

        while (!counter.equals(add(num, "1"))) {
            result = multiply(result, counter);
            counter = add(counter, "1");
        }

        return result;
    }

    // Helper to check if num1 < num2
    private static boolean isSmaller(String num1, String num2) {
        if (num1.length() < num2.length()) return true;
        if (num1.length() > num2.length()) return false;
        return num1.compareTo(num2) < 0;
    }
}
