const a = [1,2,3,2,3]; // 1
const b = [2]; // 2
const c = [4,6,2,2,4]; // 6

class Solucion {
    unSoloNumero(lista) {
        let resultado = 0;
        for (let num of lista) {
            resultado ^=  num;
        }
        return resultado;
    }
}

console.log(new Solucion().unSoloNumero(c));