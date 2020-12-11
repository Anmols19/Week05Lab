/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 783856
 */
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
                
                  HttpSession session = request.getSession();
                  String holder = (String)session.getAttribute("uName");

          
          request.setAttribute("passedUName", holder);
          request.setAttribute("passedBName", "Welcome");
          getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
          return;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        request.setAttribute("passedUName", " ");
        request.setAttribute("passedBName", "Loged Off");
        
        	HttpSession session = request.getSession();
                session.invalidate();
          getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
          return;
    }

}
