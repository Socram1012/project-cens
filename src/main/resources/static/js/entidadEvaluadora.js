$(document).ready(function() {
    cargarEntidades();
});

function cargarEntidades() {
    var select = document.getElementById("entidadSelect");
    fetch('/api/entidad-evaluadora')
        .then(response => response.json())
        .then(data => {
            data.forEach(entidad => {
                var option = document.createElement("option")
                option.value = entidad.id;
                option.text = entidad.nombre;
                select.appendChild(option);
            });
            // Asignar evento change al select
            select.addEventListener('change', function() {
                var selectedId = select.value;
                cargarEvaluaciones(selectedId);
            });
        })
        .catch(error => {
            console.error('Ocurrió un error al cargar los ámbitos:', error);
        });

}
function cargarEvaluaciones(id) {
    var form= document.getElementById("formNotas");
    var tabla = document.getElementById("tablaSubAmbitos");
    tabla.innerHTML = "";

    // Realiza la solicitud HTTP POST con la entidad evaluadora seleccionada
    fetch(`/api/entidad-evaluadora/ambitos/${id}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => response.json())
        .then(data => {
            data.forEach(ambitos => {
                //tituloCell.innerHTML = `<label>${ambitos.nombre}</label>`;
                fetch(`api/obtener-por-ambito/${ambitos.id}`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                })
                    .then(response2 => response2.json())
                    .then(data2 => {
                       data2.forEach(subAmbitos =>{
                           var row = tabla.insertRow();

                           var nombreCell = row.insertCell(0);
                           nombreCell.innerHTML = `<label>${ambitos.nombre}</label> <input type="text" value="${subAmbitos.nombre}" disabled />`;
                           var accionesCell = row.insertCell(1);
                           if (ambitos.entidadEvaluadora.id == 1){
                               accionesCell.innerHTML=`<input type="number" name="${subAmbitos.id}" id="${subAmbitos.id}" min="0" max="3" />`;
                           }else {
                               accionesCell.innerHTML=`<input type="number" name="${subAmbitos.id}" id="${subAmbitos.id}" min="0" max="1" />`;
                           }

                       })
                    })
                    .catch(error => {
                        console.error('Ocurrió un error en la segunda solicitud:', error);
                    });
            })
        })
        .catch(function(error) {
            // Error: manejar el error de la solicitud
            console.error(error);
        });
    document.getElementById("botonGuardar").style.visibility = 'visible';

}