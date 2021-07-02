package demo.quanlysanpham.utils;

import demo.quanlysanpham.Model.SanPham;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SanPhamUtils {
    public static String SAN_PHAM = "sanpham";
    public static String HOA_DON = "hoadon";
    public static String KHACH_HANG = "khachhang";
    public static String REDIRECT = "redirect:/";
    public static String SUCCESS = "sucesss";
    public static String Manager = "quanly";


    public static void WriteFile(HttpServletResponse response, List<SanPham> list) throws IOException {

        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;filename=myFile.txt");
        ServletOutputStream out = response.getOutputStream();
        out.println(String.valueOf(list));
        out.flush();
        out.close();
    }
}
