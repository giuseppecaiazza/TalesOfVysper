<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>

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
    background-color: rgb(255, 0, 102, 0.4);
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    font-family:"Copperplate Gothic Light", Copperplate Gothic Light, css;
    font-weight: bold;
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
  margin-top: 300px;
  width: 20%;
  height: 100px;
  lenght: 100px;
}
th {
  background:rgb(255, 0, 102, 0.2);
   font-weight: bold; 
  color: white;    
  font-size:35px;   
}
 td {
                border: transparent;
                width: 50%;
                text-align: center;
                padding: 5px 10px;
                
            }
 .GFG {
 			font-size: 40px;
 			font-weight: bold;
            color: rgb(255, 51, 153);
            -webkit-text-stroke-width: 0.5px;
            -webkit-text-stroke-color: black;
        }
 .GFG2 {
            text-shadow: 2px 2px #ff0066;
        }
.titolo {
text-align: center;
font-family:"Garamond";
font-size:20px;
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
  <source src="images/archerbg.mp4" type="video/mp4">
  Your browser does not support HTML5 video.
</video>
<form:form method="post" modelAttribute="arciere" action="/TalesOfVysper/addEquipArciere">
<table>
		<tr>
			<th colspan="4" class="GFG2">Potenzia Equipaggiamento</th>
		</tr>
		<tr>
		<form:hidden path="id" />
          <form:hidden path="nome" />
         	<td class="GFG"><form:label path="id_arma">Arma
         	<select name="id_arma" id= "id_arma" >
         		<option value="0">--SELEZIONA--</option>
				<option value="3" class="titolo">Destrezza+5</option>
				<option value="4" class ="titolo">Livello+1</option>
			</select>
			</form:label></td>
         	<td class="GFG"><form:label path="id_armatura">Armatura
         	<select name="id_armatura" id= "id_armatura">
         		<option value="0">--SELEZIONA--</option>
				<option value="3" class="titolo">Difesa+4</option>
				<option value="4" class ="titolo">Hp+50</option>
			</select>
			</form:label></td>
          <form:hidden path="utente"/>
        </tr>	
		<tr>
			<td colspan="2"><input type="submit" class="button button2" value = "Crea" /></td>
		</tr>
		<c:if test="${!empty errorequip}">
		<td class = "error" colspan = "10">${errorequip}</td>
		</c:if>
	</table> 
	</form:form> 
</body>
</html>
