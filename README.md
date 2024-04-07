### Використання командного рядка Java для обчислення енергії та тестування

Цей Java-застосунок дозволяє обчислювати енергію фізичного тіла та тестувати різноманітні функції через командний рядок.
## AbstractTableRenderer.java
 ```bash
       public abstract class AbstractTableRenderer implements CalculationResultRenderer {
    public abstract String renderTable(CalculationResult result, int displayOption);
}
```
## CalculationResult.java
 ```bash
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
```

## CalculationResultRenderer.java
 ```bash
      public interface CalculationResultRenderer {
    String render(CalculationResult result, int displayOption);
} 
```


## EnergyCalculator.java
 ```bash
    
public class EnergyCalculator {
    public static double calculateTotalEnergy(double mass, double velocity, double height) {
        return mass * velocity * velocity / 2 + mass * 9.81 * height;
    }
}   
```


## HTMLResultRenderer.java
 ```bash
      public class HTMLResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        // Implementation for rendering as HTML table
        return "<html><body>Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult() + "</body></html>";
    }
} 
```


## SerializationDemo.java
 ```bash
      import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializationDemo {
    public static void main(String[] args) {
        CalculationResult deserializedResult = null;
        try (FileInputStream fis = new FileInputStream("calculation_result.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            deserializedResult = (CalculationResult) ois.readObject();
            CalculationResultRenderer renderer = new TextResultRenderer();
            System.out.println(renderer.render(deserializedResult, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 
```

## Solver.java
 ```bash
      public class Solver {
    public static void main(String[] args) {
        // Ваш код здесь
    }
} 
```


## TextResultRenderer.java
 ```bash
       public class TextResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return "Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult();
    }
}
```
## TextTableRenderer.java
 ```bash
     

public class TextTableRenderer extends AbstractTableRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return renderTable(result, displayOption);
    }

    @Override
    public String renderTable(CalculationResult result, int displayOption) {
        StringBuilder table = new StringBuilder();
        
        table.append("+-----------------------+\n");
        table.append("|   Parameter   |   Value   |\n");
        table.append("+-----------------------+\n");
        table.append(String.format("|    Parameter1 |  %.2f   |\n", result.getParameter1()));
        table.append(String.format("|    Parameter2 |  %.2f   |\n", result.getParameter2()));
        table.append(String.format("|       Result   |  %.2f   |\n", result.getResult()));
        table.append("+-----------------------+\n");
        
        return table.toString();
    }
}  
```

## Test.java
 ```bash
       

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
```

### Ось результат ↓

![Результат](/screenshot/image.png)




