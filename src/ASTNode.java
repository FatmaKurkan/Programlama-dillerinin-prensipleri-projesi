 /**
 * Her düğüm hem kendini ağaç şeklinde yazdırmayı (Aşama 3) 
 * hem de kendini çalıştırmayı (Aşama 4) bilir.
 */
abstract class ASTNode {
    abstract void execute(BrewEnvironment env);
    abstract String toTreeString(String prefix, boolean isLast);
}

class SelectNode extends ASTNode {
    String type;
    SelectNode(String type) { this.type = type; }
    void execute(BrewEnvironment env) { env.setSeciliKahve(type); }
    @Override
    String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[SelectNode] ➔ \"" + type + "\"\n";
    }
}

class MilkNode extends ASTNode {
    void execute(BrewEnvironment env) { env.setSut(true); }
    @Override
    String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[MilkNode] ➔ Süt: Eklendi\n";
    }
}

class SugarNode extends ASTNode {
    int amount;
    SugarNode(int amount) { this.amount = amount; }
    void execute(BrewEnvironment env) { env.setSeker(amount); }
    @Override
    String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[SugarNode] ➔ Şeker: " + amount + "\n";
    }
}

class BrewNode extends ASTNode {
    void execute(BrewEnvironment env) { env.hazirla(); }
    @Override
    String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[BrewNode] ➔ EYLEM: HAZIRLA\n";
    }
}
