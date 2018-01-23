package main.java.subj;

public enum PublicationType {

    BOOK("Book"), ARTICLE("Article"), JOURNAL("Journal"), NEWSPAPER("Newspaper");

    private final String field;

    PublicationType(String type) {
        field = type;
    }

    @Override
    public String toString() {
        return field;
    }

}
