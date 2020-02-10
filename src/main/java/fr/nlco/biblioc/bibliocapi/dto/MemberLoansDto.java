package fr.nlco.biblioc.bibliocapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe DTO décrivant livre emprunté
 */
@Getter
@Setter
public class MemberLoansDto implements Serializable {
    private Integer loanId;
    private String title;
    private String author;
    private String type;
    private Date loanDate;
    private Date dueDate;
    private Boolean extendedLoan;

    public MemberLoansDto() {
    }

    @Override
    public String toString() {
        return "MemberLoansDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", extendedLaon=" + extendedLoan +
                '}';
    }
}
