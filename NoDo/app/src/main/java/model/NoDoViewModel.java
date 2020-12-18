package model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import util.NoDoRepository;

public class NoDoViewModel extends AndroidViewModel {
    private final NoDoRepository noDoRepository;
    private final LiveData<List<NoDo>> allNoDos;

    public NoDoViewModel(@NonNull Application application) {
        super(application);
        noDoRepository = new NoDoRepository(application);
        allNoDos = noDoRepository.getAllNoDos();

    }

    public LiveData<List<NoDo>> getAllNoDos(){
        return allNoDos;
    }

    public void insert(NoDo noDo){
        noDoRepository.insert(noDo);
    }
}
