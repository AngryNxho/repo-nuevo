// PresentacionTarjetas.jsx
import { useContext } from 'react';
import { TarjetasContext } from './ContenedorTarjetas';

const PresentacionTarjetas = () => {
  const { tarjetas, agregarTarjeta, nuevaTarjeta, manejarCambios } = useContext(TarjetasContext);

  return (
    <div className="presentacion-tarjetas">
      <div>
        <label htmlFor="titulo">Título:</label>
        <input
          type="text"
          id="titulo"
          name="titulo"
          value={nuevaTarjeta.titulo}
          onChange={manejarCambios}
        />
      </div>
      <div>
        <label htmlFor="descripcion">Descripción:</label>
        <input
          type="text"
          id="descripcion"
          name="descripcion"
          value={nuevaTarjeta.descripcion}
          onChange={manejarCambios}
        />
      </div>
      <button onClick={agregarTarjeta}>Agregar Tarjeta</button>
      <ul>
        {tarjetas.map((tarjeta, index) => (
          <li key={index} className="tarjeta">
            <h3>{tarjeta.titulo}</h3>
            <p>{tarjeta.descripcion}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PresentacionTarjetas;
