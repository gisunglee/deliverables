package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "T_MENU")
public class Menu {

    @Id @GeneratedValue
    private String menuNo; //메뉴 번호
    private String menuNm; //메뉴 명
    private String useYn; //사용 여부
    private String menuDc; //메뉴 설명
    private String rmark; //비고

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    @Setter
    private RequirementSpec requirementSpec;

    //연관 관계 편의 메서드 (메뉴 <-> 요구사항명세)
    public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getMenus().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getMenus().add(this);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPPER_MENU_NO")
    @Setter
    private Menu superMenu;

    @OneToMany(mappedBy = "superMenu" )
    private List<ActivityOutput> activityOutputs = new ArrayList<>(); //활동산출물




}
