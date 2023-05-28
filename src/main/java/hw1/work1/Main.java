package hw1.work1;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);
        /***
         * Ошибка происходит из-за того, что после операции minus переменная b == 0.
         * Операция devide (деления) невозможно. Нельзя делить на ноль.
         * Выходит ошибка - java.lang.ArithmeticException
         */
    }
}
