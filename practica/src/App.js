import { useState } from "react";

function App() {

  const [isOn, setIsOn] = useState(false);

  return (
    <button onClick={() => setIsOn(!isOn)}>
      {isOn ? "Encendido" : "Apagado"}
    </button>

  )
}

export default App;

