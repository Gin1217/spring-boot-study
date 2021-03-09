package com.example.springbootbasic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FileSizeTest {

    @Resource
    private FileSize fileSize;

    @Test
    void getMaxSize() {
        String maxSize=fileSize.getMaxSize();
        log.info(maxSize);
        assertEquals("300MB", maxSize);
    }
}