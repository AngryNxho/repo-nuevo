let mapa = {};

function fibo(n) {
    if (n in mapa) return mapa[n];
    if (n <= 1) return n;
    mapa[n] = fibo(n - 1) + fibo(n - 2);
    return mapa[n];
}

console.log(fibo(0));
console.log(fibo(1));
console.log(fibo(2));
console.log(fibo(3));
console.log(fibo(6));