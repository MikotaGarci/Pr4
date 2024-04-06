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
        // Testing calculation
        System.out.println("Testing calculation:");
        double mass = 10.0;
        double velocity = 5.0;
        double height = 20.0;
        double totalEnergy = EnergyCalculator.calculateTotalEnergy(mass, velocity, height);
        System.out.println("Total Energy: " + totalEnergy);

        // Testing rendering
        System.out.println("\nTesting rendering:");
        CalculationResult result = new CalculationResult(mass, velocity);
        CalculationResultRenderer renderer = new TextTableRenderer();
        String renderedResult = renderer.render(result);
        System.out.println("Rendered Result:\n" + renderedResult);
    }
}