function formulario(fila){
    var iduser=$(fila).find(".idusuario").text();
    var nombres=$(fila).find(".nombres").text();
    var apellidos=$(fila).find(".apellidos").text();
    var users=$(fila).find(".user").text();
    var pass=$(fila).find(".password").text();
    var alias=$(fila).find(".alias").text();
    var tipoacc=$(fila).find(".tipoacceso").text();
    
    /*Asignamos los valores a los campos*/
    $("#iduser").val(iduser);
    $("#nombres").val(nombres);
    $("#apellidos").val(apellidos);
    $("#user").val(users);
    $("#pass").val(pass);
    $("#alias").val(alias);
    $("#tipoAcceso option[selected]").removeAttr('selected');
    $("#tipoAcceso option:contains("+tipoacc+")").attr('selected', true);
}

$(document).ready(function(){
    
    $("#exampleModal").on("hiddenn.bs.modal", function(){
        $('form')[0].reset();
        $("#tipoAcceso option[selected]").removeAttr('selected');
    });
    
    $(document).on('click', '.btnEditar', function(){
        formulario($(this).closest('tr'));
    });
    
    $(document).on('click', '.btnEliminar', function(){
        formulario($(this).closest('tr'));
    });
});

