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
                <select name="marca" class="input" >
							<option value="">------</option>
							
                            <option value="1">Audi</option>
                            
                            <option value="2">BMW</option>
                            
                            <option value="3">Ford</option>

                            <option value="4">Honda</option>

                            <option value="5">Mercedes</option>

                            <option value="6">Mini</option>

                            <option value="7">Peugeut</option>
                            
                            <option value="8">Seat</option>
                            
                            </select>
            </label>
            <label class="formulario" for="correo">Potencia (cv)<br>
                <input class="input" type="number" name="potencia">
            </label>
            <label class="formulario" for="usuario">Provincia <br>
                <select class="input" name="provincia">
                <option value='0'>------</option>
  <option value='alava'>�lava</option>
  <option value='albacete'>Albacete</option>
  <option value='alicante'>Alicante/Alacant</option>
  <option value='almeria'>Almer�a</option>
  <option value='asturias'>Asturias</option>
  <option value='avila'>�vila</option>
  <option value='badajoz'>Badajoz</option>
  <option value='barcelona'>Barcelona</option>
  <option value='burgos'>Burgos</option>
  <option value='caceres'>C�ceres</option>
  <option value='cadiz'>C�diz</option>
  <option value='cantabria'>Cantabria</option>
  <option value='castellon'>Castell�n/Castell�</option>
  <option value='ceuta'>Ceuta</option>
  <option value='ciudadreal'>Ciudad Real</option>
  <option value='cordoba'>C�rdoba</option>
  <option value='cuenca'>Cuenca</option>
  <option value='girona'>Girona</option>
  <option value='laspalmas'>Las Palmas</option>
  <option value='granada'>Granada</option>
  <option value='guadalajara'>Guadalajara</option>
  <option value='guipuzcoa'>Guip�zcoa</option>
  <option value='huelva'>Huelva</option>
  <option value='huesca'>Huesca</option>
  <option value='illesbalears'>Illes Balears</option>
  <option value='jaen'>Ja�n</option>
  <option value='acoru�a'>A Coru�a</option>
  <option value='larioja'>La Rioja</option>
  <option value='leon'>Le�n</option>
  <option value='lleida'>Lleida</option>
  <option value='lugo'>Lugo</option>
  <option value='madrid'>Madrid</option>
  <option value='malaga'>M�laga</option>
  <option value='melilla'>Melilla</option>
  <option value='murcia'>Murcia</option>
  <option value='navarra'>Navarra</option>
  <option value='ourense'>Ourense</option>
  <option value='palencia'>Palencia</option>
  <option value='pontevedra'>Pontevedra</option>
  <option value='salamanca'>Salamanca</option>
  <option value='segovia'>Segovia</option>
  <option value='sevilla'>Sevilla</option>
  <option value='soria'>Soria</option>
  <option value='tarragona'>Tarragona</option>
  <option value='santacruztenerife'>Santa Cruz de Tenerife</option>
  <option value='teruel'>Teruel</option>
  <option value='toledo'>Toledo</option>
  <option value='valencia'>Valencia/Val�ncia</option>
  <option value='valladolid'>Valladolid</option>
  <option value='vizcaya'>Vizcaya</option>
  <option value='zamora'>Zamora</option>
  <option value='zaragoza'>Zaragoza</option>
</select>
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
                         <label class="formulario1" >Tipo Combustible<br>
                <select  class="input" name="combustible" >
							<option value="">------</option>
							
                            <option value="gasolina">Gasolina</option>
                            
                            <option value="diesel">Diesel</option>
                            
                            <option value="electrico">El�ctrico</option>
                            
                            </select>
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
        <td><a href='/tercerafuente'>TerceraFuente.net</a></td>
      </tr>
    </table>
  </body>
</html>