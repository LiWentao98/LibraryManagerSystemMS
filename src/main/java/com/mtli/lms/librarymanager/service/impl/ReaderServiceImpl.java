package com.mtli.lms.librarymanager.service.impl;

import com.mtli.lms.librarymanager.mapper.ReaderMapper;
import com.mtli.lms.librarymanager.model.Reader;
import com.mtli.lms.librarymanager.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public void add(Reader reader) {
        readerMapper.insert(reader);
    }

    @Override
    public void delete(Reader reader) {
        readerMapper.delete(reader);
    }

    @Override
    public void update(Reader reader) {
        readerMapper.edit(reader);
    }

    @Override
    public List<Reader> select(Reader reader) {
        return readerMapper.selectReader(reader);
    }
}
