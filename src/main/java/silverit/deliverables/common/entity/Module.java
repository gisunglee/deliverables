package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "T_MODULE")
public class Module {

    @Id @GeneratedValue
    private Long modulNo; //모듈 번호
    private String modulNm; //모듈 명
    private String modulAbbrNm; //모듈 약어 명
    private String modulDc; //모듈 설명
    private String rmark; //비고

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    @Setter
    private RequirementSpec requirementSpec;

    @OneToMany(mappedBy = "module")
    private List<Program> programs = new ArrayList<>(); //프로그램

    //연관 관계 편의 메서드 (모듈 <-> 요구사항명세)
    public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getModules().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getModules().add(this);
    }

    /* ************************************************
        자기 참조 관계 설정
     ************************************************ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPPER_MODUL_NO")
    @Setter
    private Module superModule;

    //연관 관계 편의 메서드 (하위모듈 <-> 상위모듈)
    public void changeSuperModule(Module superModule){
        if(this.superModule != null){
            this.superModule.getSubModules().remove(this);
        }
        this.superModule = superModule;
        superModule.getSubModules().add(this);
    }

    @OneToMany(mappedBy = "superModule" )
    private List<Module> subModules = new ArrayList<>(); //모듈

    //연관 관계 편의 메서드 (상위모듈 <-> 하위모듈)
    public void changeSubMenu(Module subModule){
        this.subModules.add(subModule);
        subModule.setSuperModule(this);
    }



}
