<%@page import="java.util.List"%>
<%@page import="com.samnang.entites.Message"%>
<%@page import="com.samnang.jdbc.dao.implementation.MessageDao"%>
<%@page import="com.samnang.jdbc.Connexion"%>
<%
 
    Class.forName( request.getServletContext().getInitParameter("jdbcDriver") );
    Connexion.setUrl( request.getServletContext().getInitParameter("databaseURL") );
    MessageDao unMessageDao = new MessageDao( Connexion.getInstance() );
    List<Message> uneListeDesMessages = unMessageDao.findAll();
    if( uneListeDesMessages != null ) {
        out.println("<table border=\"1px solid black\">");        
        for(int i=0; i < uneListeDesMessages.size();i++) {
            out.println("<tr><td>" + uneListeDesMessages.get(i).getMessage() + "</td><tr>");
        }
        out.println("</table>");
    }
%>