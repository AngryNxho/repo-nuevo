// ComponenteUsuarios.jsx
import { useState, useEffect } from 'react';
import useFetch from './useFetch.jsx'; // Asegúrate de tener tu gancho personalizado en el mismo directorio
import './ComponenteUsuarios.css'; // Importa tus estilos CSS

const ComponenteUsuarios = () => {
  const [usuarios, setUsuarios] = useState([]);
  const { data, loading, error } = useFetch('https://jsonplaceholder.typicode.com/users');

  useEffect(() => {
    if (data) {
      setUsuarios(data);
    }
  }, [data]);

  return (
    <div className="usuarios-container">
      <h2>Lista de Usuarios</h2>
      {loading && <p>Cargando...</p>}
      {error && <p>Error: {error}</p>}
      <div className="tarjetas-container">
        {usuarios.map((usuario) => (
          <div key={usuario.id} className="tarjeta-usuario">
            <h3>{usuario.name}</h3>
            <p>{usuario.company.catchPhrase}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ComponenteUsuarios;
