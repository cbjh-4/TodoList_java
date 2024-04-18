package org.zerock.w11_j.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zerock.w11_j.todo.dto.TodoDTO;
import org.zerock.w11_j.todo.service.TodoService;

import java.io.IOException;

@WebServlet(name="todoReadController", value = "/todo/read")
public class TodoReadController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long tno = Long.parseLong(request.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);
        request.setAttribute("dto", dto);
        request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request, response);
    }
}
