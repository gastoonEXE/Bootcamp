

// let screen = [];


// function presionar(id) {
//   const elemento = document.getElementById('Pantalla');
//     //console.log(id);

//     switch (id) {
//         case '1':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             elemento.innerHTML = screen.toString();
//             break;
//         case '2':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '3':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '4':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '5':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '6':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '7':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '8':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '9':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '0':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '+':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '-':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '*':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '/':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '.':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '=':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case '(':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case ')':
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
//         case 'CE':
//             screen = [];
//             elemento.innerHTML = '';
//             // return;
//             console.log(id);
//             screen.push(id);
//             console.log(screen);
//             break;
        



//         default:
//             onsole.log("No se encontró el elemento");
//             break;
//     }

// }

let screen = [];

function presionar(id) {
    const elemento = document.getElementById('Pantalla');
    const result = document.getElementById('Resultado');

    if (id === 'CE') {
        screen = [];
        elemento.innerHTML = '';
        result.innerHTML = '';
        return;
    }
    if (id === '=') {
        try {
            // Unir el array y evaluar la expresión
            const resultado = eval(screen.join(''));
            result.innerHTML = resultado;
            screen = [resultado.toString()];
        } catch (e) {
            result.innerHTML = 'Error';
            screen = [];
        }
        return;
    }

    // console.log(screen.join(''));

    screen.push(id);
    console.log(screen);
    elemento.innerHTML = screen.join('');
}