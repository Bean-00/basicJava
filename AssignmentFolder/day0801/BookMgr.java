package AssignmentFolder.day0801;

public class BookMgr {
    private Book[] booklist;

    public BookMgr(Book[] booklist) {
        this.booklist = booklist;
    }

    public void printBooklist() {
        for (Book book : this.booklist) {
            System.out.println(book.getTitle());
        }
    }

    public void printTotalPrice() {
        int sum = 0;
        for (Book book : this.booklist) {
            sum += book.getPrice();
        }
        System.out.println(sum);
    }
}