package org.sojuton.paper.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sojuton.paper.model.dto.PaperDto;
import org.sojuton.paper.service.PaperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/paper")
@RequiredArgsConstructor
public class PaperController {
    private Logger logger = LoggerFactory.getLogger(PaperController.class);
    private final PaperService paperService;

    @PostMapping
    @RequestMapping("/list")
    public ResponseEntity retrievePaperList(PaperDto vo) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("RESULT", null);
        result.put("CODE", "FAIL");

        try {
            result.replace("RESULT", paperService.retrievePaperList(vo));
        } catch (Exception e) {
            logger.error("롤링페이퍼 목록 실패" + e);
        } finally {
            if (result.get("RESULT") != null) {
                result.replace("CODE", "SUCCESS");
            }
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @RequestMapping("/detailList")
    public ResponseEntity retrievePaperTextList(PaperDto vo) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("RESULT", null);
        result.put("CODE", "FAIL");

        try {
            result.replace("RESULT", paperService.retrievePaperTextList(vo));
        } catch (Exception e) {
            logger.error("롤링페이퍼 상세 목록 실패" + e);
        } finally {
            if (result.get("RESULT") != null) {
                result.replace("CODE", "SUCCESS");
            }
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity insertPaper(PaperDto vo) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("RESULT", 0);
        result.put("CODE", "FAIL");

        try {
            result.replace("RESULT", paperService.insertPaper(vo));
        } catch (Exception e) {
            logger.error("롤링페이퍼 등록 실패" + e);
        } finally {
            if ((int) result.get("RESULT") > 0) {
                result.replace("CODE", "SUCCESS");
            }
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @RequestMapping("/detailAdd")
    public ResponseEntity insertPaperText(PaperDto vo) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("RESULT", 0);
        result.put("CODE", "FAIL");

        try {
            result.replace("RESULT", paperService.insertPaperText(vo));
        } catch (Exception e) {
            logger.error("롤링페이퍼 상세 등록 실패" + e);
        } finally {
            if ((int) result.get("RESULT") > 0) {
                result.replace("CODE", "SUCCESS");
            }
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @RequestMapping("/delete")
    public ResponseEntity deletePaper(PaperDto vo) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("RESULT", 0);
        result.put("CODE", "FAIL");

        try {
            int deleteCnt = paperService.deletePaperText(vo);
            deleteCnt += paperService.deletePaper(vo);
            result.replace("RESULT", deleteCnt);
        } catch (Exception e) {
            logger.error("롤링페이퍼 삭제 실패" + e);
        } finally {
            if ((int) result.get("RESULT") > 0) {
                result.replace("CODE", "SUCCESS");
            }
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @RequestMapping("/like")
    public ResponseEntity updateLike(PaperDto vo) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("RESULT", 0);
        result.put("CODE", "FAIL");

        try {
            result.replace("RESULT", paperService.updateLike(vo));
        } catch (Exception e) {
            logger.error("롤링페이퍼 좋아요 실패" + e);
        } finally {
            if ((int) result.get("RESULT") > 0) {
                result.replace("CODE", "SUCCESS");
            }
        }
        return ResponseEntity.ok(result);
    }
}
