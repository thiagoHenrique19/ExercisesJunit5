package Exercicios.fizzbuzz_solver;

public class FizzBuzzSolver {
    public String solve(int input) {
//
        final boolean multipleOfThree =_isMultipleOf(3, input);
        final boolean multipleOfFive =_isMultipleOf(5, input);
//
//        if (multipleOfThree && multipleOfFive) {
//            return "FizzBuzz";
//        }
        if (multipleOfFive) {
            return "Buzz";
        }
        if (multipleOfThree) {
            return "Fizz";
        }
        return null;
    }
//
    boolean _isMultipleOf(int number, int input) {
        return input % number == 0;
    }
}
