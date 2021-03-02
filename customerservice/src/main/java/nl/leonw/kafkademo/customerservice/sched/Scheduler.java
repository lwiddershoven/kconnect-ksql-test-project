package nl.leonw.kafkademo.customerservice.sched;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Scheduler {

    @Scheduled(fixedRate = 1000L)
    @SchedulerLock(name = "TaskScheduler_scheduledTask")
    void bla() {
        log.info("Doing scheduled task");
    }


}
