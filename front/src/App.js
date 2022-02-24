import React, { useContext, useReducer, useEffect, useRef, useState, createContext } from 'react';
import Form from './componets/Form';
import CategoryForm from './componets/categoryComponets/CategoryForm';
import List from './componets/List';
import CategoryList from './componets/categoryComponets/CategoryForm';
import StoreProvider from './helpers/StoreProvider';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <CategoryForm />
    <CategoryList />
  </StoreProvider>
}

export default App;