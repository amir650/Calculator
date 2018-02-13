import com.calculator.expression.evaluation.Evaluator;
import com.calculator.expression.primitives.VariablesScope;

final public class InterpreterExample {
    public static void main(String[] args) {
        final VariablesScope variables =
                new VariablesScope.Builder()
                        .setVar("a", 5)
                        .setVar("b", 10)
                        .setVar("c", 2)
                        .build();
        final String expressionText = "a b + c *";
        final Evaluator evaluator = new Evaluator(expressionText, variables);
        final int result = evaluator.evaluate();
        System.out.println(result);
    }
}