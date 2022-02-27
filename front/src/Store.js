import React, {createContext, useReducer} from 'react';
import StoreProvider from './StoreProvider';

export const initialState = {
    todo: { list: [], item: {} },
    category: {list:[], item: {}}
  };


//export const Store = createContext(initialState)
export default StoreProvider;
