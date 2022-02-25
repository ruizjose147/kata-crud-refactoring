import React, {useContext, useEffect} from 'react'
import {Store} from '../helpers/Store';

const HOST_API = "http://localhost:8080/api";

const CategoryList = () => {
    //const { dispatch, state: { todoByCategory } } = useContext(Store);
    //const currentList = todoByCategory.list;
  
    useEffect(() => {
      fetch(HOST_API + "/todosbycategory")
        .then(response => response.json())
        .then((list) => {
          dispatch({ type: "update-list", list })
        })
    }, [dispatch]);
  
  
    const onDelete = (id) => {
      fetch(HOST_API + "/" + id + "/todobycategory", {
        method: "DELETE"
      }).then((list) => {
        dispatch({ type: "delete-item", id })
      })
    };
  
    /*const onEdit = (todoByCategory) => {
      dispatch({ type: "edit-item", item: todoByCategory })
    };*/
  
    /*const onChange = (event, todoByCategory) => {
      const request = {
        name: todoByCategory.name,
        id: todoByCategory.id,
        completed: event.target.checked
      };
      fetch(HOST_API + "/todobycategory", {
        method: "PUT",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((todoByCategory) => {
          dispatch({ type: "update-item", item: todoByCategory });
        });
    };*/
  
    const decorationDone = {
      textDecoration: 'line-through'
    };
    return <div>
      <table >
        <thead>
          <tr>
            <td>ID</td>
            <td>Tarea</td>
            <td>¿Completado?</td>
          </tr>
        </thead>
        <tbody>
          {currentList.map((todo) => {
            return <tr key={todo.id} style={todoByCategory.completed ? decorationDone : {}}>
              <td>{todoByCategory.id}</td>
              <td>{todoByCategory.name}</td>
              <td><input type="checkbox" defaultChecked={todoByCategory.completed} onChange={(event) => onChange(event, todo)}></input></td>
              <td><button onClick={() => onDelete(todoByCategory.id)}>Eliminar</button></td>
              <td><button onClick={() => onEdit(todoByCategory)}>Editar</button></td>
            </tr>
          })}
        </tbody>
      </table>
    </div>
  }

  export default CategoryList;