package silverit.deliverables.common.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import silverit.deliverables.common.entity.Program;
import silverit.deliverables.common.entity.RequirementSpec;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class ComponentForm {

    private Long componentNo; //컴포넌트 번호
    private String componentNm; //컴포넌트 명
    private String componentAbbrNm; //컴포넌트 약어 명
    private String componentDc; //컴포넌트 설명
    private String rmark; //비고

}
