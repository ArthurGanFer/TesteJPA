/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller;

import com.br.lp3.model.dao.GenericDAO;
import com.br.lp3.model.entities.Livro;
import com.br.lp3.model.entities.UserInfo;
import com.br.lp3.model.entities.UserLP3;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31338283
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    @EJB
    private GenericDAO dao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");

            UserInfo ui = new UserInfo();
            ui.setEmail("arthur.ganfer@gmail.com");
            ui.setFullname("Arthur Gandriann");

            Livro livro1 = new Livro();
            livro1.setAutor("C. S. Lewis");
            livro1.setNome("As Cronicas de Narnia");

            Livro livro2 = new Livro();
            livro2.setAutor("V. Popozuda");
            livro2.setNome("As Valesca");

            List<Livro> livros = new ArrayList<>();
            livros.add(livro1);
            livros.add(livro2);

            UserLP3 user = new UserLP3();
            user.setUsername("arthur");
            user.setPassword("123");
            user.setUserinfo(ui);
            user.setLivros(livros);

            dao.create(user);

            List<UserLP3> lista = dao.read();
            for (UserLP3 u : lista) {
                out.println("<p>" + u + "</p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
