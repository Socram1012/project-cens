$(document).ready(function() {
    cargarEmpresas()
    $('#empresas').DataTable();
});
async function cargarEmpresas() {

    const request = await fetch('api/empresas', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const empresas = await request.json();

    let listadoHtml = '';
    for (let empresa of empresas){

        let empresaHtml = '<tr>\<td>'+empresa.id+'</td>\<td>'+empresa.rut_empresa+ '</td>\<td> '+empresa.razon_social+'</td><td>'+
            empresa.fecha_ingreso+'</td></tr>';
        listadoHtml += empresaHtml;
    }

    console.log(empresas);
    document.querySelector('#empresas tbody').outerHTML = listadoHtml;
}