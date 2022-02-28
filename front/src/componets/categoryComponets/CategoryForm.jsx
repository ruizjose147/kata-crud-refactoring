import React, { useContext, useRef, useState } from 'react'
import Store from '../../Store';

const HOST_API = "http://localhost:8080/api/category";

const CategoryForm = () => {
  const formRef = useRef(null);
  const { dispatch, state: { category } } = useContext(Store);
  const item = category.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      nameList: state.nameList,
      id: null,
    };

    fetch(HOST_API + "/todobycategory", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((category) => {
        dispatch({ type: "category-add", item: category });
        setState({ nameList: "" });
        formRef.current.reset();
      });
  }

  return <form ref={formRef} className="form">
    <input
      type="text"
      name="name"
      placeholder="Nombre de la categoria"
      onChange={(event) => {
        setState({ ...state, nameList: event.target.value })
      }}  ></input>
    <br />
    <button onClick={onAdd} >Crear</button>
    <br />
  </form>
}

export default CategoryForm;