<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/30/17
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="i" uri="/WEB-INF/jstl-tags/menuTag.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>Matches</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        #group-a {
            margin: 0px 10px 0px 20px;
            float: left;
            text-align: center;
            border-collapse: collapse;
        }

        #group-b {
            margin: 0px 10px 0px 10px;
            float: left;
            text-align: center;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<div id="container">
    <i:menu/>
    <hr>
    <div id="content">
        <div id="group-a">
            <table border="2" cellpadding="4" cellspacing="0">
                <tr>
                    <td colspan="2">Group A</td>
                </tr>
                <tr>
                    <td>"Luzhniki", Moscow, 14/06/2018</td>
                    <td>A1 vs A2</td>
                </tr>
                <tr>
                    <td>Ekaterinburg, 15/06/2018</td>
                    <td>A3 vs A4</td>
                </tr>
                <tr>
                    <td>St. Petersburg, 19/06/2018</td>
                    <td>A1 vs A3</td>
                </tr>
                <tr>
                    <td>Rostov-On-Don, 20/06/2018</td>
                    <td>A2 vs A4</td>
                </tr>
            </table>
        </div>
        <div id="group-b">
            <table border="2" cellpadding="4" cellspacing="0">
                <tr>
                    <td colspan="2">Group B</td>
                </tr>
            </table>
        </div>
    </div>
    <div id="footer">
        <img src="images/system/sponsors.png">
    </div>
</div>
</body>
</html>
