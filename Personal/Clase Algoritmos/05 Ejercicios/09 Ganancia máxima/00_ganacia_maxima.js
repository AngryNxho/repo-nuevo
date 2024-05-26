let a = [5, 4, 3, 2, 1]; // 0
let b = [-1, 2, 3, 4, 5, 9]; // 10
let c = [0, 1, -5, 3, 5, 15, 30, 2, 3, 77, 2]; // 82

class Solucion {
    gananciaMaxima(lista) {

        let gMax = 0;

        for (let i = 0; i < lista.length - 1; i++) {
            const valor1 = lista[i];
            for (let j = i + 1; j < lista.length; j++) {
                const valor2 = lista[j];
                if (valor2 - valor1 > gMax) {
                    gMax = valor2 - valor1;
                }
            }
        }

        return gMax;

    }
}

console.log(new Solucion().gananciaMaxima(a));

