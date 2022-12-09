<%-- 
    Document   : registroUsuario
    Created on : 26 nov 2022, 20:31:43
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de usuarios</title>

<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.1/mdb.min.css"
  rel="stylesheet"
/>
    </head>
    <body>
        <!-- Section: Design Block -->
<section class="text-center">
  <!-- Background image -->
  <div class="p-5 bg-image" style="
        background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg');
        height: 300px;
        "></div>
  <!-- Background image -->

  <div class="card mx-4 mx-md-5 shadow-5-strong" style="
        margin-top: -100px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(30px);
        ">
    <div class="card-body py-5 px-md-5">

      <div class="row d-flex justify-content-center">
        <div class="col-lg-8">
          <h2 class="fw-bold mb-5">Registrar Producto</h2>
          <%@page import="Controlador.RegistroProducto" %>
          <form action="RegistroProducto" method="post">
            <div class="row">
                <div class="col-6">
                    <label>Seleccionar categoría</label>                    
                    <select class="form-control" name="categoria" id="categoria">
                        <option value="Pizza">Pizza</option>
                        <option value="Bebida">Bebida</option>
                        <option value="Adicionales">Adicionales</option>
                    </select>
                </div>
                <div class="col-6">
                    <label>Nombre producto</label>
                    <input type="text" class="form-control" name="nomProd" id="nomProd">
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label>Descripción</label>
                    <input type="text" class="form-control" name="descripcion" id="descripcion">
                </div>
                    <div class="col-6">
                    <label>Precio</label>
                    <input type="text" class="form-control" name="precio" id="precio">
                </div>
            </div><br>

            <!-- Submit button -->
            <div class="row">
                <div class="col-6">
                    <button type="submit" class="btn btn-primary btn-block mb-4" name="btnRegistrar">
                      Registrar producto
                    </button>                    
                </div>
                <div class="col-6">
                    <a href="sistema.jsp" class="btn btn-warning btn-block mb-4">
                      Ir a menú principal
                    </a>                    
                </div>
            </div>

            </div>
           <div class="col-6">
                     <a href="${pageContext.request.contextPath}/reportes/rptproductos.jsp" class="btn btn-primary btn-block mb-4">
                     DESCARGAR LISTA DE PRODUCTOS
                     
                    </a>      
                    
                </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->
<%
    if (request.getAttribute("mensaje")!=null) {
%>
<script> alert('<%= request.getAttribute("mensaje") %>'); </script>
<%
    }
%>
    </body>
</html>
