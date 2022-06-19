package de.htw.roomwordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PackageDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Package aPackage);

    @Query("DELETE FROM package_table")
    void deleteAll();

    @Delete
    void delete(Package aPackage);

    @Query("SELECT * FROM package_table ORDER BY trackingNumber ASC")
    LiveData<List<Package>> getAlphabetizedWords();
}
