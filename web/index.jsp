<%@page import="com.samnang.entites.Pays"%>
<%@page import="java.util.List"%>
<%@page import="com.samnang.jdbc.dao.implementation.PaysDao"%>
<%@page import="com.samnang.jdbc.Connexion"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript">
    var xho;
    function go(pays) {
      var url = "getVilles.jsp?pays=" + pays;
      if (window.ActiveXObject) {//si Internet Explorer
            xho = new ActiveXObject("Microsoft.XMLHTTP");
            if (xho) {
                xho.onreadystatechange = processStateChange;
                xho.open("GET",url,true);
                xho.send();
            }
      } else {//si autre navigateur
        xho = new XMLHttpRequest();
        xho.onreadystatechange = processStateChange;
        try {
            xho.open("GET",url,true);
        } catch (e) {
            alert(e);
        }
        xho.send(null);
      }
    }

    function processStateChange()
    {
      if (xho.readyState == 4) //complété
        if (xho.status == 200)  //réponse OK
            {
              document.getElementById("villes").innerHTML = /*"Status text : "+xho.statusText+"<br />"+*/xho.responseText;
            }
            else
            {
              document.getElementById("villes").innerHTML = "Problème : "+xho.statusText;
              //alert("Problème : "+xho.statusText);
            }
    }
</script>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>    
</head>
<body>
    <table border="1px solid black">
        <tr>
            <td>Pays : </td>
            <td>
                <select id="pays" name="pays" onchange="go(this.value)">
                    <option value="--choisir--">--Choisir--</option>
<%
    Class.forName( request.getServletContext().getInitParameter("jdbcDriver") );
    Connexion.setUrl( request.getServletContext().getInitParameter("databaseURL") );    
    PaysDao unPaysDao = new PaysDao( Connexion.getInstance() );
    List<Pays> listeDesPays = unPaysDao.findAll();
    for(int i=0; i < listeDesPays.size(); i++) {
        out.println("<option value=\"" + listeDesPays.get(i).getNom() + "\">" + listeDesPays.get(i).getNom() + "</option>");
    }
%>
                </select>
            </td>
            <td><div id="villes"></div></td>
        </tr>
    </table> 
    <hr />    
    <div id="utilisateursPresents">
        
    </div>
    <script>
        
        $(window).load(function(){
            
            var fakeThread = setInterval(retrieveUsers, 1000);
            
            function retrieveUsers() {
                $("#utilisateursPresents").load("getUtilisateurs.jsp table"); 
            };
            
        });
        
    </script>
</body>
</html>