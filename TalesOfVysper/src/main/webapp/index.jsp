<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>

.button {
    background-color: rgba(255, 204, 0, 0.7);
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    font-weight: bold;
    display: inline-block;
    font-size: 16px;
    font-family:"papyrus";
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
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}

th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }

.center {	
position: fixed;
right:1;
  font-family: "papyrus", papyrus, fantasy; 
  font-size: 50;
  margin-top: 100px;
  width: 70%;
  color: #ffcc00;
  text-shadow: -1px 1px 0 #000,
                          1px 1px 0 #000,
                         1px -1px 0 #000,
                        -1px -1px 0 #000;
  font-weight: bold;
}
.center-button {
font-family: "papyrus", papyrus, fantasy;
margin:auto;
margin-top: 1px;
width: 60%;
text-align:"center";
color:#ffcc00;
font-weight: bold;
}
   
   
</style>
</head>
<body>
<video autoplay muted loop id="background-video">
  <source src="images/background.mp4" type="video/mp4">
  Your browser does not support HTML5 video.
</video>
		<div class = "center">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BENVENUTO<br><div class= "center-button">&nbsp;&nbsp;&nbsp;&nbsp;IN</div>TALES OF VYSPER
		<form:form method="get" action="/TalesOfVysper/login">
			<div class = "center-button">&nbsp;<input type="submit" class="button button2" value = "ENTRA" /></div>
			</form:form>
		</div>
</body>
</html>
