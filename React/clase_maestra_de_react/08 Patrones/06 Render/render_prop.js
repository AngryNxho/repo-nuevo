/**
 * @nombre render prop
 * @descipción
 * permite reutilizar componentes en React (similar a HOC)
 * pasamos in componente como propiedad
 * compartir lógica es fácil en lugar de levantar estado
 */

function Titulo({ style }) {
    return <h1 style={style}>Render Prop</h1>;
}

function FondoRojo({ render }) {
    const style = { background: 'blue' };
    return render(style)
}

function TituloRojo() {
    const render = style => <Titulo style={style} />;
    return <FondoRojo render={render} />
}

ReactDOM.render(<TituloRojo />, document.getElementById('root'));