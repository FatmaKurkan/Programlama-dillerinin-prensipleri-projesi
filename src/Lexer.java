 import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;
    private int pos = 0;

    public Lexer(String input) { this.input = input; }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (pos < input.length()) {
            char ch = input.charAt(pos);

            // Boşlukları atla
            if (Character.isWhitespace(ch)) { pos++; continue; }

            // PUNCTUATION (Noktalama) kontrolü
            if (ch == ';') { 
                tokens.add(new Token(Token.Type.SEMICOLON, ";")); 
                pos++; 
            }
            // STRING okuma (Tırnak içindeki metinler)
            else if (ch == '"') {
                StringBuilder sb = new StringBuilder(); pos++;
                while (pos < input.length() && input.charAt(pos) != '"') { 
                    sb.append(input.charAt(pos)); pos++; 
                }
                pos++; tokens.add(new Token(Token.Type.STRING, sb.toString()));
            } 
            // NUMBER (Sayı) okuma
            else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && Character.isDigit(input.charAt(pos))) { 
                    sb.append(input.charAt(pos)); pos++; 
                }
                tokens.add(new Token(Token.Type.NUMBER, sb.toString()));
            } 
            // KEYWORD (Anahtar Kelime) okuma
            else if (Character.isLetter(ch)) {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && Character.isLetter(input.charAt(pos))) { 
                    sb.append(input.charAt(pos)); pos++; 
                }
                String word = sb.toString();
                switch (word) {
                    case "kahveSec": tokens.add(new Token(Token.Type.KAHVE_SEC, word)); break;
                    case "sutEkle": tokens.add(new Token(Token.Type.SUT_EKLE, word)); break;
                    case "sekerEkle": tokens.add(new Token(Token.Type.SEKER_EKLE, word)); break;
                    case "hazirla": tokens.add(new Token(Token.Type.HAZIRLA, word)); break;
                    default: throw new RuntimeException("Syntax Error: Bilinmeyen komut -> " + word);
                }
            } else { throw new RuntimeException("Geçersiz karakter: " + ch); }
        }
        tokens.add(new Token(Token.Type.EOF, ""));
        return tokens;
    }
}
