package Contents;

import java.util.Date;

/**
 * Represents an event with a title, start date, and finish date.
 */
public class Event {
    // Fields
    private String title;
    private Date startDate;
    private Date finishDate;

    /**
     * Constructs an Event with the specified title, start date, and finish date.
     *
     * @param title      the title of the event
     * @param startDate  the start date of the event
     * @param finishDate the finish date of the event
     */
    public Event(String title, Date startDate, Date finishDate) {
        this.title = title;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    /**
     * Checks if the event has finished.
     *
     * @return true if the current date is after the finish date, false otherwise
     */
    public boolean isFinished() {
        Date currentDate = new Date();
        return currentDate.after(finishDate);
    }

    /**
     * Displays details of the event, including title, start date, finish date, and whether the event has finished.
     */
    public void viewEvent() {
        System.out.println("Title: " + title);
        System.out.println("Start Date: " + startDate);
        System.out.println("Finish Date: " + finishDate);
        System.out.println("Is Finished: " + isFinished());
    }

    // Getters and setters (optional, depending on your requirements)

    /**
     * Gets the title of the event.
     *
     * @return the title of the event
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the event.
     *
     * @param title the new title of the event
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the start date of the event.
     *
     * @return the start date of the event
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the event.
     *
     * @param startDate the new start date of the event
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the finish date of the event.
     *
     * @return the finish date of the event
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * Sets the finish date of the event.
     *
     * @param finishDate the new finish date of the event
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}

