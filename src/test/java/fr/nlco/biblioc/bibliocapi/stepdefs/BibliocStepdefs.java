package fr.nlco.biblioc.bibliocapi.stepdefs;

import fr.nlco.biblioc.bibliocapi.BibliocapiApplication;
import fr.nlco.biblioc.bibliocapi.controller.BookController;
import fr.nlco.biblioc.bibliocapi.dto.BookStockDto;
import fr.nlco.biblioc.bibliocapi.repository.BookRepository;
import fr.nlco.biblioc.bibliocapi.repository.CopyRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = BibliocapiApplication.class, loader = SpringBootContextLoader.class)
@ActiveProfiles("test")
public class BibliocStepdefs {

    @Autowired
    private BookRepository _BookRepository;
    @Autowired
    private CopyRepository _CopyRepository;
    @Autowired
    private BookController _BookController;


    private Integer bookNumber = 0;
    private Integer copyNumber = 0;
    private ResponseEntity<List<BookStockDto>> response;

    @Given("a library with n copies of y books")
    public void aLibraryWithBooksFromYWorks() {
        copyNumber = _CopyRepository.findAll().size();
        bookNumber = _BookRepository.findAll().size();
        Assert.assertTrue("La base de données ne contient pas d'ouvrages", bookNumber > 0);
        Assert.assertTrue("La base de données ne contient pas de livres", copyNumber > 0);
    }

    @When("I ask the list of books")
    public void iAskTheListOfBooks() {
        response = _BookController.getBooksStock();
    }

    @Then("a list of y books with their availability is returned")
    public void aListOfBooksWithTheirAvailabilityIsReturned() {
        Assert.assertEquals(ResponseEntity.ok().build().getStatusCode(), response.getStatusCode());
        Integer nbBookResult = response.getBody().size();
        Assert.assertEquals(bookNumber, nbBookResult);
        Integer nbCopyResult = response.getBody().stream().mapToInt(BookStockDto::getNbCopy).sum();
        Assert.assertEquals(copyNumber, nbCopyResult);
    }

    @Given("a member with loaned books")
    public void aMemberWithLoanedBooks() {
        throw new NotImplementedException();
    }

    @When("he consult his loaning")
    public void heConsultHisLoaning() {
        throw new NotImplementedException();
    }

    @Then("a list of his loaned book is returned")
    public void aListOfHisLoanedBookIsReturned() {
        throw new NotImplementedException();
    }

    @Given("a loaned book which due date is not extended")
    public void aLoanedBookWhichDueDateIsNotExtended() {
        throw new NotImplementedException();
    }

    @When("the loan period is extended")
    public void theLoanPeriodIsExtended() {
        throw new NotImplementedException();
    }

    @Then("the book is flagged with the extend loaning period")
    public void theBookIsFlaggedWithTheExtendLoaningPeriod() {
        throw new NotImplementedException();
    }
}
