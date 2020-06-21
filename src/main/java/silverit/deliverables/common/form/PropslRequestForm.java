package silverit.deliverables.common.form;

import lombok.Getter;
import lombok.Setter;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.PropslRequirementMppg;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
/**
 * 제안 요청
 */
public class PropslRequestForm {


    private Long propslReqNo; //제안 요청 번호
    private String propslReqNm; //제안 요청 명
    private String propslReqClasText; //제안 요청 분류 내용
    private String propslReqText; //제안 요청 내용
    private String propslReqId; //제안요청 Id
    private String propslReqDefiText; //제안 요청 정의 내용
    private String relPrdcWtrText; //관련 산출물 내용
    private String suplmtDemndMaterYn; //추가 요구사항 여부

}
