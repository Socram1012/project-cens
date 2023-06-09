async function crearSubambitos() {
    let datos= {};

    datos.nombre = document.getElementById('txtNombre').value;
    datos.comentario = document.getElementById('txtComentario').value;

    const request = await fetch('api/subambito', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("El ambito se ha creado con exito!");
    //window.location.href = 'login.html'

}