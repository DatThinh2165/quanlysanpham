package demo.quanlysanpham.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import demo.quanlysanpham.Model.HoaDon;
import demo.quanlysanpham.Repository.HoaDonRepo;

@Service
public class HoaDonServices {

    private HoaDonRepo hoaDonRepo;

    public HoaDonServices(HoaDonRepo hoaDonRepoo) { this.hoaDonRepo = hoaDonRepoo;
    }

    public List<HoaDon> getAll() {
        return hoaDonRepo.findAll();
    }

    public HoaDon find(String temp) {
        Optional<HoaDon> optional = hoaDonRepo.findById(temp);
        HoaDon hoaDon = null;
        if (optional.isPresent()) {
            hoaDon = optional.get();
        }
        return hoaDon;
    }
    public Optional<HoaDon> findByString(String mahd) {
        return hoaDonRepo.findById(mahd);
    }
    public HoaDon save(HoaDon hoaDon) {
        return hoaDonRepo.save(hoaDon);
    }

    public void delete(String temp) {
        hoaDonRepo.deleteById(temp);
    }
}
