package main.java.subj;

public class Publication {

    private PublicationType type;
    private String title;

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = PublicationType.valueOf(type.toUpperCase());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(type.toString());
        sb.append(" \"");
        sb.append(title);
        sb.append('\"');
        return sb.toString();
    }

}
