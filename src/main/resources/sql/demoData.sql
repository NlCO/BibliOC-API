INSERT INTO book (isbn, title, author, type) VALUES ('978-2267011258', 'Le Seigneur des anneaux', 'J.R.R. Tolkien', 'Roman Fantastique'), ('978-2845999145', 'Fairy Tail - Tome 1', 'Hiro Mashima', 'Shonen'), ('978-2845999459', 'Fairy Tail - Tome 2', 'Hiro Mashima', 'Shonen'), ('978-2080703248', 'Ruy Blas', 'Victor Hugo', 'Théatre'), ('978-2800109558', 'Gaston, Tome 14 : La Saga des gaffes ', 'André FRANQUIN', 'BD');

INSERT INTO copy (book_book_id) VALUES (1),(2),(2),(3),(3),(5),(5);

INSERT INTO loan (loan_date, extended_loan, copy_copy_id) VALUES ('2020-01-11 10:02:26','false',1),('2020-02-05 16:45:26','false',2),('2020-01-19 17:45:26','true',3),('2019-12-12 08:45:26','true',5);