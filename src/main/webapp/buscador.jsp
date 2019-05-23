<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Busca tu nuevo coche</title>
    <link rel="stylesheet" type="text/css" media="screen" href="main.css">
</head>
<body>
 <header class="cabecera" >
        
        <a href="index.html"><img id="logo" src="https://cdn.pixabay.com/photo/2018/01/09/15/43/auto-3071895_960_720.png" alt="LOGO PRINCIPAL DE LA P�GINA"></a>
        <h1 id="titulo">COMPARADOR DE COCHES</h1>

    </header>
    <main class="main">
    	<form class="cuadro" method="GET" action="/buscador">
    		<label class="formulario" for="usuario">Marca <br>
                <input class="input" type="text" name="marca">
            </label>
            <label class="formulario" for="correo">Potencia (cv)<br>
                <input class="input" type="number" name="potencia">
            </label>
            <label class="formulario" for="usuario">Provincia <br>
                <input class="input" type="text" name="provincia">
            </label>
            <label class="formulario" for="correo">Fecha M�xima de matriculaci�n <br>
                <input class="input" type="date" name="fecha">
            </label>
            <label class="formulario" for="correo">Precio <br>
                <input class="input" type="number" name="precio">
            </label>
            
            <label class="formulario" for="correo">Kil�metros <br>
                <input class="input" type="number" name="km">
            </label>
            <label for="submit">
             <input id="submit" type="submit" value="Buscar" name="buscar" > 
             </label>
    </form>
    <section class="derecha">
    	<img id="logo1" src="https://cdn.pixabay.com/photo/2013/07/13/11/36/volkswagen-158463_960_720.png" alt="LOGO PRINCIPAL DE LA P�GINA">
    </section>
     </main>
     <footer class="pie">
     <p>Autores: <b>Antonio Jim�nez</b> y <b>Andr�s L�pez</b></p>
	 
     </footer>
    <!-- <h1>Hola pr�ctica de ISI!</h1>
	<h2>Antonio Jim�nez</h2>
	<h2>Andr�s L�pez</h2> -->
    <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        <td><a href='/hello'>The servlet</a></td>
        <td><a href='/fuentemilanuncios'>Milanuncion.com</a></td>
        <td><a href='/fuenteCochesNet'>Coches.net</a></td>
      </tr>
    </table>
  </body>
</html>