package com.ingesis.cursoJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesis.cursoJpa.TimeTracker;
import com.ingesis.cursoJpa.entity.CsvFile;
import com.ingesis.cursoJpa.logic.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadToDBService {
    private final FileReader fileReader;
    private final CsvFileService csvFileDao;
    private final TimeTracker timeTracker;

    @Autowired
    public FileUploadToDBService(FileReader fileReader,
                                 CsvFileService csvFileDao,
                                 TimeTracker timeTracker) {
        this.fileReader = fileReader;
        this.csvFileDao = csvFileDao;
        this.timeTracker = timeTracker;
    }

    public void uploadToDB() throws IOException {
        List<String> lines = fileReader.readAllLines();
        csvFileDao.insert(convertToJpaCsvFile(lines));
    }

    private List<CsvFile> convertToJpaCsvFile(List<String> lines) {
        timeTracker.start("ConvertToJPA");
        ArrayList<CsvFile> csvFileList = new ArrayList<>(lines.size());
        String processId = UUID.randomUUID().toString();
        for (String line : lines) {
            CsvFile csvFile = new CsvFile();
            csvFile.setProcessUuid(processId);
            csvFile.setLineText(line);
            csvFileList.add(csvFile);
        }
        timeTracker.stop("ConvertToJPA");
        return csvFileList;
    }
}
