<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="screen" href="main.css">
</head>
<body>
	<header class="cabecera" id="cab" >
        
        <a href="index.html"><img id="logo" src="https://cdn.pixabay.com/photo/2018/01/09/15/43/auto-3071895_960_720.png" alt="LOGO PRINCIPAL DE LA PÁGINA"></a>
        <h1 id="titulo">COMPARADOR DE COCHES</h1>

    </header>
    <main class="main1">
    <section class="subtitulo">
    <h2 class="valor">Resultado de la busqueda</h2>
    </section>
    
    <c:forEach var="oferta" items="${ofertas}">
    	<section class="apartado">
    	<a href="">
    		
    	<img class="foto_coche" src="https://images0.autocasion.com/unsafe/260x146/ad/10/1537/022fd85e7223cd1aef7acbae6295f5f3c27b69e6.jpeg" alt="FOTO COCHE">
    		<section class="desc">
    			<article class="apartado_peque1">
    				<p class="letra">Marca-Modelo: ${oferta.marca}</p>  
    			</article>
    			<article class="apartado_peque">
    				<p class="letra">Potencia(cv): ${oferta.precio}</p>
    			</article>
    			<article class="apartado_peque">
    				<p class="letra">Tipo de combustible: ${oferta.combustible}</p>
    			</article>
    			<article class="apartado_peque">
    				<p class="letra">Provincia: ${oferta.provincia}</p>
    			</article>
    			<article class="apartado_peque">
    				<p class="letra">Precio(Euros): ${oferta.precio}</p>
    			</article>
    			<article class="apartado_peque">
    				<p class="letra">Kilometros: ${oferta.km}</p>
    			</article>
    			<article class="apartado_peque">
    				<p class="letra">Matriculacion: ${oferta.fecha}</p>
    			</article>
    			
    			
    			
    	
			
    		</section>
    		</a>
    	</section>
    </c:forEach>
    
    	
    	
    		
    	    	
    </main>

</body>
</body>
</html>