package com.lanou.java.test2;

public class PaperFactory {

    private static Paper paper;

    public Paper getPaper() {
        return new Paper();
    }

    public static Paper getStaticPaper() {
        if (paper == null) {
            paper = new Paper();
        }
        return paper;
    }
}
