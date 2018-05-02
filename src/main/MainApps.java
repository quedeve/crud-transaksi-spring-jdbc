package main;

import config.Konfigurasi;
import dao.TransaksiDao;
import dao.TransaksiDetailDao;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import model.Transaksi;
import model.TransaksiDetail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApps {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.register(HelloWorldConfig.class);
        ctx.register(Konfigurasi.class);
        ctx.refresh();
        while (true) {
            int pilihan;

            System.out.println("1. Insert Data Transaksi ");
            System.out.println("2. Tampilkan Data Transaksi ");
            System.out.println("3. Update Data Transaksi ");
            System.out.println("4. Delete Data Transaksi ");
            System.out.println("5. Insert Data Transaksi Detil ");
            System.out.println("6. Tampilkan Data Transaksi Detil");
            System.out.println("7. Update Data Transaksi Detil");
            System.out.println("8. Delete Data Transaksi Detil");
            System.out.println("Masukkan Pilihan anda : ");
            Scanner input = new Scanner(System.in);
            pilihan = input.nextInt();

            Timestamp time = new Timestamp(System.currentTimeMillis());
            System.out.println(time);
            TransaksiDao transaksiDao = ctx.getBean(TransaksiDao.class);
            TransaksiDetailDao transaksiDetailDao = ctx.getBean(TransaksiDetailDao.class);
            List<Transaksi> listTransaksi = new LinkedList<>();
            List<TransaksiDetail> listTransaksiDetail = new LinkedList<>();

            Transaksi transaksi = new Transaksi();
            TransaksiDetail transaksiDetail = new TransaksiDetail();
            if (pilihan == 1) {
                transaksiDao.addTransaksi(time);
            }
            if (pilihan == 2) {
                System.out.println("1.Tampilkan Semua");
                System.out.println("2.Tampilkan By ID");
                pilihan = input.nextInt();
                if (pilihan == 1) {
                    listTransaksi = transaksiDao.findAll();
                    for (Transaksi transaksi1 : listTransaksi) {
                        System.out.println("ID : " + transaksi1.getId() + " Waktu : " + transaksi1.getWaktu());
                    }
                } else {
                    System.out.println("Masukkan ID");

                    transaksi = transaksiDao.findById(input.nextInt());
                    System.out.println("ID : " + transaksi.getId() + " Waktu : " + transaksi.getWaktu());
                }
            }
            if (pilihan == 3) {
                listTransaksi = transaksiDao.findAll();
                for (Transaksi transaksi1 : listTransaksi) {
                    System.out.println("ID : " + transaksi1.getId() + " Waktu : " + transaksi1.getWaktu());
                }
                System.out.println("Masukkan ID yang ingin di update : ");
                transaksi.setId(input.nextInt());
                transaksi.setWaktu(time);
                transaksiDao.updateTransaksi(transaksi);
            }
            if (pilihan == 4) {
                listTransaksi = transaksiDao.findAll();
                for (Transaksi transaksi1 : listTransaksi) {
                    System.out.println("ID : " + transaksi1.getId() + " Waktu : " + transaksi1.getWaktu());
                }
                System.out.println("Masukkan ID Transaksi yang ingin dihapus");
                transaksi.setId(input.nextInt());
                transaksiDao.deleteTransaksi(transaksi);
            }
            if (pilihan == 5) {
                System.out.println("Masukkan Data Transaksi Detail : ");
                listTransaksi = transaksiDao.findAll();
                for (Transaksi transaksi1 : listTransaksi) {
                    System.out.println("Pilihan ID : " + transaksi1.getId() + " Waktu : " + transaksi1.getWaktu());
                }
                System.out.println("Pilih Id Transaksi");
                transaksiDetail.setIdTransaksi(input.nextInt());
                System.out.println("Masukkan nama Item");
                transaksiDetail.setItem(input.next());
                System.out.println("Masukkan Jumlah item");
                transaksiDetail.setQty(input.nextInt());
                System.out.println("Masukkan Harga per Item");
                transaksiDetail.setPrice(input.nextBigDecimal());
                transaksiDetailDao.addTransaksiDao(transaksiDetail);
            }
            if (pilihan == 6) {
                System.out.println("1.Tampilkan Semua");
                System.out.println("2.Tampilkan By ID");
                pilihan = input.nextInt();
                if (pilihan == 1) {
                    listTransaksiDetail = transaksiDetailDao.findAll();
                    for (TransaksiDetail transaksiDetail1 : listTransaksiDetail) {
                        System.out.println("ID : " + transaksiDetail1.getId() + " ID Transaksi: " + transaksiDetail1.getIdTransaksi()
                                + " Item : " + transaksiDetail1.getItem() + " QTY : " + transaksiDetail1.getQty() + " Price : " + transaksiDetail1.getPrice());
                    }
                } else {
                    System.out.println("Masukkan ID");
                    transaksiDetail = transaksiDetailDao.findById(input.nextInt());
                    System.out.println("ID : " + transaksiDetail.getId() + " ID Transaksi: " + transaksiDetail.getIdTransaksi()
                            + " Item : " + transaksiDetail.getItem() + " QTY : " + transaksiDetail.getQty() + " Price : " + transaksiDetail.getPrice());
                }

            }
            if (pilihan == 7) {
                listTransaksiDetail = transaksiDetailDao.findAll();
                for (TransaksiDetail transaksiDetail1 : listTransaksiDetail) {
                    System.out.println("ID : " + transaksiDetail1.getId() + " ID Transaksi: " + transaksiDetail1.getIdTransaksi()
                            + " Item : " + transaksiDetail1.getItem() + " QTY : " + transaksiDetail1.getQty() + " Price : " + transaksiDetail1.getPrice());
                }
                System.out.println("Masukkan ID yang ingin di update : ");
                transaksiDetail.setId(input.nextInt());
                System.out.println("Masukkan Data Transaksi Detail : ");
                listTransaksi = transaksiDao.findAll();
                for (Transaksi transaksi1 : listTransaksi) {
                    System.out.println("Pilihan ID : " + transaksi1.getId() + " Waktu : " + transaksi1.getWaktu());
                }
                System.out.println("Pilih Id Transaksi");
                transaksiDetail.setIdTransaksi(input.nextInt());
                System.out.println("Masukkan nama Item");
                transaksiDetail.setItem(input.next());
                System.out.println("Masukkan Jumlah item");
                transaksiDetail.setQty(input.nextInt());
                System.out.println("Masukkan Harga per Item");
                transaksiDetail.setPrice(input.nextBigDecimal());
                transaksiDetailDao.updateTransaksi(transaksiDetail);

            }
            if (pilihan == 8) {
                listTransaksiDetail = transaksiDetailDao.findAll();
                for (TransaksiDetail transaksiDetail1 : listTransaksiDetail) {
                    System.out.println("ID : " + transaksiDetail1.getId() + " ID Transaksi: " + transaksiDetail1.getIdTransaksi()
                            + " Item : " + transaksiDetail1.getItem() + " QTY : " + transaksiDetail.getQty() + " Price : " + transaksiDetail1.getPrice());
                }
                System.out.println("Masukkan ID yang ingin dihapus : ");
                transaksiDetailDao.deleteTransaksi(input.nextInt());

            }
            System.out.println("Lagi?  (true/false)");
            Boolean lagi = input.nextBoolean();
            if (lagi == false) {
                break;
            }
        }
    }

}
