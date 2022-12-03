package org.sojuton.paper.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sojuton.paper.model.dto.PaperDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface PaperDao {
    public List<Map<String, Object>> retrievePaperList(PaperDto vo);
    public List<Map<String, Object>> retrievePaperTextList(PaperDto vo);
    public int insertPaper(PaperDto vo);
    public int insertPaperText(PaperDto vo);
    public int deletePaperText(PaperDto vo);
    public int deletePaper(PaperDto vo);
    public int updateLike(PaperDto vo);
}
