function Titulo({ style }) {
    return <h1 style={style}>Render Prop</h1>;
}

function FondoRojo({ children }) {
    const style = { background: 'blue' };
    return children(style)
}

function TituloRojo() {
    const render = style => <Titulo style={style} />;
    return <FondoRojo>{render}</FondoRojo>;
}

ReactDOM.render(<TituloRojo />, document.getElementById('root'));