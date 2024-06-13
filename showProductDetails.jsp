<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList,com.pace.product.bean.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product details</title>
</head>
<body>
  <%
  session.getAttribute("productlist");
  ArrayList<Product>productList=new ArrayList<Product>();
  productList=(ArrayList<Product>)session.getAttribute("productlist");
  %>
  <table border='1'>
  <%
  for(Product product:productList){
  %>
  <tr>
  <td align="center"><%=product.getProductId() %></td>
  <td align="center"><%=product.getPname() %></td>
  <td align="center"><%=product.getPrice() %></td>
  <%
  }
  %>
  </table>
  <a href="index.html">Home Page!</a>
</body>
</html>