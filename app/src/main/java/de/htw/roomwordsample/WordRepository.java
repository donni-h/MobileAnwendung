package de.htw.roomwordsample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class WordRepository {

    private PackageDAO mPackageDAO;
    private LiveData<List<Package>> mAllWords;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mPackageDAO = db.wordDao();
        mAllWords = mPackageDAO.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Package>> getAllWords() {
        return mAllWords;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Package aPackage) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPackageDAO.insert(aPackage);
        });
    }
    void deleteAll(){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPackageDAO.deleteAll();
        });
    }
    void delete(Package aPackage){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPackageDAO.delete(aPackage);
        });
    }
}
