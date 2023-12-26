package Users;

import java.util.Comparator;


/**
 * This interface represents a researcher within the university, who is an employee responsible for conducting research.
 */
public interface Researcher {

    /**
     * Conducts research.
     */
    void conductResearch();

    /**
     * Calculates the H-index of the researcher.
     *
     * @return The H-index of the researcher.
     */
    int calculateHIndex();

    /**
     * Prints the researcher's papers, sorted by the specified comparator.
     *
     * @param c The comparator to use for sorting.
     */
    void printPapers(Comparator c);

    /**
     * Shares a research paper with the specified researcher.
     *
     * @param to The researcher to share the paper with.
     */
    void shareResearchPaper(Researcher to);
}
