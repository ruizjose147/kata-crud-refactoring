import React from 'react';
import CategoryForm from './componets/categoryComponets/CategoryForm';
import CategoryList from './componets/categoryComponets/CategoryList';
import StoreProvider from './helpers/StoreProvider';

function App() {
  return <StoreProvider>
    <h1 align="center">Reto Full Stack Crud Lista de Litas</h1>
    <div className="container" align="center">
      <br />
      <div className="row border rounded">
        <h3>Crea una Lista de tareas</h3>
        <CategoryForm />
      </div>
      <br />
    </div>
    <CategoryList/>
  </StoreProvider>
}

export default App;