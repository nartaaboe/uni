package Users;

import Database.Data;
import Enums.Format;

import java.util.Date;
import java.util.HashSet;

public class ResearchPaper {
    private String name;
    private String citations;
    private HashSet<User> authors;
    private int pages;
    private Date date;
    public String getCitation(Format f){
        return citations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitations() {
        return citations;
    }

    public void setCitations(String citations) {
        this.citations = citations;
    }

    public HashSet<User> getAuthors() {
        return authors;
    }

    public void setAuthors(HashSet<User> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}