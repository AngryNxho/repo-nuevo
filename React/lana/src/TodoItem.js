// src/TodoItem.js
import React from 'react';
import PropTypes from 'prop-types';

const TodoItem = ({ task, index, onDeleteTask }) => {
  return (
    <li className="todo-item">
      {task}
      <button onClick={() => onDeleteTask(index)}>Delete</button>
    </li>
  );
};

TodoItem.propTypes = {
  task: PropTypes.string.isRequired,
  index: PropTypes.number.isRequired,
  onDeleteTask: PropTypes.func.isRequired,
};

export default TodoItem;
