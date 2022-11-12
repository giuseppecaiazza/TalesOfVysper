<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>

body {background-image: url("images/arena.png");
background-size: cover;
background-repeat: no-repeat;
}  
.button {
    background-color: rgb(204, 51, 0,0.8);
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    font-family:"Copperplate Gothic Light", Copperplate Gothic Light, css;
    font-weight:bold;
    margin: 4px 2px;
    cursor: pointer;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
     text-shadow: 2px 2px #FF0000;
}

.button1 {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}


.error {
text-align: center;
font-style: lighter;
color: red;
border: transparent;
}     

table {
  font-family:"papyrus", papyrus, fantasy;
  font-size:30px;
  background: transparent;
  width: 20%;
}
.right{
	float:right;
}
.left{
float:left;
}
.center{
float:center;
text-aling:center;
}
th {
  background: trasparent;
  color: black;
  padding: 5px 10px;
}
rgba(250, 240, 230, 0.6)
 td {
     border: transparent;
     background: rgba(250, 240, 230, 0.6);
     width: 50%;
     text-align: center;
     padding: 5px 10px;
     text-weight:bolder;   
}
            
.GFG {
			font-family:"papyrus", papyrus, fantasy;
			text-align: left;
     		padding: 5px 10px;  
			font-size:50px;
 			font-weight: bold;
            color: black;
            -webkit-text-stroke-width: 0.8px;
            -webkit-text-stroke-color: black;
             background:transparent;
             text-shadow: 2px 2px #FF0000;
        }
.GFG2 {
			text-align:center;
			font-size:30px;
 			font-weight: bold;
            color: black;
            -webkit-text-stroke-width: 0.8px;
            -webkit-text-stroke-color: black;
            text-shadow: 2px 2px #FF0000;
        }
.GFG3 {
			font-family:"papyrus", papyrus, fantasy;
     		padding: 5px 10px;  
			font-size:40px;
 			font-weight: bold;
            color: white;
            -webkit-text-stroke-width: 0.8px;
            -webkit-text-stroke-color: black;
             background:transparent;
             text-shadow: 2px 2px #FF0000;
        }
.GFG4{
font-family:"papyrus", papyrus, fantasy;
     		padding: 5px 10px;  
			font-size:45px;
 			font-weight: bold;
            color: black;
            -webkit-text-stroke-width: 0.8px;
            -webkit-text-stroke-color: black;
             background:transparent;
             text-shadow: 2px 2px #FF0000;
             mergin-left:1000px;
}
.GFG5{
font-family:"papyrus", papyrus, fantasy;
			text-align: center;
     		padding: 5px 10px;  
			font-size:30px;
 			font-weight: bold;
            color: white;
             background:transparent;
             text-shadow: 2px 2px #FF0000;
}
.GFG6{
font-family:"papyrus", papyrus, fantasy;
			text-align: center;
     		padding: 5px 10px;  
			font-size:30px;
 			font-weight: bold;
            color: white;
             background:transparent;
             text-shadow: 2px 2px #FF0000;
             margin-right:400px;
}        
tr {
	 text-align: center;
	  background: rgba(250, 240, 230, 0.6);
}
tr.nobg{
background:transparent;
}
img.animated-gif{
  width: 200px;
  height: auto;
  border-radius: 50%;
  border: 1px solid black;
}
img.animated-gif2{
  width: 200px;
  height: auto;
  border-radius: 50%;
  border: 1px solid black;
  display: block;
  margin-left:650px;
}
img.animated-gif3{
  width: 200px;
  height: auto;
  border-radius: 50%;
  border: 1px solid black;
  display: block;
  margin-left:650px;
}
img.animated-gif4{
  width: 300px;
  height: auto;
  border-radius: 50%;
  border: 1px solid black;
  display: block;
  margin-left:600px;
}

