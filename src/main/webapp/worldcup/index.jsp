<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/23/17
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Authorization</title>
    <style type="text/css" rel="stylesheet">
        body {
            background-image: url('/worldcup/images/system/background.png');
            font-family: DushaV5-Regular;
            color: #ffffff;
        }

        .header {
            height: 54px;
            font-size: 35px;
            text-align: center;
            margin: 0px 50px 0px 0px;
            position: relative;
        }

        .header form {
            float: right;
            font-size: 18px;
            margin: 0px auto;
            text-align: left;
            border-spacing: 10px 0px;
        }

        .header input {
            font-family: DushaV5-Regular;
            font-size: 16px;
            border-radius: 5px;
        }

        .header input[type="submit"] {
            font-family: DushaV5-Regular;
            background-image: url('/worldcup/images/system/background.png');
            color: #CCCC99;
            font-size: 15px;
            cursor: pointer;
            border-radius: 20px;
            width: 80px;
            height: 30px;
        }

        .container {
        }

        .content {
            align-content: center;
        }

        .reg-form-div {
            text-align: center;
            float: left;
            width: 40%;
        }

        .reg-form {
            font-size: 20px;
            text-align: center;
            width: 80%;
            border-spacing: 20px;
        }

        .reg-form td {
            text-align: right;
            width: 80%;
        }

        .reg-form input {
            font-family: DushaV5-Regular;
            font-size: 20px;
            border-radius: 15px;
        }

        .reg-form input[type="submit"] {
            font-family: DushaV5-Regular;
            background-image: url('/worldcup/images/system/background.png');
            color: #CCCC99;
            border-radius: 20px;
            cursor: pointer;
        }

        .zabivaka {
            float: left;
            width: 60%;
            text-align: center;
        }

        .button {
            width: 200px;
            height: 50px;
            border-radius: 20px;
            background-image: url('/worldcup/images/system/background.png');
            color: #CCCC99;
            font-size: 18px;
            cursor: pointer;
        }

        .button:hover {
            border: 0px solid #000;
            color: white;
        }

        .footer {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="conatiner">

    <div class="header">
        <span style="vertical-align: -22px">FIFA World Cup 2018</span>
        <form action="/profile" method="post">
            <table>
                <tr>
                    <td><label for="login">Login:</label></td>
                    <td><label for="pass">Password:</label></td>
                </tr>
                <tr>
                    <td><input type="text" name="enterlogin"></td>
                    <td><input type="password" name="enterpass"></td>
                    <td><input type="checkbox" name="remember" checked>Remember me</td>
                    <td><input type="submit" name="signin" value="Sign In"></td>
                </tr>
            </table>
        </form>

    </div>

    <hr>

    <div class="content">

        <div class="zabivaka">
            <img src="/worldcup/images/system/zabivaka.png" width=70% height=70%>
        </div>

        <form action="success" method="POST" class="reg">
            <div class="reg-form-div">
                <h1>Registration</h1>
                <table class="reg-form">
                    <col width="30%">
                    <col width="70%" align="center">
                    <tr>
                        <td><label for="login">Login<sup>•</sup></label></td>
                        <td><input type="text" id="login" name="login"></td>
                    </tr>

                    <tr>
                        <td><label for="pass">Password<sup>•</sup></label></td>
                        <td><input type="password" id="pass" name="pass"></td>
                    </tr>

                    <tr>
                        <td><label for="confirm">Confirm password<sup>•</sup></label></td>
                        <td><input type="password" id="confirm" name="cpassword"></td>
                    </tr>

                    <tr>
                        <td><label for="name">Name<sup>•</sup></label></td>
                        <td><input type="text" id="name" name="name"></td>
                    </tr>

                    <tr>
                        <td><label for="lname">Lastname<sup>•</sup></label></td>
                        <td><input type="text" id="lname" name="lname"></td>
                    </tr>

                    <tr>
                        <td><label for="email">E-Mail<sup>•</sup></label></td>
                        <td><input type="email" id="email" name="email"></td>
                    </tr>

                    <tr>
                        <td><label for="phone">Telephone<sup>•</sup></label></td>
                        <td><input type="text" id="phone" name="phone"></td>
                    </tr>
                    <tr>

                        <td><label for="city">City<sup>•</sup></label></td>
                        <td>
                            <select id="city" name="city">
                                <option disabled>Chose city</option>
                                <option name="city" value="Kazan">Kazan</option>
                                <option name="city" value="Moscow">Moscow</option>
                                <option name="city" value="St. Petersburg">St. Petersburg</option>
                                <option name="city" value="Sochi">Sochi</option>
                                <option name="city" value="Kaliningrad">Kaliningrad</option>
                                <option name="city" value="Rostov-On-Don">Rostov-On-Don</option>
                                <option name="city" value="Nizhniy Novgorod">Nizhniy Novgorod</option>
                                <option name="city" value="Ekaterinburg">Ekaterinburg</option>
                                <option name="city" value="Saransk">Saransk</option>
                                <option name="city" value="Samara">Samara</option>
                                <option name="city" value="Volgograd">Volgograd</option>
                            </select></td>
                    </tr>

                    <tr>
                        <td><label for="gender">Gender<sup>•</sup></label></td>
                        <td>
                            <input type="radio" id="gender" name="gender" value="true">
                            <label for="gender">Male</label>
                            <input type="radio" name="gender" value="false">
                            <label for="gender">Female</label>
                        </td>
                    </tr>

                    <tr>
                        <td><label for="birthday">Birthday<sup>•</sup></label></td>
                        <td>
                            <select id="birthday" name="bday">
                                <option value="0" disabled>Day</option>
                                <option name="bday" value="1">1</option>
                                <option name="bday" value="2">2</option>
                                <option name="bday" value="3">3</option>
                                <option name="bday" value="4">4</option>
                                <option name="bday" value="5">5</option>
                                <option name="bday" value="6">6</option>
                                <option name="bday" value="7">7</option>
                                <option name="bday" value="8">8</option>
                                <option name="bday" value="9">9</option>
                                <option name="bday" value="10">10</option>
                                <option name="bday" value="11">11</option>
                                <option name="bday" value="12">12</option>
                                <option name="bday" value="13">13</option>
                                <option name="bday" value="14">14</option>
                                <option name="bday" value="15">15</option>
                                <option name="bday" value="16">16</option>
                                <option name="bday" value="17">17</option>
                                <option name="bday" value="18">18</option>
                                <option name="bday" value="19">19</option>
                                <option name="bday" value="20">20</option>
                                <option name="bday" value="21">21</option>
                                <option name="bday" value="22">22</option>
                                <option name="bday" value="23">23</option>
                                <option name="bday" value="24">24</option>
                                <option name="bday" value="25">25</option>
                                <option name="bday" value="26">26</option>
                                <option name="bday" value="27">27</option>
                                <option name="bday" value="28">28</option>
                                <option name="bday" value="29">29</option>
                                <option name="bday" value="30">30</option>
                                <option name="bday" value="31">31</option>
                            </select>

                            <select name="bmon">
                                <option value="0" disabled>Month</option>
                                <option name="bmon" value="01">Jan</option>
                                <option name="bmon" value="02">Feb</option>
                                <option name="bmon" value="03">Mar</option>
                                <option name="bmon" value="04">Apr</option>
                                <option name="bmon" value="05">May</option>
                                <option name="bmon" value="06">Jun</option>
                                <option name="bmon" value="07">Jul</option>
                                <option name="bmon" value="08">Aug</option>
                                <option name="bmon" value="09">Sep</option>
                                <option name="bmon" value="10">Oct</option>
                                <option name="bmon" value="11">Nov</option>
                                <option name="bmon" value="12">Dec</option>
                            </select>

                            <select name="byear">
                                <option value="0" disabled>Year</option>
                                <option name="byear" value="2010">2010</option>
                                <option name="byear" value="2009">2009</option>
                                <option name="byear" value="2008">2008</option>
                                <option name="byear" value="2007">2007</option>
                                <option name="byear" value="2006">2006</option>
                                <option name="byear" value="2005">2005</option>
                                <option name="byear" value="2004">2004</option>
                                <option name="byear" value="2003">2003</option>
                                <option name="byear" value="2002">2002</option>
                                <option name="byear" value="2001">2001</option>
                                <option name="byear" value="2000">2000</option>
                                <option name="byear" value="1999">1999</option>
                                <option name="byear" value="1998">1998</option>
                                <option name="byear" value="1997">1997</option>
                                <option name="byear" value="1996">1996</option>
                                <option name="byear" value="1995">1995</option>
                                <option name="byear" value="1994">1994</option>
                                <option name="byear" value="1993">1993</option>
                                <option name="byear" value="1992">1992</option>
                                <option name="byear" value="1991">1991</option>
                                <option name="byear" value="1990">1990</option>
                                <option name="byear" value="1989">1989</option>
                                <option name="byear" value="1988">1988</option>
                                <option name="byear" value="1987">1987</option>
                                <option name="byear" value="1986">1986</option>
                                <option name="byear" value="1985">1985</option>
                                <option name="byear" value="1984">1984</option>
                                <option name="byear" value="1983">1983</option>
                                <option name="byear" value="1982">1982</option>
                                <option name="byear" value="1981">1981</option>
                                <option name="byear" value="1980">1980</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" class="button" name="signup" value="Create account">
                        </td>
                    </tr>

                </table>
                <h2><sup>•</sup> - <strong>required fields!</strong></h2>
                ${message}
            </div>
        </form>
    </div>

    <div class="footer">
        <img src="/worldcup/images/system/sponsors.png">
    </div>
</div>
</body>
</html>