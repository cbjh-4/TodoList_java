package org.zerock.w11_j.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zerock.w11_j.todo.service.TodoService;

import java.io.IOException;

@WebServlet(name="todoDeleteCotroller", urlPatterns = "/todo/delete")
public class TodoDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long tno = Long.parseLong(req.getParameter("tno"));
        TodoService.INSTANCE.delete(tno);
        resp.sendRedirect("/todo/list");
    }
}
