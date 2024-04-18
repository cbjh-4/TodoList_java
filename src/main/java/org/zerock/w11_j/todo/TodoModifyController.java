package org.zerock.w11_j.todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zerock.w11_j.todo.dto.TodoDTO;
import org.zerock.w11_j.todo.service.TodoService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO todoDTO = TodoService.INSTANCE.get(tno);
        req.setAttribute("todoDTO", todoDTO);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long tno = Long.parseLong(req.getParameter("tno"));
        String title = req.getParameter("title");
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));
        boolean finished = Boolean.parseBoolean(req.getParameter("finished"));
        TodoDTO todoDTO = new TodoDTO(tno, title, dueDate, finished);
        TodoService.INSTANCE.modify(todoDTO);
        resp.sendRedirect("/todo/list");
    }
}
