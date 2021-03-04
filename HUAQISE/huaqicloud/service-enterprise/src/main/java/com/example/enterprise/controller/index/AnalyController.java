package com.example.enterprise.controller.index;

import com.example.common.vo.ResponseVO;
import com.example.enterprise.bl.index.IndexService;
import com.example.enterprise.blImpl.index.IndexServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;


/**
 * @Author: Owen
 * @Date: 2020/10/27 20:54
 * @Description:
 */

@RestController
@RequestMapping("/api/analy")
@Api(value="/",tags ="评析接口")
public class AnalyController {

    @Autowired
    IndexServiceImpl indexService;

    @GetMapping("/{id}/getAnaly")
    ResponseVO getAnaly(@PathVariable Integer id){
        String[] str = indexService.getAnaly(id);
        if (str == null){
            return ResponseVO.buildFailure("获取数组错误");
        }
        return ResponseVO.buildSuccess(str);
    }

    @GetMapping("/get_grade_all_list/{id}")
    ResponseVO getGradeAllList(@PathVariable Integer id){
        Double[] result = indexService.getGradeAllList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_financial_grade_display_list/{id}")
    ResponseVO getFinancialGradeDisplayList(@PathVariable Integer id){
        Double[] result = indexService.getFinancialDisplayList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_debt_grade_display_list/{id}")
    ResponseVO getDebtGradeDisplayList(@PathVariable Integer id){
        Double[] result = indexService.getDebtDisplayList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_dev_phrase_num/{id}")
    ResponseVO getDevPhraseNum(@PathVariable Integer id){
        Integer[] result = indexService.getDevPhraseNum();
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_growth_abailty_indexs_list/{id}")
    ResponseVO getGrowthAbilityIndexList(@PathVariable Integer id){
        Double[] result = indexService.getAbilityIndexList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_gain_abailty_indexs_list/{id}")
    ResponseVO getGainAbilityIndexList(@PathVariable Integer id){
        Double[] result = indexService.getGainAbilityIndexList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_operation_abailty_indexs_list/{id}")
    ResponseVO getOperationAbilityIndexList(@PathVariable Integer id){
        Double[] result = indexService.getOperationAbilityIndexList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_liang_hua_grade_list/{id}")
    ResponseVO getDiverGradeList(@PathVariable Integer id){
        Double[] result = indexService.getDiverGradeList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_liang_hua_first_index_grade_list/{id}")
    ResponseVO getDiverFirstIndexList(@PathVariable Integer id){
        Double[] result = indexService.getDiverFirstIndexList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_gong_ying_lian_guan_li_list/{id}")
    ResponseVO getDiverGongYingLianList(@PathVariable Integer id){
        Double[] result = indexService.getDiverGongYingLianList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("get_xing_zheng_guan_li_list/{id}")
    ResponseVO getDiverXingZhengList(@PathVariable Integer id){
        Double[] result = indexService.getDiverXingZhengList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_money_investment_list/{id}")
    ResponseVO getDiverInvestmentList(@PathVariable Integer id){
        Double[] result = indexService.getDiverInvestmentList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

    @GetMapping("/get_zen_zhi_fu_wu_list/{id}")
    ResponseVO getDiverZenZhiList(@PathVariable Integer id){
        Double[] result = indexService.getDiverZenZhiList(id);
        if (result.length == 0){
            return ResponseVO.buildFailure("数据异常");
        }
        return ResponseVO.buildSuccess(result);
    }

}

