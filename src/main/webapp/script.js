
async function cargarEventos() {
    const deporte = document.getElementById("deporte").value;
    const estado = document.getElementById("estado").value;
    const url = "/eventos?deporte=" + encodeURIComponent(deporte) + "&estado=" + encodeURIComponent(estado);

    const response = await fetch(url);
    const eventos = await response.json();
    const tableBody = document.getElementById("tablaEventos");

    tableBody.innerHTML = ""; // Limpiar la tabla antes de agregar los nuevos datos

    eventos.forEach(evento => {
        const equipos = evento.equiposParticipantes.join(", ");
        tableBody.innerHTML += `
                    <tr>
                        <td>${evento.nombre}</td>
                        <td>${evento.fecha}</td>
                        <td>${evento.lugar}</td>
                        <td>${evento.deporte}</td>
                        <td>${evento.capacidad}</td>
                        <td>${evento.entradasVendidas}</td>
                        <td>${evento.estado}</td>
                        <td>${equipos}</td>
                    </tr>`;
    });
}

// Cargar eventos al cargar la página
window.onload = cargarEventos;