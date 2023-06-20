async function crearNotas() {
    let datos= {};

    datos.calificacion = document.getElementById('nmbCalificacion').value;

    const request = await fetch('api/nota', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("La calificación se ha creado con exito!");
    //window.location.href = 'login.html'

}

async function crearProcesoSello() {
    let datos= {};

    datos.proceso_sello = document.getElementById('txtNombreEtapa').value;
    datos.proceso_sello = document.getElementById('txtFechaNda').value;
    datos.proceso_sello = document.getElementById('txtFechaAccesoHerramienta').value;
    datos.proceso_sello = document.getElementById('txtFechaCreacionFormulario').value;
    datos.proceso_sello = document.getElementById('txtFechaEnvioFormulario').value;
    datos.proceso_sello = document.getElementById('txtFechaDemostracion').value;
    datos.proceso_sello = document.getElementById('txtFechaEntregaInformeEvaluadores').value;
    datos.proceso_sello = document.getElementById('txtFechaEntregaInforme').value;
    datos.proceso_sello = document.getElementById('txtFechaEvidenciaFinal').value;
    datos.proceso_sello = document.getElementById('txtFechaEvidenciaFonasa').value;
    datos.proceso_sello = document.getElementById('txtFechaIntegracionFonasa').value;
    datos.proceso_sello = document.getElementById('txtFechaOtorgamiento').value;

    const request = await fetch('api/proceso_sello', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("El proceso de sello se ha creado con exito!");
    //window.location.href = 'login.html'

}

async function crearProcesoMejora() {
    let datos = {};

    datos.proceso_mejora = document.getElementById('txtFechaEntregaInforme').value;
    datos.proceso_mejora = document.getElementById('txtUltimaEvidenciaEntregada').value;
    datos.proceso_mejora = document.getElementById('txtSeguimiento').value;
    datos.proceso_mejora = document.getElementById('txtComentario').value;
    datos.proceso_mejora = document.getElementById('nmbPendienteSello').value;
    datos.proceso_mejora = document.getElementById('nmbCumplimientoSello').value;
    datos.proceso_mejora = document.getElementById('nmbIntegracion').value;
    datos.proceso_mejora = document.getElementById('nmbCantidadObservacionesTotales').value;
    datos.proceso_mejora = document.getElementById('nmbObservacionesDimensionesCens').value;
    datos.proceso_mejora = document.getElementById('nmbTotalEvaluacionesCens').value;
    datos.proceso_mejora = document.getElementById('nmbObservacionesAtf').value;

    const request = await fetch('api/proceso_mejora', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("El proceso de mejora se ha creado con exito!");

}
