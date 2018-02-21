<%-- 
    Document   : register
    Created on : 20 Feb, 2018, 2:51:29 PM
    Author     : Shahrukh
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Form</h1>
        
        <f:form action="saveRegister" method="post" modelAttribute="cmd"> 
            
            Name:<f:input path="name" /><br>
            UserName:<f:input path="username"/><br>
            Password:<f:password path="password"/> <br>
          
            Mobile Number:<f:input path="mobileNumber"/><br>
            ROLE:<f:input path="role"/><br>
            Address:<f:textarea  path="address"></f:textarea> <br>
            <f:button>SAVE</f:button>
        
        </f:form>
        
    </body>
</html>
