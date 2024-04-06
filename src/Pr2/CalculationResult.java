import java.io.Serializable;

/**
 * Клас, який представляє результат обчислення.
 */
public class CalculationResult implements Serializable {
    private double parameter1;
    private double parameter2;
    private double result;

    /**
     * Конструктор для ініціалізації об'єкта результату обчислення.
     * 
     * @param parameter1 Параметр 1.
     * @param parameter2 Параметр 2.
     */
    public CalculationResult(double parameter1, double parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = parameter1 + parameter2;
    }

    /**
     * Отримати значення параметра 1.
     * 
     * @return Значення параметра 1.
     */
    public double getParameter1() {
        return parameter1;
    }

    /**
     * Отримати значення параметра 2.
     * 
     * @return Значення параметра 2.
     */
    public double getParameter2() {
        return parameter2;
    }

    /**
     * Отримати результат обчислення.
     * 
     * @return Результат обчислення.
     */
    public double getResult() {
        return result;
    }
}