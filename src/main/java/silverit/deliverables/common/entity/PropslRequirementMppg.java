package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_PROPSL_REQUIREMENT_MPPG")
public class PropslRequirementMppg {

    @Id @GeneratedValue
    private Long propslReqRequirementNo; //제안 요청 요구사항 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROPSL_REQ_NO")
    @Setter
    private PropslRequest propslRequest; //제인요청

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    @Setter
    private RequirementSpec requirementSpec; //요구사항 명세

    //연관 관계 편의 메서드 (제안요청요구사항 <-> 제안요청)
    public void changePropslRequest(PropslRequest propslRequest){
        if(this.propslRequest != null){
            this.propslRequest.getPropslRequirementMppgs().remove(this);
        }

        this.propslRequest = propslRequest;
        propslRequest.getPropslRequirementMppgs().add(this);
    }

    //연관 관계 편의 메서드 (제안요청요구사항 <-> 요구사항명세세)
   public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getPropslRequirementMppgs().remove(this);
        }

        this.requirementSpec = requirementSpec;
       requirementSpec.getPropslRequirementMppgs().add(this);
    }


}
