package com.looyee.alipay.billparse;

import com.looyee.alipay.entity.AliDownloadBusinessDetailsSummary;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class AliBillParse {

    private final static Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");

    public void parseAliBusinessDetailsBillSummary(File file) {
        try {
            List<AliDownloadBusinessDetailsSummary> resultList = new ArrayList<>();
            List<String> list = FileUtils.readLines(file, "GBK");
            String otherStr = list.get(5);
            String[] otherStrLine = StringUtils.splitByWholeSeparatorPreserveAllTokens(otherStr, ",");
            log.info(otherStr);
            String countStr = list.get(6);
            String[] countStrLine = StringUtils.splitByWholeSeparatorPreserveAllTokens(countStr, ",");
            log.info(countStr);
        } catch (Exception e) {
            log.info("解析支付宝业务明细(汇总)账单异常", e);
        }
    }

    public void parseAliBusinessDetailsBill(File file) {
        try {
            List<String> list = FileUtils.readLines(file, "GBK");
            Matcher matcherTransaction = pattern.matcher(list.get(list.size() - 3));  //交易合计
            String listStrTransaction = matcherTransaction.replaceAll("");
            log.info(listStrTransaction);

            Matcher matcherRefund = pattern.matcher(list.get(list.size() - 2));  //退款合计
            String listStrRefund = matcherRefund.replaceAll("");
            log.info(listStrRefund);

            list = list.subList(5, list.size() - 4);
            list.forEach(l -> {
                Matcher matcher = pattern.matcher(l);
                String listStr = matcher.replaceAll("");
                String[] splitLine = StringUtils.splitByWholeSeparatorPreserveAllTokens(listStr, ",");
                log.info(listStr);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseAliAccountDetailsBillSummary(File file) {
        try {
            List<String> list = FileUtils.readLines(file, "GBK");
            list = list.subList(5, list.size() - 2);
            list.forEach(l -> {
                Matcher matcher = pattern.matcher(l);
                String listStr = matcher.replaceAll("");
                String[] splitLine = StringUtils.splitByWholeSeparatorPreserveAllTokens(listStr, ",");
                log.info(listStr);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseAliAccountDetailsBill(File file) {
        try {
            List<String> list = FileUtils.readLines(file, "GBK");
            list = list.subList(5, list.size() - 4);
            list.forEach(l -> {
                Matcher matcher = pattern.matcher(l);
                String listStr = matcher.replaceAll("");
                String[] splitLine = StringUtils.splitByWholeSeparatorPreserveAllTokens(listStr, ",");
                log.info(listStr);
            });

        } catch (Exception e) {
            log.info("解析支付宝业务明细(汇总)账单异常", e);
        }
    }

}
