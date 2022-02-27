import React, {useContext, useEffect} from 'react'
import { Store } from '../../Store';
import List from '../List';
import Form from '../Form';

const HOST_API = "http://localhost:8080/api/category";

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
      {currentList.map((element) =>{
        return<div className="border my-5 " key={elemento.id} >
        <div >
            <span >Categoria</span>
            <input 
            className="form-control "  
            disabled={true} 
            value={elemento.nameList} />
            <button
            className="btn btn-outline-danger" 
            onClick={() => onDelete(elemento.id)} >Eliminar
            </button>
        </div>
        <Form todoListId={elemento.id} />
        <List todoListId={elemento.id} />
    </div>
      })}
  </div>
}

export default CategoryList;