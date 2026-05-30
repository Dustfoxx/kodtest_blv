package kodtest.Countries;

public class VisitorNotFoundException extends RuntimeException{
    VisitorNotFoundException(Long id) {
        super("Could not find visitor " + id);
    }
}
