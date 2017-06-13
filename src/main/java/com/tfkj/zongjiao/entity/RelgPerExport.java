package com.tfkj.zongjiao.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by wangqingxiang on 2017/5/19.
 */
@XmlRootElement(name="relgPerExport")
public class RelgPerExport {

    private List<RelgPer> relgPerList;

    @XmlElement(name = "relgPerList")
    public List<RelgPer> getRelgPerList() {
        return relgPerList;
    }

    public void setRelgPerList(List<RelgPer> relgPerList) {
        this.relgPerList = relgPerList;
    }


}
