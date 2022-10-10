package entity;

public class Mark {

    private int id;
    private Student student;
    private Term term;
    private Subject subject;
    private int mark;

    public Mark() {
    }

    public Mark(int id, Student student, Term term, Subject subject, int mark) {
        this.id = id;
        this.student = student;
        this.term = term;
        this.subject = subject;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (id != mark1.id) return false;
        if (mark != mark1.mark) return false;
        if (!student.equals(mark1.student)) return false;
        if (!term.equals(mark1.term)) return false;
        return subject.equals(mark1.subject);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + student.hashCode();
        result = 31 * result + term.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + mark;
        return result;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", student=" + student +
                ", term=" + term +
                ", subject=" + subject +
                ", mark=" + mark +
                '}';
    }
}
