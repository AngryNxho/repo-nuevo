import './styles.css'
import { useState } from 'react';
function Box () {
    const [value, setValue] = useState(0);

    function increaseNumber() {
        setValue(value + 1);
    }

    return (
            <div className="box">
                <button onClick={increaseNumber}>{value} R</button>
            </div>
    );
}

function Board() {
    return (
        <div className="container">
            <div className='grid-container'>
                    <Box className='box'/>        
                    <Box className='box'/>        
                    <Box className='box'/>        
            </div>
        </div>
    );
}

export default function App (){
    return (
        <>
            <Board />
        </>
    );
}