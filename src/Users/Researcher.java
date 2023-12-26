package Users;

import java.util.Comparator;

public interface Researcher {
    void conductResearch();

    int calculateHIndex();
    void printPapers(Comparator c);
    void shareResearchPaper(Researcher to);
}
