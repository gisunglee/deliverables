package silverit.deliverables.common.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "COMPONENT_NO")
    private Component component; //컴포넌트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    private RequirementSpec requirementSpec; //요구사항명세

    @OneToMany(mappedBy = "program")
    private List<Function> functions = new ArrayList<>(); //기능

    @OneToMany(mappedBy = "program")
    private List<Source> sources = new ArrayList<>(); //소스

    //연관 관계 편의 메서드 (프로그램 <-> 컴포넌트)
    public void changeComponent(Component component){
        if (this.component != null) {
            this.component.getPrograms().remove(this);
        }
        this.component = component;
        component.getPrograms().add(this);
    }

    //연관 관계 편의 메서드 (프로그램 <-> 요구사항명세)
    public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getPrograms().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getPrograms().add(this);
    }

    //연관 관계 편이 메서드 (프로그램 <-> 기능)
    public void changeFunction(Function function){
        this.functions.add(function);
        function.setProgram(this);
    }

    //연관 관계 편이 메서드 (프로그램 <-> 소스)
    public void changeSource(Source source){
        this.sources.add(source);
        source.setProgram(this);
    }




}
