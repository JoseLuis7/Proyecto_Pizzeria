<%-- 
    Document   : registro
    Created on : 27 nov 2022, 11:00:30
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro Clientes</title>
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
<section class="background-radial-gradient overflow-hidden">
  <style>
    .background-radial-gradient {
      background-color: hsl(218, 41%, 15%);
      background-image: radial-gradient(650px circle at 0% 0%,
          hsl(218, 41%, 35%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%),
        radial-gradient(1250px circle at 100% 100%,
          hsl(218, 41%, 45%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%);
    }

    #radius-shape-1 {
      height: 220px;
      width: 220px;
      top: -60px;
      left: -130px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    #radius-shape-2 {
      border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
      bottom: -60px;
      right: -110px;
      width: 300px;
      height: 300px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    .bg-glass {
      background-color: hsla(0, 0%, 100%, 0.9) !important;
      backdrop-filter: saturate(200%) blur(25px);
    }
  </style>

  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <div class="row gx-lg-5 align-items-center mb-5">
      <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
          The best offer <br />
          <span style="color: hsl(218, 81%, 75%)">for your business</span>
        </h1>
        <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit.
          Temporibus, expedita iusto veniam atque, magni tempora mollitia
          dolorum consequatur nulla, neque debitis eos reprehenderit quasi
          ab ipsum nisi dolorem modi. Quos?
        </p>
      </div>

      <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
        
        <div class="card bg-glass">
          <div class="card-body px-4 py-5 px-md-5">
              <%@page import="Controlador.RegistroCliente" %>
              
              <form action="RegistroCliente" method="post">
              <!-- 2 column grid layout with text inputs for the first and last names -->
              <div class="row">
                   <!-- Ingreso de nombres -->
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" id="nombres" class="form-control" name="nombres"/>
                    <label class="form-label" for="form3Example1">Nombres</label>
                  </div>
                </div>
                   <!-- Ingreso de apellidos -->
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" id="apellidos" class="form-control" name="apellidos"/>
                    <label class="form-label" for="form3Example2">Apellidos</label>
                  </div>
                </div>
              </div>
              
              <div class="row">
                   <!-- Ingreso de usuario -->
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" id="usuario" class="form-control" name="user"/>
                    <label class="form-label" for="form3Example1">Usuario</label>
                  </div>
                </div>
                   <!-- Ingreso de contraseña -->
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="password" id="pass" class="form-control" name="pass"/>
                    <label class="form-label" for="form3Example2">Contraseña</label>
                  </div>
                </div>
              </div>

              <!-- Email input -->
              <div class="form-outline mb-4">
                <input type="email" id="email" class="form-control" name="email"/>
                <label class="form-label" for="form3Example3">Correo electrónico</label>
              </div> <br> 
              
              <!-- Submit button -->
              <button type="submit" class="btn btn-primary btn-block mb-4" name="btnRegistrarCliente">
                Registrar cuenta
              </button>
              
              <a href="index.jsp" class="btn btn-warning btn-block mb-4">
                Volver a la página principal
              </a>
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->
        <%
            if (request.getAttribute("mensaje")!=null) {
                    
               
        %>
        <script>alert('<%= request.getAttribute("mensaje") %>');</script>
        <%
            }
        %>
    </body>
</html>
