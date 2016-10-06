import com.calculator.expression.evaluation.Evaluator;
import com.calculator.expression.primitives.VariablesScope;

final public class InterpreterExample {
    public static void main(String[] args) {
        final VariablesScope variables =
                new VariablesScope.Builder()
                        .setVar("w", 5)
                        .setVar("x", 10)
                        .setVar("z", 2)
                        .build();
        final String expressionText = "w x z - +";
        final Evaluator evaluator = new Evaluator(expressionText, variables);
        final int result = evaluator.evaluate();
        System.out.println(result);
    }
}