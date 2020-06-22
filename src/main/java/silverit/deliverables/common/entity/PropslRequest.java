package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "T_PROPSL_REQUEST")
/**
 * 제안 요청
 */
public class PropslRequest {

    @Id @GeneratedValue
    private Long propslReqNo; //제안 요청 번호
    private String propslReqNm; //제안 요청 명
    private String propslReqClasText; //제안 요청 분류 내용
    private String propslReqDefiText; //제안 요청 정의 내용
    @Column(length = 2000)
    private String propslReqText; //제안 요청 내용
    private String propslReqId; //제안요청 Id
    private String relPrdcWtrText; //관련 산출물 내용
    private String suplmtDemndMaterYn; //추가 요구사항 여부


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJ_NO")
    @Setter
    private Project project;

    @OneToMany(mappedBy = "propslRequest")
    private List<PropslRequirementMppg> propslRequirementMppgs = new ArrayList<>(); //제안요청요구사항매핑


   //연관관계 편의 메서드 (제안 요청 <-> 프로젝트)
    public void changeProject(Project project) {
        if(this.project != null) {
            this.project.getPropslRequests().remove(this);
        }
        this.project = project;
        project.getPropslRequests().add(this);
    }

    //연관 관계 편의 메서드 (제안요청 <-> 제안요청요구사항매핑)
    public void changePropslRequirementMppg(PropslRequirementMppg propslRequirementMppg){
        this.propslRequirementMppgs.add(propslRequirementMppg);
        propslRequirementMppg.setPropslRequest(this);
    }


}
