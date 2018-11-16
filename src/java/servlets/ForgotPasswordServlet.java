/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.NotesDBException;
import database.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.AccountService;

/**
 *
 * @author awarsyle
 */
public class ForgotPasswordServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            //as.forgotPassword(user.getEmail(), getServletContext().getRealPath("/WEB-INF"));
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
   
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        try {
            UserDB udb = new UserDB();
            AccountService as = new AccountService();
            String email = request.getParameter("emailaddress");
            User user = udb.getUserbyEmail(email);
            
            
    
        if(as.forgotPassword(user.getEmail(), getServletContext().getRealPath("/WEB-INF")) == true)
            {
                request.setAttribute("confirm", "email sent.");
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        } catch (NotesDBException ex) {
            Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
    }


}
