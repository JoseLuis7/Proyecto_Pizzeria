function formulario(fila){
    var idcli=$(fila).find(".idcli").text();
    var nombres=$(fila).find(".nombres").text();
    var apellidos=$(fila).find(".apellidos").text();
    var usuario=$(fila).find(".usuario").text();
    var pass=$(fila).find(".pass").text();
    var correo=$(fila).find(".correo").text();
    
    /*Asignamos los valores a los campos*/
    $("#idcli").val(idcli);
    $("#nombres").val(nombres);
    $("#apellidos").val(apellidos);
    $("#usuario").val(usuario);
    $("#pass").val(pass);
    $("#correo").val(correo);    
}

$(document).ready(function(){
    
    $("#exampleModal").on("hiddenn.bs.modal", function(){
        $('form')[0].reset();
    });
    
    $(document).on('click', '.btnEditar', function(){
        formulario($(this).closest('tr'));
    });
    
    $(document).on('click', '.btnEliminar', function(){
        formulario($(this).closest('tr'));
    });    
});

