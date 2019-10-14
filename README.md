
# Proje Adý 

Öðrenci Bilgi Sistemi (Student Information System = SIS)
	
	
# Projeyi geliþtiren 

Özge AYDIN


# Versiyon  

0.0.1-SNAPSHOT	
	
	
# Projenin Sunduklarý

## 1- þEHÝRLER
1.1- Tüm þehirler sayfada PrimeFaces ýn table yapýsý ile listelenebilmektedir.
1.2- Yeni þehir eklenebilmektedir.
1.3- Seçilen þehir güncellenebilmektedir.
1.4- Seçilen þehir silinebilmektedir.
	1.4.1- Þehire baðlý tüm ilçeler de silinecektir.
	
## 2- iLÇELER
2.1- Tüm ilçeler sayfada PrimeFaces ýn table yapýsý ile listelenebilmektedir.
2.2- Ýl bazýnda yeni ilçe eklenebilmektedir.
2.3- Seçilen ilçe güncellenebilmektedir.
2.4- Seçilen ilçe silinebilmektedir.

### 3- ÖÐRENCÝLER
3.1- Tüm öðrenciler sayfada PrimeFaces ýn table yapýsý ile listelenebilmektedir.
3.2- Yeni öðrenci eklenebilmektedir.
3.3- Seçilen Öðrenci güncellenebilmektedir.
3.4- Seçilen öðrenci silinebilmektedir.
	3.4.1- Öðrencinin belgesi olmasý halinde o belgeler de silinecektir.

### 4- ÖÐRENCÝ BELGELERÝ

4.1- Tüm öðrenci belgeleri sayfada PrimeFaces ýn table yapýsý ile listelenebilmektedir.
	4.1.1- Öðrenci bazýnda öðrenci belgesi listelenebilmektedir.
	4.1.2- Tüm öðrenci ve öðrenci belgeleri listelenebilmektedir.
4.2- Her öðrenci için birden fazla öðrenci belgeleri eklenebilmektedir.
4.3- Seçilen Öðrenci belgesi güncellenebilmektedir.
4.4- Seçilen öðrenci belgesi silinebilmektedir.


* src/main/test altýna Birim test classlarý oluþturulmuþtur. Kullanýlan test classlarýnda ilgili class Repository lerinde kullanýlan metodlarýn testleri yapýlmýþtýr.
* Projeye AdminFaces temasýný pom.xml e dahil edilip kullanýldý. resources klasörü altýna css eklenerek küçük css deðiþiklikleri yapýldý.
* Dosya Yükleme ve indirme iþlemleri için PrimeFaces ýn fileUpload ve fileDowload özelliklerinden yararlanýldý.
* Tüm ekranlarda verilerin listenebilmesi için PrimeFaces ýn table yapýlarýndan RowGroup ve Sort özellikleri kullanýldý.
* Ýlçeler seçilen þehir deðerine göre yüklenebilmesi için Ajax özelliklerinden yararlanýldý.
* Öðrenci cep telefonu numarasý için mask kullanýldý.


# Kullanýlan Teknojiler 	

1-Kullanýcý arayüzü için JSF ve Primefaces kullanýldý.
2-Proje yapýlandýrmasý(konfigürasyonu) Maven tarafýndan yapýldý.
3-Spring Framework kullanýldý. 
4-HSQLDB'yi veritabaný olarak kullanýldý.
5-Veritabaný baðlantýsý için Hibernate'i kullanýldý.

IDE : Spring Tool Suite (STS)

	
# Proje Çalýþtýrýlmasý 	

Proje yapýlandýrmasý(konfigürasyonu) Maven tarafýndan yapýlmýþtýr. Maven eklenti özelliði sayesinde bir servlet container olan Jetty sunucu yazýlýmýný projenin içinde taþýmaya imkan saðlýyor.
Maven’ýn konfigürasyon dosyasý olan pom.xml’e Jetty’nin plugi eklenmiþtir.
Eclipse yada STS de projeyi "Maven Project" olarak import ettikten sonra 
projeye sað týklayýp Run As -> Maven build seçerek gelen ekranda Goals kýsmýna "jetty:run" kodunu yazýp çalýþtýmamýz gerekmektedir.
Started jetty server durumuna geldiðinde tarayýcýdan "http://localhost:8080/" adresinden projeye ulaþýlabilir.

Test class larýný çalýþtýrmak için de Run As -> jUnit Test seçerek test metodlarý çalýþtýrýlmaktadýr.
Ya da test classlarýnýn içinde Test metodalarý üzerinden de çalýþtýrýlabilmektedir.


 
	
	