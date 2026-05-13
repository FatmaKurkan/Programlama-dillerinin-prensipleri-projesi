 import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) { this.tokens = tokens; }

    public List<ASTNode> parse() {
        List<ASTNode> nodes = new ArrayList<>();
        while (!isAtEnd()) {
            nodes.add(statement());
        }

        // --- AST GÖRSELLEŞTİRME (Hocanın beklediği ağaç çıktısı) ---
        System.out.println("\n[AŞAMA 3] AST AĞACI İNŞA EDİLDİ:");
        System.out.println("ROOT (BrewProgram)");
        for (int i = 0; i < nodes.size(); i++) {
            boolean isLast = (i == nodes.size() - 1);
            System.out.print(nodes.get(i).toTreeString("    ", isLast));
        }
        System.out.println("----------------------------------------------\n");
        return nodes;
    }

    private ASTNode statement() {
        // Gramer Kuralları ve Syntax Error kontrolleri
        if (match(Token.Type.KAHVE_SEC)) {
            Token val = consume(Token.Type.STRING, "Syntax Error: Kahve adı eksik!");
            consume(Token.Type.SEMICOLON, "Syntax Error: ';' bekleniyor!");
            return new SelectNode(val.value);
        } else if (match(Token.Type.SUT_EKLE)) {
            consume(Token.Type.SEMICOLON, "Syntax Error: ';' bekleniyor!");
            return new MilkNode();
        } else if (match(Token.Type.SEKER_EKLE)) {
            Token val = consume(Token.Type.NUMBER, "Syntax Error: Şeker miktarı sayı olmalı!");
            consume(Token.Type.SEMICOLON, "Syntax Error: ';' bekleniyor!");
            return new SugarNode(Integer.parseInt(val.value));
        } else if (match(Token.Type.HAZIRLA)) {
            consume(Token.Type.SEMICOLON, "Syntax Error: ';' bekleniyor!");
            return new BrewNode();
        }
        throw new RuntimeException("Syntax Error: Bilinmeyen komut!");
    }

    private boolean match(Token.Type t) { if(check(t)){current++; return true;} return false; }
    private boolean check(Token.Type t) { return !isAtEnd() && peek().type == t; }
    private Token consume(Token.Type t, String m) { if(check(t)) return tokens.get(current++); throw new RuntimeException(m); }
    private Token peek() { return tokens.get(current); }
    private boolean isAtEnd() { return peek().type == Token.Type.EOF; }
}
