package com.softwareeni.sftw.service.time;
import com.softwareeni.sftw.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class time {


    @Scheduled(cron = "0 00 00 * * *")

    private void ScheduledTask() {
        String tableName = new SimpleDateFormat("yyyyMMdd").format(new Date());

        String query = String.format("""
            CREATE TABLE IF NOT EXISTS "%s" (
                id SERIAL PRIMARY KEY,
                prurl TEXT NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                prtrendyolurl TEXT NOT NULL,
                trendyolid TEXT NOT NULL
            );
        """, tableName);
try {
    Query q = new Query();
   ResultSet rs = q.sorgu(query);
   System.out.println("kodumun çalışıyor");
}catch (Exception e){
    System.out.println(e);
}
    }



}
