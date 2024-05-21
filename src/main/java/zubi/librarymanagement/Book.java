package zubi.librarymanagement;

public class Book {

    //Alejandro Zubillaga , CEN-3024C-31950 05/16/2024
//This class will encapsulate the book information (ID, title, and author) and provide methods to access and modify the book data.

        private int id;
        private String title;
        private String author;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }


