package fpoly.namdhph34455.duanmau.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "thuVien.db", null, 3);
    }

    String tb_thanhVien = "CREATE TABLE ThanhVien(MATV INTEGER PRIMARY KEY AUTOINCREMENT, HOTEN TEXT NOT NULL,NAMSINH TEXT NOT NULL)";
    String createTableThuThu = "CREATE TABLE ThuThu (maTT TEXT PRIMARY KEY,hoTen TEXT NOT NULL,matKhau TEXT NOT NULL)";

    String createTableTheLoai = "CREATE TABLE TheLoai(maLoai INTEGER PRIMARY KEY AUTOINCREMENT,tenLoai TEXT NOT NULL)";
    String createTableSach = "CREATE TABLE Sach (maSach INTEGER PRIMARY KEY AUTOINCREMENT,tenSach TEXT NOT NULL," +
            "giaSach INTEGER NOT NULL, maLoai INTEGER REFERENCES TheLoai(maLoai))";
    String createTablePhieuMuon = "CREATE TABLE PhieuMuon(" +
             "maPM INTEGER PRIMARY KEY AUTOINCREMENT," +
            "maTT TEXT REFERENCES ThuThu(maTT), " +
            "maTV INTEGER REFERENCES ThanhVien(maTV), " +
            "maSach INTEGER REFERENCES Sach(maSach), " +
            "tienThue INTEGER NOT NULL," +
            "ngay DATE NOT NULL," +
            "traSach INTEGER NOT NULL)";

    String insertintoThuThu = "INSERT INTO ThuThu(maTT,hoTen,matKhau) VALUES('nam01','admin','123abc')";
    String insertintoSach = "INSERT INTO Sach VALUES(1,'Ma Thái Lan',2500,1)";
    String insertintoLSach = "INSERT INTO TheLoai VALUES(1,'Kinh Dị')";
    String insertintoThanhVien = "INSERT INTO ThanhVien VALUES(1,'Đinh Hoài Nam',2004)";
    String insertintoPhieuMuon = "INSERT INTO PhieuMuon VALUES(1,1,1,1,3000,'30-04-2022',0)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tb_thanhVien);
        db.execSQL(createTableThuThu);
        db.execSQL(createTableTheLoai);
        db.execSQL(createTableSach);
        db.execSQL(createTablePhieuMuon);
        db.execSQL(insertintoThuThu);
        db.execSQL(insertintoSach);
        db.execSQL(insertintoLSach);
        db.execSQL(insertintoThanhVien);
        db.execSQL(insertintoPhieuMuon);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS ThuThu");
            db.execSQL("DROP TABLE IF EXISTS TheLoai");
            db.execSQL("DROP TABLE IF EXISTS Sach");
            db.execSQL("DROP TABLE IF EXISTS ThanhVien");
            db.execSQL("DROP TABLE IF EXISTS PhieuMuon");
            onCreate(db);
        }
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }
}
