$(document).ready(function() {
    // on ready
});

function cargarTablaAmbitos() {
    var tabla = document.getElementById("tablaAmbitos");
    tabla.innerHTML = ""; // Limpiar la tabla

    fetch('/api/tabla-ambito')
        .then(response => response.json())
        .then(data => {
            data.forEach(ambito => {
                var row = tabla.insertRow();

                var nombreCell = row.insertCell(0);
                nombreCell.innerHTML = `<input type="text" id="nombre_${ambito.id}" value="${ambito.nombre}" disabled />`;

                var accionesCell = row.insertCell(1);
                accionesCell.innerHTML = `<button class="btn btn-primary" onclick="modificarAmbito(${ambito.id})">Modificar</button>
                          <button class="btn btn-danger" onclick="eliminarAmbito(${ambito.id})">Eliminar</button>
                          <button class="btn btn-success" onclick="guardarCambios(${ambito.id})" id="guardar_${ambito.id}" style="display: none;">Guardar</button>`;
            });
        })
        .catch(error => {
            console.error('Ocurrió un error al cargar los ámbitos:', error);
        });
}

async function crearAmbitos() {
    let datos= {};

    datos.nombre = document.getElementById('txtNombre').value;

    const request = await fetch('api/ambito', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("El ambito se ha creado con exito!");
    window.location.href = 'login.html'

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

function modificarAmbito(id) {
    var nombreInput = document.getElementById(`nombre_${id}`);
    var guardarBtn = document.getElementById(`guardar_${id}`);

    nombreInput.disabled = false;
    guardarBtn.style.display = "inline";
}


function guardarCambios(id) {
    var nombreInput = document.getElementById(`nombre_${id}`);
    var guardarBtn = document.getElementById(`guardar_${id}`);

    var nuevoNombre = nombreInput.value;

    var datos = { id: id, nombre: nuevoNombre };

    fetch(`/api/modificar-ambito/${id}`, {
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
            } else {
                alert('Ocurrió un error al guardar los cambios.');
            }
        })
        .catch(error => {
            console.error('Ocurrió un error en la solicitud:', error);
            alert('Ocurrió un error en la solicitud. Consulta la consola para más detalles.');
        });

    nombreInput.disabled = true;
    guardarBtn.style.display = "none";
}

async function eliminarAmbito(id) {
    const url = `api/eliminar-ambito/${id}`;

    try {
        const response = await fetch(url, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('El ámbito se ha eliminado con éxito.');
            cargarTablaAmbitos(); // Vuelve a cargar la tabla para reflejar los cambios
        } else {
            alert('Ocurrió un error al intentar eliminar el ámbito.');
        }
    } catch (error) {
        console.error('Ocurrió un error en la solicitud:', error);
        alert('Ocurrió un error en la solicitud. Consulta la consola para más detalles.');
    }
}


