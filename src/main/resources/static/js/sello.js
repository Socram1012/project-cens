$(document).ready(function() {
    // on ready
});

function cargarTablaSellos() {
    var tabla = document.getElementById("tablaSellos");
    tabla.innerHTML = ""; // Limpiar la tabla

    fetch('/api/tabla-sello')
        .then(response => response.json())
        .then(data => {
            data.forEach(sello => {
                var row = tabla.insertRow();

                var nombreCell = row.insertCell(0);
                nombreCell.innerHTML = `<input type="text" id="nombre_${sello.id}" value="${sello.nombre}" disabled />`;

                var descripcionCell = row.insertCell(1);
                descripcionCell.innerHTML = `<input type="text" id="descripcion_${sello.id}" value="${sello.descripcion}" disabled />`;

                var accionesCell = row.insertCell(2);
                accionesCell.innerHTML = `<button class="btn btn-primary" onclick="modificarSello(${sello.id})"><ion-icon name="pencil-outline"></ion-icon></button>
                          <button class="btn btn-danger" onclick="eliminarSello(${sello.id})"><ion-icon name="trash-outline"></ion-icon></button>
                          <button class="btn btn-success" onclick="guardarCambios(${sello.id})" id="guardar_${sello.id}" style="display: none;"><ion-icon name="save-outline"></ion-icon></button>`;
            });
        })
        .catch(error => {
            console.error('Ocurrió un error al cargar los sellos:', error);
        });
}

async function crearSellos() {
    let datos= {};

    datos.nombre = document.getElementById('txtNombre').value;
    datos.descripcion = document.getElementById('txtDescripcion').value;

    const request = await fetch('api/sello', {
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

function modificarSello(id) {
    var nombreInput = document.getElementById(`nombre_${id}`);
    var descripcionInput = document.getElementById(`descripcion_${id}`);
    var guardarBtn = document.getElementById(`guardar_${id}`);

    nombreInput.disabled = false;
    descripcionInput.disabled = false;
    guardarBtn.style.display = "inline";
}


function guardarCambios(id) {
    var nombreInput = document.getElementById(`nombre_${id}`);
    var descripcionInput = document.getElementById(`descripcion_${id}`);
    var guardarBtn = document.getElementById(`guardar_${id}`);

    var nuevoNombre = nombreInput.value;
    var nuevaDescripcion = descripcionInput.value;

    var datos = { id: id, nombre: nuevoNombre, descripcion: nuevaDescripcion };

    fetch(`/api/modificar-sello/${id}`, {
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

    nombreInput.disabled = true;
    descripcionInput.disabled = true;
    guardarBtn.style.display = "none";
}

async function eliminarSello(id) {
    const url = `api/eliminar-sello/${id}`;

    try {
        const response = await fetch(url, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('El sello se ha eliminado con éxito.');
            cargarTablaSellos(); // Vuelve a cargar la tabla para reflejar los cambios
        } else {
            alert('Ocurrió un error al intentar eliminar el ámbito.');
        }
    } catch (error) {
        console.error('Ocurrió un error en la solicitud:', error);
        alert('Ocurrió un error en la solicitud. Consulta la consola para más detalles.');
    }
}