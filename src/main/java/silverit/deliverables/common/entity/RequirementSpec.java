package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import silverit.deliverables.common.form.RequirementSpecForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "T_REQUIREMENT_SPEC")
/**
 * 요구사항 명세
 */
public class RequirementSpec {

    @Id @GeneratedValue
    private Long requirementNo; //요구사항 번호
    private String requirementClasCd; //요구사항 분류 코드
    @Column(length = 1000)
    private String requirementDefi; //요구사항 정의
    @Column(length = 2000)
    private String requirementText; //요구사항 내용
    private String requirementId; //요구사항 id
    private String priorRankNo; //우선 순위 번호
    private String dfflyCd; //난이도 코드
    @Column(length = 2000)
    private String rstcMaterText; //제약 사항 내용
    @Column(length = 2000)
    private String inspStdrText; //검사 기준 내용
    private String fnctSeCd; //기능 구분 코드
    @Column(length = 1000)
    private String requirementNm; //요구사항 명칭
    private String aceptncYn; //수용 여부
    private String chrgEmpId; //담당 사원 id
    @Column(length = 1000)
    private String entyPathText; //진입 경로 내용
    private String specProgStatCd; //명세 진행 상태 코드
    private String apvlReqDtt; //승인 요청 일시
    private String apvlpsId; //승인자 ID
    private String apvlDtt; //승인 일시
    private String noteCn;//노트 내용

    private String componentNo;

    //파리미터 값 셋팅
    public void copyFromParam(RequirementSpecForm requirementSpecForm){
        BeanUtils.copyProperties(requirementSpecForm, this);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJ_NO")
    @Setter
    private Project project; // 프로젝트

    @OneToMany(mappedBy = "requirementSpec", cascade = CascadeType.ALL)
    private List<PropslRequirementMppg> propslRequirementMppgs = new ArrayList<>(); //제안요청요구사항매핑

    @OneToMany(mappedBy = "requirementSpec")
    private List<Menu> menus = new ArrayList<>(); //메뉴

    @OneToMany(mappedBy = "requirementSpec")
    private List<Component> components = new ArrayList<>(); //컴포넌트

    @OneToMany(mappedBy = "requirementSpec")
    private List<Program> programs = new ArrayList<>(); //프로그램

    @OneToMany(mappedBy = "requirementSpec")
    private List<Function> functions = new ArrayList<>(); //기능

    @OneToMany(mappedBy = "requirementSpec")
    private List<RequirementOrgn> requirementOrgns = new ArrayList<>(); //요구사항출처

    //연관관계 편의 메서드 (요구사항명세 <-> 프로젝트)
    public void changeProject(Project project) {
        if(this.project != null) {
            this.project.getRequirementSpecs().remove(this);
        }
        this.project = project;
        project.getRequirementSpecs().add(this);
    }

    //연관 관계 편의 메서드 (요구사항명세 <-> 제안요청요구사항매핑)
    public void changePropslRequirementMppg(PropslRequirementMppg propslRequirementMppg){
        this.propslRequirementMppgs.add(propslRequirementMppg);
        propslRequirementMppg.setRequirementSpec(this);
    }

    //연관 관계 편의 메서드 (요구사항명세 <-> 메뉴)
    public void changeMenu(Menu menu){
        this.getMenus().add(menu);
        menu.setRequirementSpec(this);
    }

    //연관 관계 편이 메서드 (요구사항명세 <-> 기능)
    public void changeFunction(Function function){
        this.functions.add(function);
        function.setRequirementSpec(this);
    }

    //연관 관계 편이 메서드 (요구사항명세 <-> 요구사항출처)
    public void changeRequirementOrgns(RequirementOrgn requirementOrgn){
        this.requirementOrgns.add(requirementOrgn);
        requirementOrgn.setRequirementSpec(this);
    }



}
