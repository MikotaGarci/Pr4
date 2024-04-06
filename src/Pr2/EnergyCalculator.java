

/**
 * Клас, який містить методи для обчислення енергії.
 */
public class EnergyCalculator {
    /**
     * Метод для обчислення повної енергії фізичного тіла.
     * 
     * @param mass     Маса тіла.
     * @param velocity Швидкість тіла.
     * @param height   Висота тіла.
     * @return Повна енергія фізичного тіла.
     */
    public static double calculateTotalEnergy(double mass, double velocity, double height) {
        return mass * velocity * velocity / 2 + mass * 9.81 * height;
    }
}