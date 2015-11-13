package com.samnang.web.mvc;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControleurFrontal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if ("login".equals(action)) {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signin");  //redirection vers la servlet login
                r.forward(request, response);     
                return;
            }            
            if ("logout".equals(action)) {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signout");  //redirection vers la servlet login
                r.forward(request, response);                
            }            
            if("inscription".equals(action)) {                
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signup");
                r.forward(request, response);
            }
            if ("passwordForgot".equals(action)) {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/passwordForgot");  //redirection vers la servlet login
                r.forward(request, response);                
            }     
            if ("passwordReset".equals(action)) {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/passwordReset");  //redirection vers la servlet login
                r.forward(request, response);                
            }    
            if( "trouverUnJoueur".equals(action) ) {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/findAPlayer");
                r.forward(request, response);
            }
            if( "demanderUneAlliance".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/sendAlliance").forward(request, response);
            }
            if( "consulterDemandeAlliance".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/showFriendRequest").forward(request, response);
            }
            if( "accepterDemandeAlliance".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/allianceAccepted").forward(request, response);
            }
            if( "envoyerUnMessagePrive".equals(action) ) {
                //request.getServletContext().getRequestDispatcher("/index_templating.jsp?thePage=contact").forward(request, response);
                request.getServletContext().getRequestDispatcher("/sendPrivateMessage").forward(request, response);
            }
            if( "publierUnMessage".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/postAMessage").forward(request, response);
            }
            if( "pve".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/index.jsp?thePage=pve").forward(request, response);
                //request.getServletContext().getRequestDispatcher("/gotoPvE").forward(request, response);
            }
            if( "pvp".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/index.jsp?thePage=pvp").forward(request, response);
                //request.getServletContext().getRequestDispatcher("/gotoPvP").forward(request, response);
            }
            if( "inventaire".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/index.jsp?thePage=inventaire").forward(request, response);
                //request.getServletContext().getRequestDispatcher("/gotoInventory").forward(request, response);
            }
            if( "garage".equals(action) ) {
                request.getServletContext().getRequestDispatcher("/index.jsp?thePage=garage").forward(request, response);
                //request.getServletContext().getRequestDispatcher("/gotoGarage").forward(request, response);
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    public String getServletInfo() {
        return "Short description";
    }
}