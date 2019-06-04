$("#editModal").on('show.bs.modal', function(event) {
    var doctorId = $(event.relatedTarget).data('doctor-id');
    var cols = $('#doctorId-' + doctorId + ' td');
    fillCrudPatient(doctorId, cols, false)
});

$("#editModal").on('hidden.bs.modal', function() {
    var form = $(this).find('form');
    form[0].reset();
});

function fillCrudPatient(id, cols, isDel) {
    var firstname = $(cols[0]).text();
    var fathername = $(cols[1]).text();
    var lastname = $(cols[2]).text();
    var specification = $(cols[3]).text();
    if (isDel) {
        $('#idDel').val(id);
        $('#firstnameDel').val(firstname);
        $('#fathernameDel').val(fathername);
        $('#lastnameDel').val(lastname);
        $('#specificationDel').val(specification)
    } else {
        $('#idEdit').val(id);
        $('#firstnameEdit').val(firstname);
        $('#fathernameEdit').val(fathername);
        $('#lastnameEdit').val(lastname);
        $('#specificationEdit').val(specification)
    }
}

function deleteRow(id) {
    var cols = $('#doctorId-' + id + ' td');
    fillCrudPatient(id, cols, true);
    document.forms["removeDoctor"].submit();
}
$(function() {
    $('#messages li').click(function() {
        $(this).fadeOut();
    });
    setTimeout(function() {
        $('#messages li.count').fadeOut();
    }, 3000);
});

$('document').ready(function () {
    $('#dtBasicExample').DataTable();
    $('.dataTables_length').addClass('bs-select');
})
