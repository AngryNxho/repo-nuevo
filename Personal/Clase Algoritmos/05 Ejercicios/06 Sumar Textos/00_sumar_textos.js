let a = '999';
let b = '1';

class Solucion {
    sumarTextos(texto1, texto2) {
        let result = '';
        let sobras = 0;
        for (let i = 0; i < Math.max(texto1.length, texto2.length); i++) {
            let num1 = parseInt(texto1[texto1.length - 1 - i] || 0);
            let num2 = parseInt(texto2[texto2.length - 1 - i] || 0);
            let suma = num1 + num2 + sobras;
            sobras = 0;
            if (suma > 9) {
                result = String(suma % 10) + result;
                sobras = 1;
            } else {
                result = String(suma) + result;
            }
        }

        if (sobras) {
            result = '1' + result;
        }

        return result;
    }
}

console.log(new Solucion().sumarTextos(a, b));