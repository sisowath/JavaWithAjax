<%@page import="com.samnang.entites.Pays"%>
<%@page import="java.util.List"%>
<%@page import="com.samnang.jdbc.dao.implementation.PaysDao"%>
<%@page import="com.samnang.jdbc.Connexion"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<%
    /*
    if( request.getParameter("pays") != null) 
        out.println("<h3>SUCCESS</h3>");
    else 
        out.println("<h3>FAIL</h3>");
    */
    Class.forName( request.getServletContext().getInitParameter("jdbcDriver") );
    Connexion.setUrl( request.getServletContext().getInitParameter("databaseURL"));
    PaysDao unPaysDao = new PaysDao( Connexion.getInstance() );
    List<Pays> listeDesVilles = unPaysDao.findAllCity( request.getParameter("pays") );        
        if(listeDesVilles.size() > 0 ) {
            out.println("<select id=\"villes\">");
            for(int i=0 ; i < listeDesVilles.size(); i++) {                
                out.println("<option value=\"" + listeDesVilles.get(i).getVille() + "\">" + listeDesVilles.get(i).getVille() + "</option>");
                
            }
            out.println("</select>");
        } else {
            out.println("<h3>Erreur d'affichage</h3>");
        }
%>
</body>
</html>