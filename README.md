
# Proje Ad� 

��renci Bilgi Sistemi (Student Information System = SIS)
	
	
# Projeyi geli�tiren 

�zge AYDIN


# Versiyon  

0.0.1-SNAPSHOT	
	
	
# Projenin Sunduklar�

## 1- �EH�RLER
1.1- T�m �ehirler sayfada PrimeFaces �n table yap�s� ile listelenebilmektedir.
1.2- Yeni �ehir eklenebilmektedir.
1.3- Se�ilen �ehir g�ncellenebilmektedir.
1.4- Se�ilen �ehir silinebilmektedir.
	1.4.1- �ehire ba�l� t�m il�eler de silinecektir.
	
## 2- iL�ELER
2.1- T�m il�eler sayfada PrimeFaces �n table yap�s� ile listelenebilmektedir.
2.2- �l baz�nda yeni il�e eklenebilmektedir.
2.3- Se�ilen il�e g�ncellenebilmektedir.
2.4- Se�ilen il�e silinebilmektedir.

### 3- ��RENC�LER
3.1- T�m ��renciler sayfada PrimeFaces �n table yap�s� ile listelenebilmektedir.
3.2- Yeni ��renci eklenebilmektedir.
3.3- Se�ilen ��renci g�ncellenebilmektedir.
3.4- Se�ilen ��renci silinebilmektedir.
	3.4.1- ��rencinin belgesi olmas� halinde o belgeler de silinecektir.

### 4- ��RENC� BELGELER�

4.1- T�m ��renci belgeleri sayfada PrimeFaces �n table yap�s� ile listelenebilmektedir.
	4.1.1- ��renci baz�nda ��renci belgesi listelenebilmektedir.
	4.1.2- T�m ��renci ve ��renci belgeleri listelenebilmektedir.
4.2- Her ��renci i�in birden fazla ��renci belgeleri eklenebilmektedir.
4.3- Se�ilen ��renci belgesi g�ncellenebilmektedir.
4.4- Se�ilen ��renci belgesi silinebilmektedir.


* src/main/test alt�na Birim test classlar� olu�turulmu�tur. Kullan�lan test classlar�nda ilgili class Repository lerinde kullan�lan metodlar�n testleri yap�lm��t�r.
* Projeye AdminFaces temas�n� pom.xml e dahil edilip kullan�ld�. resources klas�r� alt�na css eklenerek k���k css de�i�iklikleri yap�ld�.
* Dosya Y�kleme ve indirme i�lemleri i�in PrimeFaces �n fileUpload ve fileDowload �zelliklerinden yararlan�ld�.
* T�m ekranlarda verilerin listenebilmesi i�in PrimeFaces �n table yap�lar�ndan RowGroup ve Sort �zellikleri kullan�ld�.
* �l�eler se�ilen �ehir de�erine g�re y�klenebilmesi i�in Ajax �zelliklerinden yararlan�ld�.
* ��renci cep telefonu numaras� i�in mask kullan�ld�.


# Kullan�lan Teknojiler 	

1-Kullan�c� aray�z� i�in JSF ve Primefaces kullan�ld�.
2-Proje yap�land�rmas�(konfig�rasyonu) Maven taraf�ndan yap�ld�.
3-Spring Framework kullan�ld�. 
4-HSQLDB'yi veritaban� olarak kullan�ld�.
5-Veritaban� ba�lant�s� i�in Hibernate'i kullan�ld�.

IDE : Spring Tool Suite (STS)

	
# Proje �al��t�r�lmas� 	

Proje yap�land�rmas�(konfig�rasyonu) Maven taraf�ndan yap�lm��t�r. Maven eklenti �zelli�i sayesinde bir servlet container olan Jetty sunucu yaz�l�m�n� projenin i�inde ta��maya imkan sa�l�yor.
Maven��n konfig�rasyon dosyas� olan pom.xml�e Jetty�nin plugi eklenmi�tir.
Eclipse yada STS de projeyi "Maven Project" olarak import ettikten sonra 
projeye sa� t�klay�p Run As -> Maven build se�erek gelen ekranda Goals k�sm�na "jetty:run" kodunu yaz�p �al��t�mam�z gerekmektedir.
Started jetty server durumuna geldi�inde taray�c�dan "http://localhost:8080/" adresinden projeye ula��labilir.

Test class lar�n� �al��t�rmak i�in de Run As -> jUnit Test se�erek test metodlar� �al��t�r�lmaktad�r.
Ya da test classlar�n�n i�inde Test metodalar� �zerinden de �al��t�r�labilmektedir.


 
	
	