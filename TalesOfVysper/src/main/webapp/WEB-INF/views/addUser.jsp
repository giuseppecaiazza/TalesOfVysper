<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>

body {
background-size: cover;
background-repeat: no-repeat;
}
#background-video {
  width: 100vw;
  height: 100vh;
  object-fit: cover;
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  z-index: -1;
} 
.button {
    background-color: rgba(0, 127, 255, 0.36);
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    font-weight:bold;
    display: inline-block;
    font-size: 16px;
    font-family:"Copperplate Gothic Light", Copperplate Gothic Light, css;
    margin: 4px 2px;
    cursor: pointer;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}

.button1 {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}        
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	margin: auto;
	border:1px solid #1A87B9
}   
  
table {
  font-family:"papyrus", papyrus, fantasy;
  font-size:30px;
  background: transparent;
  margin: auto;
  margin-top: 150px;
  width: 20%;
  height: 100px;
  lenght: 100px;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th {
                border: transparent;
                width: 50%;
                text-align: center;
                padding: 5px 10px;
                
            }
.titolo {
text-align: center;
}

.error {
font-family:"Garamond";
text-align: center;
color: white;
border: transparent;
text-shadow: 2px 2px #FF0000;
}

</style>
</head>
<body>
<video autoplay muted loop id="background-video">
  <source src="images/regbg.mp4" type="video/mp4">
  Your browser does not support HTML5 video.
</video>

<form:form method="post" modelAttribute="utente" action="/TalesOfVysper/addUser">
<table>

		<tr>
			<th class = "titolo" colspan="1">Registrati</th>
		</tr>
		<tr>
		<form:hidden path="id" />
          <td><form:label path="utente">Utente </form:label>
          <form:input path="utente" size="27" maxlength="30"></form:input></td>
        </tr>
		<tr>
		  <td><form:label path="password">Password </form:label>
          <form:input type="password" path="password" size="23" maxlength="30"></form:input></td>
		</tr>	
		<tr>
			<td colspan="1">
			<input type="submit" class="button button1" value="Registrati" />
			</td>
			<c:if test="${!empty message}">
			<tr>
			<td class = "error">${message}</td>
			</tr>
			</c:if>
			</tr>
	</table>


</form:form>
</body>
</html>
