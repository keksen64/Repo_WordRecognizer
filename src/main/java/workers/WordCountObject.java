package workers;

import java.util.Objects;


//объект для хранения связки слов и кол-ва совпадений по ним
public class WordCountObject {
    private String word;
    private Integer count;

    public WordCountObject(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WordCountObject{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCountObject that = (WordCountObject) o;
        return Objects.equals(word, that.word) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }
}
