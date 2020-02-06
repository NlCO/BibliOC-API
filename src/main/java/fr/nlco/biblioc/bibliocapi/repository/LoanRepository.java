package fr.nlco.biblioc.bibliocapi.repository;

import fr.nlco.biblioc.bibliocapi.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface pour la couche DAO de la classe model Loan
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
