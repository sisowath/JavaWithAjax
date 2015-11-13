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
    Class.forName( request.getServletContext().getInitParameter("jdbcDriver") );
    Connexion.setUrl( request.getServletContext().getInitParameter("databaseURL"));
    PaysDao unPaysDao = new PaysDao( Connexion.getInstance() );
    List<Pays> listeDesVilles = unPaysDao.findAllCity( request.getParameter("pays") );    
%>
    <select id="villes">
<%
        for(int i=0 ; i < listeDesVilles.size(); i++) {
            out.println("<option value=\"" + listeDesVilles.get(i).getVille() + "\">" + listeDesVilles.get(i).getVille() + "</option>");
        }
%>
    </select>
</body>
</html>