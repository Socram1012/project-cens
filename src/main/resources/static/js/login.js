$(document).ready(function() {
    // on ready
});


async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.contrasena = document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const respuesta = await request.text();
    if (respuesta != 'FAIL') {
        localStorage.token = respuesta;
        localStorage.email = datos.email;
        window.location.href = 'tables.html'
    } else {
        alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
    }

}