import "./main.css"
import React, { useState } from "react";


function Table() {
  const [value, setValue] = useState(0);

  function handleClick() {
    alert("Clicked")
  }

  return (
    <button onClick={handleClick}>X</button>
  )
}

export default function App() {
  return (
    <div>
      <table>
        <tr>
          <td>
            <Table value={value}/>
            <Table value={value}/>
            <Table value={value}/>
          </td>
        </tr>

        <tr>
          <td>
            <Table value={value}/>
            <Table value={value}/>
            <Table value={value}/>
          </td>
        </tr>

        <tr>
          <td>
            <Table value={value}/>
            <Table value={value}/>
            <Table value={value}/>
          </td>
        </tr>

        <tr>
          <td>
            <Table value={value}/>
            <Table value={value}/>
            <Table value={value}/>
          </td>
        </tr>

        <tr>
          <td>
            <Table value={value}/>
            <Table value={value}/>
            <Table value={value}/>
          </td>
        </tr>
      </table>
      
    </div>
  )
}

