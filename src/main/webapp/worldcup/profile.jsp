<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/24/17
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="i" uri="/WEB-INF/jstl-tags/menuTag.tld" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="/worldcup/style.css">
    <script src="http://yastatic.net/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://api-maps.yandex.ru/2.0-stable/?load=package.standard&lang=en-RU" type="text/javascript"></script>
</head>
<body>
<div id="container">
    <i:menu/>
    <hr>
    <div id="content">
        <div class="image">
            <img src="${image}" width="200" height="200" style="background-color: white;">
            <a href=""></a>
        </div>

        <div class="information">
            <table class="info">
                <tr>
                    <td><label><font size="20px">${name}</font></label></td>
                </tr>
                <tr style="height: 5px">
                    <td style="height: 2px"><hr></td>
                    <td><div class="edit">
                        <a href="/editprofile" style="margin-bottom: 0">edit</a>
                    </div></td>
                </tr>
                <tr>
                    <td><label>Bday: ${bday}</label></td>
                </tr>
                <tr>
                    <td><label>City: ${city}</label></td>
                </tr>
                <%--<tr>--%>
                    <%--<td><label>Current city:<div id="user-city"></div></label></td>--%>
                <%--</tr>--%>
                <tr>
                    <td><label>Gender: ${gender}</label></td>
                </tr>
                <tr>
                    <td><label>E-mail: ${email}</label></td>
                </tr>
                <tr>
                    <td><label>Instagram:</label></td>
                </tr>
            </table>
        </div>
    </div>

    <div id="footer">
        <img src="/worldcup/images/system/sponsors.png" usemap="#mymap">
    </div>

    <map name="mymap">
        <area shape="rect" coords="1.06,4.00,5.82,5.80" href="http://adidas.com/">
    </map>
</div>
</body>
</html>