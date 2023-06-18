$(document).ready(function() {
    // on ready
});
function cargarTablaEmpresas() {
    var tabla = document.getElementById("tablaEmpresas");
    tabla.innerHTML = ""; // Limpiar la tabla

    fetch('/api/tabla-empresa')
        .then(response => response.json())
        .then(data => {
            data.forEach(empresa=> {
                var row = tabla.insertRow();

                var rutEmpresaCell = row.insertCell(0);
                rutEmpresaCell.innerHTML = `<input type="text" id="rut_empresa_${empresa.id}" value="${empresa.rut_empresa}" disabled />`;

                var razonSocialCell = row.insertCell(1);
                razonSocialCell.innerHTML = `<input type="text" id="razon_social_${empresa.id}" value="${empresa.razon_social}" disabled />`;

                var fechaIngresoCell = row.insertCell(2);
                fechaIngresoCell.innerHTML = `<input type="text" id="fecha_ingreso_${empresa.id}" value="${empresa.fecha_ingreso}" disabled />`;

                var accionesCell = row.insertCell(3);
                accionesCell.innerHTML = `<button class="btn btn-primary" onclick="modificarEmpresa(${empresa.id})"><ion-icon name="pencil-outline"></ion-icon></button>
                          <button class="btn btn-danger" onclick="eliminarEmpresa(${empresa.id})"><ion-icon name="trash-outline"></ion-icon></button>
                          <button class="btn btn-success" onclick="guardarCambios(${empresa.id})" id="guardar_${empresa.id}" style="display: none;"><ion-icon name="save-outline"></ion-icon></button>`;
            });
        })
        .catch(error => {
            console.error('Ocurrió un error al cargar los sellos:', error);
        });
}

async function crearEmpresas() {
    let datos= {};

    datos.rutEmpresa = document.getElementById('txtRutEmpresa').value;
    datos.razonSocial = document.getElementById('txtRazonSocial').value;
    datos.fechaIngreso = document.getElementById('txtFechaIngreso').value;

    const request = await fetch('api/empresa', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("El sello se ha creado con exito!");
    window.location.reload()

}

/*
async function modificarAmbito(id) {
    const nombre = document.getElementById('txtNombre').value;

    const datos = {
        nombre: nombre
    };

    const url = `api/modificar-ambito/${id}`;

    try {
        const response = await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        if (response.ok) {
            alert('El ámbito se ha actualizado con éxito.');
            window.location.href = 'modificar-ambito.html?id=' + id;
        } else {
            alert('Ocurrió un error al intentar actualizar el ámbito.');
        }

    } catch (error) {
        console.error('Ocurrió un error en la solicitud:', error);
        alert('Ocurrió un error en la solicitud. Consulta la consola para más detalles.');
    }

}*/

function modificarEmpresa(id) {
    var rutEmpresaInput = document.getElementById(`rut_empresa_${id}`);
    var razonSocialInput = document.getElementById(`razon_social_${id}`);
    var fechaIngresoInput = document.getElementById(`fecha_ingreso_${id}`);
    var guardarBtn = document.getElementById(`guardar_${id}`);

    rutEmpresaInput.disabled = false;
    razonSocialInput.disabled = false;
    fechaIngresoInput.disabled = false;
    guardarBtn.style.display = "inline";
}


function guardarCambios(id) {
    var rutEmpresaInput = document.getElementById(`rut_empresa_${id}`);
    var razonSocialInput = document.getElementById(`razon_social_${id}`);
    var fechaIngresoInput = document.getElementById(`fecha_ingreso_${id}`);
    var guardarBtn = document.getElementById(`guardar_${id}`);

    var nuevoRutEmpresa = rutEmpresaInput.value;
    var nuevaRazonSocial = razonSocialInput.value;
    var nuevaFechaIngreso = fechaIngresoInput.value;

    var datos = { id: id, rut_empresa: nuevoRutEmpresa, razon_social: nuevaRazonSocial, fecha_ingreso: nuevaFechaIngreso };

    fetch(`/api/modificar-empresa/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
        .then(response => {
            if (response.ok) {
                alert('Los cambios se han guardado correctamente.');
                //window.location.href = 'modificar-ambito.html?id=' + id;
                window.location.reload()
            } else {
                alert('Ocurrió un error al guardar los cambios.');
            }
        })
        .catch(error => {
            console.error('Ocurrió un error en la solicitud:', error);
            alert('Ocurrió un error en la solicitud. Consulta la consola para más detalles.');
        });

    rutEmpresaInput.disabled = true;
    razonSocialInput.disabled = true;
    fechaIngresoInput.disabled = true;
    guardarBtn.style.display = "none";
}

async function eliminarEmpresa(id) {
    const url = `api/eliminar-empresa/${id}`;

    try {
        const response = await fetch(url, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('La empresa se ha eliminado con éxito.');
            cargarTablaEmpresas(); // Vuelve a cargar la tabla para reflejar los cambios
        } else {
            alert('Ocurrió un error al intentar eliminar el ámbito.');
        }
    } catch (error) {
        console.error('Ocurrió un error en la solicitud:', error);
        alert('Ocurrió un error en la solicitud. Consulta la consola para más detalles.');
    }
}