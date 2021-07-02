package demo.quanlysanpham.Controller;

import java.util.List;
import java.util.Random;

import demo.quanlysanpham.Model.KhachHang;
import demo.quanlysanpham.Services.KhachHangServices;
import demo.quanlysanpham.utils.SanPhamUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import demo.quanlysanpham.Model.HoaDon;
import demo.quanlysanpham.Services.HoaDonServices;

@Controller
public class HoaDonController {
    private static String Search = "searchkh";
    private static String addKh = "addKH";
    private static String Error = "error";
    private HoaDonServices hoaDonServices;

    public HoaDonController(HoaDonServices hoaDonServices) {
        this.hoaDonServices = hoaDonServices;
    }

    @GetMapping("/ViewHD")
    public String viewHd(Model model) {
        List<HoaDon> list = hoaDonServices.getAll();
        model.addAttribute(SanPhamUtils.HOA_DON, list);
        return "ViewHD";
    }

    @GetMapping("/AddHD")
    public String addHd(Model model) {
        model.addAttribute(SanPhamUtils.HOA_DON, new HoaDon());
        return "AddHD";
    }

    @PostMapping("/AddHD")
    public String saveHD(@ModelAttribute("hoadon") HoaDon hoaDon, RedirectAttributes redirectAttributes) {
        if (hoaDon.getMaHd() == null || hoaDon.getMaKh() == null || hoaDon.getNgayLap() == null || hoaDon.getTongTien() == null) {
            redirectAttributes.addFlashAttribute(Error, "Thêm hoa don thất bại");
            return SanPhamUtils.REDIRECT + "AddHD";
        } else {

            hoaDonServices.save(hoaDon);
            redirectAttributes.addFlashAttribute(SanPhamUtils.SUCCESS, "Thêm hoa don thành Công");
            return SanPhamUtils.REDIRECT + SanPhamUtils.Manager;
        }
    }

    @PostMapping("/EditHD")
    public String edit(@ModelAttribute("hoadon") HoaDon hoaDon, RedirectAttributes redirectAttributes) {
        if (hoaDon.getMaHd() == null || hoaDon.getMaKh() == null || hoaDon.getNgayLap() == null || hoaDon.getTongTien() == null) {
            redirectAttributes.addFlashAttribute(Error, "Update hoa don thất bại");
            return SanPhamUtils.REDIRECT + "editHD";
        } else {
            hoaDonServices.save(hoaDon);
            redirectAttributes.addFlashAttribute(SanPhamUtils.SUCCESS, "Edit hoa don " + hoaDon.getMaHd() + " thành Công");
            return SanPhamUtils.REDIRECT + SanPhamUtils.Manager;
        }

    }

    @RequestMapping("/deleteHD")
    public String del(@RequestParam("mahd") String hoadon, RedirectAttributes redirectAttributes) {
        hoaDonServices.delete(hoadon);
        redirectAttributes.addFlashAttribute(SanPhamUtils.SUCCESS, "Xóa hoa don " + hoadon + " thành Công");
        return SanPhamUtils.REDIRECT + SanPhamUtils.Manager;
    }

    @GetMapping("/UpdateHD/{maHd}")
    public String update(@PathVariable("maHd") String mahd, Model model) {
        HoaDon hoaDon = hoaDonServices.find(mahd);
        model.addAttribute(SanPhamUtils.HOA_DON, hoaDon);
        return "UpdateHD";
    }


}
