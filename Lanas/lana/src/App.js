import "./main.css"
import React, { useState } from "react";


function Table() {
  const [value, setValue] = useState(0);

  function handleClick() {
    setValue(value + 1);
  }

  return (
          <button onClick={handleClick}>{value}</button>
  )
}



export default function App() {
  return (
    <div className="tableContainer">
        <div className="tableContent">
          <div className="box">
              <Table className="button-left"/>
              <Table className="button-right"/>
              <Table className="button-left"/>
              <Table className="button-right"/>

          </div>
        </div>
    </div>
  )
}


