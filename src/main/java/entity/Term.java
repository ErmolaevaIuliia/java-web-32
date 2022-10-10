package entity;

import java.util.ArrayList;
import java.util.List;

public class Term {

    private int id;
    private String term;
    private String duration;
    private List <Subject> subjects = new ArrayList<>();

    public Term() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term1 = (Term) o;

        if (id != term1.id) return false;
        if (!term.equals(term1.term)) return false;
        if (!duration.equals(term1.duration)) return false;
        return subjects.equals(term1.subjects);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + term.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + subjects.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
