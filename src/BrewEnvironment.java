/**
 * Hafıza (Environment) ve Sembol Tablosu görevi görür.
 */
public class BrewEnvironment {
    private String seciliKahve = "";
    private int seker = 0;
    private boolean sut = false;

    public void setSeciliKahve(String s) { this.seciliKahve = s; }
    public void setSeker(int n) { this.seker = n; }
    public void setSut(boolean b) { this.sut = b; }

    public void hazirla() {
        // ANLAMSAL ANALİZ (Semantic Analysis)
        // Kahve seçilmeden hazırlama yapılamaz (Mantık Hatası)
        if (seciliKahve.isEmpty()) {
            throw new RuntimeException("Semantic Error: Kahve seçilmeden hazırlama yapılamaz!");
        }
        
        System.out.println(">>> MAKİNE ÇALIŞIYOR: " + seciliKahve + " hazırlanıyor...");
        System.out.println(">>> ÖZELLİKLER: " + (sut?"Sütlü":"Sütsüz") + ", " + seker + " Şekerli.");
        System.out.println(">>> SONUÇ: Kahveniz hazır! ☕\n");
    }
} 
