// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});
async function registrarUsuarios() {
    let datos= {};

    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.telefono = document.getElementById('txtTelefono').value;
    datos.email = document.getElementById('txtCorreo').value;
    datos.contrasena = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtPasswordrepetida').value;

    if (repetirPassword != datos.contrasena){
        alert('Tus contraseñas no coinciden, intenta nuevamente');
        return;

    }


    const request = await fetch('api/usuario', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("La cuenta fue creada con exito!");
    window.location.href = 'login.html'

}