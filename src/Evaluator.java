import java.util.List;

public class Evaluator {
    private BrewEnvironment env = new BrewEnvironment();

    public void evaluate(List<ASTNode> nodes) {
        // Ağacı yukarıdan aşağıya dolaşma (Traversal)
        for (ASTNode node : nodes) {
            node.execute(env);
        }
    }
}
