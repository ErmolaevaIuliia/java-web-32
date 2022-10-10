package entity;

public class Subject {

    private int id;
    private String subject;

    public Subject() {
    }

    public Subject(int id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject1 = (Subject) o;

        if (id != subject1.id) return false;
        return subject.equals(subject1.subject);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + subject.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                '}';
    }
}
