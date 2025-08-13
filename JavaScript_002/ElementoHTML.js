

function actualizarElemento(id, texto) {
  const elemento = document.getElementById(id);
  if (elemento) {
    elemento.innerHTML = texto;
  } else {
    console.log("No se encontró el elemento");
  }
}
