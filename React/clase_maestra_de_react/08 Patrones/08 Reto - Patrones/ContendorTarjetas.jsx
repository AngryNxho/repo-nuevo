// ContenedorTarjetas.jsx
import { createContext, useState } from 'react';
import PresentacionTarjetas from './PresentacionTarjetas';
import './estilos.css';

export const TarjetasContext = createContext();

const ContenedorTarjetas = () => {
  const [tarjetas, setTarjetas] = useState([]);
  const [nuevaTarjeta, setNuevaTarjeta] = useState({ titulo: '', descripcion: '' });

  const agregarTarjeta = () => {
    setTarjetas([...tarjetas, nuevaTarjeta]);
    // Limpiar las entradas después de agregar una tarjeta
    setNuevaTarjeta({ titulo: '', descripcion: '' });
  };

  const manejarCambios = (e) => {
    const { name, value } = e.target;
    setNuevaTarjeta({ ...nuevaTarjeta, [name]: value });
  };

  return (
    <TarjetasContext.Provider value={{ tarjetas, agregarTarjeta, nuevaTarjeta, manejarCambios }}>
      <div className="contenedor-tarjetas">
        <h2>Notas</h2>
        <PresentacionTarjetas />
      </div>
    </TarjetasContext.Provider>
  );
};

export default ContenedorTarjetas;
