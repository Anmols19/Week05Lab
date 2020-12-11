<%-- 
    Document   : login
    Created on : Nov 13, 2020, 7:06:57 PM
    Author     : 783856
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <div>
            <form action="login" method="POST">
                Username: <input type="text" name="username" value=" ${show1}"><br>
                Password: <input type="text" name="password" value=" ${show2}"><br>
                <input type="submit" value="Log in">
            </form>
        </div>
        <div>
             ${message}
        </div>
    </body>
</html>
