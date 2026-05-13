 Proje Adı: CoffeeLang
CoffeeLang, bir kahve makinesinin tüm çalışma mantığını dijital bir ortama aktaran, Java diliyle geliştirilmiş özel bir Yorumlayıcı (Interpreter) projesidir. Bu proje, karmaşık komutları adım adım analiz ederek gerçek bir programlama dili gibi işler.

Dilin Özellikleri
CoffeeLang, hem bir öğrenci projesi sadeliğinde hem de profesyonel bir derleyici mimarisi ciddiyetindedir:

Hiyerarşik İşleyiş: Dil, mantıksal bir sıra gözetir. Örneğin; kahve türü seçilmeden ek malzeme eklenmesine veya hazırlama aşamasına geçilmesine izin vermez.

Sözcüksel Analiz (Lexer): Yazdığınız her kelimeyi (Örn: kahveSec, sutEkle) tek tek tanır ve anlamlı parçalara ayırır.

Sözdizimi Denetimi (Parser): Kodun gramer kurallarına uyup uymadığını (noktalı virgül eksikliği gibi) kontrol eder.

Anlamsal Güvenlik (Semantic Check): Kodun yazımı doğru olsa bile mantıksal bir hata olup olmadığını (Kahve seçilmeden "hazırla" denmesi gibi) denetler.

Dinamik Runtime Hafızası: Seçilen kahve türünü, şeker miktarını ve süt tercihini çalışma anında hafızasında tutarak en doğru çıktıyı üretir.

Hata Raporlama: Kullanıcı bir hata yaptığında, hatanın nerede olduğunu (Syntax Error veya Semantic Error olarak) açıkça belirtir.


CoffeeLang dilinin tüm kuralları hiyerarşik bir yapıya sahiptir. Aşağıdaki Backus-Naur Form (BNF) gösterimi, dilin hangi komutları hangi sırayla kabul ettiğini belirleyen resmi kurallar bütünüdür:

BNF
<Program>      ::= <KomutListesi>
<KomutListesi> ::= <Komut> | <Komut> <KomutListesi>
<Komut>        ::= <SecimKomutu> | <EklemeKomutu> | <AksiyonKomutu>

<SecimKomutu>  ::= "kahveSec" <Metin> ";"
<EklemeKomutu> ::= "sutEkle" ";" | "sekerEkle" <TamSayi> ";"
<AksiyonKomutu> ::= "hazirla" ";"

<Metin>        ::= "\"" [a-zA-Z]+ "\""
<TamSayi>      ::= [0-9]+
Kuralların Açıklaması:
<Program>: Kodun en üst seviyesidir ve bir komut listesinden oluşur.

<SecimKomutu>: Mutlaka kahveSec kelimesiyle başlar, tırnak içinde bir metin alır ve ; ile biter.

<EklemeKomutu>: Süt ekleme veya şeker miktarını belirleme işlemlerini kapsar. Şeker miktarı mutlaka tam sayı olmalıdır.

<AksiyonKomutu>: Siparişi tamamlayan hazirla komutudur.

Noktalı Virgül (;): Her komutun bittiğini Parser'a bildiren zorunlu duraktır.

Not: Bu yapı, projedeki Parser.java dosyanın kodlarını nasıl kontrol ettiğinin bir özetidir. 
 Projenin Kurulumu ve Çalıştırılması
Bu projeyi kendi bilgisayarınızda test etmek için teknik karmaşaya girmeden şu basit adımları izleyebilirsiniz:

1. Dosyaları Hazırlama
GitHub sayfasındaki sağ üstte bulunan yeşil "Code" butonuna tıklayın.

"Download ZIP" seçeneği ile projeyi bilgisayarınıza indirin ve klasöre (masaüstüne) çıkarın.

2. Geliştirme Ortamına Aktarma (IDE)
Eclipse, IntelliJ veya VS Code gibi kullandığınız Java geliştirme programını açın.

"Import" (İçeri Aktar) diyerek indirdiğiniz klasörü projenize dahil edin.

3. Programı Başlatma
src klasörü içerisinde yer alan Main.java dosyasını açın.

Programın üst kısmındaki "Run" (Çalıştır/Oynat) butonuna basın.

4. Sonuçları Gözlemleme
Program çalıştığında, alt kısımdaki Konsol (Console) ekranında CoffeeLang dilinin komutları nasıl işlediğini göreceksiniz.

Main.java içindeki örnek kodlar değiştikçe, konsol ekranında adım adım kahve hazırlama aşamaları veya sistemin yakaladığı hatalar görüntülenecektir.
