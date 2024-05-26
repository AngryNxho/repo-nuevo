let a = [
    ['3', '7', '6', '2', '5', '4', '8', '9', '1'],
    ['.', '2', '.', '1', '7', '.', '3', '.', '5'],
    ['.', '5', '.', '3', '.', '.', '6', '2', '.'],
    ['.', '8', '.', '.', '2', '.', '9', '.', '.'],
    ['.', '.', '.', '.', '.', '.', '7', '.', '.'],
    ['.', '.', '3', '.', '4', '.', '2', '1', '.'],
    ['.', '1', '4', '7', '6', '3', '5', '8', '.'],
    ['2', '.', '7', '4', '8', '5', '1', '6', '.'],
    ['.', '.', '.', '9', '1', '2', '4', '.', '1']
];

class Solucion {
    sudokuValido(matriz) {
        if(!this.filasValidas(matriz)) return false;
        if(!this.columnasValidas(matriz)) return false;
        if(!this.bloquesValidos(matriz)) return false;
        return true;
    }
    filasValidas(matriz) {
        for (let y = 0; y < 9; y++) {
            const fila = matriz[y];
            const mapa = {};
            for (let x = 0; x < 9; x++) {
                const celda = fila[x];
                if (celda === '.') continue;
                if (!mapa[celda]) {
                    mapa[celda] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    columnasValidas(matriz) {
        for (let y = 0; y < 9; y++) {
            const mapa = {};
            for (let x = 0; x < 9; x++) {
                const columna = matriz[x];
                const celda = columna[y];
                if (celda === '.') continue;
                if (!mapa[celda]) {
                    mapa[celda] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    bloquesValidos(matriz) {
        const mapa = {};
        for (let y = 0; y < 9; y++) {
            for (let x = 0; x < 9; x++) {
                const bloque = `${Math.floor(y/3)}-${Math.floor(x/3)}`;
                const celda = matriz[y][x];
                if (!mapa[bloque]) {
                    mapa[bloque] = {};
                }
                if (celda === '.') continue;
                if (!mapa[bloque][celda]) {
                    mapa[bloque][celda] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    sudokuValidoOptimo(matriz) {
        const mapa = {};
        for (let y = 0; y < 9; y++) {
            for (let x = 0; x < 9; x++) {
                const bloque = `${Math.floor(y/3)}-${Math.floor(x/3)}`;
                const celda = matriz[y][x];
                const fila = matriz[y];
                const columna = matriz[x];

                if (celda === '.') continue;
                if (mapa[`${celda} en fila ${fila}`]
                || mapa[`${celda} en columna ${columna}`]
                || mapa[`${celda} en bloque ${bloque}`]) return false;
                mapa[`${celda} en fila ${fila}`] = true;
                mapa[`${celda} en columna ${columna}`] = true;
                mapa[`${celda} en bloque ${bloque}`] = true;
            }
        }
        return true;
    }
}

console.log(new Solucion().sudokuValidoOptimo(a));