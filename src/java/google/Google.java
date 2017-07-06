/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//url parsing
package google;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
//import java.nio.charset.StandardCharsets;
import java.sql.*;
//import java.util.Arrays;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Google extends HttpServlet {

    public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
   

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String word = request.getParameter("search");
        String results = request.getParameter("results");
        int num = Integer.parseInt(results);
        String searchURL = GOOGLE_SEARCH_URL + "?q=" + word + "&num=" + num;
        int j = 0;
        
      
        Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
        Elements result = doc.select("h3.r > a");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:MySql://localhost:3306/project", "root", "");

            Statement stmt = con.createStatement();
String check = "GOOGLE";
            out.println("<html>");
            out.println("<style>");
            out.println("body{background-image: url('img.jpg');background-size:cover;background-repeat: no-repeat;}");
         out.println("a{ font-family: Papyrus,fantasy;color:white;font-size: 15px;font-style: normal;font-variant:normal;font-weight: bold;line-height:20px;}");
             out.println("h2{ font-family: Papyrus;color:white;font-size: 17px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 25px;}");
             out.println("h4{ font-family: Papyrus;color:white;font-size: 17px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 25px;}");
             out.println("h6{ font-family: Papyrus;color:white;font-size: 14px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 16px;}");
            out.println("</style>");
            out.println("<title>" + word + "</title>");
            
	out.println("</head>");
	out.println("<body>");
        out.println("<center><h2>RESULTS</h2></center>");
       
    out.println("<center><a href=https://www.google.co.in/?gfe_rd=cr&ei=BjXlV9ifH5DT8gftzoTQAQ>"+check+"</a></center>");
    out.println("<br><br><br>");   
    String url;
    
      
    for (Element res : result) {
      
            
                
                String linkHref = res.attr("href");
                String linkText = res.text();
                
                url = linkHref.substring(7, linkHref.indexOf("&"));
         
               
                out.println(" <h4>" + linkText + "</h4>");    
                out.println("URL: <a href="+url+" >" + url+ "</a>");
               out.println("<br>");      
                j = stmt.executeUpdate("insert into search(word,text,url) values('" + word + "','" + linkText + "','" + url + "')");

            
         
      
            
        }
            out.println("<br><br>");
            if (j != 0) {
                out.println("<center><h6>Search  results  added  to  database successfully</h6></center>");
            } else {
                out.println("<h6>unsuccessful</h6>");
            }
            out.println("</body>");
            out.println("</html>");
    } 
    
    
        
          catch (Exception e2) {
            System.out.println(e2);
        }
    }
    }
