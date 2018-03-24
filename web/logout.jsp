<%-- 
    Document   : logout
    Created on : 10 Oct, 2017, 6:20:45 PM
    Author     : Aman Garg
--%>

<html>
  <head>
    
    <title>::Sign out::</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="script.js"></script>
    <link rel="shortcut icon" href="icon.jpg" />

  </head>
  
  <body>
<% session.invalidate();%>
<center>
<h1>You are currently Signed out<br>
<a href="http://localhost:8084/ChatApplication">Login</a> to continue..
</h1>
</center>
  </body>
</html>