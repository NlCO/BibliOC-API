package fr.nlco.biblioc.bibliocapi.controller;

import fr.nlco.biblioc.bibliocapi.dto.MemberLateLoansDto;
import fr.nlco.biblioc.bibliocapi.dto.MemberLoansDto;
import fr.nlco.biblioc.bibliocapi.model.Loan;
import fr.nlco.biblioc.bibliocapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe Controller pour la consultation des prêt de la bibliothèque
 */
@RestController
public class LoanController {

    private LoanService _LoanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this._LoanService = loanService;
    }

    /**
     * Methode qui retourne les prêts d'un usager
     *
     * @param memberNumber numéro de l'usager
     * @return liste des livres emprunté par l'usager encapsulé dans une ResponseEntity
     */
    @GetMapping("/loan/{memberNumber}")
    public ResponseEntity<List<MemberLoansDto>> getMemberLoans(@PathVariable String memberNumber) {
        List<MemberLoansDto> memberLoans = _LoanService.getMemberLoans(memberNumber);
        if (memberLoans == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(memberLoans);
    }

    /**
     * Methode permettant de prolonger la periode de prêt
     *
     * @param loanId id du prêt
     * @return le prêt mis à jour encapsulé dans une ResponseEntity
     */
    @PutMapping("/loan/{loanId}")
    public ResponseEntity<Loan> extendLoanPeriod(@PathVariable Integer loanId) {
        Loan updatedLoan = _LoanService.extendLoanPeriod(loanId);
        if (updatedLoan == null) return ResponseEntity.status(400).build();
        return ResponseEntity.ok(updatedLoan);
    }

    /**
     * Endpoint permettant de récuperer la liste des livres en retard de retour de prêt
     */
    @GetMapping("/loan/late")
    public ResponseEntity<List<MemberLateLoansDto>> getLateLoans() {
        List<MemberLateLoansDto> lateLoans = _LoanService.getLateLoans();
        if (lateLoans == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lateLoans);
    }
}
