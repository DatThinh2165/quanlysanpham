package demo.quanlysanpham.Repository;


import demo.quanlysanpham.Model.CTHD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTHDRepo extends JpaRepository<CTHD, String> {
}

