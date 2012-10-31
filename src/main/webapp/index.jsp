<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("index.htm"); %>
--%>
<%--
  Created by IntelliJ IDEA.
  User: Xeops
  Date: 22.10.12
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
		<form action="login" method="post" >
  	    <table>
  	        <tr>
  	            <td>Username:</td><td><input name="username"/></td>
  	        </tr>
  	        <tr>
  	            <td>Password:</td><td><input type="password" name="password"/></td>
  	        </tr>
  	        <tr>
  	            <td></td><td><input type="submit" value="Submit"/></td>
  	        </tr>
  	    </table>
  	</form>
      
      
    <a href="hello">Say Hello</a>


  </body>


</html>
