package silverit.deliverables;

import org.springframework.beans.BeanUtils;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.form.PropslRequestForm;

public class TestMain {


    public static void main(String[] args) {
        PropslRequestForm source = new PropslRequestForm();
        source.setPropslReqNm("setPropslReqNm");

        PropslRequestForm target = new PropslRequestForm();

        BeanUtils.copyProperties(source, target);

        BeanUtils.copyProperties(source, target);

    }

}
