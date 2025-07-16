import java.util.Scanner;
50
public class EcoSimCalc {
2
    public static double calculateExponential(double a, double b, int x) {
        double power = 1.0;
        for (int i = 0; i < x; i++) {
            power *= b;
        }
        return a * power;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter initial growth (a) in cm: ");
        double a = input.nextDouble();

        System.out.print("Enter weekly growth rate (b): ");
        double b = input.nextDouble();

        System.out.print("Enter number of weeks (x): ");
        int x = input.nextInt();

        if (b <= 0 || b == 1 || x < 0) {
            System.out.println("Invalid input. 'b' must be > 0 and ≠ 1, and 'x' must be ≥ 0.");
        } else {
            double result = calculateExponential(a, b, x);
            System.out.printf("Estimated growth after %d weeks: %.2f cm%n", x, result);
        }

        input.close();
    }
}