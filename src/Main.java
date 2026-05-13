 import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Denemek istediğiniz kod satırı
        String kaynakKod="kahveSec\"Latte\";\n"+
        "sutEkle;\n" +
        "sekerEkle 2; \n"+
        "hazirla;";
      
    	
    	
        try {
            // AŞAMA 2: Sözcüksel Analiz
            Lexer lexer = new Lexer(kaynakKod);
            List<Token> tokens = lexer.tokenize();
            
            // AŞAMA 3: Sözdizimsel Analiz (AST Oluşturma)
            Parser parser = new Parser(tokens);
            List<ASTNode> ast = parser.parse();
            
            // AŞAMA 4: Anlamsal Analiz ve Çalıştırma
            Evaluator eval = new Evaluator();
            eval.evaluate(ast);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
