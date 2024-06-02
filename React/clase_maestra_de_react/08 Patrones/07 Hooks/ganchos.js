/**
 * @nombre ganchos
 * @descipción
 * permite reutilizar separamos lógica de UI (similar a HOC y render pro)
 * es recomendado user ganchos, después render prop, y por último HOC
 */

function Titulo({ style }) {
    return <h1 style={style}>Hooks</h1>;
}

function useFondoRojo() {
    const style = { background: 'red' };
    return style;
}

function TituloRojo() {
    const style = useFondoRojo();
    return <Titulo style={style} />
}

ReactDOM.render(<TituloRojo />, document.getElementById('root'));