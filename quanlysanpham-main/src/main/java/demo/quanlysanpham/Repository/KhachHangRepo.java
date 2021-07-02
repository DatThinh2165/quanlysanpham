package demo.quanlysanpham.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.quanlysanpham.Model.KhachHang;

/**
 * @author dfean
 */
@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, String> {
}
