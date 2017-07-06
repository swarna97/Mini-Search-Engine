/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor./*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class History extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:MySql://localhost:3306/project", "root", "");
            
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from search");
            out.println("<html>");
                out.println("<head><title>Search History</title>");
               
                out.println("<style>");
               
                out.println("body{background-image: url('img.jpg');background-size:cover;background-repeat: no-repeat;}");
         out.println("h5{ font-family: Papyrus;color:white;fantasy;font-size: 30px;font-style: normal;font-variant:normal;font-weight: bold;line-height:20px;}");
             out.println("h2{ font-family: Papyrus;color:white;font-size: 35px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 25px;}");
             out.println("h4{ font-family: Papyrus;color:white;font-size: 35px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 25px;}");
              out.println("h3{ font-family: Papyrus;color:white;font-size: 25px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 25px;}");
             out.println("a{ font-family: Papyrus;color:white;font-size: 15px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 16px;}");
            out.println("</style>");
                
                out.println("</head>");
                out.println("<body>");
               
              //  out.println("<img src="miniature.jpg"  id="imgid"><br>");
                 out.println("<center><h2>Search History</h2></center>");
            while (rs.next()) {
                
                
                out.println("<h4>" + rs.getString("word") + "</h4>");
                out.println("<h5>" + rs.getString("text") + "</h5>");
                //out.println("<h3>" + rs.getString("url") + "</h3>");
                out.println("<a href=" + rs.getString("url") + ">" + rs.getString("url") + "</a>");
                //out.println("URL: <a href="+url+" >" + url+ "</a>");
            
            }
    out.println("</body></html>");
               

        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();
    }

}
