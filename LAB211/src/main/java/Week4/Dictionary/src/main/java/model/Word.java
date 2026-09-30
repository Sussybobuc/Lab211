package model;

public class Word {
    private String engWord;
    private String vietWord;

    public Word(String engWord, String vietWord) {
        this.engWord = engWord;
        this.vietWord = vietWord;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getVietWord() {
        return vietWord;
    }

    public void setVietWord(String vietWord) {
        this.vietWord = vietWord;
    }

    @Override
    public String toString() {
        return engWord + ':' + vietWord;
    }
}
