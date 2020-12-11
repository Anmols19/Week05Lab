/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Models.User;
import Services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 783856
 */
public class LoginServlet extends HttpServlet {
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        Cookie[] cookies = request.getCookies();
      
        
        try{
        for(Cookie cookie: cookies){
      
          if(cookie.getValue().equals("adam") || cookie.getValue().equals("betty") ){
          
          String holder = (String)cookie.getValue();

          
          request.setAttribute("passedUName", holder);
          request.setAttribute("passedBName", "Welcome");
          getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
          return;
          
          }
        }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         
         
         
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String userN = request.getParameter("username");
        String passN = request.getParameter("password");
            
         if (userN == null || userN.equals("") ||
                passN == null || passN.equals("")) {
            request.setAttribute("message", "Please enter any missing values.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
         
         AccountService ac = new AccountService();
         User c = ac.login(userN, passN);
         String flag = "";
         
         try 
         {
         if(c==null){
             
           flag = "invaild Login Info";
        
           request.setAttribute("message",flag);
           request.setAttribute("show1", userN);
           request.setAttribute("show2", passN);
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
          return;
         }
         else
         {
          flag = c.getUsername();
         }         
         }
         catch(Exception e )
         {
             e.printStackTrace();
         }
        
        
        
         HttpSession session = request.getSession();
         session.setAttribute("uName", c.getUsername());
         Cookie ck = new Cookie("user",c.getUsername());
         ck.setPath("/");
         ck.setMaxAge(300);
         response.addCookie(ck);
         response.sendRedirect("./home");
          //return;
    }


}
