// ComponenteTarjetaArticulo.js
import { useState } from 'react';
import './Tarjeta.css';

const Tarjeta = (props) => {
  const [cantidad, setCantidad] = useState(0);

  const aumentarCantidad = () => {
    setCantidad(cantidad + 1);
  };

  const disminuirCantidad = () => {
    if (cantidad > 0) {
      setCantidad(cantidad - 1);
    }
  };

  return (
    <div className="tarjeta-articulo">
      <img src={props.imagen} alt={props.alt} />
      <div className="contenido">
        <h2>{props.titulo}</h2>
        <p>{props.descripcion}</p>
        <div className="contador">
          <button onClick={disminuirCantidad}>-</button>
          <span>{cantidad}</span>
          <button onClick={aumentarCantidad}>+</button>
        </div>
      </div>
    </div>
  );
};

export default Tarjeta;
