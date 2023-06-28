package com.example.booksellersystem.service.imp;

import com.example.booksellersystem.mapper.SuppliersMapper;
import com.example.booksellersystem.pojo.Suppliers;
import com.example.booksellersystem.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersServiceA implements SuppliersService {

    @Autowired
    private SuppliersMapper suppliersMapper;

    @Override
    public int SuppliersAdd(Suppliers add_Suppliers){
        if (suppliersMapper.count(add_Suppliers)>0){
            return 0;
        }
        else {
            suppliersMapper.add(add_Suppliers);
            return 1;
        }
    }

    @Override
    public List<Suppliers> SuppliersSearch(int page,int size) {

        return suppliersMapper.search((page - 1) * size,size);
    }

    @Override
    public int SuppliersChange(Suppliers supplier) {
        suppliersMapper.update(supplier);
        return 1;
    }

    @Override
    public int SuppliersDelete(List<String> ID) {
        ID.stream().forEach((id) ->
                suppliersMapper.delete(id)
        );

        return 1;
    }

    @Override
    public int SuppliersCount() {
        return suppliersMapper.countAll();
    }

}
