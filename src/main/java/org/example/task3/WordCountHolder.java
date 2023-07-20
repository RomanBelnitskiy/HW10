package org.example.task3;

public class WordCountHolder implements Comparable<WordCountHolder> {
    private final String word;
    private int count;

    public WordCountHolder(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public WordCountHolder(String word) {
        this(word, 1);
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(WordCountHolder o) {
        return Integer.compare(count, o.count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordCountHolder that = (WordCountHolder) o;

        return word.equals(that.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word + " " + count;
    }
}
