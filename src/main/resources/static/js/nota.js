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