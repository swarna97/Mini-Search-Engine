/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google;

         /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor./*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class clearHistory extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:MySql://localhost:3306/project", "root", "");

            Statement stmt = con.createStatement();
            i = stmt.executeUpdate("truncate table search");

            out.println("<html>");
            out.println("<head><title>Search History</title>");

            out.println("<style>");
            //  out.println("#imgid{ width:450px;height:150px;");
            out.println("body{background-image: url('img.jpg');background-size:cover;background-repeat: no-repeat;}");
            // out.println("h5{ font-family: Papyrus,fantasy;font-size: 15px;font-style: normal;font-variant:normal;font-weight: bold;line-height:20px;}");
            //out.println("h2{ font-family: Papyrus;font-size: 17px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 25px;}");
            out.println("h1{ font-family: Papyrus;color:white;font-size: 35px;font-style: normal;font-variant:small-caps;font-weight: bold;line-height: 25px;}");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");

            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");

            //out.println("<img src="miniature.jpg"  id="imgid"><br>");
            if (i != 0) {

                out.println("<center><h1>History has not been cleared<h2></center>");
            } else {
                out.println("<center><h1>history has  been cleared<h2></center>");

            }
            out.println("</body></html>");

        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();
    }

}
