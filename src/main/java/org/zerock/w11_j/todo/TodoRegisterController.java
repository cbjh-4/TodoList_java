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


@WebServlet(name="todoREsterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long seq = TodoService.INSTANCE.getSeq();
        req.setAttribute("tno", seq);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long tno = -1;  //임시값, TodoService에서 seq로 처리됨
        String title = req.getParameter("title");
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));
        boolean finished = Boolean.parseBoolean(req.getParameter("finished"));

        TodoDTO todoDTO = new TodoDTO(tno, title, dueDate, finished);
        TodoService.INSTANCE.register(todoDTO);
        //~번째 할일이 추가되었습니다. 팝업 뜨는 기능 추가?

        resp.sendRedirect("/todo/list");
    }
}
