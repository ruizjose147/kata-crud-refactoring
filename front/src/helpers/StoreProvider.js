import React, {useReducer} from 'react';
import reducer from './Reduce';
import {Store} from './Store';
import {initialState} from './Store';

const StoreProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, initialState);
  
    return <Store.Provider value={{ state, dispatch }}>
      {children}
    </Store.Provider>
  
  }

  export default StoreProvider;