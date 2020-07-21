package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "T_COMPONENT")
public class Component {

    @Id @GeneratedValue
    private Long componentNo; //컴포넌트 번호
    private String componentNm; //컴포넌트 명
    private String componentAbbrNm; //컴포넌트 약어 명
    private String componentDc; //컴포넌트 설명
    private String rmark; //비고

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    @Setter
    private RequirementSpec requirementSpec;

    @OneToMany(mappedBy = "component")
    private List<Program> programs = new ArrayList<>(); //프로그램

    //연관 관계 편의 메서드 (컴포넌트 <-> 요구사항명세)
    public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getComponents().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getComponents().add(this);
    }

    /* ************************************************
        자기 참조 관계 설정
     ************************************************ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPPER_COMPONENT_NO")
    @Setter
    private Component superComponent;

    //연관 관계 편의 메서드 (하위컴포넌트 <-> 상위컴포넌트)
    public void changeSuperComponent(Component superComponent){
        if(this.superComponent != null){
            this.superComponent.getSubComponents().remove(this);
        }
        this.superComponent = superComponent;
        superComponent.getSubComponents().add(this);
    }

    @OneToMany(mappedBy = "superComponent" )
    private List<Component> subComponents = new ArrayList<>(); //컴포넌트

    //연관 관계 편의 메서드 (상위컴포넌트 <-> 하위컴포넌트)
    public void changeSubMenu(Component subComponent){
        this.subComponents.add(subComponent);
        subComponent.setSuperComponent(this);
    }



}
