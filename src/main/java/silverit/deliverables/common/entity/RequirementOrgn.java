package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_REQUIREMENT_ORGN")
public class RequirementOrgn {

    @Id @GeneratedValue
    private Long requirementOrgnNo; //요구사항 출처 번호
    private String orgnSeCd; //출처 구분 코드
    private String orgnText; //출처내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    @Setter
    private RequirementSpec requirementSpec; //요구사항명세

    //연관 관계 편의 메서드 (요구사항출처 <-> 요구사항명세)
    private void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getRequirementOrgns().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getRequirementOrgns().add(this);
    }

}
