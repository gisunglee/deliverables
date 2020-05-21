package silverit.deliverables.common.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_PROGRAM")
public class Program {

    @Id @GeneratedValue
    private Long pgmNo; //프로그램 번호
    private String pgmNm; //프로그램 명
    private String pgmAbbrNm; //프로그램 약어 명
    private String pgmId; //프로그램 id
    private String dfflyCd; //난이도 코드
    private String pgmDc; //프로그램 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODUL_NO")
    private Module module; //모듈

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    private RequirementSpec requirementSpec; //요구사항명세

    //연관 관계 편의 메서드 (프로그램 <-> 모듈)
    public void changeModule(Module module){
        if (this.module != null) {
            this.module.getPrograms().remove(this);
        }
        this.module = module;
        module.getPrograms().add(this);
    }

    //연관 관계 편의 메서드 (프로그램 <-> 요구사항명세)
    public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getPrograms().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getPrograms().add(this);
    }


}
