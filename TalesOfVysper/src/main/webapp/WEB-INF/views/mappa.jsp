<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
body {background-image: url("images/mappa.png");
background-size: cover;
background-repeat: no-repeat;
}
.button {
    background-color: rgba(0, 127, 255, 0.36);
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    font-weight: bold;
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
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9 table{
  font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: center;
	padding: 5px 10px;
}

<!--Aggiunto da Michele Paolucci - 03/08/2021 22:06 
Il codice sotto inserisce lo stile CSS del DIV dell'immagine (center). Ancora non funziona l'allineamento. -->

.center {
	margin: auto;
	border: solid 2px;
	border-radius: 5px;
	height: 100px;
	text-align: center;
	width: 300px;
}
</style>
</head>

<body>

<!--Aggiunto da Michele Paolucci - 03/08/2021 22:06 
Il codice seguente aggiunge una immagine in una pagina JSP. Il percorso delle immagini è stato aggiunto in spring-servlet.xml -->
	
	<form:form method="post" modelAttribute="listeroe"
		action="/TalesOfVysper/vaiarea1">
			<form:hidden path="id" />
			<form:hidden path="nome" />
			<form:hidden path="forza" />
			<form:hidden path="destrezza" />
			<form:hidden path="saggezza" />
			<form:hidden path="difesa" />
			<form:hidden path="livello" />
			<form:hidden path="hp" />
			<form:hidden path="utente" />
			<form:hidden path="id_arma" />
			<form:hidden path="id_armatura" />
			<input type="submit" class="button button2"
				value="Vai a Dragoncilff" /> <br>
				<button type="submit" formaction="/TalesOfVysper/vaiarea2"
					class="button button2">Vai a Stoneland</button> <br>
				<button type="submit" formaction="/TalesOfVysper/vaiarea3"
					class="button button2">Vai a Cursed Forest</button>
	</form:form>
</body>
</html>
