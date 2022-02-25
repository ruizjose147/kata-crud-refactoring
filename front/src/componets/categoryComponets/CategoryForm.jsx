import React, { useContext, useRef, useState } from 'react'
import { Store } from '../../Store';

const HOST_API = "http://localhost:8080/api";

const CategoryForm = () => {
  const formRef = useRef(null);
  const { dispatch, state: { Category } } = useContext(Store);
  const item = Category.item;
  const [state, setState] = useState(item);

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

  return <form ref={formRef} className="form">
    <input
      className="form-control"
      type="text"
      name="name"
      placeholder="Nombre de la categoria"
      onChange={(event) => {
        setState({ ...state, nameList: event.target.value })
      }}  ></input>
    <br />
    <button className="btn btn-outline-success" onClick={onAdd} >Crear</button>
    <br />
  </form>
}

export default CategoryForm;