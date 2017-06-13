package com.tfkj.zongjiao.dao;

import com.tfkj.zongjiao.entity.RelgPer;

import java.util.List;
import java.util.Map;

/**
 * Created by wangqingxiang on 2017/5/20.
 */
public interface RelgPerDao {
    public RelgPer get(String id);
    public List<RelgPer> findList(RelgPer relgPer);
    public List<RelgPer> findTest(RelgPer relgPer);
    public String getExportData(String area);
    public int getDataCount(RelgPer relgPer);
    public List<RelgPer> export(String area);
    public void deleteAll();
    public void insert(RelgPer relgPer); 

    public List<RelgPer> excelExport(RelgPer relgPer);
    public void update(RelgPer relgPer);
    public void delete(RelgPer relgPer);
    public void realDelete(RelgPer relgPer);
    
    
    public List<Map<String, String>> getProvinceList();
    public List<Map<String, String>> getCityList(String father);
    public List<Map<String, String>> getAreaList(String father);

}
