Web Scrapping and Pdf Download API

Build and run

1)Using the terminal
Go on the project's root folder, then type:

mvn spring-boot:run

2) Using Eclipse or ANy ide
Import as Existing Maven Project and run it as Java Application(Selecting FriendApplication)  or as  Spring Boot App.


Launch the application and go on http://localhost:8080/

1)Web Scrapping --
        http://localhost:8080/getProductDetails          
        
        give query parameter--url 
        Values(url of Amazon product Page u wanna Scrap)
        
2) Pdf Generation
  http://localhost:8080/downloadPdf
        
        
        give above API return payload in Body

