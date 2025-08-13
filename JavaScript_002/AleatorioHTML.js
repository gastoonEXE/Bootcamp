

function aleatorioElemento(id) {
  const elemento = document.getElementById(id);


  if (elemento) {
    console.log(1 + Math.floor(Math.random() * 100));
    elemento.innerHTML = 1 + Math.floor(Math.random() * 100);
  } else {
    console.log("No se encontró el elemento");
  }
}
