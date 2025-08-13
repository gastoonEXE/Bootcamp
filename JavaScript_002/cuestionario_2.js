const readline = require('readline');

// Obtenemos los argumentos de línea de comandos
const args = process.argv.slice(2);

let nombre = null;
let idioma = 'es'; // Idioma por defecto

// Procesamos los argumentos

// console.log(args);

console.log("raiz cuadrática (-):" + CuadraticaSuma(args[0], args[1], args[2]));

function CuadraticaSuma(a, b, c) {
  const DIS = b * b - 4 * a * c;

  if (DIS < 0) {
    return "No tiene Solución Real";
  }
  const raiz = (-b - Math.sqrt(DIS)) / (2 * a);
  return raiz;
}
