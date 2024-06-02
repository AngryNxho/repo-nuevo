// ComponenteFormulario.jsx
import { useState } from 'react';
import './Form.css'; // Asegúrate de tener el archivo CSS en la misma carpeta

const Form = () => {
  const [datos, setDatos] = useState({
    nombre: '',
    email: '',
    mensaje: '',
  });

  const handleChange = (e) => {
    setDatos({
      ...datos,
      [e.target.id]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Aquí puedes realizar acciones con los datos, como enviarlos a un servidor
    console.log(datos);
  };

  return (
    <div className="formulario">
      <h2>Formulario</h2>
      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <label htmlFor="nombre">Nombre:</label>
          <input
            type="text"
            id="nombre"
            value={datos.nombre}
            onChange={handleChange}
          />
        </div>
        <div className="input-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            value={datos.email}
            onChange={handleChange}
          />
        </div>
        <div className="input-group">
          <label htmlFor="mensaje">Mensaje:</label>
          <textarea
            id="mensaje"
            value={datos.mensaje}
            onChange={handleChange}
          ></textarea>
        </div>
        <button type="submit" className="button">
          Enviar
        </button>
      </form>
    </div>
  );
};

export default Form;
