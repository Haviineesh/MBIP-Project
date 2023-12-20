package com.ip.mbip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.mbip.model.Recycle;
import com.ip.mbip.repository.RecycleRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecycleService {

    @Autowired
    private RecycleRepo recycleRepo;

    public Iterable<Recycle> findAll(){
        return recycleRepo.findAll();
    }

    public void addRecycle(Recycle recycle){
        recycleRepo.save(recycle);
    }

    public void deleteById(long id){
        recycleRepo.deleteById(id);
    }

    public void updateRecycle(Recycle recycle){
        recycleRepo.save(recycle);
    }

    public Optional <Recycle> findById(long id){
        return recycleRepo.findById(id);
    }


    

}
