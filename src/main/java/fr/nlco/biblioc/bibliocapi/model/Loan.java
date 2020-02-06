package fr.nlco.biblioc.bibliocapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Classe représentant les prêts
 */
@Entity
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loanId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date loanDate;

    private boolean extendedLoan = false;

    @OneToOne
    private Copy copy;

    public Loan() {
    }

    public Loan(Date loanDate, boolean extendedLoan, Copy copy) {
        this.loanDate = loanDate;
        this.extendedLoan = extendedLoan;
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", extendedLoan=" + extendedLoan +
                ", copy=" + copy +
                '}';
    }
}
