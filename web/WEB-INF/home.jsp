<%-- 
    Document   : home
    Created on : Nov 14, 2020, 2:17:16 PM
    Author     : 783856
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        
        <h3 value="${show} ">${passedBName} ${passedUName}</h3>
        <form  action="home" method="POST">
        <input type="submit" value="Log Out"></input>
        </form>
    </body>
</html>
