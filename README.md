# Books

This Spring Boot Application connects to a MySQL database that is predefined in application.properties. Using the domain model "Book", we create a table within our database that 
keeps track of a book's attributes.

**BookRepository**
  The **BookRepository** interface contains methods to find all books in the database, find a book with a description that contains a defined String, counts how many book titles
  contain a certain String, and delete books with a specific title.
  
**Book Service**
  Here, we inject an instance of **BookRepository** and utilize it to define our CRUD commands.
    
**BookApi**
  This controller attaches our CRUD methods to routes, whose RequestMethod defines what will be done with form data. For example, utilizing a the POST method when visiting 
  "/api/books" will add a new book to the database. Then, if we visit "/api/books" (default GET request) we retrieve all the books in our database.
