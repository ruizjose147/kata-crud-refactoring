
function reducer(state, action) {
    switch (action.type) {
      case 'delete-category':
            const todoListDelete = state.category;
            const todoListIsUpdate = todoListDelete.list.filter((element) => {
                return element.id !== action.id;
            });
            todoListDelete.list = todoListIsUpdate;
            return { ...state, category: todoListDelete }
  
        case 'category-list':
            const todoList = state.category;
            todoList.list = action.list;
            return { ...state, category: todoList  };
  
        case 'category-add':
            const todoListAdd = state.category.list;
            todoListAdd.push(action.item);
            return { ...state, category: {list:todoListAdd} };
        
        case 'update-item':
            const todoUpItem = state.todo;
            const listUpdateEdit = todoUpItem.list.map((item) => {
                if (item.id === action.item.id) {
                    return action.item;
                }
                return item;
            });
            todoUpItem.list = listUpdateEdit;
            todoUpItem.item = {};
            return { ...state, todo: todoUpItem }
  
        case 'delete-item':
            const todoUpDelete = state.todo;
            const listUpdate = todoUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            todoUpDelete.list = listUpdate;
            return { ...state, todo: todoUpDelete }
  
        case 'edit-item':
            const todoUpEdit = state.todo;
            todoUpEdit.item = action.item;
            return { ...state, todo: todoUpEdit }
  
        case 'add-item':
            const todoUp = state.todo.list;
            todoUp.push(action.item);
            return { ...state, todo: { list: todoUp, item: {} } }
  
        case 'update-list':
            const todoUpList = state.todo;
            todoUpList.list = action.list;
            return { ...state, todo: todoUpList }
  
        default:
            return state;
    }
  }

export default reducer;