import com.calculator.expression.evaluation.Evaluator;
import com.calculator.expression.primitives.VariablesScope;

final public class InterpreterExample {
    public static void main(String[] args) {
        final VariablesScope variables =
                new VariablesScope.Builder()
                        .setVar("a", 2)
                        .setVar("b", 6)
                        .build();
        final String expressionText = "a b ^";
        final Evaluator evaluator = new Evaluator(expressionText, variables);
        final int result = evaluator.evaluate();
        System.out.println(result);
    }
}