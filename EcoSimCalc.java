import java.util.Scanner;

public class EcoSimCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to EcoSim Calc  Invasive Species Growth Estimator");
        System.out.println("This tool calculates the result of the function f(x) = ab^x\n");

        try {
            System.out.print("Enter value for a: ");
            double a = scanner.nextDouble();

            System.out.print("Enter value for b (b > 0 and b ≠ 1): ");
            double b = scanner.nextDouble();

            if (b <= 0 || b == 1.0) {
                System.out.println(" Error: b must be greater than 0 and not equal to 1.");
                return;
            }

            System.out.print("Enter value for x (e.g., weeks): ");
            double x = scanner.nextDouble();

            double result = a * Math.pow(b, x);
            System.out.printf("\n Result: f(x) = %.6f%n", result);

        } catch (Exception e) {
            System.out.println(" Error: Invalid input. Please enter numeric values only.");
        } finally {
            scanner.close();
        }

        System.out.println("\n Thank you for using EcoSim Calc!");
    }
}
