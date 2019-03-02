<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer entry form</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 5px
}
</style>
</head>
<body>
<h1>Add new Customer -</h1>

       <form:form method="post" action="savecustomer">    
        <table > 
        <tr>    
          <td>Firstname :</td>    
          <td><form:input path="cust_name" /></td>  
         </tr>     
         <tr>    
          <td>Customer Email : </td>   
          <td><form:input path="cust_email"  /></td>  
         </tr>       
         <tr>    
          <td>Password :</td>    
          <td><form:input path="password" /></td>  
         </tr> 
         <tr>    
          <td>Phone No :</td>    
          <td><form:input path="phno" /></td>  
         </tr> 
         <tr>    
          <td>Customer Address :</td>    
          <td><form:input path="cust_add" /></td>  
         </tr>  
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
       
       <br/><br/>
       
<table border="1">
<tr>
      <th>Customer Email</th>
      <th>Customer Name</th>
      <th>Password</th>
      <th>Phone No.</th>
      <th>Customer Address</th>
</tr> 
<c:forEach var="j" items="${customers}">  
<tr>
  <td>${j.cust_email}</td>
  <td>${j.cust_name}</td>
  <td>${j.password}</td>
  <td>${j.phno}</td>
  <td>${j.cust_add}</td>
</tr>
</c:forEach>  
</table>
</body>
</html>



