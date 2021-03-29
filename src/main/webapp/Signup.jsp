<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<div>
    <br>
    <form action="signup-servlet" method="post">
        <table style="with: 50%">

            <tr>
                <td>Username</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="password" name="c_password" /></td>
            </tr>
            <tr>
                <td>Email ID</td>
                <td><input type="email" name="email" /></td>
            </tr></table>
        <br>
        <input type="submit" value="Register" />
    </form>
</div>


</body>
</html>