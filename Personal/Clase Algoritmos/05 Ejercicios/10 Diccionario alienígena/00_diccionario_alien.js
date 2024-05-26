let a = ["avion", "zoologico"];
let diccionarioA = "zbcdefghijklmnopqrstuvwxya";
let b = ["barco", "banco"];
let diccionarioB = "barcodefghijklmnpqstuvwxyz";
let c = ["carro", "carroceria", "zarroceria"];
let diccionarioC = "abcdefghijklmnopqrstuvwxyz";

class Solucion {
    diccionarioAlien(lista, diccionario) {
        let ordenIndices = {};

        for (let i = 0; i < diccionario.length; i++) {
            const char = diccionario[i];
            ordenIndices[char] = i;
        }

        busqueda: for (let i = 0; i < lista.length - 1; i++) {
            const palabra1 = lista[i];
            const palabra2 = lista[i + 1];

            for (let j = 0; j < Math.min(palabra1.length, palabra2.length); j++) {
                if (palabra1[j] != palabra2[j]) {
                    if (ordenIndices[palabra1[j]] > ordenIndices[palabra2[j]]) {
                        return false;
                    }
                    continue busqueda;
                }
            }

            if (palabra1.length > palabra2.length) {
                return false;
            }

        }

        return true;
    }
}

console.log(new Solucion().diccionarioAlien(b, diccionarioB));
