<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">

</head>
<body>
<nav class="nav">Welcome to the Ninja Gold Game! Try your luck!!

</nav>
<div class="goldcontainer">
<h3>Your gold: </h3>
<div class="goldTotal">

<c:out value="${gold}" />
</div>
</div>
<div class="container">
<div class="farmContainer">
<form action="/gold" method= "post">
<input type="hidden" name="location" value="farm">
<h3>Farm</h3>
<p>(earns 10-20 gold)</p>

<button class="btn btn-warning" name="farm">find gold!!</button>
</form> 
</div>
<div class="caveContainer">
<form action="/gold" method= "post">
<input type="hidden" name="location" value="cave">
<h3>Cave</h3>
<p>(earns 5-10 gold)</p>

<button class="btn btn-secondary">find gold!!</button>
</form>
</div>
<div class="houseContainer">
<form action="/gold" method= "post">
<input type="hidden" name="location" value="house">
<h3>House</h3>
<p>(earns 2-5 gold)</p>

<button class="btn btn-primary">find gold!!</button>
</form>
</div>
<div class="questContainer">
<form action="/gold" method= "post">
<input type="hidden" name="location" value="quest">
<h3>Quest</h3>
<p>(earns/takes 0-50 gold)</p>

<button class="btn btn-info">find gold!!</button>
</form>
</div>



</div>
<a style="color: gold; margin-left: 50px; margin-top: 20px;"  href= "/reset"><span>do you want to restart?</span></a>

<div class="logs">
<c:forEach items="${log}" var="goldLog" >
<p>
${goldLog}
</p>

</c:forEach>


</div>


</body>
</html>