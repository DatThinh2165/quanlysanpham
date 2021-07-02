package demo.quanlysanpham.Services;

import java.util.List;
import java.util.Optional;

import demo.quanlysanpham.Model.HoaDon;
import org.springframework.stereotype.Service;

import demo.quanlysanpham.Model.CTHD;
import demo.quanlysanpham.Repository.CTHDRepo;

@Service
public class CTHDServices {
    private CTHDRepo cthdRepo;

    public CTHDServices(CTHDRepo cthdRepoo) { this.cthdRepo = cthdRepoo;
    }

    public CTHD find(String temp) {
        Optional<CTHD> optional = cthdRepo.findById(temp);
        CTHD cthd = null;
        if (optional.isPresent()) {
            cthd = optional.get();
        }
        return cthd;
    }
    public Optional<CTHD> findByString(String macthd) { return cthdRepo.findById(macthd);
    }
    public CTHD save(CTHD cthd) {
        return cthdRepo.save(cthd);
    }

    public void delete(String temp) {
        cthdRepo.deleteById(temp);
    }
}

