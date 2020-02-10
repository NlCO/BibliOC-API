package fr.nlco.biblioc.bibliocapi.service;

import fr.nlco.biblioc.bibliocapi.dto.MemberLoansDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface contenant la logique metier sur les prêts
 */
@Service
public interface LoanService {
    /**
     * Methode permettant de lister la liste des prêts d'un usager
     *
     * @param memberNumber numéro identifiant de l'usager
     * @return la liste des prêts de l'usager
     */
    List<MemberLoansDto> getMemberLoans(String memberNumber);
}
