<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product entry form</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 5px
}
</style>
</head>
<body>
<h1>Add a new Product -</h1>

       <form:form method="post" action="saveproduct" enctype = "multipart/form-data">    
        <table > 
        <tr>    
          <td>Product ID :</td>    
          <td><form:input path="id" /></td>  
         </tr>     
         <tr>    
          <td>Product Name : </td>   
          <td><form:input path="pname"  /></td>  
         </tr>       
         <tr>    
          <td>Description :</td>    
          <td><form:input path="pdescription" /></td>  
         </tr> 
         <tr>    
          <td>Quantity :</td>    
          <td><form:input path="quantity" /></td>  
         </tr> 
         <tr>    
          <td>Price :</td>    
          <td><form:input path="price" /></td>  
         </tr>  
         <tr>
         <td>Upload product image:</td>
         <td><form:input type = "file" path="image" name = "image"/></td>
         </tr>
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>
 <br/><br/>
<table border="1">
<tr>
      <th>Product ID</th>
      <th>Product Name</th>
      <th>Description</th>
      <th>Quantity</th>
      <th>Price(Rs.)</th>
      <th>Product image</th>
</tr> 
<c:forEach var="j" items="${products}">  
<tr>
  <td>${j.id}</td>
  <td>${j.pname}</td>
  <td>${j.pdescription}</td>
  <td>${j.quantity}</td>
  <td>${j.price}</td>
  <td><img src="<c:url value="/resources/images/${j.id}.jpg" />" width="100" height="50"/></td>
  <c:url value="/admin/updateproductform" var="url"></c:url>
  <td><a href="${url}?id=${j.id}"><button type="button">Update</button></a></td>
  <td><a href="DeletePro-${j.id}"><button type="button">Delete</button></a></td>
</tr>
</c:forEach>  
</table>       
     
</body>
</html>



