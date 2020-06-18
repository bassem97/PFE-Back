package com.ats.remotetimemanager.Config.seeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SeedByOrder {
    @Autowired
    RoleSeeder roleSeeder;
    @Autowired
    UsersSeeder usersSeeder;
    @Autowired
    PostSeeder postSeeder;
    @Autowired
    ScheduleSeeder scheduleSeeder;

    public void init() throws Exception {
        scheduleSeeder.seed();
        roleSeeder.seed();
        postSeeder.seed();
        usersSeeder.seed();
    }
}
