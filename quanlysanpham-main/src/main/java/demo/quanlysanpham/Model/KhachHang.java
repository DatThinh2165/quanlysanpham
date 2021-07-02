package demo.quanlysanpham.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dfean
 */
@Entity
@Table(name = "khachhang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAKH")
    @GenericGenerator(
            name = "MAKH",
            strategy = "demo.quanlysanpham.Model.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "KH"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
    @Column(name = "MAKH")
    private String maKh;
    @Column(name = "TENKH")
    private String tenKh;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "PASS")
    private String passWord;
    @Column(name = "SOTAIKHOAN")
    private String soTK;
    @Column(name = "SODUTK")
    private Long soDuTK;

}
