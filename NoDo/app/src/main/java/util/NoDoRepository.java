package util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import data.NoDoDao;
import data.NoDoRoomDatabase;
import model.NoDo;

public class NoDoRepository {
    private final NoDoDao noDoDao;
    private final LiveData<List<NoDo>> allNoDos;

    public NoDoRepository(Application application) {
        //Get data from a remote API and then put it on a diff. list
        NoDoRoomDatabase db = NoDoRoomDatabase.getDatabase(application);
        noDoDao = db.noDoDao();
        allNoDos =noDoDao.getAllNoDos();
    }

    public LiveData<List<NoDo>> getAllNoDos(){
        return allNoDos;
    }

    public void insert(NoDo noDo){
        new insertAsyncTask(noDoDao).execute(noDo);
    }

    private static class insertAsyncTask extends AsyncTask<NoDo, Void, Void> {
        private final NoDoDao asyncTaskDao;
        public insertAsyncTask(NoDoDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(NoDo... params) {
            //[obj1, obj2....]
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
