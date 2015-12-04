<%@page import="com.samnang.entites.Message"%>
<%@page import="com.samnang.jdbc.dao.implementation.MessageDao"%>
<%@page import="com.samnang.jdbc.Connexion"%>
<%
    String messageRecu = request.getParameter("message");
    if( messageRecu != null ) {      
        out.println("<h1>Je suis dans la condition</h1>");
        out.println("<h3>" + messageRecu + "</h3>");
        Class.forName( request.getServletContext().getInitParameter("jdbcDriver") );
        Connexion.setUrl( request.getServletContext().getInitParameter("databaseURL") );
        MessageDao unMessageDao = new MessageDao( Connexion.getInstance() );
        Message unMessage = new Message();
        unMessage.setMessage( messageRecu );
        out.println("unMessage.getMessage() == " + unMessage.getMessage() );
        //out.println("<h3>" + unMessageDao.findAll() + "</h3>");
        if( unMessageDao.create( messageRecu ) ) {
            out.println("<h1>Envoie réussie !!</h1>");
        } else {
            out.println("<h1>Envoie échoué...</h1>");
        }
    }
%>