package Enums;

public enum Language {
    KZ("Қазақша"),
    EN("English"),
    RU("Русский");

    private final String text;

    Language(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}