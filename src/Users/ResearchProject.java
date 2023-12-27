package Users;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ResearchProject {
    private List<ResearchPaper> researchPapers;
    private HashSet<Researcher> members;
    private Supervisor supervisor;

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public void setResearchPapers(List<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    public HashSet<Researcher> getMembers() {
        return members;
    }

    public void setMembers(HashSet<Researcher> members) {
        this.members = members;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
