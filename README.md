# BigInteger Calculator

## Overview
The **BigInteger Calculator** is a command-line application that performs arbitrary-precision arithmetic operations without relying on external libraries for the core functionality. Developed to demonstrate the ability to handle large integers and complex mathematical operations programmatically. The program is wrapped in a REPL (Read-Eval-Print Loop) to allow continuous interaction with the user.

## Features
- **Supported Operations**:
  - Addition (`+`)
  - Subtraction (`-`)
  - Multiplication (`*`)
  - Division (`/`)
  - Modulo (`%`)
  - Exponentiation (`^`)
  - Factorial (`factorial <number>`)
- **Arbitrary-Precision**: Handles numbers of any size without losing accuracy.
- **Error Handling**: Detects unsupported operations, invalid inputs, and division by zero.

## How to Use
Navigate to the src folder, then to the BigIntegerCalculator folder, where the BigIntegerCalculator.java file containing the code is located.
1. Clone the repository or copy the code into a Java environment such Eclipse.
2. Compile and run the program using a Java compiler.
3. Interact with the REPL by entering operations. For example:
   - `12345678901234567890 + 98765432109876543210`
   - `factorial 9` (this is the format of writing factorial otherwise it can output unsupported operation)
   - `10 ^ 15`
   - `1234567890 / 3`
4. Type `exit` to quit the program.

### Example Interaction
```
BigInteger Calculator - Enter 'exit' to quit.
Enter operation: 12345678901234567890 + 98765432109876543210
Result: 111111111011111111100
Enter operation: factorial 9
Result: 362880
Enter operation: exit
```

## Implementation Details
- **Core Arithmetic**:
  - Implemented using character-by-character manipulation to simulate mathematical operations like addition, subtraction, and multiplication.
  - Avoids using libraries like `java.math.BigInteger` to demonstrate manual implementation.
- **Factorial**:
  - Supports calculating factorial using iterative multiplication.
  - Factorial is accessed via `factorial <number>` to clarify input format.
- **Exponentiation**:
  - Implemented using the method of repeated squaring for efficiency.
- **REPL Design**:
  - Provides an interactive loop for user input, processes commands, and prints results dynamically.

## Challenges and Solutions
- **Handling Negative Results**:
  - Subtraction throws an error if the result is negative, as only non-negative integers are supported.
- **Parsing Input**:
  - Designed a flexible parser to split input into operands and operators while handling various symbols like `+`, `*`, `^`, etc.
- **Error Handling**:
  - Incorporated checks for invalid inputs and division by zero.

## Future Improvements
1. **Enhanced Input Parsing**:
   - Add support for shorthand notation like `9!` for factorial.
2. **Negative Numbers**:
   - Extend functionality to handle negative numbers and results.
3. **Additional Operations**:
   - Implement logarithms, roots, and support for fractions.
4. **Non-Decimal Bases**:
   - Add support for operations in binary, hexadecimal, or other bases.
5. **Performance Optimization**:
   - Optimize algorithms for faster computation of very large numbers.

## Thought Process
The program was designed to:
1. Solve the problem of arbitrary-precision arithmetic without external libraries.
2. Emphasize the implementation of basic mathematical operations from scratch.
3. Demonstrate clean coding practices and interactive design via the REPL.

## Running the Program
Ensure you have a Java compiler installed. Use the following steps to run the program:
1. Save the code to a file named `BigIntegerCalculator.java`.
2. Open a terminal and navigate to the directory containing the file.
3. Compile the program with:
   ```
   javac BigIntegerCalculator.java
   ```
4. Run the program with:
   ```
   java BigIntegerCalculator
   ```

