

import java.util.Scanner;

/**
 * Клас для тестування основної функціональності.
 */
public class Test {
    /**
     * Метод для запуску тестів.
     * 
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter mass:");
        double mass = scanner.nextDouble();
        
        System.out.println("Enter velocity:");
        double velocity = scanner.nextDouble();

        System.out.println("Enter height:");
        double height = scanner.nextDouble();

        double totalEnergy = EnergyCalculator.calculateTotalEnergy(mass, velocity, height);
        System.out.println("Total Energy: " + totalEnergy);

        System.out.println("\nSelect display option (1 - Text table, 2 - HTML table):");
        int displayOption = scanner.nextInt();
        
        CalculationResultRenderer renderer;
        if (displayOption == 1) {
            renderer = new TextTableRenderer();
        } else {
            renderer = new HTMLResultRenderer();
        }

        CalculationResult result = new CalculationResult(mass, velocity);
        String renderedResult = renderer.render(result, displayOption);
        System.out.println("Rendered Result:\n" + renderedResult);
        
        scanner.close();
    }
}