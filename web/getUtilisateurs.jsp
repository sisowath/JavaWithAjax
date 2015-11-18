<%@page import="com.samnang.entites.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page import="com.samnang.jdbc.dao.implementation.UtilisateurDao"%>
<%@page import="com.samnang.jdbc.Connexion"%>
<%
        Class.forName( request.getServletContext().getInitParameter("jdbcDriver") );
        Connexion.setUrl( request.getServletContext().getInitParameter("databaseURL") );
        UtilisateurDao unUtilisateurDao = new UtilisateurDao( Connexion.getInstance() );
        List<Utilisateur> uneListeDesUtilisateursActives = unUtilisateurDao.findAllActive();        
        if( uneListeDesUtilisateursActives != null ) {
%>
            <table border="1px solid black">
                <tr>
                    <th colspan="4">Listes des utilisateurs actives</th>
                </tr>            
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Etat</th>
                </tr>
<%                
            for(int i=0; i < uneListeDesUtilisateursActives.size(); i++) {
                out.println("<tr>");
                out.println("<td>" + uneListeDesUtilisateursActives.get(i).getId() + "</td>");
                out.println("<td>" + uneListeDesUtilisateursActives.get(i).getNom() + "</td>");
                out.println("<td>" + uneListeDesUtilisateursActives.get(i).getPrenom() + "</td>");
                out.println("<td>" + uneListeDesUtilisateursActives.get(i).getEtat() + "</td>");
                out.println("<tr>");
            }
            out.println("<table>");
        }        
%>