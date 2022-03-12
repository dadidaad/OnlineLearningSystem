/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bean.CounterBean;
import dao.CounterViewDAO;
import dao.ICounterViewDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class CountViewPageListener implements ServletContextListener {

    ServletContext ctx;
    int countPerDay;
    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ctx = sce.getServletContext();
        ctx.setAttribute("pcount", countPerDay);

        scheduler = Executors.newSingleThreadScheduledExecutor();

        // It will be executed every 1 hour
        scheduler.scheduleAtFixedRate(new DailyHitsRunnable(), 0, 1, TimeUnit.MINUTES);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        scheduler.shutdownNow();
    }

    public class DailyHitsRunnable implements Runnable {

        public DailyHitsRunnable() {
        }

        @Override
        public void run() {
            try {
                countPerDay = (Integer) ctx.getAttribute("pcount");
                CounterBean x = new CounterBean();
                x.setCounter(countPerDay);
                LocalDate localDate = LocalDate.now();
                Date date = Date.valueOf(localDate);
                x.setDate(date);
                ICounterViewDAO db = new CounterViewDAO();
                db.insertNewRecord(x);
                ctx.setAttribute("pcount", 0);
            } catch (Throwable t) {
                Logger.getLogger(CountViewPageListener.class.getName()).log(Level.SEVERE, null, t);
            }
        }
    }
}
