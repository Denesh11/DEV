package data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import model.NoDo;

@Database(entities = {NoDo.class}, version = 1)
public abstract class NoDoRoomDatabase extends RoomDatabase {

    public static volatile NoDoRoomDatabase INSTANCE;
    public abstract NoDoDao noDoDao();

    public static NoDoRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (NoDoRoomDatabase.class){
                if (INSTANCE == null){
                    //create our db
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoDoRoomDatabase.class,"nodo_database")
                            .addCallback(roomDatabaseCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback roomDatabaseCallBack =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };
    private static class PopulateDbAsync extends AsyncTask<Void, Void ,Void> {
        private final NoDoDao noDoDao;

        public PopulateDbAsync(NoDoRoomDatabase db){
            noDoDao = db.noDoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noDoDao.deleteAll();//removes all items from our table
           // For testing
            NoDo noDo = new NoDo("Buy a new Ferrari");
            noDoDao.insert(noDo);

            noDo = new NoDo("Buy a Big house");
            noDoDao.insert(noDo);
//
            return null;
        }
    }

}
