function formulario(fila){
    var idprod=$(fila).find(".idprod").text();
    var catDes=$(fila).find(".catDes").text();
    var nomProd=$(fila).find(".nomProd").text();
    var prodDes=$(fila).find(".prodDes").text();
    var precio=$(fila).find(".precio").text();
    
    /*Asignamos los valores a los campos*/
    $("#idprod").val(idprod);
    $("#catDes").val(catDes);
    $("#nomProd").val(nomProd);
    $("#prodDes").val(prodDes);
    $("#precio").val(precio);
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

