<%--
  Created by IntelliJ IDEA.
  User: arvin
  Date: 29/03/2021
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Image Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style type="text/css">
        .container {
            color: blue;
            border-style: solid;
            border-width: 2px;
            border-color: gray;
        }

        .header {
            text-align: center;
        }

        p {
            font-size: 28px;
        }

        .search {
            display: flex;
            padding: 10px 0;

        }

        .srchBtn {
            margin-left: 10px;
        }

        .right-align {
            float: right;
            padding: 10px 0;
        }
        .form-control1:focus {
            border-color: inherit;
            box-shadow: none;
            border-bottom: 2px solid #0DB8DE;
            outline: 0;
            background-color: #1A2226;
            color: #ECF0F5;
        }
    </style>
</head>
<body>
<%
    String username = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username"))
                username = cookie.getValue();

        }
    }
%>
<nav class="navbar navbar-inverse">

    <div class="container-fluid">

        <div class="navbar-header ">

            <a class="navbar-brand ">Image Search</a>

        </div>
        <form action="image_search-servlet" method="post">
            <div class="navbar-brand right-align">
                Signed in as : <%=username%>&nbsp;&nbsp;

                <button type="submit" class="btn btn-danger">
                    Logout
                </button>

            </div>
        </form>


    </div>
    <div class="container-fluid">
        <div class="md-form active-purple active-purple-2 mb-2">

            <form action="image_search-servlet" method="get">
                <div class="search">
                    <input class="form-control" type="text" name="url"
                           placeholder="Enter your Image Url here" aria-label="Search"> &nbsp;&nbsp;
                    <input maxlength="3" size="5" type="text" name="k" class="form-control1"
                           placeholder="Top k" aria-label="Top_K">
                    <div class="srchBtn">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</nav>

</body>
</html>
