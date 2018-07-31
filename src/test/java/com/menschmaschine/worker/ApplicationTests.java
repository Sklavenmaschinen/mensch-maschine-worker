package com.menschmaschine.worker;

import com.menschmaschine.worker.configuration.bus.EventBus;
import com.menschmaschine.worker.repository.TasksRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("it")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private TasksRepository tasksRepository;

    @Test
    public void contextLoads() {
        tasksRepository.findAll();
        eventBus.post("Teste");
    }

}
