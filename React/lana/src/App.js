import { useState } from 'react';
import box from './box.css'

function Box() {
    return (
        <div className = 'container'>
                <div className="two-buttons first">
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                </div>

                <div className="two-buttons second">
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                </div>

                <div className="two-buttons third">
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                </div>

                <div className="two-buttons fourth">
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                    <div className="square">D</div>
                    <div className="square">l</div>
                </div>
        </div>
    )
}

function App() {
    return (
        <div>
            <h1>Hola Mundo</h1>
            <Box />
        </div>
    )
}

export default App;