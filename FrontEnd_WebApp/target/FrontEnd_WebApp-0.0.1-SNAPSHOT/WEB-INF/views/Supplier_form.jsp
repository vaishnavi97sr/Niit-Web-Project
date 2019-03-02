<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier entry form</title>
</head>
<body>
<h1>Add a new Supplier -</h1>

       <form:form method="post" action="savesupplier">    
        <table > 
        <tr>    
          <td>Supplier ID :</td>    
          <td><form:input path="sup_id" /></td>  
         </tr>     
         <tr>    
          <td>Supplier Name : </td>   
          <td><form:input path="sup_name"  /></td>  
         </tr>       
         <tr>    
          <td>Supplier Address :</td>    
          <td><form:input path="sup_add" /></td>  
         </tr>   
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
<br/><br/>
<table border="1">
<tr>
      <th>Supplier ID</th>
      <th>Supplier Name</th>
      <th>Supplier Address</th>
</tr> 
<c:forEach var="j" items="${suppliers}">  
<tr>
  <td>${j.sup_id}</td>
  <td>${j.sup_name}</td>
  <td>${j.sup_add}</td>
  <td><a href="Update"><button type="button">Update</button></a></td>
  <td><a href="DeleteSup-${j.sup_id}"><button type="button">Delete</button></a></td>
</tr>
</c:forEach>  
</table>
</body>
</html>



