package fr.nlco.biblioc.bibliocapi.mapper;

import fr.nlco.biblioc.bibliocapi.dto.MemberLoansDto;
import fr.nlco.biblioc.bibliocapi.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Interface de mapping des prêts
 */
@Mapper(componentModel = "spring")
public interface MemberLoansMapper {

    /**
     * Methode permettent d'obtenir une liste de prêts détaillés à partir de la liste obtenus du repository
     *
     * @param loans liste issu du repository
     * @return liste des prêts formatées
     */
    List<MemberLoansDto> loansToMemberLoansDtos(List<Loan> loans);

    /**
     * Mapping d'un prêt vers sa forme DTO
     *
     * @param loan prêt
     * @return prêt formaté
     */
    @Mappings({
            @Mapping(target = "title", expression = "java(loan.getCopy().getBook().getTitle())"),
            @Mapping(target = "author", expression = "java(loan.getCopy().getBook().getAuthor())"),
            @Mapping(target = "type", expression = "java(loan.getCopy().getBook().getType())"),
            @Mapping(target = "dueDate", expression = "java(loan.getLoanDate())")
    })
    MemberLoansDto loanToMemberLoanDto(Loan loan);
}
