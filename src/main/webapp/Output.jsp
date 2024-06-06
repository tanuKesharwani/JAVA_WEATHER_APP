<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f9f9f9;
    }
    .json-container {
        border: 1px solid #ccc;
        padding: 10px;
        border-radius: 5px;
        background-color: #5a89ad;
    }
    .json-data {
        white-space: pre-wrap;
    }
</style>
</head>
<body>


<div class="json-container">
    <h2>1.Longitude</h2>
 
    <h3>=
        <% 
            // Retrieve JSON data from request attribute
            Double jsonData = (Double)request.getAttribute("lon");
           
        %>
       <%=jsonData %> </h3>
       
     <h2>2.Latitude</h2>
 
    <h3>=
        <% 
            // Retrieve JSON data from request attribute
            Double jsonData1 = (Double)request.getAttribute("lat");
           
        %>
       <%=jsonData1 %> </h3>
       
     <h2>3.Description</h2>
 
    <h3>=
        <% 
            // Retrieve JSON data from request attribute
           String jsonData2 = (String)request.getAttribute("description");
           
        %>
       <%=jsonData2 %> </h3>
       
     <h2>4.Temerature</h2>
 
    <h3>=
        <% 
            // Retrieve JSON data from request attribute
            Double jsonData3 = (Double)request.getAttribute("temperature");
           
        %>
       <%=jsonData3 %> </h3>
       
     <h2>5.Humidity</h2>
 
    <h3>=
        <% 
            // Retrieve JSON data from request attribute
            int jsonData4 = (int)request.getAttribute("humidity");
           
        %>
       <%=jsonData4 %> </h3>
    
</div>

</body>
</html>