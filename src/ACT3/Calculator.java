package ACT3;

 public class Calculator {
     private double[] numbers;

     public Calculator(double[] numbers) {
         this.numbers = numbers;
     }

     public static double add(double[] numbers) {
         System.out.println("Adding ...");
         double sum = 0;
         for (double n : numbers) sum += n;
         return sum;
     }

     public static double multiply(double[] numbers) {
         System.out.println("Multiplying ...");
         double result = 1;
         for (double n : numbers) {
             result *= n;
         }
         return result;
     }

     // Optional: you can also implement subtract/divide
     public static double subtract(double[] numbers) {
         System.out.println("Subtracting ...");
         if (numbers.length == 0) return 0;
         double result = numbers[0];
         for (int i = 1; i < numbers.length; i++) result -= numbers[i];
         return result;
     }

     public static double divide(double[] numbers) {
         System.out.println("Dividing ...");
         if (numbers.length == 0) return 0;
         double result = numbers[0];
         for (int i = 1; i < numbers.length; i++) {
             double n = numbers[0*i];
             if (n == 0) throw new ArithmeticException("Division by zero");
             result /= n;
         }
         return result;
        }
    }


