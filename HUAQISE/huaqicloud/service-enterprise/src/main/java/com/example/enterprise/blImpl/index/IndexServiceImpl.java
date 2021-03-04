package com.example.enterprise.blImpl.index;

import com.example.common.calculation.DivRank;
import com.example.common.calculation.FinRank;
import com.example.enterprise.bl.enterprise.EnterpriseService;
import com.example.enterprise.bl.index.IndexService;
import com.example.enterprise.blImpl.enterprise.EnterpriseServiceImpl;
import com.example.enterprise.dao.enterprise.EnterpriseMapper;
import com.example.enterprise.dao.index.*;
import com.example.enterprise.po.Enterprise;
import com.example.enterprise.po.index.financial.FinancialIndex;
import com.example.enterprise.po.index.financial.FinancialPercent;
import com.example.enterprise.po.index.integrate.*;
import com.example.enterprise.vo.EnterpriseTarget;
import com.example.enterprise.vo.EnterpriseVO;
import com.example.enterprise.vo.TargetObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/24 16:33
 * @Description 在这里写更新所有参评企业的评分，不需要实现indexservice中的接口，作为工具方法使用
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    EnterpriseServiceImpl enterpriseServiceImpl;
    @Autowired
    EnterpriseMapper enterpriseMapper;
    @Autowired
    MassDisMapper massDisMapper;
    @Autowired
    MixInduMapper mixInduMapper;
    @Autowired
    ProcInduMapper procInduMapper;
    @Autowired
    ServInduMapper servInduMapper;
    @Autowired
    SmeDisMapper smeDisMapper;
    @Autowired
    FinanIndMapper finanIndMapper;

    public Integer addEnterpriseTarget(Integer id, EnterpriseTarget enterpriseTarget){

        Double[] div = enterpriseTarget.getDiv();
        Double[] fin = enterpriseTarget.getFin();
        int effect_div = 0, effect_fin = 0;
        try{
            switch (div.length) {
                case 17:
                    //mass
                    MassDiscrete md = new MassDiscrete(id, div);
                    effect_div = massDisMapper.insertMassDis(md);
                    break;
                case 21:
                    // mix
                    MixIndustry mi = new MixIndustry(id, div);
                    effect_div = mixInduMapper.insertMixIndu(mi);
                    break;
                case 25:
                    // process
                    ProcIndustry pi = new ProcIndustry(id, div);
                    effect_div = procInduMapper.insertProcIndu(pi);
                    break;
                case 18:
                    // service
                    ServeIndustry si = new ServeIndustry(id, div);
                    effect_div = servInduMapper.insertServIndu(si);
                    break;
                case 26:
                    // sme dis
                    SmeDiscrete sd = new SmeDiscrete(id, div);
                    effect_div = smeDisMapper.insertSmeDis(sd);
                    break;
                default:
                    System.out.println("Invalid Array!");
                    return 0;
            }

            FinancialIndex fi = new FinancialIndex(id, fin);
            effect_fin = finanIndMapper.insertFinanInd(fi);

        }catch(Exception e){
            System.out.println("数据库冗余");
            System.out.println(e.getMessage());
            return 0;
        }

        // 自动刷新Enterprise表中的三项分数
        enterpriseServiceImpl.updateTable(id);
        //计算&刷新指标百分比
        enterpriseServiceImpl.updatePercent(id);
        return 1;
    }

    public Integer updateEnterpriseFinanTarget(Integer id, TargetObject targetObject){

        Double[] fin = targetObject.getArray();
        int effect = finanIndMapper.deleteFinanById(id);
        if (effect == 0){
            System.out.println("error deletion");
            return 0;
        }

        FinancialIndex fi = new FinancialIndex(id, fin);
        effect = finanIndMapper.insertFinanInd(fi);
        if (effect == 0){
            System.out.println("error insertion");
            return 0;
        }

        // 自动刷新Enterprise表中的三项分数
        enterpriseServiceImpl.updateTable(id);
        //计算&刷新指标百分比
        enterpriseServiceImpl.updatePercent(id);
        return 1;
    }

    public Integer updateEnterpriseDiverTarget(Integer id, TargetObject targetObject){

        Double[] div = targetObject.getArray();
        int effect = 0;
        switch (div.length) {
            case 17:
                //mass
                massDisMapper.deleteDiverById(id);
                MassDiscrete md = new MassDiscrete(id, div);
                effect = massDisMapper.insertMassDis(md);
                break;
            case 21:
                // mix
                mixInduMapper.deleteDiverById(id);
                MixIndustry mi = new MixIndustry(id, div);
                effect = mixInduMapper.insertMixIndu(mi);
                break;
            case 25:
                // process
                procInduMapper.deleteDiverById(id);
                ProcIndustry pi = new ProcIndustry(id, div);
                effect = procInduMapper.insertProcIndu(pi);
                break;
            case 18:
                // service
                servInduMapper.deleteDiverById(id);
                ServeIndustry si = new ServeIndustry(id, div);
                effect = servInduMapper.insertServIndu(si);
                break;
            case 26:
                // sme dis
                smeDisMapper.deleteDiverById(id);
                SmeDiscrete sd = new SmeDiscrete(id, div);
                effect = smeDisMapper.insertSmeDis(sd);
                break;
            default:
                System.out.println("Invalid Array!");
                return 0;
        }

        // 自动刷新Enterprise表中的三项分数
        enterpriseServiceImpl.updateTable(id);
        //计算&刷新指标百分比
        enterpriseServiceImpl.updatePercent(id);

        return 1;
    }

    public Double[][] getEnterpriseTarget(Integer id){
        EnterpriseVO enterpriseVO = enterpriseServiceImpl.getEnterpriseById(id);
        int type = enterpriseVO.getType();

        List<List<Double>> list = new ArrayList<>();

        try{
            switch (type) {
                case 1:
                    MassDiscrete massDiscrete = massDisMapper.getMassDisByEpId(id);
                    list.add(massDiscrete.getList());
                    break;
                case 2:
                    ProcIndustry procIndustry = procInduMapper.getProcByEpId(id);
                    list.add(procIndustry.getList());
                    break;
                case 3:
                    SmeDiscrete smeDiscrete = smeDisMapper.getSmeDisByEpId(id);
                    list.add(smeDiscrete.getList());
                    break;
                case 4:
                    ServeIndustry serveIndustry = servInduMapper.getSerIndByEpId(id);
                    list.add(serveIndustry.getList());
                    break;
                case 5:
                    MixIndustry mixIndustry = mixInduMapper.getMixIndByEpId(id);
                    list.add(mixIndustry.getList());
                    break;
                default:
                    System.out.println("Error type");
                    return null;
            }

            FinancialIndex financialIndex = finanIndMapper.getFinanByEpId(id);
            list.add(financialIndex.getList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        List<Double> dList = list.get(0);
        List<Double> fList = list.get(1);

        Double[] div = new Double[dList.size()];
        dList.toArray(div);

        Double[] fin = new Double[fList.size()];
        fList.toArray(fin);

        Double[][] re = {div, fin};

        return re;
    }

    public String[] getAnaly(Integer id){

        List<String> list = new ArrayList<>();
        String str = "";
        String grade = "";


        EnterpriseVO enterprise = enterpriseServiceImpl.getEnterpriseById(id);

        //企业名称
        str = enterprise.getName();
        list.add(str);

        //企业总分
        NumberFormat nf2 = NumberFormat.getNumberInstance();
        nf2.setMaximumFractionDigits(2);
        list.add(nf2.format(enterprise.getTotalScore() * 100));

        //评级结果
        Double tmp = enterprise.getTotalScore() * 100;
        if (tmp >= 90.0) {
            list.add("AAA");
            grade = "AAA";
        }
        else if (tmp >= 80.0 && tmp < 90.0) {
            list.add("AA");
            grade = "AA";
        }
        else if (tmp >= 70.0 && tmp < 80.0) {
            list.add("A");
            grade = "A";
        }
        else if (tmp >= 60.0 && tmp < 70.0){
            list.add("BBB");
            grade = "BBB";
        }
        else if (tmp >= 50.0 && tmp < 60.0) {
            list.add("BB");
            grade = "BB";
        }
        else if (tmp >= 40.0 && tmp < 50.0){
            list.add("B");
            grade = "B";
        }
        else if (tmp >= 30.0 && tmp < 40.0){
            list.add("CCC");
            grade = "CCC";
        }
        else if (tmp >= 20.0 && tmp < 30.0) {
            list.add("CC");
            grade = "CC";
        }
        else if (tmp >= 10.0 && tmp < 20.0) {
            list.add("C");
            grade = "C";
        }
        else{
            list.add("D");
            grade = "D";
        }

        //评级日期
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        list.add(formatter.format(date));

        //企业类型 + 企业类型关键指标
        switch (enterprise.getType()){
            case 1:
                list.add("离散大批量行业");
                list.add("供应链管理、增值服务管理、信息化管理、行政管理");
                break;
            case 2:
                list.add("流程行业");
                list.add("供应链管理、增值服务管理、信息化管理、行政管理、研发管理");
                break;
            case 3:
                list.add("离散中小批量行业");
                list.add("供应链管理、增值服务管理、信息化管理、行政管理、研发管理");
                break;
            case 4:
                list.add("服务行业");
                list.add("供应链管理、增值服务管理、信息化管理、行政管理");
                break;
            case 5:
                list.add("混合行业");
                list.add("供应链管理、增值服务管理、信息化管理、行政管理");
                break;
            default:
                break;
        }

        //公司回款能力 + 经营活动产生的现金流量净额与经营活动净收益之比
        FinancialPercent financialPercent = finanIndMapper.getPercentByEpId(id);
        FinancialIndex financialIndex = finanIndMapper.getFinanByEpId(id);
        List<Double> finanPercentList = financialPercent.getList();
        List<Double> finanIndexList = financialIndex.getList();
        tmp = finanPercentList.get(0);

        str = "2019年公司经营活动产生的现金流量净额与经营活动净收益之比为" + nf2.format(tmp);
        if (tmp <= 30) {
            list.add("公司回款能力较强");
            str = str + "，与同行业相比，公司的经营活动现金流可以更多地转化为经营活动净收益。";
            if (finanIndexList.get(0) < 0){
                str = str + "企业的信用状况不好或正处于公司产品初创期。";
            }
            list.add(str);
        }
        else if (tmp <= 70 && tmp > 30){
            list.add("公司回款能力中等");
            str = str + "，处于行业中等水平。";
            if (finanIndexList.get(0) < 0){
                str = str + "企业的信用状况不好或正处于公司产品初创期。";
            }
            list.add(str);
        }
        else{
            list.add("公司回款能力较弱");
            str = str + "，处于行业较低水平。公司应做好客户信用评估，定期分析回款率，适当建立回款激励机制。";
            if (finanIndexList.get(0) < 0){
                str = str + "企业的信用状况不好或正处于公司产品初创期。";
            }
            list.add(str);
        }

        // 偿债能力
        //缺乏计算一级指标Percent手段，要再新写逻辑
        //偿债能力位处第二个一级指标
        List<Double> tmpList = new ArrayList<>();
        List<List<Double>> doubleList = new ArrayList<>();
        List<FinancialIndex> financialIndexList = finanIndMapper.getAllFinInd();
        int inttmp = 0;

        for (int i=0; i<financialIndexList.size(); i++){
            doubleList.add(financialIndexList.get(i).getList());
            if (financialIndexList.get(i).getEnterprise_id() == id) inttmp = i;
        }
        doubleList = FinRank.getFinanceTopTarget(doubleList);
        for (int i=0; i<doubleList.size(); i++){
            tmpList.add(doubleList.get(i).get(1));
        }
        tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
        if (tmp <= 30.0){
            list.add("公司偿债能力较强");
        }else if (tmp > 30.0 && tmp <= 70.0){
            list.add("公司偿债能力中等");
        }else{
            list.add("公司偿债能力较弱");
        }

        //资产负债率
        str = "";
        tmp = finanIndexList.get(1);
        str = str + "2019年，公司的资产负债率为" + nf2.format(tmp) + "，";
        if (tmp >= 100.0){
            str = str + "公司已经资不抵债，对于债权人来说风险非常大。";
        }else if (tmp < 100.0 && tmp > 70.0){
            str = str + "债权人的利益缺乏保障。";
        }else if (tmp >= 40.0 && tmp <= 70.0){
            str = str + "较为适宜。";
        }else{
            str = str + "企业偿债有保证。";
        }
        list.add(str);

        //流动比例
        str = "";
        Double tmp2;
        tmp = finanIndexList.get(2);
        tmp2 = finanIndexList.get(3);
        str = "流动比率为" + nf2.format(tmp) + "，速动比率为" + nf2.format(tmp2) + "，";
        if (tmp < 1.0 && tmp2 < 0.5 ) {
            str = str + "资金流动性差。";
        }else if (tmp > 1.5 && tmp2 < 2.0){
            str = str + "资金流动性一般。";
        }else if (tmp > 2.0 && tmp2 > 1.0){
            str = str + "资金流动性差。";
        }else{
            str = str + "公司短期偿债能力偏低。";
        }
        list.add(str);

        //经营活动产生的现金流量净额与流动负债之比
        tmp = finanIndexList.get(4);
        str = "";
        str = "经营活动产生的现金流量净额与流动负债之比为" + nf2.format(tmp);
        if (tmp > 1.0){
            str = str + "，企业流动负债的偿还有保证";
            list.add(str);
        }else{
            list.add(str);
        }

        //有形资产与负债合计之比
        str = "";
        tmp = finanIndexList.get(5);
        tmp2 = finanPercentList.get(5);
        str = "有形资产与负债合计之比为" + nf2.format(tmp) + "。";
        if (tmp > 0.8){
            str = str + "企业有较好的偿债能力，举债规模正常。";
        }
        list.add(str);

        //偿债能力位于同行业后30%
        tmpList = new ArrayList<>();
        doubleList = new ArrayList<>();
        for (int i=0; i<financialIndexList.size(); i++){
            doubleList.add(financialIndexList.get(i).getList());
            if (financialIndexList.get(i).getEnterprise_id() == id) inttmp = i;
        }
        doubleList = FinRank.getFinanceTopTarget(doubleList);
        for (int i=0; i<doubleList.size(); i++){
            tmpList.add(doubleList.get(i).get(1));
        }
        tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
        if (tmp >= 70.0){
            list.add("公司面临债务偿还压力较大，应优化资本结构，提高资产质量，科学举债，制定合理的偿债计划。");
        }else{
            list.add("");
        }

        //公司成长能力
        tmpList = new ArrayList<>();
        doubleList = new ArrayList<>();
        for (int i=0; i<financialIndexList.size(); i++){
            doubleList.add(financialIndexList.get(i).getList());
            if (financialIndexList.get(i).getEnterprise_id() == id) inttmp = i;
        }
        doubleList = FinRank.getFinanceTopTarget(doubleList);
        for (int i=0; i<doubleList.size(); i++){
            tmpList.add(doubleList.get(i).get(2));
        }
        tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
        if (tmp < 30.0){
            list.add("公司成长能力较强");
        }else if (tmp > 70.0){
            list.add("公司成长能力较弱");
        }else{
            list.add("公司成长能力中等");
        }

        //营业总收入同比增长率
        str = "";
        tmp = finanIndexList.get(6);
        str = "2019年营业总收入同比增长率为"+nf2.format(tmp);
        if (tmp > 0.1){
            str = str + "，正处于成长期，将继续保持较好的增长势头，尚未面临产品更新的风险，属于成长型公司。";
        }else if (tmp < 0.05){
            str = str + "，公司产品已进入稳定期，不久将进入衰退期，需要着手开发新产品。";
        }else {
            str = str + "，公司产品已进入衰退期，保持市场份额已经很困难，主营业务利润开始滑坡，如果没有已开发好的新产品，将步入衰落。";
        }
        list.add(str);

        //利润总额同比增长率
        tmp = finanIndexList.get(7);
        tmp2 = finanPercentList.get(7);
        str = "利润总额同比增长率为" + nf2.format(tmp) + "，处于行业";
        if (tmp2 < 30.0){
            str = str + "较高水平。";
        }else if (tmp2 > 70.0){
            str = str + "较低水平。";
        }else{
            str = str + "中等水平。";
        }
        list.add(str);

        //成长能力后30%
        tmpList = new ArrayList<>();
        doubleList = new ArrayList<>();
        for (int i=0; i<financialIndexList.size(); i++){
            doubleList.add(financialIndexList.get(i).getList());
            if (financialIndexList.get(i).getEnterprise_id() == id) inttmp = i;
        }
        doubleList = FinRank.getFinanceTopTarget(doubleList);
        for (int i=0; i<doubleList.size(); i++){
            tmpList.add(doubleList.get(i).get(2));
        }
        tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
        if (tmp > 70.0){
            list.add("公司应找寻增加利润的销售方式，实行合理的负债经营。");
        }else{
            list.add("");
        }

        //公司盈利能力
        tmpList = new ArrayList<>();
        doubleList = new ArrayList<>();
        for (int i=0; i<financialIndexList.size(); i++){
            doubleList.add(financialIndexList.get(i).getList());
            if (financialIndexList.get(i).getEnterprise_id() == id) inttmp = i;
        }
        doubleList = FinRank.getFinanceTopTarget(doubleList);
        for (int i=0; i<doubleList.size(); i++){
            tmpList.add(doubleList.get(i).get(3));
        }
        tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
        if (tmp < 30.0){
            list.add("公司盈利能力较强");
        }else if (tmp > 70.0){
            list.add("公司盈利能力较弱");
        }else{
            list.add("公司盈利能力中等");
        }

        //净资产收益率
        tmp = finanIndexList.get(9);
        str = "2019年公司净资产收益率为" + nf2.format(tmp);
        if (tmp <= 0.39 && tmp >= 0.15){
            str = str + "，公司对资金的利用效率较好。";
        }else if (tmp < 0.15 && tmp >= 0.05){
            str = str + "，公司对股东投入资本的利用效率较低。";
        }else if (tmp < 0.05){
            str = str + "，公司对股东投入资本的利用效率很低，不太值得投资者关注。";
        }else{
            // > 0.39
            str = str + "，公司对资金的利用效率很好。";
        }
        list.add(str);

        // 净资产收益率>100%并且资产负债率>80%
        tmp2 = finanIndexList.get(1);
        if (tmp > 1.0 && tmp2 > 0.8){
            list.add("资金使用效率很高，但这是建立在高负债基础上的，风险不可小觑。");
        }else{
            list.add("");
        }

        //销售净利率
        String strtmp = "";
        tmp = finanIndexList.get(10);
        tmp2 = finanPercentList.get(10);
        str = "销售净利率" + nf2.format(tmp) + "，销售收入收益水平处于行业";
        strtmp = tmp2 <= 70.0 ? ( tmp2 < 30.0 ? "较低水平" : "中等水平") : "较高水平";
        str = str + strtmp;
        list.add(str);

        //销售毛利率
        tmp = finanIndexList.get(11);
        tmp2 = finanPercentList.get(11);
        str = "销售毛利率" + nf2.format(tmp) + "，";
        strtmp = tmp2 <= 70.0 ? ( tmp2 < 30.0 ? "公司竞争力较弱" : "处于行业中等水平") : "公司产品附加值较高或与同行相比存在成本上的优势，有竞争力";
        str = str + strtmp;
        list.add(str);

        //盈利能力位于同行业后30%)
        tmpList = new ArrayList<>();
        doubleList = new ArrayList<>();
        for (int i=0; i<financialIndexList.size(); i++){
            doubleList.add(financialIndexList.get(i).getList());
            if (financialIndexList.get(i).getEnterprise_id() == id) inttmp = i;
        }
        doubleList = FinRank.getFinanceTopTarget(doubleList);
        for (int i=0; i<doubleList.size(); i++){
            tmpList.add(doubleList.get(i).get(3));
        }
        tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
        if (tmp > 70.0){
            list.add("公司未来需积极开拓更灵活的经营方式，合理配置资本结构，通过正确决策和管理运营增加营业总收入，降低总成本，提高销售净利率。");
        }else{
            list.add("");
        }

        //公司营运能力
        tmpList = new ArrayList<>();
        doubleList = new ArrayList<>();
        for (int i=0; i<financialIndexList.size(); i++){
            doubleList.add(financialIndexList.get(i).getList());
            if (financialIndexList.get(i).getEnterprise_id() == id) inttmp = i;
        }
        doubleList = FinRank.getFinanceTopTarget(doubleList);
        for (int i=0; i<doubleList.size(); i++){
            tmpList.add(doubleList.get(i).get(4));
        }
        tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
        if (tmp > 70.0) list.add("公司营运能力较强");
        else if (tmp < 30.0) list.add("公司营运能力较弱");
        else list.add("公司营运能力中等");

        //财务费用与营业总收入之比
        tmp = finanIndexList.get(12);
        tmp2 = finanPercentList.get(12);
        str = "公司财务费用与营业总收入之比为" + nf2.format(tmp) + "，企业财务负担与同行业相比";
        strtmp = tmp2 <= 70.0 ? ( tmp < 30.0 ? "较轻" : "适中" ) : "较重";
        str = str + strtmp;
        list.add(str);

        //存货周转天数
        tmp = finanIndexList.get(13);
        tmp2 = finanPercentList.get(13);
        str = "存货周转天数为" + nf2.format(tmp) + "天，";
        strtmp = tmp2 <= 70.0 ? (tmp2 < 30.0 ? "存货积压，变现能力较差，应提高存货管理水平，加强仓储管理与跨部门合作。" : "适中") : "存货变现的速度较快，存货占用资金时间较短，工作效率较高。";
        str = str + strtmp;
        list.add(str);

        // 企业流动资产周转速度
        tmp = finanIndexList.get(14);
        tmp2 = finanPercentList.get(14);
        str = "公司流动资产周转率为" + nf2.format(tmp) + "，";
        strtmp = tmp2 <= 70.0 ? (tmp2 < 30.0 ? "企业流动资产周转速度较快，利用较好。" : "处于同行业中等水平") : "企业周转速度慢，需要补充流动资金参加周转，企业应加强内部管理，充分利用流动资产，如调动暂时闲置的货币资金用于短期的投资创造收益等。";
        str = str + strtmp;
        list.add(str);

        //公司应收账款周转率
        tmp = finanIndexList.get(15);
        tmp2 = finanPercentList.get(15);
        str = "公司应收账款周转率为" + nf2.format(tmp) + "，";
        strtmp = tmp2 <= 70.0 ? (tmp2 < 30.0 ? "公司收账速度快，平均收账期短，坏账损失少，资产流动快，偿债能力强" : "处于同行业中等水平") : "公司催收账款不力，增大了发生坏账损失的风险，这对公司正常的生产经营是很不利的，企业应加大收款力度。";
        str = str + strtmp;
        list.add(str);

        //已获利息倍数
        tmp = finanIndexList.get(16);
        tmp2 = finanPercentList.get(16);
        str = "已获利息倍数为" + nf2.format(tmp) + "。";
        if (tmp < 1){
            str = str + "公司在一定盈利水平下支付债务利息的能力很弱。";
        }
        list.add(str);

        //已获利息倍数
        if (tmp2 < 30.0){
            list.add("公司在一定盈利水平下支付债务利息的能力较强。");
        }else{
            list.add("");
        }

        //两化指标评析
        switch(enterprise.getType()){
            case 1:
                MassPercent massPercent = massDisMapper.getPercentByEpId(id);
                MassDiscrete massDiscrete = massDisMapper.getMassDisByEpId(id);
                List<MassDiscrete> massDiscreteList = massDisMapper.getAllMassDis();
                List<Double> massPercentList = massPercent.getList();
                List<Double> massList = massDiscrete.getList();

                //供应链管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<massDiscreteList.size(); i++){
                    doubleList.add(massDiscreteList.get(i).getList());
                    if (massDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(0).size(); i++){
                    tmpList.add(doubleList.get(0).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "在供应链管理层面，公司在采购、生产、销售流程中的体系比较单一化" : "在供应链管理层面，公司在采购、生产、销售流程中的体系比较全面";
                list.add(str);

                //按期交货率
                tmp = massList.get(0);
                tmp2 = massPercentList.get(0);
                str = "2019年公司实现按期交货率为" + nf2.format(tmp);
                strtmp = tmp2 <= 70.0 ? ( tmp2 < 30.0 ? "，相对较高" : "，属于同行业中间水平" ) : "，相对较低";
                str = str + strtmp;
                list.add(str);

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "企业具有一体化的管理与控制集成模式，经营管理系统与车间生产制造执行系统之间的指令传达具有范围广、系统化、自动化的特点" : "企业的管理与控制集成模式尚且缺乏体系，经营管理系统与车间生产制造执行系统之间的指令传达具有范围较小、系统化欠缺、自动化进程缓慢的特点";
                list.add(str);

                //应用信息系统
                tmp = massPercentList.get(1);
                str = tmp > 50.0 ? "企业在项目管理过程中的信息系统与解决方案有待完善" : "企业在项目管理过程中的信息系统与解决方案较为成熟";
                list.add(str);

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度不太可观，位居同行业中后部" : "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度比较可观，位居同行业前中部";
                list.add(str);

                //行政管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<massDiscreteList.size(); i++){
                    doubleList.add(massDiscreteList.get(i).getList());
                    if (massDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(3).size(); i++){
                    tmpList.add(doubleList.get(3).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在行政管理层面，公司的水平较低" : "在行政管理层面，公司的水平一般" ) : "在行政管理层面，公司的水平较高";
                list.add(str);

                //企业组织模式
                tmp = massList.get(12);
                tmp2 = massPercentList.get(12);
                str = "其中企业组织模式得分为" + nf2.format(tmp) + "，说明公司本身对于“两化融合”中的行政管理进程";
                strtmp = tmp2 > 50.0 ? "予以高度关注。" : "未予以关注。";
                str = str + strtmp;
                list.add(str);

                //人力资源管理
                tmp = massList.get(16);
                tmp2 = massPercentList.get(16);
                str = "在人力资源方面，应用信息化手段进行人力资源管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 < 50.0 ? "，比较客观" : "，仍有上升空间";
                str = str + strtmp;
                list.add(str);

                //设备管理
                tmp = massList.get(15);
                tmp2 = massPercentList.get(15);
                str = "在设备管理方面，公司应用信息化手段进行设备管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 > 30.0 ? ( tmp2 > 70.0 ? "，位于行业尾部" : "，位于行业中游" ) : "，位于行业前列";
                str = str + strtmp;
                list.add(str);

                //信息化规划执行情况
                tmp = massList.get(13);
                tmp2 = massPercentList.get(13);
                str = "整体来看，信息化规划执行情况得分为" + nf2.format(tmp) + "，说明公司正处于";
                strtmp = tmp2 < 50.0 ? "信息化较为成熟的阶段" : "从自动化向信息化过渡的阶段";
                str = str + strtmp;
                list.add(str);

                //信息化管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<massDiscreteList.size(); i++){
                    doubleList.add(massDiscreteList.get(i).getList());
                    if (massDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(2).size(); i++){
                    tmpList.add(doubleList.get(2).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在信息化管理层面，公司的资金投入水平较低" : "在信息化管理层面，公司的资金投入一般" ) : "在信息化管理层面，公司的资金投入水平较高";
                list.add(str);

                //信息化管理层内的二级指标混合判断
                tmp = massList.get(11);
                list.add("公司的信息系统运维投入占信息化总投入的比例为" + nf2.format(tmp) + "。");

                //增值服务管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<massDiscreteList.size(); i++){
                    doubleList.add(massDiscreteList.get(i).getList());
                    if (massDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(1).size(); i++){
                    tmpList.add(doubleList.get(1).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在增值服务管理层面，公司所反映出的协同水平较低" : "在增值服务管理层面，公司所反映出的协同水平一般" ) : "在增值服务管理层面，公司所反映出的协同水平较高";
                list.add(str);

                // 增值服务管理判断-2
                str = "综合比对一些主要指标得分，包括：通过信息化实现业务协同和一体化情况、产业链企业之间信息交互和共享情况、以及通过建立互联网开放社区实现价值网络协同情况等，发现该公司在产业链协同方面具有";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太健康" : "一般" ): "比较良好";
                str = str + strtmp;
                str = str + "的协同发展生态圈，";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太利于" : "比较利于" ): "有利于";
                str = str + strtmp + "跨企业资源共享与关键制造环节协同优化。";
                list.add(str);

                // 增值服务管理判断-3
                if (tmp <= 50.0) list.add("同时，公司可以很好地利用信息化手段实现能源与环保的管理，有利于企业的可持续发展与升级");
                else list.add("同时，公司无法很好地利用信息化手段实现能源与环保的管理，不利于企业的可持续发展与升级");

                //流程、中小批量
                list.add("");

                //新产品产值率-流程行业
                list.add("");

                // 百人专利拥有量-离散中小批量
                list.add("");


                break;
            case 2:
                ProcPercent procPercent = procInduMapper.getPercentByEpId(id);
                ProcIndustry procIndustry = procInduMapper.getProcByEpId(id);
                List<ProcIndustry> procIndustryList = procInduMapper.getAllProcInd();
                List<Double> procPercentList = procPercent.getList();
                List<Double> procList = procIndustry.getList();

                //供应链管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<procIndustryList.size(); i++){
                    doubleList.add(procIndustryList.get(i).getList());
                    if (procIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(0).size(); i++){
                    tmpList.add(doubleList.get(0).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "在供应链管理层面，公司在采购、生产、销售流程中的体系比较单一化" : "在供应链管理层面，公司在采购、生产、销售流程中的体系比较全面";
                list.add(str);

                //按期交货率
                list.add("");

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "企业具有一体化的管理与控制集成模式，经营管理系统与车间生产制造执行系统之间的指令传达具有范围广、系统化、自动化的特点" : "企业的管理与控制集成模式尚且缺乏体系，经营管理系统与车间生产制造执行系统之间的指令传达具有范围较小、系统化欠缺、自动化进程缓慢的特点";
                list.add(str);

                //应用信息系统
                tmp = procPercentList.get(0);
                str = tmp > 50.0 ? "企业在项目管理过程中的信息系统与解决方案有待完善" : "企业在项目管理过程中的信息系统与解决方案较为成熟";
                list.add(str);

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度不太可观，位居同行业中后部" : "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度比较可观，位居同行业前中部";
                list.add(str);

                //行政管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<procIndustryList.size(); i++){
                    doubleList.add(procIndustryList.get(i).getList());
                    if (procIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(3).size(); i++){
                    tmpList.add(doubleList.get(3).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在行政管理层面，公司的水平较低" : "在行政管理层面，公司的水平一般" ) : "在行政管理层面，公司的水平较高";
                list.add(str);

                //企业组织模式
                tmp = procList.get(16);
                tmp2 = procPercentList.get(16);
                str = "其中企业组织模式得分为" + nf2.format(tmp) + "，说明公司本身对于“两化融合”中的行政管理进程";
                strtmp = tmp2 > 50.0 ? "予以高度关注。" : "未予以关注。";
                str = str + strtmp;
                list.add(str);

                //人力资源管理
                tmp = procList.get(22);
                tmp2 = procPercentList.get(22);
                str = "在人力资源方面，应用信息化手段进行人力资源管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 < 50.0 ? "，比较客观" : "，仍有上升空间";
                str = str + strtmp;
                list.add(str);

                //设备管理
                tmp = procList.get(21);
                tmp2 = procPercentList.get(21);
                str = "在设备管理方面，公司应用信息化手段进行设备管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 > 30.0 ? ( tmp2 > 70.0 ? "，位于行业尾部" : "，位于行业中游" ) : "，位于行业前列";
                str = str + strtmp;
                list.add(str);

                //信息化规划执行情况
                tmp = procList.get(17);
                tmp2 = procPercentList.get(17);
                str = "整体来看，信息化规划执行情况得分为" + nf2.format(tmp) + "，说明公司正处于";
                strtmp = tmp2 < 50.0 ? "信息化较为成熟的阶段" : "从自动化向信息化过渡的阶段";
                str = str + strtmp;
                list.add(str);

                //信息化管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<procIndustryList.size(); i++){
                    doubleList.add(procIndustryList.get(i).getList());
                    if (procIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(2).size(); i++){
                    tmpList.add(doubleList.get(2).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在信息化管理层面，公司的资金投入水平较低" : "在信息化管理层面，公司的资金投入一般" ) : "在信息化管理层面，公司的资金投入水平较高";
                list.add(str);

                //信息化管理层内的二级指标混合判断
                tmp = procList.get(15);
                list.add("公司的信息系统运维投入占信息化总投入的比例为" + nf2.format(tmp) + "。");

                //增值服务管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<procIndustryList.size(); i++){
                    doubleList.add(procIndustryList.get(i).getList());
                    if (procIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(1).size(); i++){
                    tmpList.add(doubleList.get(1).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在增值服务管理层面，公司所反映出的协同水平较低" : "在增值服务管理层面，公司所反映出的协同水平一般" ) : "在增值服务管理层面，公司所反映出的协同水平较高";
                list.add(str);

                // 增值服务管理判断-2
                str = "综合比对一些主要指标得分，包括：通过信息化实现业务协同和一体化情况、产业链企业之间信息交互和共享情况、以及通过建立互联网开放社区实现价值网络协同情况等，发现该公司在产业链协同方面具有";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太健康" : "一般" ): "比较良好";
                str = str + strtmp;
                str = str + "的协同发展生态圈，";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太利于" : "比较利于" ): "有利于";
                str = str + strtmp + "跨企业资源共享与关键制造环节协同优化。";
                list.add(str);

                // 增值服务管理判断-3
                if (tmp <= 50.0) list.add("同时，公司可以很好地利用信息化手段实现能源与环保的管理，有利于企业的可持续发展与升级");
                else list.add("同时，公司无法很好地利用信息化手段实现能源与环保的管理，不利于企业的可持续发展与升级");

                //研发管理层-流程、中小批量
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<procIndustryList.size(); i++){
                    doubleList.add(procIndustryList.get(i).getList());
                    if (procIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(4).size(); i++){
                    tmpList.add(doubleList.get(4).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在研发管理层面，公司的创新能力较弱" : "在研发管理层面，公司的创新能力一般" ) : "在研发管理层面，公司的创新能力较强";
                list.add(str);

                //新产品产值率-流程行业
                tmp = procPercentList.get(24);
                if (tmp < 30.0) list.add("从新产品产值率这一指标来看，该公司的创新能力位于行业前列，面临较大的的创新滞后风险与可持续性发展瓶颈 。");
                else if (tmp > 70.0) list.add("从新产品产值率这一指标来看，该公司的创新能力位于行业尾部，面临较小的的创新滞后风险与可持续性发展瓶颈 。");
                else list.add("从新产品产值率这一指标来看，该公司的创新能力位于行业尾部，面临较小的的创新滞后风险与可持续性发展瓶颈 。");

                // 百人专利拥有量-离散中小批量
                list.add("");

                break;
            case 3:
                SmePercent smePercent = smeDisMapper.getPercentByEpId(id);
                SmeDiscrete smeDiscrete = smeDisMapper.getSmeDisByEpId(id);
                List<SmeDiscrete> smeDiscreteList = smeDisMapper.getAllSmeDis();
                List<Double> smePercentList = smePercent.getList();
                List<Double> smeList = smeDiscrete.getList();

                //供应链管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<smeDiscreteList.size(); i++){
                    doubleList.add(smeDiscreteList.get(i).getList());
                    if (smeDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(0).size(); i++){
                    tmpList.add(doubleList.get(0).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "在供应链管理层面，公司在采购、生产、销售流程中的体系比较单一化" : "在供应链管理层面，公司在采购、生产、销售流程中的体系比较全面";
                list.add(str);

                //按期交货率
                list.add("");

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "企业具有一体化的管理与控制集成模式，经营管理系统与车间生产制造执行系统之间的指令传达具有范围广、系统化、自动化的特点" : "企业的管理与控制集成模式尚且缺乏体系，经营管理系统与车间生产制造执行系统之间的指令传达具有范围较小、系统化欠缺、自动化进程缓慢的特点";
                list.add(str);

                //应用信息系统
                tmp = smePercentList.get(0);
                str = tmp > 50.0 ? "企业在项目管理过程中的信息系统与解决方案有待完善" : "企业在项目管理过程中的信息系统与解决方案较为成熟";
                list.add(str);

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度不太可观，位居同行业中后部" : "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度比较可观，位居同行业前中部";
                list.add(str);

                //行政管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<smeDiscreteList.size(); i++){
                    doubleList.add(smeDiscreteList.get(i).getList());
                    if (smeDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(3).size(); i++){
                    tmpList.add(doubleList.get(3).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在行政管理层面，公司的水平较低" : "在行政管理层面，公司的水平一般" ) : "在行政管理层面，公司的水平较高";
                list.add(str);

                //企业组织模式
                tmp = smeList.get(16);
                tmp2 = smePercentList.get(16);
                str = "其中企业组织模式得分为" + nf2.format(tmp) + "，说明公司本身对于“两化融合”中的行政管理进程";
                strtmp = tmp2 > 50.0 ? "予以高度关注。" : "未予以关注。";
                str = str + strtmp;
                list.add(str);

                //人力资源管理
                tmp = smeList.get(21);
                tmp2 = smePercentList.get(21);
                str = "在人力资源方面，应用信息化手段进行人力资源管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 < 50.0 ? "，比较客观" : "，仍有上升空间";
                str = str + strtmp;
                list.add(str);

                //设备管理
                tmp = smeList.get(20);
                tmp2 = smePercentList.get(20);
                str = "在设备管理方面，公司应用信息化手段进行设备管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 > 30.0 ? ( tmp2 > 70.0 ? "，位于行业尾部" : "，位于行业中游" ) : "，位于行业前列";
                str = str + strtmp;
                list.add(str);

                //信息化规划执行情况
                tmp = smeList.get(16);
                tmp2 = smePercentList.get(16);
                str = "整体来看，信息化规划执行情况得分为" + nf2.format(tmp) + "，说明公司正处于";
                strtmp = tmp2 < 50.0 ? "信息化较为成熟的阶段" : "从自动化向信息化过渡的阶段";
                str = str + strtmp;
                list.add(str);

                //信息化管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<smeDiscreteList.size(); i++){
                    doubleList.add(smeDiscreteList.get(i).getList());
                    if (smeDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(2).size(); i++){
                    tmpList.add(doubleList.get(2).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在信息化管理层面，公司的资金投入水平较低" : "在信息化管理层面，公司的资金投入一般" ) : "在信息化管理层面，公司的资金投入水平较高";
                list.add(str);

                //信息化管理层内的二级指标混合判断
                tmp = smeList.get(14);
                tmp2 = smeList.get(13);
                Double tmp3 = smeList.get(12);
                list.add("公司的信息系统运维投入占信息化总投入的比例为" + nf2.format(tmp2) + "，当年企业生产设备总资产为" + nf2.format(tmp) + "亿元，近五年信息化建设投入为" + nf2.format(tmp3) + "万元。" );

                //增值服务管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<smeDiscreteList.size(); i++){
                    doubleList.add(smeDiscreteList.get(i).getList());
                    if (smeDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(1).size(); i++){
                    tmpList.add(doubleList.get(1).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在增值服务管理层面，公司所反映出的协同水平较低" : "在增值服务管理层面，公司所反映出的协同水平一般" ) : "在增值服务管理层面，公司所反映出的协同水平较高";
                list.add(str);

                // 增值服务管理判断-2
                str = "综合比对一些主要指标得分，包括：通过信息化实现业务协同和一体化情况、产业链企业之间信息交互和共享情况、以及通过建立互联网开放社区实现价值网络协同情况等，发现该公司在产业链协同方面具有";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太健康" : "一般" ): "比较良好";
                str = str + strtmp;
                str = str + "的协同发展生态圈，";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太利于" : "比较利于" ): "有利于";
                str = str + strtmp + "跨企业资源共享与关键制造环节协同优化。";
                list.add(str);

                // 增值服务管理判断-3
                if (tmp <= 50.0) list.add("同时，公司可以很好地利用信息化手段实现能源与环保的管理，有利于企业的可持续发展与升级");
                else list.add("同时，公司无法很好地利用信息化手段实现能源与环保的管理，不利于企业的可持续发展与升级");

                //研发管理层-流程、中小批量
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<smeDiscreteList.size(); i++){
                    doubleList.add(smeDiscreteList.get(i).getList());
                    if (smeDiscreteList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(4).size(); i++){
                    tmpList.add(doubleList.get(4).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在研发管理层面，公司的创新能力较弱" : "在研发管理层面，公司的创新能力一般" ) : "在研发管理层面，公司的创新能力较强";
                list.add(str);

                //新产品产值率-流程行业
                list.add("");

                // 百人专利拥有量-离散中小批量
                tmp = smePercentList.get(24);
                if (tmp < 30.0) list.add("从百人专利拥有量等指标来看，该公司的创新能力位于行业前列，面临较大的创新滞后风险与可持续性发展瓶颈。");
                else if (tmp > 70.0) list.add("从百人专利拥有量等指标来看，该公司的创新能力位于行业尾部，面临较小的创新滞后风险与可持续性发展瓶颈。");
                else list.add("从百人专利拥有量等指标来看，该公司的创新能力位于行业中游，面临适中的创新滞后风险与可持续性发展瓶颈。");

                list.add("");

                break;
            case 4:
                ServePercent servePercent = servInduMapper.getPercentByEpId(id);
                ServeIndustry serveIndustry = servInduMapper.getSerIndByEpId(id);
                List<ServeIndustry> serveIndustryList = servInduMapper.getAllSerInd();
                List<Double> servePercentList = servePercent.getList();
                List<Double> serveList = serveIndustry.getList();

                //供应链管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<serveIndustryList.size(); i++){
                    doubleList.add(serveIndustryList.get(i).getList());
                    if (serveIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(0).size(); i++){
                    tmpList.add(doubleList.get(0).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "在供应链管理层面，公司在采购、生产、销售流程中的体系比较单一化" : "在供应链管理层面，公司在采购、生产、销售流程中的体系比较全面";
                list.add(str);

                //按期交货率
                list.add("");

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "企业具有一体化的管理与控制集成模式，经营管理系统与车间生产制造执行系统之间的指令传达具有范围广、系统化、自动化的特点" : "企业的管理与控制集成模式尚且缺乏体系，经营管理系统与车间生产制造执行系统之间的指令传达具有范围较小、系统化欠缺、自动化进程缓慢的特点";
                list.add(str);

                //应用信息系统
                tmp = servePercentList.get(0);
                str = tmp > 50.0 ? "企业在项目管理过程中的信息系统与解决方案有待完善" : "企业在项目管理过程中的信息系统与解决方案较为成熟";
                list.add(str);

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度不太可观，位居同行业中后部" : "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度比较可观，位居同行业前中部";
                list.add(str);

                //行政管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<serveIndustryList.size(); i++){
                    doubleList.add(serveIndustryList.get(i).getList());
                    if (serveIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(3).size(); i++){
                    tmpList.add(doubleList.get(3).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在行政管理层面，公司的水平较低" : "在行政管理层面，公司的水平一般" ) : "在行政管理层面，公司的水平较高";
                list.add(str);

                //企业组织模式
                tmp = serveList.get(12);
                tmp2 = servePercentList.get(12);
                str = "其中企业组织模式得分为" + nf2.format(tmp) + "，说明公司本身对于“两化融合”中的行政管理进程";
                strtmp = tmp2 > 50.0 ? "予以高度关注。" : "未予以关注。";
                str = str + strtmp;
                list.add(str);

                //人力资源管理
                tmp = serveList.get(16);
                tmp2 = servePercentList.get(16);
                str = "在人力资源方面，应用信息化手段进行人力资源管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 < 50.0 ? "，比较客观" : "，仍有上升空间";
                str = str + strtmp;
                list.add(str);

                //设备管理
                tmp = serveList.get(15);
                tmp2 = servePercentList.get(15);
                str = "在设备管理方面，公司应用信息化手段进行设备管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 > 30.0 ? ( tmp2 > 70.0 ? "，位于行业尾部" : "，位于行业中游" ) : "，位于行业前列";
                str = str + strtmp;
                list.add(str);

                //信息化规划执行情况
                tmp = serveList.get(13);
                tmp2 = servePercentList.get(13);
                str = "整体来看，信息化规划执行情况得分为" + nf2.format(tmp) + "，说明公司正处于";
                strtmp = tmp2 < 50.0 ? "信息化较为成熟的阶段" : "从自动化向信息化过渡的阶段";
                str = str + strtmp;
                list.add(str);

                //信息化管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<serveIndustryList.size(); i++){
                    doubleList.add(serveIndustryList.get(i).getList());
                    if (serveIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(2).size(); i++){
                    tmpList.add(doubleList.get(2).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在信息化管理层面，公司的资金投入水平较低" : "在信息化管理层面，公司的资金投入一般" ) : "在信息化管理层面，公司的资金投入水平较高";
                list.add(str);

                //信息化管理层内的二级指标混合判断
                tmp = serveList.get(10);
                list.add("公司的信息系统运维投入占信息化总投入的比例为" + nf2.format(tmp) + "。");

                //增值服务管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<serveIndustryList.size(); i++){
                    doubleList.add(serveIndustryList.get(i).getList());
                    if (serveIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(1).size(); i++){
                    tmpList.add(doubleList.get(1).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在增值服务管理层面，公司所反映出的协同水平较低" : "在增值服务管理层面，公司所反映出的协同水平一般" ) : "在增值服务管理层面，公司所反映出的协同水平较高";
                list.add(str);

                // 增值服务管理判断-2
                str = "综合比对一些主要指标得分，包括：通过信息化实现业务协同和一体化情况、产业链企业之间信息交互和共享情况、以及通过建立互联网开放社区实现价值网络协同情况等，发现该公司在产业链协同方面具有";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太健康" : "一般" ): "比较良好";
                str = str + strtmp;
                str = str + "的协同发展生态圈，";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太利于" : "比较利于" ): "有利于";
                str = str + strtmp + "跨企业资源共享与关键制造环节协同优化。";
                list.add(str);

                // 增值服务管理判断-3
                if (tmp <= 50.0) list.add("同时，公司可以很好地利用信息化手段实现能源与环保的管理，有利于企业的可持续发展与升级");
                else list.add("同时，公司无法很好地利用信息化手段实现能源与环保的管理，不利于企业的可持续发展与升级");

                //流程、中小批量
                list.add("");

                //新产品产值率-流程行业
                list.add("");

                // 百人专利拥有量-离散中小批量
                list.add("");

                break;
            case 5:
                MixPercent mixPercent = mixInduMapper.getPercentByEpId(id);
                MixIndustry mixIndustry = mixInduMapper.getMixIndByEpId(id);
                List<MixIndustry> mixIndustryList = mixInduMapper.getAllMixInd();
                List<Double> mixPercentList = mixPercent.getList();
                List<Double> mixList = mixIndustry.getList();

                //供应链管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<mixIndustryList.size(); i++){
                    doubleList.add(mixIndustryList.get(i).getList());
                    if (mixIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(0).size(); i++){
                    tmpList.add(doubleList.get(0).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "在供应链管理层面，公司在采购、生产、销售流程中的体系比较单一化" : "在供应链管理层面，公司在采购、生产、销售流程中的体系比较全面";
                list.add(str);

                //按期交货率
                list.add("");

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "企业具有一体化的管理与控制集成模式，经营管理系统与车间生产制造执行系统之间的指令传达具有范围广、系统化、自动化的特点" : "企业的管理与控制集成模式尚且缺乏体系，经营管理系统与车间生产制造执行系统之间的指令传达具有范围较小、系统化欠缺、自动化进程缓慢的特点";
                list.add(str);

                //应用信息系统
                tmp = mixPercentList.get(0);
                str = tmp > 50.0 ? "企业在项目管理过程中的信息系统与解决方案有待完善" : "企业在项目管理过程中的信息系统与解决方案较为成熟";
                list.add(str);

                //供应链管理得分
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp > 50.0 ? "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度不太可观，位居同行业中后部" : "其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度比较可观，位居同行业前中部";
                list.add(str);

                //行政管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<mixIndustryList.size(); i++){
                    doubleList.add(mixIndustryList.get(i).getList());
                    if (mixIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(3).size(); i++){
                    tmpList.add(doubleList.get(3).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在行政管理层面，公司的水平较低。" : "在行政管理层面，公司的水平一般。" ) : "在行政管理层面，公司的水平较高。";
                list.add(str);

                //企业组织模式
                tmp = mixList.get(14);
                tmp2 = mixPercentList.get(14);
                str = "其中企业组织模式得分为" + nf2.format(tmp) + "，说明公司本身对于“两化融合”中的行政管理进程";
                strtmp = tmp2 > 50.0 ? "予以高度关注。" : "未予以关注。";
                str = str + strtmp;
                list.add(str);

                //人力资源管理
                tmp = mixList.get(19);
                tmp2 = mixPercentList.get(19);
                str = "在人力资源方面，应用信息化手段进行人力资源管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 < 50.0 ? "，比较客观" : "，仍有上升空间";
                str = str + strtmp;
                list.add(str);

                //设备管理
                tmp = mixList.get(18);
                tmp2 = mixPercentList.get(18);
                str = "在设备管理方面，公司应用信息化手段进行设备管理实现的功能与层级得分为" + nf2.format(tmp);
                strtmp = tmp2 > 30.0 ? ( tmp2 > 70.0 ? "，位于行业尾部" : "，位于行业中游" ) : "，位于行业前列";
                str = str + strtmp;
                list.add(str);

                //信息化规划执行情况
                tmp = mixList.get(15);
                tmp2 = mixPercentList.get(15);
                str = "整体来看，信息化规划执行情况得分为" + nf2.format(tmp) + "，说明公司正处于";
                strtmp = tmp2 < 50.0 ? "信息化较为成熟的阶段" : "从自动化向信息化过渡的阶段";
                str = str + strtmp;
                list.add(str);

                //信息化管理层面
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<mixIndustryList.size(); i++){
                    doubleList.add(mixIndustryList.get(i).getList());
                    if (mixIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(2).size(); i++){
                    tmpList.add(doubleList.get(2).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在信息化管理层面，公司的资金投入水平较低" : "在信息化管理层面，公司的资金投入一般" ) : "在信息化管理层面，公司的资金投入水平较高";
                list.add(str);

                //信息化管理层内的二级指标混合判断
                tmp = mixList.get(13);
                tmp2 = mixList.get(12);
                list.add("当年企业生产设备总资产为" + nf2.format(tmp) + "亿元，近五年信息化建设投入为" + nf2.format(tmp2) + "万元。");

                //增值服务管理
                tmpList = new ArrayList<>();
                doubleList = new ArrayList<>();
                for (int i=0; i<mixIndustryList.size(); i++){
                    doubleList.add(mixIndustryList.get(i).getList());
                    if (mixIndustryList.get(i).getEnterprise_id() == id) inttmp = i;
                }
                doubleList = DivRank.getDivergenceTopTarget(doubleList, enterprise.getType());
                for (int i=0; i<doubleList.get(1).size(); i++){
                    tmpList.add(doubleList.get(1).get(i));
                }
                tmp = enterpriseServiceImpl.getPercent(tmpList, inttmp);
                str = tmp >= 30.0 ? ( tmp > 70.0 ? "在增值服务管理层面，公司所反映出的协同水平较低" : "在增值服务管理层面，公司所反映出的协同水平一般" ) : "在增值服务管理层面，公司所反映出的协同水平较高";
                list.add(str);

                // 增值服务管理判断-2
                str = "综合比对一些主要指标得分，包括：通过信息化实现业务协同和一体化情况、产业链企业之间信息交互和共享情况、以及通过建立互联网开放社区实现价值网络协同情况等，发现该公司在产业链协同方面具有";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太健康" : "一般" ): "比较良好";
                str = str + strtmp;
                str = str + "的协同发展生态圈，";
                strtmp = tmp >= 30.0 ? ( tmp > 70.0 ? "不太利于" : "比较利于" ): "有利于";
                str = str + strtmp + "跨企业资源共享与关键制造环节协同优化。";
                list.add(str);

                // 增值服务管理判断-3
                if (tmp <= 50.0) list.add("同时，公司可以很好地利用信息化手段实现能源与环保的管理，有利于企业的可持续发展与升级");
                else list.add("同时，公司无法很好地利用信息化手段实现能源与环保的管理，不利于企业的可持续发展与升级");

                //流程、中小批量
                list.add("");

                //新产品产值率-流程行业
                list.add("");

                // 百人专利拥有量-离散中小批量
                list.add("");

                break;
            default:
                break;
        }

        list.add("综上所述，本平台确定" + enterprise.getName() + "长期信用等级为" + grade + "。该评级结论有效反映了企业的信用风险状况。");

        String[] array = list.toArray(new String[list.size()]);

        return array;
    }

    public Double[] getGradeAllList(Integer id){
        EnterpriseVO enterpriseVO = enterpriseServiceImpl.getEnterpriseById(id);
        int type = enterpriseVO.getType();

        List<Enterprise> allEnterprises = enterpriseMapper.getAllEnterprises();
        List<Double> result = new ArrayList<>();

        for (int i=0; i<allEnterprises.size(); i++){
            if (allEnterprises.get(i).getType() == type){
                if (allEnterprises.get(i).getId()==id){
                    result.add(0, allEnterprises.get(i).getFinancialScore());
                }else{
                    result.add(allEnterprises.get(i).getFinancialScore());
                }
            }
        }

        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getFinancialDisplayList(Integer id){
        Integer[] index = new Integer[]{1,5,3,3,5,1}; // 只需要取前五个
        Integer[] sum_index = new Integer[]{0,1,6,9,12,17};
        // 目标得分：Sigma(xi)/index[i] ；平均得分：100/行业个数
        List<Enterprise> allEnterprises = enterpriseMapper.getAllEnterprises();
        FinancialPercent financialPercent = finanIndMapper.getPercentByEpId(id);
        List<Double> finanList = financialPercent.getList();
        // 平均分
        Double averange = 100.0 / allEnterprises.size();
        // 目标得分
        Integer basic = 0;
        Double tmp = 0.0, sum = 0.0;
        List<Double> result = new ArrayList<>();

        for (int i=0; i<index.length; i++){
            if (i == 5) break;
            for (int j=0; j<index[i]; j++){
                sum += finanList.get(sum_index[i] + j);
            }
            tmp = sum / index[i];
            sum = 0.0;
            result.add(tmp);
        }

        for(int i=0; i<5; i++){
            result.add(averange);
        }
        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getDebtDisplayList(Integer id){
        // 1-5
        List<Enterprise> allEnterprises = enterpriseMapper.getAllEnterprises();
        FinancialPercent financialPercent = finanIndMapper.getPercentByEpId(id);
        List<Double> finanList = financialPercent.getList();
        // 平均分
        Double averange = 100.0 / allEnterprises.size();
        // 目标得分
        Integer basic = 0;
        Double tmp = 0.0, sum = 0.0;
        List<Double> result = new ArrayList<>();

        for (int i=1; i<6; i++){
            result.add(finanList.get(i));
        }

        for(int i=0; i<5; i++){
            result.add(averange);
        }
        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Integer[] getDevPhraseNum(){
        List<FinancialIndex> financialIndexList = finanIndMapper.getAllFinInd();
        // 目标得分
        Integer[] result = new Integer[]{0,0,0};
        Double tmp = 0.0;

        for(int i=0; i<financialIndexList.size(); i++){
            tmp = financialIndexList.get(i).getOperating_revenue();
            if (tmp > 10.0) result[0]++;
            else if (tmp <= 10.0 && tmp > 5.0) result[1]++;
            else result[2]++;
        }

        return result;
    }

    public Double[] getAbilityIndexList(Integer id){
        List<Enterprise> allEnterprises = enterpriseMapper.getAllEnterprises();
        FinancialPercent financialPercent = finanIndMapper.getPercentByEpId(id);
        List<Double> finanList = financialPercent.getList();
        // 平均分
        Double averange = 100.0 / allEnterprises.size();
        // 目标得分
        Integer basic = 0;
        Double tmp = 0.0, sum = 0.0;
        List<Double> result = new ArrayList<>();

        for (int i=6; i<9; i++){
            result.add(finanList.get(i));
        }

        for(int i=0; i<3; i++){
            result.add(averange);
        }
        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getGainAbilityIndexList(Integer id){
        List<Enterprise> allEnterprises = enterpriseMapper.getAllEnterprises();
        FinancialPercent financialPercent = finanIndMapper.getPercentByEpId(id);
        List<Double> finanList = financialPercent.getList();
        // 平均分
        Double averange = 100.0 / allEnterprises.size();
        // 目标得分
        Integer basic = 0;
        Double tmp = 0.0, sum = 0.0;
        List<Double> result = new ArrayList<>();

        for (int i=9; i<12; i++){
            result.add(finanList.get(i));
        }

        for(int i=0; i<3; i++){
            result.add(averange);
        }
        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getOperationAbilityIndexList(Integer id){
        List<Enterprise> allEnterprises = enterpriseMapper.getAllEnterprises();
        FinancialPercent financialPercent = finanIndMapper.getPercentByEpId(id);
        List<Double> finanList = financialPercent.getList();
        // 平均分
        Double averange = 100.0 / allEnterprises.size();
        // 目标得分
        Integer basic = 0;
        Double tmp = 0.0, sum = 0.0;
        List<Double> result = new ArrayList<>();

        for (int i=12; i<17; i++){
            result.add(finanList.get(i));
        }

        for(int i=0; i<5; i++){
            result.add(averange);
        }
        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getDiverGradeList(Integer id){
        Enterprise target = enterpriseMapper.getEnterpriseById(id);
        Integer type = target.getType();
        List<Enterprise> enterprises = enterpriseMapper.getEnterprisesByType(type);

        List<Double> result = new ArrayList<>();

        for (int i=0; i<enterprises.size(); i++){
            if (enterprises.get(i).getId()==id){
                result.add(0, enterprises.get(i).getDiverScore());
            }else{
                result.add(enterprises.get(i).getDiverScore());
            }
        }

        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getDiverFirstIndexList(Integer id){
        Enterprise target = enterpriseMapper.getEnterpriseById(id);
        Integer type = target.getType();
        List<Double> result = new ArrayList<>();
        Double tmp = 0.0, ave = 0.0;
        int basic = 0;

        if (type==1){
            Integer[] index = new Integer[]{5,6,1,5};
            List<MassPercent> massPercents = massDisMapper.getAllPercent(); //5 6 1 5
            MassPercent massPercent = massDisMapper.getPercentByEpId(id);
            ave = 100.0 / massPercents.size();

            List<Double> concreteList = massPercent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==2){
            Integer[] index = new Integer[]{9,6,1,8,1};
            List<ProcPercent> percents = procInduMapper.getAllPercent();
            ProcPercent percent = procInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==3){
            Integer[] index = new Integer[]{7,5,3,8,3};
            List<SmePercent> percents = smeDisMapper.getAllPercent();
            SmePercent percent = smeDisMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==4){
            Integer[] index = new Integer[]{7,5,6};
            List<ServePercent> percents = servInduMapper.getAllPercent();
            ServePercent percent = servInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else{
            Integer[] index = new Integer[]{6,6,2,7};
            List<MixPercent> percents = mixInduMapper.getAllPercent();
            MixPercent percent = mixInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }

        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getDiverGongYingLianList(Integer id){
        Enterprise target = enterpriseMapper.getEnterpriseById(id);
        Integer type = target.getType();
        List<Double> result = new ArrayList<>();
        Double tmp = 0.0, ave = 0.0;
        int basic = 0;

        if (type==1){
            Integer[] index = new Integer[]{1,1,1,1,1};
            List<MassPercent> massPercents = massDisMapper.getAllPercent(); //5 6 1 5
            MassPercent massPercent = massDisMapper.getPercentByEpId(id);
            ave = 100.0 / massPercents.size();

            List<Double> concreteList = massPercent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==2){
            Integer[] index = new Integer[]{1,1,4,1,1,1};
            List<ProcPercent> percents = procInduMapper.getAllPercent();
            ProcPercent percent = procInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==3){
            Integer[] index = new Integer[]{1,1,2,2,1};
            List<SmePercent> percents = smeDisMapper.getAllPercent();
            SmePercent percent = smeDisMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==4){
            Integer[] index = new Integer[]{1,1,1,1,2,1};
            List<ServePercent> percents = servInduMapper.getAllPercent();
            ServePercent percent = servInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else{
            Integer[] index = new Integer[]{1,1,1,1,1,1};
            List<MixPercent> percents = mixInduMapper.getAllPercent();
            MixPercent percent = mixInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }

        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;

    }

    public Double[] getDiverXingZhengList(Integer id){
        Enterprise target = enterpriseMapper.getEnterpriseById(id);
        Integer type = target.getType();
        List<Double> result = new ArrayList<>();
        Double tmp = 0.0, ave = 0.0;
        int basic = 0;

        if (type==1){
            basic = 12; // 离散大批量行政开始
            Integer[] index = new Integer[]{2,1,1,1};
            List<MassPercent> massPercents = massDisMapper.getAllPercent(); //5 6 1 5
            MassPercent massPercent = massDisMapper.getPercentByEpId(id);
            ave = 100.0 / massPercents.size();

            List<Double> concreteList = massPercent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==2){
            basic = 16;
            Integer[] index = new Integer[]{2,3,1,1,1};
            List<ProcPercent> percents = procInduMapper.getAllPercent();
            ProcPercent percent = procInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==3){
            basic = 15;
            Integer[] index = new Integer[]{2,3,1,1,1};
            List<SmePercent> percents = smeDisMapper.getAllPercent();
            SmePercent percent = smeDisMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==4){
            basic = 12;
            Integer[] index = new Integer[]{2,1,1,1,1};
            List<ServePercent> percents = servInduMapper.getAllPercent();
            ServePercent percent = servInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else{
            basic = 14;
            Integer[] index = new Integer[]{2,2,1,1,1};
            List<MixPercent> percents = mixInduMapper.getAllPercent();
            MixPercent percent = mixInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }

        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getDiverInvestmentList(Integer id){
        Enterprise target = enterpriseMapper.getEnterpriseById(id);
        Integer type = target.getType();
        List<Double> result = new ArrayList<>();
        Double ave = 0.0;

        if (type==1){
            List<MassPercent> massPercents = massDisMapper.getAllPercent(); //5 6 1 5
            MassPercent massPercent = massDisMapper.getPercentByEpId(id);
            ave = 100.0 / massPercents.size();

            List<Double> concreteList = massPercent.getList();
            result.add(concreteList.get(11));
            result.add(ave);
        }else if (type==2){
            List<ProcPercent> percents = procInduMapper.getAllPercent();
            ProcPercent percent = procInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            result.add(concreteList.get(15));
            result.add(ave);
        }else if (type==3){
            List<SmePercent> percents = smeDisMapper.getAllPercent();
            SmePercent percent = smeDisMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            result.add(concreteList.get(12));
            result.add(concreteList.get(13));
            result.add(concreteList.get(14));
            result.add(ave);
            result.add(ave);
            result.add(ave);
        }else if (type==4){
            List<ServePercent> percents = servInduMapper.getAllPercent();
            ServePercent percent = servInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();
            List<Double> concreteList = percent.getList();
            result.add(concreteList.get(10));
            result.add(concreteList.get(11));
            result.add(ave);
            result.add(ave);
        }else{
            List<MixPercent> percents = mixInduMapper.getAllPercent();
            MixPercent percent = mixInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            result.add(concreteList.get(12));
            result.add(concreteList.get(13));
            result.add(ave);
            result.add(ave);
        }

        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }

    public Double[] getDiverZenZhiList(Integer id){
        Enterprise target = enterpriseMapper.getEnterpriseById(id);
        Integer type = target.getType();
        List<Double> result = new ArrayList<>();
        Double tmp = 0.0, ave = 0.0;
        int basic = 0;

        if (type==1){
            basic = 5; // 离散大批量行政开始
            Integer[] index = new Integer[]{2,1,2,1};
            List<MassPercent> massPercents = massDisMapper.getAllPercent(); //5 6 1 5
            MassPercent massPercent = massDisMapper.getPercentByEpId(id);
            ave = 100.0 / massPercents.size();

            List<Double> concreteList = massPercent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==2){
            basic = 9;
            Integer[] index = new Integer[]{1,1,3,1};
            List<ProcPercent> percents = procInduMapper.getAllPercent();
            ProcPercent percent = procInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==3){
            basic = 7;
            Integer[] index = new Integer[]{1,1,2,1};
            List<SmePercent> percents = smeDisMapper.getAllPercent();
            SmePercent percent = smeDisMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else if (type==4){
            basic = 7;
            Integer[] index = new Integer[]{1,2};
            List<ServePercent> percents = servInduMapper.getAllPercent();
            ServePercent percent = servInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }else{
            basic = 6;
            Integer[] index = new Integer[]{2,2,1,1};
            List<MixPercent> percents = mixInduMapper.getAllPercent();
            MixPercent percent = mixInduMapper.getPercentByEpId(id);
            ave = 100.0 / percents.size();

            List<Double> concreteList = percent.getList();
            for (int i=0; i<index.length; i++){
                for (int j=0; j<index[i]; j++){
                    tmp += concreteList.get(basic + j);
                }
                result.add(tmp/index[i]);
                basic += index[i];
                tmp = 0.0;
            }

            for (int i=0; i<index.length; i++){
                result.add(ave);
            }
        }

        Double[] scores = new Double[result.size()];
        result.toArray(scores);

        return scores;
    }
}
