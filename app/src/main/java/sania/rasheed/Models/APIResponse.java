package sania.rasheed.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.List;


@Entity
public class APIResponse {

    @ColumnInfo(name = "word")
    String word = "";

    @ColumnInfo(name = "phonetics")
    List<Phonetics> phonetics = null;

    @ColumnInfo(name = "meanings")
    List<Meanings> meanings = null;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }
}
