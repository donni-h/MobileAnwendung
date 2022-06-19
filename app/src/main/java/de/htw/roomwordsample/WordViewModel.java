package de.htw.roomwordsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private final LiveData<List<Package>> mAllWords;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Package>> getAllWords() { return mAllWords; }

    public void insert(Package aPackage) { mRepository.insert(aPackage); }
    public void deleteAll(){ mRepository.deleteAll();}
    public void delete(Package aPackage){ mRepository.delete(aPackage);}
}
