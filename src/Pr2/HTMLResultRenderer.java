public class HTMLResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        // Implementation for rendering as HTML table
        return "<html><body>Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult() + "</body></html>";
    }
}