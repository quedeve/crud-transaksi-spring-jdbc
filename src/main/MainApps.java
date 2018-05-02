package main;

import config.Konfigurasi;
import dao.TransaksiDao;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import model.Transaksi;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApps {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.register(HelloWorldConfig.class);
        ctx.register(Konfigurasi.class);
        ctx.refresh();

        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(time);
        TransaksiDao transaksiDao = new TransaksiDao();
        transaksiDao.findAll();
//        transaksiDao.addTransaksi(time);
    }

}
