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
    background-color: rgb(0, 153, 51,0.8);
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    font-family:"Copperplate Gothic";
    font-weight:bold;
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
    
table {
  font-family:"papyrus", papyrus, fantasy;
  font-size:30px;
  background: transparent;
  margin: auto;
  margin-top: 250px;
  width: 20%;
  height: 100px;
  lenght: 100px;
}

th {
  background: SteelBlue;
  color: white;
  padding: 5px 10px;
}

 td {
     border: transparent;
     background: rgba(250, 240, 230, 0.6);
     width: 50%;
     text-align: center;
     padding: 5px 10px;   
}           
            
tr {
	 text-align: center;
}
.GFG{
font-family:"Copperplate Gothic";
			text-align: center;
     		padding: 5px 10px;  
			font-size:50px;
 			font-weight: bold;
            color: black;
            -webkit-text-stroke-width: 0.8px;
            -webkit-text-stroke-color: black;
             background:transparent;
             text-shadow: 2px 2px #009933;
}
.center{
text-align:center;
}
img.animated-gif{
  width: 300px;
  height: auto;
  border-radius: 50%;
  border: 1px solid black;
}
img.animated-gif2{
  width: 250px;
  height: auto;
  border-radius: 50%;
  border: 1px solid black;
}
.GFG2 {
			font-size:20px;
            color: white;
            text-shadow: 2px 2px #FF0000;
        }
</style>
</head>
<body>
<video autoplay muted loop id="background-video">
  <source src="images/area1.mp4" type="video/mp4">
  Your browser does not support HTML5 video.
</video>
<h3 class="GFG">DRAGONCLIFF</h3>
<c:if test="${!empty message2}">
<div class="center">
<img src="images/arpia_avatar.gif" class="animated-gif"/>
<h3 class="GFG2">Hai incotrato un'arpia!</h3>
	<form:form method="post" modelAttribute="listeroe" action="/TalesOfVysper/combattiarea1">
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
			<td colspan="2">
			<input type="submit" class="button button2" value = "Combatti" />
			<button type="submit" formaction="/TalesOfVysper/vaihomepage" class ="button button2">Scappa</button>
			</td>
		</tr> 
</form:form>
</div>
</c:if>
<c:if test="${!empty winner}">
<div class="center">
<h3 class="GFG2">Hai vinto!</h3>
<img src="images/mortearpia.gif" class="animated-gif"/>
<h3 class="GFG2">L'eroe recupera le forze e torna al villaggio</h3>
<img src= ${teleport } class="animated-gif"/>
	<form:form method="post" modelAttribute="listeroe" action="/TalesOfVysper/vaivillaggio">
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
			<td colspan="2">
			<input type="submit" class="button button2" value = "Vai" />
			</td>
		</tr> 
</form:form>
</div>
</c:if>
<c:if test="${!empty loser}">
<div class="center">
<h3 class="GFG2">Hai perso!</h3>
<img src= ${url } class="animated-gif2"/>
<h3 class="GFG2">L'eroe recupera le forze e torna al villaggio</h3>
<img src= ${teleport } class="animated-gif2"/>
	<form:form method="post" modelAttribute="listeroe" action="/TalesOfVysper/vaivillaggio">
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
			<td colspan="2">
			<input type="submit" class="button button2" value = "Vai" />
			</td>
		</tr> 
</form:form>
</div>
</c:if>
</body>
</html>