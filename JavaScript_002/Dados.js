function generarDados() {
    const container = document.getElementById('dadosContainer');
    container.innerHTML = '';
    for (let i = 0; i < 5; i++) {
        const numero = Math.floor(Math.random() * 6) + 1;
        container.appendChild(crearDado(numero));
    }
}

// Dibuja el dado según el número (1-6)
function crearDado(num) {
    const cell = document.createElement('div');
    cell.className = 'divDado';
    cell.appendChild(dibujarCara(num));
    return cell;
}

function dibujarCara(num) {
    // Matriz de posiciones de los puntos para cada cara
    const posiciones = [
        // 1
        [[0,0,0],[0,1,0],[0,0,0]],
        // 2
        [[1,0,0],[0,0,0],[0,0,1]],
        // 3
        [[1,0,0],[0,1,0],[0,0,1]],
        // 4
        [[1,0,1],[0,0,0],[1,0,1]],
        // 5
        [[1,0,1],[0,1,0],[1,0,1]],
        // 6
        [[1,0,1],[1,0,1],[1,0,1]]
    ];
    const table = document.createElement('table');
    table.className = 'unstyledTable';
    const tbody = document.createElement('tbody');
    for (let r = 0; r < 3; r++) {
        const tr = document.createElement('tr');
        for (let c = 0; c < 3; c++) {
            const td = document.createElement('td');
            if (posiciones[num-1][r][c]) {
                const dot = document.createElement('span');
                dot.className = 'dot';
                td.appendChild(dot);
            }
            tr.appendChild(td);
        }
        tbody.appendChild(tr);
    }
    table.appendChild(tbody);
    return table;
}

// Tirar los dados al cargar la página
window.onload = generarDados;