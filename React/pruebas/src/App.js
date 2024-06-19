import React, { useState } from 'react';
// import './AddTask.js'
// Contador
// function App() {
//     const [counter, setCounter] = useState(0);

//     const increaseCounter = () => {
//         setCounter(counter + 1);
//     }

//     const decreaseCounter = () => {
//         setCounter(counter - 1);
//     }

//     return (
//         <div>
//             <h1>{counter}</h1>
//             <button onClick={increaseCounter}>Increase</button>
//             <button onClick={decreaseCounter}>Decrease</button>
//         </div>
//     )
// }

// export default App;

// Agregar tareas

import Task from './Task.js';

function App() {
    const [task, setTask] = useState('');
    const [tasks, setTasks] = useState([]);

    const handleClick = () => {
        console.log(task);
        setTasks(task)

    };

    const handleChange = (e) => {
        setTask(e.target.value)
    }

    return (
        <div>
            <input type="text" placeholder='Type task' onChange={handleChange}/>
            <button onClick={handleClick}>Add</button>
            <Task task={tasks} />
        </div>
    );
}

export default App;