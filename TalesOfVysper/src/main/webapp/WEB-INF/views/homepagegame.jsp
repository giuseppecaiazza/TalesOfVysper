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
			text-align: center;
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

</style>
</head>
<body>
<video autoplay muted loop id="background-video">
  <source src="images/village.mp4" type="video/mp4">
  Your browser does not support HTML5 video.
</video>
<c:if test="${!empty listeroe}">
	<div class="left">
	<table><div class="GFG">EROE</div><tr class="nobg"><td>&nbsp;&nbsp;&nbsp;&nbsp;<img src= ${url } class="animated-gif"/></td></tr>
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
	</table>
	</div>
	<div class="right">
	<table>
	<form:form method="post" modelAttribute="listeroe" action="/TalesOfVysper/esplora">
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
         <div class="GFG3">AZIONI</div>
		<tr class="nobg">
			<td><input type="submit" class="button button2" value = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Apri Mappa"/></td>
		</tr>
		</form:form>
		</table>
		</div>
</c:if>
</body>
</html>
