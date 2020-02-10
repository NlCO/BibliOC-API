package fr.nlco.biblioc.bibliocapi.controller;

import fr.nlco.biblioc.bibliocapi.dto.MemberLoansDto;
import fr.nlco.biblioc.bibliocapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * @return liste des livres emprunté par l'uasger
     */
    @GetMapping("/loan/{memberNumber}")
    public ResponseEntity<List<MemberLoansDto>> getMemberLoans(@PathVariable String memberNumber) {
        List<MemberLoansDto> memberLoans = _LoanService.getMemberLoans(memberNumber);
        if (memberLoans == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(memberLoans);
    }
}
