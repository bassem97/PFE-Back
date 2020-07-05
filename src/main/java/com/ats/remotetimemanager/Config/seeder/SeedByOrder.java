package com.ats.remotetimemanager.Config.seeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SeedByOrder {

    @Autowired
    UsersSeeder usersSeeder;
    @Autowired
    PostSeeder postSeeder;
    @Autowired
    ScheduleSeeder scheduleSeeder;

    public void init() throws Exception {
        scheduleSeeder.seed();
        postSeeder.seed();
        usersSeeder.seed();
    }
}
