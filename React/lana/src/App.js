import { useState } from 'react';
import './box.css';

function Box() {
    return (
        <div className='container'>
            <div className="two-buttons first">
                <div className="square">
                    <MyButton />
                </div>
                <div className="square">
                    <MyButton />
                </div>
                <div className="square">D</div>
            </div>
        </div>
    );
}

function MyButton() {
    const [count, setCount] = useState(0);

    function handleClick() {
        setCount(count + 1);
    }

    return (
        <button onClick={handleClick}>
            {count}
        </button>
    );
}

function App() {
    return (
        <div>
            <Box />
        </div>
    );
}

export default App;
