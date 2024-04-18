package org.zerock.w11_j.todo.dto;

import java.time.LocalDate;

public class TodoDTO {
    private long tno;       //목록 번호
    private String title;   //글 제목
    private LocalDate dueDate;  //현재 시간
    private boolean finished;  //해냈는지 체크
    public TodoDTO(final long tno, final String title, final LocalDate dueDate, final boolean finished) {
        this.tno = tno;
        this.title = title;
        this.dueDate = dueDate;
        this.finished = finished;
    }
    public TodoDTO(){}
    public long getTno() {return tno;}
    public String getTitle() {return title;}
    public LocalDate getDueDate() {return dueDate;}
    public boolean isFinished() {return finished;}
    public void setTno(long tno) {this.tno = tno;}
    public void setTitle(String title) {this.title = title;}
    public void setDueDate(LocalDate dueDate) {this.dueDate = dueDate;}
    public void setFinished(boolean finished) {this.finished = finished;}

    @Override
    public String toString() {
        return "TodoDTO{" +
                "tno=" + tno +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", finished=" + finished +
                '}';
    }
}
