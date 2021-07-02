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
@Table(name = "HOADON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAHD")
    @GenericGenerator(
            name = "MAHD",
            strategy = "demo.quanlysanpham.Model.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "KH"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
    @Column(name = "MAHD")
    private String maHd;
    @Column(name = "MAKH")
    private String maKh;
    @Column(name = "NGAYLAP")
    private Date ngayLap;
    @Column(name = "TONGTIEN")
    private Long tongTien;
}
