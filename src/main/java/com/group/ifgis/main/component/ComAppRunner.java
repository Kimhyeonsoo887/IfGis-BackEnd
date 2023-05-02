package com.group.ifgis.main.component;

import com.group.ifgis.main.model.CodeDTO;
import com.group.ifgis.main.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ComAppRunner implements ApplicationRunner {

    public static List<CodeDTO> codes;

    private final CodeRepository codeRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        codes = codeRepository.findAll();
    }
}
