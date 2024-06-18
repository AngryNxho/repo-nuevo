// src/TodoList.js
import React from 'react';
import PropTypes from 'prop-types';
import TodoItem from './TodoItem';

const TodoList = ({ tasks, onDeleteTask }) => {
  return (
    <ul className="todo-list">
      {tasks.map((task, index) => (
        <TodoItem key={index} task={task} index={index} onDeleteTask={onDeleteTask} />
      ))}
    </ul>
  );
};

TodoList.propTypes = {
  tasks: PropTypes.array.isRequired,
  onDeleteTask: PropTypes.func.isRequired,
};

export default TodoList;