</style>
</head>
<body>
<c:if test="${!empty listeroe}">
	<div class="left">
	<table><div class="GFG">&nbsp;&nbsp;EROE</div><c:if test="${empty colpobase}"><c:if test="${empty colpospecial}"> <tr class="nobg"><td>&nbsp;&nbsp;&nbsp;&nbsp;<img src= ${url } class="animated-gif"/></td></tr></c:if></c:if>
	</table>
	<table>
	<tr>
		<td class="GFG2">Nome</td><td>${listeroe.nome}</td></tr><tr>
		<td class="GFG2">Livello</td><td>${listeroe.livello}</td></tr><tr>
		<td class="GFG2">Forza</td><td>${listeroe.forza}</td></tr><tr>
		<td class="GFG2">Destrezza</td><td>${listeroe.destrezza}</td></tr><tr>
		<td class="GFG2">Saggezza</td><td>${listeroe.saggezza}</td></tr><tr>
		<td class="GFG2">Difesa</td><td>${listeroe.difesa}</td></tr><tr>
		<td class="GFG2">Hp</td><td>${listeroe.hp}</td></tr><tr>
	</tr>
		<form:form method="post" modelAttribute="listeroe" action="/TalesOfVysper/attaccobase">
		<tr>
		  <form:hidden path="id"/>
          <form:hidden path="nome"/>
		  <form:hidden path="forza"/>
          <form:hidden path="destrezza"/>
          <form:hidden path="saggezza"/>
          <form:hidden path="difesa"/>
          <form:hidden path="livello"/>
          <form:hidden path="hp"/>
          <form:hidden path="utente"/>
          <form:hidden path="id_arma"/>
          <form:hidden path="id_armatura"/>
		<tr>
		<form:form method="post" modelAttribute="mostro" action="/TalesOfVysper/attaccobase">
          <form:hidden path="nomemostro"/>
		  <form:hidden path="attacco"/>
          <form:hidden path="difesamostro"/>
          <form:hidden path="vita"/>
           <form:hidden path="area"/>
		<tr>
			<td colspan="2">
			<input type="submit" class="button button2" value = "Attacco Base" />
			<button type="submit" formaction="/TalesOfVysper/attaccospeciale" class ="button button2">Abilità Speciale</button>
			</td>
		</tr> 
</form:form>
</form:form>
		</table>
		</div>
		<div class="right">
	<table><div class="GFG">MOSTRO</div><c:if test="${empty colpobase}"><c:if test="${empty colpospecial}"><tr class="nobg"><td>&nbsp;&nbsp;&nbsp;&nbsp;<img src= ${urlm } class="animated-gif"/></td></tr></c:if></c:if>
	</table>
	<table>
	<tr>
		<td class="GFG2">Nome</td><td>${mostro.nomemostro}</td></tr><tr>
		<td class="GFG2">Hp</td><td>${mostro.vita}</td></tr><tr>
		<td class="GFG2">Attacco</td><td>${mostro.attacco}</td></tr><tr>
		<td class="GFG2">Difesa</td><td>${mostro.difesamostro}</td></tr><tr>
	</tr>
		</table>
		</div>
</c:if>
<div class="center">
<h3 class="GFG4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BATTAGLIA</h3>
<c:if test="${!empty colpobase}">
<img src= ${attpg } class="animated-gif2"/>
<h2 class="GFG6">L'eroe attacca il mostro e infligge ${danno} danni!</h2>
<img src= ${attmost } class="animated-gif3"/>
<h2 class ="GFG5">Il mostro contrattacca e infligge ${dannomostro} danni!</h2>
</c:if>
<c:if test="${!empty colpospecial}">
<img src= ${specialpg } class="animated-gif4"/>
<h2 class="GFG6"> ${skill} <c:if test="${!empty danno}"> ${danno}  </c:if> <c:if test="${!empty message}"> ${message} </c:if> </h2>
<img src= ${attmost } class="animated-gif3"/>
<h2 class ="GFG5">Il mostro contrattacca e infligge ${dannomostro} danni!</h2>
</c:if>
</div>
</body>
</html>
