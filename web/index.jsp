<%-- 
    Document   : index
    Created on : 6 Sep, 2017, 10:27:12 PM
    Author     : Aman Garg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript" src="check.js"></script>
        <title>The Chat Room</title>
        <link rel="shorcut icon" href="icon.jpeg"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="middle" id="result-data">
            <form autocomplete="off">
                <centre>
                <table>
                    <tr height="80px">
                        <td>Username:</td>
                        <td><input type="text" id="uname" class="textbox" autocomplete="off"></td>
                    </tr>
                    <tr height="20px">
                        <td>Password:</td>
                        <td><input type="password" id="pw" class="textbox"></td>
                    </tr>
                    <tr>
                        <td><input type="button" value="Go" class="circle" onclick="startchating();" ></td>
                        <td><div id="loading-icon"></div></td>
                    </tr>
                </table>
                </centre>
            </form>
        </div>
    </body>
</html>
