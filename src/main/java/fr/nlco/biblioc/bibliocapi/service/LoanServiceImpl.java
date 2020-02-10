package fr.nlco.biblioc.bibliocapi.service;

import fr.nlco.biblioc.bibliocapi.dto.MemberLoansDto;
import fr.nlco.biblioc.bibliocapi.mapper.MemberLoansMapper;
import fr.nlco.biblioc.bibliocapi.model.Member;
import fr.nlco.biblioc.bibliocapi.repository.LoanRepository;
import fr.nlco.biblioc.bibliocapi.repository.MemberRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Implementation de l'interface LoanService
 */
@Service("LoanService")
public class LoanServiceImpl implements LoanService {

    private final LoanRepository _LoanRepository;
    private final MemberRepository _MemberRepository;
    private MemberLoansMapper mapper = Mappers.getMapper(MemberLoansMapper.class);

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, MemberRepository memberRepository) {
        this._LoanRepository = loanRepository;
        this._MemberRepository = memberRepository;
    }

    /**
     * Methode permettant de lister la liste des prêts d'un usager
     *
     * @param memberNumber numéro identifiant de l'usager
     * @return la liste des prêts de l'usager
     */
    @Override
    public List<MemberLoansDto> getMemberLoans(String memberNumber) {
        Member member = _MemberRepository.findByMemberNumber(memberNumber).orElse(null);
        List<MemberLoansDto> memberLoansDto = mapper.loansToMemberLoansDtos(_LoanRepository.findLoansByMember(member));
        memberLoansDto.forEach(l -> l.setDueDate(ComputeDueDate(l.getLoanDate(), l.getExtendedLoan())));
        return memberLoansDto;
    }

    /**
     * Methode permettant de calculer la date de retour d'un prêt en fonction de la date de prêt
     *
     * @param loanDate     date de prêt
     * @param extendedLoan prolongation de prêt (booléen)
     * @return date de retour du prêt
     */
    private Date ComputeDueDate(Date loanDate, Boolean extendedLoan) {
        Calendar c = Calendar.getInstance();
        c.setTime(loanDate);
        c.add(Calendar.WEEK_OF_MONTH, 4 * (extendedLoan ? 2 : 1));
        return c.getTime();
    }
}
