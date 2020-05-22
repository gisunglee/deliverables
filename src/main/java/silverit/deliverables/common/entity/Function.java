package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_FUNCTION")
public class Function {

    @Id @GeneratedValue
    private Long fnNo; //기능 번호
    private String fnNm; //기능 명
    private String fnAbbrNm; //기능 약어 명
    private String fnId; //기능 id
    private String dfflyCd; //난이도 코드
    private String fnDc; //기능 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    @Setter
    private RequirementSpec requirementSpec; //요구사항 명세

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PGM_NO")
    @Setter
    private Program program; //프로그램

    //연관 관계 편의 메서드 (기능 <-> 요구사항명세)
    public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getFunctions().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getFunctions().add(this);
    }

    //연관 관계 편의 메서드 (기능 <-> 프로그램)
    public void changeProgram(Program program){
        if(this.program != null){
            this.program.getFunctions().remove(this);
        }
        this.program = program;
        program.getFunctions().add(this);
    }


}
