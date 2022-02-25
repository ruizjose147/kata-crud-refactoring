import React, {useContext, useEffect} from 'react'
import { Store } from '../../Store';
import List from '../List';
import Form from '../Form';

const HOST_API = "http://localhost:8080/api";

const CategoryList = () => {
    const { dispatch, state: { todoByCategory } } = useContext(Store);
    const currentList = todoByCategory.list;
  
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