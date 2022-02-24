import React, { useContext, useReducer, useEffect, useRef, useState, createContext } from 'react';
import Form from './componets/Form';
import List from './componets/List';
import StoreProvider from './helpers/StoreProvider';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <Form />
    <List />
  </StoreProvider>
}

export default App;