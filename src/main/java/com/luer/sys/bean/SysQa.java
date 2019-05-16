package com.luer.sys.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class SysQa implements Serializable {
    private Integer id;
    private String question;
    private String answer;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date addDate;

    private String addUser;

    private Integer source;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }



}

class SysQalist {
    List<SysQa> list;

    public List<SysQa> getList() {
        return list;
    }

    public void setList(List<SysQa> list) {
        this.list = list;
    }
}

