package android.analytics.dataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;

public interface Dao {

    @Insert
    void insert(Model model);

    @Query("select * from `table` order by name")
    LiveData<ArrayList<Model>> getList();

}
