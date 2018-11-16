<%-- 
    Document   : forgot
    Created on : 7-Nov-2018, 9:34:21 AM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        Please enter your email address to retrieve your password. <br>

        <form method="post" action="forgot">
            Email Address: <input type="text" required name="emailaddress"><br>

            <input type="submit" value="Submit">
            <br>
            ${confirm}
        </form>
    </body>
</html>
