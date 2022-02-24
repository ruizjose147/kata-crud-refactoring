import React, {useContext, useRef, useState} from 'react'
import {Store} from '../helpers/Store';

const HOST_API = "http://localhost:8080/api";

const CategoryForm = () => {
    const formRef = useRef(null);
    const { dispatch, state: { todo } } = useContext(Store);
    //const item = todo.item;
    const [state, setState] = useState(todo);
  
    const onAdd = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id: null,
        completed: false
      };
  
  
      fetch(HOST_API + "/todobycategory", {
        method: "POST",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((list) => {
          dispatch({ type: "add-item", item: list });
          setState({ name: "" });
          formRef.current.reset();
        });
    }
  
    return <form ref={formRef}>
      <input
        type="text"
        name="name"
        placeholder="Agregar Categoria"
        
        onChange={(event) => {
          setState({ ...state, name: event.target.value })
        }}  ></input>
      
    </form>
  }

  export default CategoryForm;