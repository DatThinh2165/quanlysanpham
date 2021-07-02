package demo.quanlysanpham.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import demo.quanlysanpham.Model.SanPham;
import demo.quanlysanpham.Services.SanPhamServices;
import demo.quanlysanpham.utils.SanPhamUtils;

/**
 * @author dfean
 */
@Controller
public class HomeController {

    private SanPhamServices sanPhamServices;

    public HomeController(SanPhamServices sanPhamServices) {
        this.sanPhamServices = sanPhamServices;
    }

    @GetMapping(value = "/ViewSP")
    public String view(Model model) {
        List<SanPham> list = sanPhamServices.getAll();
        model.addAttribute(SanPhamUtils.SAN_PHAM, list);
        return "View";
    }


    @GetMapping(value = "/addSP")
    public String whos(Model model) {
        SanPham sanPham = new SanPham();
        model.addAttribute(SanPhamUtils.SAN_PHAM, sanPham);
        return "addSP";
    }

    @PostMapping(value = "/addSP")
    public String savesp(@ModelAttribute("sanpham") SanPham sanPham, RedirectAttributes redirectAttributes) {
        if (sanPham.getTenSp() == null || sanPham.getQuyCach() == 0 || sanPham.getGiaGoc() == 0) {
            redirectAttributes.addFlashAttribute("error", "Thêm sản phẩm thất bại!");
            return SanPhamUtils.REDIRECT + "addSP";
        } else {
            sanPhamServices.save(sanPham);
            redirectAttributes.addFlashAttribute(SanPhamUtils.SUCCESS, "Thêm sản phẩm thành công!");
            return SanPhamUtils.REDIRECT + SanPhamUtils.Manager;
        }
    }

    @GetMapping("/delete")
    public String del(@RequestParam("masp") String masp, RedirectAttributes redirectAttributes) {
        sanPhamServices.delete(masp);
        redirectAttributes.addFlashAttribute(SanPhamUtils.SUCCESS, "Xóa " + masp + " thành công!");
        return SanPhamUtils.REDIRECT + SanPhamUtils.Manager;
    }

    @GetMapping("/update/{masp}")
    public String edit(@PathVariable(value = "masp") String masp, Model model) {
        SanPham sanPham = sanPhamServices.find(masp);
        model.addAttribute(SanPhamUtils.SAN_PHAM, sanPham);
        return "editSP";
    }

    @PostMapping(value = "/UpdateSP")
    public String updatesp(@ModelAttribute("sanpham") SanPham sanPham, RedirectAttributes redirectAttributes) {
        if (sanPham.getTenSp() == null || sanPham.getQuyCach() == 0 || sanPham.getGiaGoc() == 0) {
            redirectAttributes.addFlashAttribute("error", "Update sản phẩm thất bại!");
            return SanPhamUtils.REDIRECT + "editSP";
        } else {
            sanPhamServices.save(sanPham);
            redirectAttributes.addFlashAttribute(SanPhamUtils.SUCCESS, "Update sản phẩm thành công!");
            return SanPhamUtils.REDIRECT + SanPhamUtils.Manager;
        }
    }

    @GetMapping(value = "/search")
    public String search(Model model) {
        SanPham sanPham = new SanPham();
        model.addAttribute(SanPhamUtils.SAN_PHAM, sanPham);
        return "search";
    }

    @PostMapping("/search")
    public String searchsp(@RequestParam("maSp") String masp, Model model, RedirectAttributes redirectAttributes) {
        if (sanPhamServices.find(masp) == null || masp == null) {
            redirectAttributes.addFlashAttribute("error", masp + " không tồn tại");
            return SanPhamUtils.REDIRECT + "search";
        }

        model.addAttribute(SanPhamUtils.SAN_PHAM, sanPhamServices.find(masp));
        return "search";
    }
}
