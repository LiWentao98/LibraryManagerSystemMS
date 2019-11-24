package com.mtli.lms.librarymanager.service.impl;

import com.mtli.lms.librarymanager.mapper.ReaderTypeMapper;
import com.mtli.lms.librarymanager.model.ReaderType;
import com.mtli.lms.librarymanager.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderTypeServiceImpl implements ReaderTypeService {
    @Autowired
    private ReaderTypeMapper readerTypeMapper;

    @Override
    public ReaderType searchMessage(Integer rType) {
        return readerTypeMapper.selectReaderTypeMessage(rType);
    }
}
