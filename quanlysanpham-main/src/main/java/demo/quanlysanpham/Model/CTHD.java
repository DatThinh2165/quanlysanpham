package demo.quanlysanpham.Model;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name = "CHITIETHOADON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CTHD implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MA_CTHD")
    @GenericGenerator(
            name = "MA_CTHD",
            strategy = "demo.quanlysanpham.Model.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "KH"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
    @Column(name = "MA_CTHD")
    private String maCthd;
    @Column(name = "MAHD")
    private String maHd;
    @Column(name = "MASP")
    private String maSp;
    @Column(name = "MACK")
    private String maCk;
    @Column(name = "SOLUONG")
    private Integer soLuong;
    @Column(name = "THANHTIEN")
    private Long thanhTien;
}
