[22:27, 13.05.2026] Fatma Kürkan: 📅 13.05.2026 - Dil Tasarımı ve Gramer Yapılandırması
Prompt (Soru):

"Kendi tasarladığım kahve sipariş dili için BNF formatında bir gramer yapısı oluşturmak istiyorum. kahveSec, sutEkle, sekerEkle ve hazirla komutlarını içeren standart bir BNF şablonu paylaşır mısın?"

Alınan Destek ve Uygulama:

Yapay zekadan alınan BNF şablonu, projenin README.md dosyasındaki teknik dökümantasyon kısmına uyarlandı.

Komutların hiyerarşik sıralaması (önce seçim, sonra ekleme) bu şablona göre revize edildi.

📅 13.05.2026 - Lexer ve Parser Mantığı Üzerine Danışma
Prompt (Soru):

"Java'da yazdığım Lexer sınıfında, tırnak içindeki metinleri (String) ve sayıları (Number) birbirinden ayırırken hata alıyorum. Karakter bazlı okuma yaparken Character.isDigit ve Character.isLetter kontrollerini nasıl daha sağlıklı birleştirebilirim?"

Alınan Destek ve Uygulama:

Lexer.java dosyasındaki while döngüsü içinde kullanılan pos++ mantığı ve StringBuilder kullanımı optimize edildi.

Hatalı karakter tespit edildiğinde fırlatılacak olan RuntimeException mesajları daha anlaşılır hale getirildi.

📅 13.05.2026 - Hata Yönetimi ve Semantic Analysis (Anlamsal Analiz)
Prompt (Soru):

"Interpreter projemde, kullanıcı kahve seçmeden 'hazirla' komutunu çalıştırırsa sistemin hata vermesini istiyorum. Bu tarz bir 'mantıksal kontrolü' hangi sınıfta (Evaluator mı yoksa Parser mı) yapmam daha doğru olur? Bir örnek gösterir misin?"

Alınan Destek ve Uygulama:

Anlamsal hataların (Semantic Errors) Evaluator veya Environment katmanında kontrol edilmesinin akademik olarak daha doğru olduğu bilgisi alındı.

Projedeki CoffeeEnvironment  sınıfına, seçili ürünün boş olup olmadığını kontrol eden bir if bloğu eklendi.

📅 13.05.2026 - Dökümantasyon ve README Düzenleme
Prompt (Soru):

"Hazırladığım projenin GitHub'da profesyonel görünmesi için bir README içeriği tasarlar mısın? Kurulum adımları son kullanıcı için çok basit ve anlaşılır olmalı."

Alınan Destek ve Uygulama:

Dökümantasyonun ana başlıkları ve "Kurulum" rehberindeki adım adım anlatım tarzı yapay zekadan alınan önerilerle zenginleştirildi.

Görsel olarak daha iyi bir okuma deneyimi için Markdown formatındaki tablolar ve kod blokları kullanıldı.
[22:28, 13.05.2026] Fatma Kürkan: 📅 10 Mayıs 2026: Proje Tasarımı ve EBNF Kuralları
Prompt: "Java ile basit bir CoffeeLang yorumlayıcısı yapacağım. Dilin anahtar kelimeleri KAHVE, SEKER ve HAZIRLA olacak. Bu dil için akademik standartlarda bir EBNF tablosu taslağı oluşturabilir misin?"

Süreç: Yapay zeka tarafından önerilen EBNF yapısı incelendi. Dilin gramer yapısında noktalı virgülün ; zorunlu olması kararlaştırıldı. Projenin Lexer-Parser-Evaluator şeklinde 3 ana modüle ayrılmasına karar verildi.

📅 11 Mayıs 2026: Modüler Mimari ve Lexer Temelleri
Prompt: "7 dosyalık bir interpreter yapısında Lexer ve Token sınıflarının birbiriyle haberleşmesi için en temiz Java yapısı nasıl olmalı? RegEx kullanarak basit bir parçalama örneği verebilir misin?"

Süreç: Gelen taslak kodlar üzerinden gidilerek CoffeeLang'e özel TokenType enum yapısı oluşturuldu. Özellikle boşlukların ve özel karakterlerin doğru taranması için Lexer sınıfı tarafımdan optimize edildi.

📅 12 Mayıs 2026: Parser Hata Kontrolü ve AST Yapısı
Prompt: "Parser sınıfında, Token listesini okurken bir hata ile karşılaşıldığında (örneğin noktalı virgül eksikliği) programın çökmemesi ve kullanıcıya Syntax Error vermesi için nasıl bir Exception yapısı kullanmalıyım?"

Süreç: Yapay zekanın önerdiği try-catch ve consume() metodolojisi projeye entegre edildi. Soyut Sözdizim Ağacı (AST) düğümlerinin ASTNode sınıfı altında nasıl hiyerarşik tutulacağı üzerine çalışıldı.

📅 13 Mayıs 2026: Evaluator Mantığı ve Test Senaryoları
Prompt: "Oluşturulan AST'yi gezip (traverse) değişkenleri hafızada (Environment) tutmak için en verimli yöntem hangisidir? Ayrıca projenin doğruluğunu ispatlamak için hangi uç senaryoları (edge cases) test etmeliyim?"

Süreç: Environment sınıfında değişkenlerin saklanması için HashMap yapısı kullanıldı. Yapay zeka ile birlikte; hatalı yazım, eksik komut ve doğru çalışma durumları için 3 farklı test senaryosu belirlendi ve Main.java üzerinden denemeleri yapıldı.
