package org.zerock.w11_j.todo.service;

import org.zerock.w11_j.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE(0);
    long seq;
    TodoService(long seq) {
        this.seq = seq;
    }

    public long getSeq() {
        return seq;
    }

    private List<TodoDTO> todoList = new ArrayList<>();

    public  int getSize(){
        return TodoService.INSTANCE.todoList.size();
    }

    public List<TodoDTO> getList() {
        if (todoList.isEmpty()) {
            todoList = IntStream.range(0, 10).mapToObj(i -> {
                TodoDTO dto = new TodoDTO();
                dto.setTno((TodoService.INSTANCE.seq++));
                dto.setTitle("do..." + i);
                dto.setDueDate(LocalDate.now());
                dto.setFinished(false); //안해도 초기값은 false, null이므로!
                return dto;
            }).collect(Collectors.toList());    //List 형식에 10개 객체 만든 것을 저장한다.
        }
        return todoList;
    }

        public TodoDTO get(Long tno){
            for(TodoDTO dto : todoList){
                if(dto.getTno() == tno){
                    return dto;
                }
            }
            return null;
        }

        public void register(TodoDTO dto){
            System.out.println("Register Todo" + dto);
            dto.setTno(TodoService.INSTANCE.seq++);
            todoList.add(dto);
        }

        public void delete(long tno){
            TodoDTO todoDTO = get(tno);
            if(todoDTO != null){
                todoList.remove(todoDTO);
            }
            System.out.println("Delete Todo" + tno + "가 없어 삭제하지 못함.");
        }

    public void modify(TodoDTO todoDTO) {
        TodoDTO todoDTO_temp = get(todoDTO.getTno());
        int index = -1;
        index = todoList.indexOf(todoDTO_temp);
        if(index != -1){
            todoList.set(index, todoDTO);
        }
    }
}

