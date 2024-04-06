

public class TextTableRenderer extends AbstractTableRenderer {
    @Override
    public String render(CalculationResult result) {
        return renderTable(result);
    }

    @Override
    public String renderTable(CalculationResult result) {
        // Реалізуйте метод для створення текстової таблиці тут
        return "Текстова таблиця з результатами";
    }
}