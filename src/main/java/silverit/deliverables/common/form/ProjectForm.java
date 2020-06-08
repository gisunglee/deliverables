package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "T_PROJECT")
/**
 * 프로젝트
 */
public class Project {

    @Id @GeneratedValue
    private Long prjNo; //프로젝트 번호
    private String prjNm; //프로젝트 명
    private String prjBeginDe; //프로젝트 시작일자
    private String prjEndDe; //프로젝트 종료일자
    private String prjEngCdNm; //프로젝트 영문 코드 명

    //단계
    @OneToMany(mappedBy = "project")
    private List<Step> steps = new ArrayList<>(); //단계 = T_STEP

    //제안 요청
    @OneToMany(mappedBy = "project")
    private List<PropslRequest> propslRequests = new ArrayList<>(); //제안 요청 = T_PROPSL_REQUESTS

    //요구사항
    @OneToMany(mappedBy = "project")
    private List<RequirementSpec> requirementSpecs = new ArrayList<>(); //요구사항 = T_REQUIREMENT_SPECS

    //프로젝트 팀원
    @OneToMany(mappedBy = "project")
    private List<ProjectMemberMppg> projectMemberMppg = new ArrayList<>(); //프로젝트 팀원 = T_PROJECT_MEMBER_MAPPG

    // 단계 연관관계 편의 메서드 (프로젝트 <-> 단계)
    public void changeSteps(Step step){
        this.getSteps().add(step);
        step.setProject(this);
    }

    // 연관관계 편의 메서드 (프로젝트 <-> 제안 요청)
    public void changePropslRequests(PropslRequest propslRequest){
        this.getPropslRequests().add(propslRequest);
        propslRequest.setProject(this);
    }

    // 연관관계 편의 메서드 (프로젝트 <-> 요구사항 명세)
    public void changeRequirementSpecs(RequirementSpec requirementSpec){
        this.getRequirementSpecs().add(requirementSpec);
        requirementSpec.setProject(this);
    }

    // 연관관계 편의 메서드 (프로젝트 <-> 프로젝트 팀원)
    public void changePojectMemberMppg(ProjectMemberMppg pojectMemberMppg){
        this.getProjectMemberMppg().add(pojectMemberMppg);
        pojectMemberMppg.setProject(this);
    }


}
