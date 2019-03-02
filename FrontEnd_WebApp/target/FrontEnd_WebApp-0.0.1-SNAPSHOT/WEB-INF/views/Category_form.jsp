<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category entry form</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 5px
}
</style>
</head>
<body>
<h1>Add a new Category -</h1>
       <form:form method="post" action="savecategory">    
        <table >    
         <tr>    
          <td>Category ID : </td>   
          <td><form:input path="cid"  /></td>  
         </tr>    
         <tr>    
          <td>Category Name :</td>    
          <td><form:input path="name" /></td>  
         </tr>     
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
 <br/><br/>
 <table border="1">
  <tr>
    <th>Category ID</th>
    <th>Category Name</th> 
  </tr>
 <c:forEach var="i" items="${categories}">  
<tr>
  <td>${i.cid}</td>
  <td>${i.name}</td>
  <td><a href="Update"><button type="button">Update</button></a></td>
  <td><a href="DeleteCat-${i.cid}"><button type="button">Delete</button></a></td>
</tr>
</c:forEach>  
</table>
</body>
</html>