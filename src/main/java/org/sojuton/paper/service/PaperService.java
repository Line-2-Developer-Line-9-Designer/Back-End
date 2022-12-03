package org.sojuton.paper.service;

import lombok.RequiredArgsConstructor;
import org.sojuton.paper.model.dao.PaperDao;
import org.sojuton.paper.model.dto.PaperDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaperService {
    private final PaperDao paperDao;

    public List<Map<String, Object>> retrievePaperList(PaperDto vo) {
        return paperDao.retrievePaperList(vo);
    }

    public List<Map<String, Object>> retrievePaperTextList(PaperDto vo) {
        return paperDao.retrievePaperTextList(vo);
    }

    public int insertPaper(PaperDto vo) {
        return paperDao.insertPaper(vo);
    }

    public int insertPaperText(PaperDto vo) {
        return paperDao.insertPaperText(vo);
    }
    public int deletePaperText(PaperDto vo) {
        return paperDao.deletePaperText(vo);
    }
    public int deletePaper(PaperDto vo) {
        return paperDao.deletePaper(vo);
    }
    public int updateLike(PaperDto vo) {
        return paperDao.updateLike(vo);
    }
}
