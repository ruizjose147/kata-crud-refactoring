import React, {useContext, useEffect} from 'react'
import Store from '../../Store';
import List from '../List';
import Form from '../Form';

const HOST_API = "http://localhost:8080/api/category";

const CategoryList = () => {
    const { dispatch, state: { category } } = useContext(Store);
    const currentCategory = category.list;
  
    useEffect(() => {
      fetch(HOST_API + "/todosbycategory")
        .then(response => response.json())
        .then((list) => {
          dispatch({ type: "category-list", list })
        })
    }, [dispatch]);
  
  
    const onDelete = (id) => {
      fetch(HOST_API + "/" + id + "/todobycategory", {
        method: "DELETE"
      }).then((list) => {
        dispatch({ type: "delete-category", id })
      })
    };
  
    return <div>
      {currentCategory.map((element) =>{
        return<div className="border my-5 " key={element.id} >
        <div >
            <span >Categoria</span>
            <input 
            className="form-control "  
            disabled={true} 
            value={element.nameList} />
            <button
            className="btn btn-outline-danger" 
            onClick={() => onDelete(element.id)} >Eliminar
            </button>
        </div>
        <Form categoryId={element.id} />
        <List categoryId={element.id} />
    </div>
      })}
  </div>
}

export default CategoryList;