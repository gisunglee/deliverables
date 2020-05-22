package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_SOURCE")
public class Source {

    @Id @GeneratedValue
    private Long srcNo; //소스 번호
    private String srcTyCd; //소스 타입 코드
    private String srcFileNm; //소스 파일 명
    private String srcDc; //소스 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PGM_NO")
    @Setter
    private Program program; //프로그램


}
