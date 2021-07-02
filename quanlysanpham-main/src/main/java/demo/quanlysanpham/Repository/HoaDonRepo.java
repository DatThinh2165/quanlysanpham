package demo.quanlysanpham.Repository;

import demo.quanlysanpham.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, String> {
}
