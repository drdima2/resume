package net.devstudy.resume.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.sql.Date;

@MappedSuperclass
public abstract class AbstractFinishDateEntity<T> extends AbstractEntity<T>{

    private static final long serialVersionUID = -2348784678545171119L;


    @Column(name = "finish_date")
    private Date finishDate;

    @Transient
    private Integer finishDateMonth;

    @Transient
    private Integer finishDateYear;


    public Integer getFinishDateYear() {

        return finishDateYear;
    }

    public void setFinishDateYear(Integer finishDateYear) {
        this.finishDateYear = finishDateYear;
    }

    public Integer getFinishDateMonth() {
        return finishDateMonth;
    }

    public void setFinishDateMonth(Integer finishDateMonth) {
        this.finishDateMonth = finishDateMonth;
    }



    public Date getFinishDate() {

        return finishDate;
    }


    public boolean isFinish(){
        return finishDate != null;
    }




    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }



}
