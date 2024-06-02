/**
 * @nombre HOC (high orden component)
 * @descipción
 * pasa lógica reutilizable a componentes
 * componente que retorna otro componente
 * es modular y simple
 * es usado por librerías de React como Apollo y Redux
 */

function Titulo({ style }) {
    return <h1 style={style}>HOC</h1>;
}

function withFondoRojo(Componente) {
    return props => {
        const style = { background: 'red' };
        return <Componente {...props} style={style} />
    }
}

const TituloRojo = withFondoRojo(Titulo);

ReactDOM.render(<TituloRojo />, document.getElementById('root'));