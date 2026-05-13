/**
 * AŞAMA 2: Sözcüksel Analiz Birimleri
 * Kodun parçalandığında dönüştüğü en küçük anlamlı yapı taşlarıdır.
 */
public class Token {
    public enum Type {
        KAHVE_SEC,   // KEYWORD: kahveSec
        SUT_EKLE,    // KEYWORD: sutEkle
        SEKER_EKLE,  // KEYWORD: sekerEkle
        HAZIRLA,     // KEYWORD: hazirla
        STRING,      // IDENTIFIER/VALUE: "Mocha"
        NUMBER,      // VALUE: 2, 3
        SEMICOLON,   // PUNCTUATION: ;
        EOF          // End of File (Kodun sonu)
    }

    public Type type;
    public String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }
}
