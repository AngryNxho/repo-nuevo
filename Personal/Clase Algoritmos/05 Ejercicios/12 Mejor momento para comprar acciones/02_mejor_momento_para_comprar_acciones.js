let a = [3,5,2,1,9,10,3]; // 11
let b = []; // 0
let c = [0,10,5,15,30,35,10]; // 40

class Solucion {
    mejorMomentoParaComprarAcciones(precios) {
        let ganancia = 0;
        for (let i = 1; i < precios.length; i++) {
            if (precios[i] > precios[i - 1])
            ganancia += precios[i] - precios[i - 1];
        }
        return ganancia;
    }
}

console.log(new Solucion().mejorMomentoParaComprarAcciones(a));

