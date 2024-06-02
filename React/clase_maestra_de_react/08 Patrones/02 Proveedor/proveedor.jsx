import { createContext, useContext } from "react";

const Contexto = createContext(null);
const Memoria = () => (
    <Contexto.Provider value={{ texto: 'Texto' }}>
        {children}
    </Contexto.Provider>
);

function App() {
    return <Memoria><Abuelo datos={datos} /></Memoria>;
}

const Abuelo = () => <Padre />;
const Padre = () => <Hijo />;
const Hijo = () => <Nieto />;
const Nieto = () => {
    const { datos } = useContext(Contexto);
    return <p>{datos.texto}</p>;
};

