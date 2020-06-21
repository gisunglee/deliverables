package silverit.deliverables.common.form;

import lombok.Getter;
import lombok.Setter;
import silverit.deliverables.common.entity.ProjectMemberMppg;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.entity.RequirementSpec;
import silverit.deliverables.common.entity.Step;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
/**
 * 프로젝트
 */
public class ProjectForm {

    private Long prjNo; //프로젝트 번호
    private String prjNm; //프로젝트 명
    private String prjBeginDe; //프로젝트 시작일자
    private String prjEndDe; //프로젝트 종료일자
    private String prjEngCdNm; //프로젝트 영문 코드 명
    private String prjDc; //프로젝트 설명

}
