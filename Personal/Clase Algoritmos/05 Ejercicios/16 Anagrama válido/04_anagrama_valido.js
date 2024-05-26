let a = 'amor';
let b = 'roma';
let c = 'mora';
let d = 'casa';

class Solucion {
    anagramaValido(texto1, texto2) {
        if (texto1.length !== texto2.length) return false;

        let mapa = {};
        for (let letra of texto1) {
            mapa[letra] = mapa[letra] + 1 || 1;
        }

        for (let letra of texto2) {
            if (!mapa[letra]) return false;
            mapa[letra]--;
        }
        return true;
    }
}

let solucion = new Solucion();
console.log(solucion.anagramaValido(a, b)); // true
console.log(solucion.anagramaValido(a, c)); // true
console.log(solucion.anagramaValido(b, c)); // true
console.log(solucion.anagramaValido(b, d)); // false